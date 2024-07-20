//On Acse.lex{
":" { return COLON; }

"for" { return FOR; }

//On Acse.y

%token COLON

+%token <foreach_stmt> FOR


statements: //preserve existing rules
            | foreach_statement
;            

foreach_statement: FOR LPAR IDENTIFIER DUEPUNTI IDENTIFIER LPAR {
    
    t_axe_variable *arr getVariable(program, $5);
    
    //check that the input array exists
    if(!arr){
        yyerror("The input array doesn't exist");
        YYERROR;
    }

    //check that the input array is actually an array
    if(!arr->isArray){
        yyerror("The input array is not valid");
        YYERROR;
    }

    //register for array index
    int r_i = gen_load_immediate(program, 0);

    //register for storing and, then, updating first input value
    int r_x = get_symbol_location(program, $3, 0);

    //beginning of foreach loop
    t_axe_label *l_loop = assignNewLabel(program);

    //Check if needed to jump to the end.
    t_axe_label *l_end = newLabel(l_end);
    gen_subi_instruction(program, REG_0, r_i, arr -> arraySize);
    gen_beq_instruction(program, l_end, 0);

    //assign x to a[i]
    int r_tmp = loadArrayElement(program, $5, create_expression(r_i, REGISTER)):
    gen_add_instruction(program r_x, REG_0, r_tmp, CG_DIRECT_ALL);

    //free dynamically allocated identifiers
    free($3);
    free($5);
} code_block {

    //update index value
    gen_addi_instruction(program, $1.r_i, $1.r_i, 1);

    //move back to the beginning of the loop
    gen_bt_instruction(program, l_loop, 0);

    //label that points out of the loop
    assignLabel(l_end);
};