//On Acse.lex
"permutate" { return PERMUTATE; }
"q["  { return LPER; }
"]p"  { return RPER; }

//On Acse.y
%token PERMUTATE
%token LPER
%token RPER

%type<list> per_list

statements: //preserve existing rules
           |perm_statement SEMI {/*Does nothing*/}
           | SEMI
;           

per_list: NUMBER{
    $$ = addLast(NULL, INTDATA($1))
} | per_list COMMA NUMBER {
    $$ = addLast($1, INTDATA($3))
}

perm_statement: PERMUTATE LPAR IDENTIFIER COMMA LPER per_list RPER RPAR {

    //C CODE TO TRANSLATE

    /*
    n = l_per[1]
    next = array[l_per[1]]
    while(l_per){
        tmp = array[l_per[i]];
        array[l_per[i]] = next;
        next = tmp;
        l_per -> next;
    }
    array[n] = next;
    */

   //check that the firs number of the list
   //has a value that is smaller than the array size

   t_axe_variable *arr getVariable(program, $3);
   t_list *list = $6;

   int perm_0 = LINTDATA(list);
   if(perm_0 > arr->arraySize){
    yyerror("INVALID INDEX");
    YYERROR;
   }

   //save the next element to be stored
   int r_next = loadArrayElement(program, $3, create_expression(perm_0, IMMEDIATE));

   //registers that allow to perform the switch
   int r_tmp = getNewRegister(program);

   //perform the switches
   list = LNEXT(list);

   while(list != NULL){
    int perm_i = LINTDATA(list);
    if(perm_i > arr->arraySize){
        yyerror("INVALID INDEX");
        YYERROR;
    }

    //extract the old value
    int r_value = loadArrayElement(program, $3, create_expression(perm_i, IMMEDIATE));
    
    //store the "old" value in tmp
    gen_addi_instruction(program, r_tmp, r_value, 0);
    
    //update with the new value
    storeArrayElement(program, $3, create_expression(perm_i, IMMEDIATE), create_expressione(r_next, REGISTER));
    
    //prepare for the next instruction, that might be the last one
    gen_addi_instruction(program, r_next, r_tmp, 0);
    LNEXT(list);
   }

   storeArrayElement(program, $3, create_expression(perm_0, IMMEDIATE), create_expression(r_next, REGISTER));

   //free the dynamically allocated identifiers
   free($3);
   free($6)
}
;