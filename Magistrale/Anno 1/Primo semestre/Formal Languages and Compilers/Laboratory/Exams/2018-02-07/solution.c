//On Acse.lex
//Aleady present
"red" { return RED; }

//On Acse.y
%token RED

exp: //preserve existing rules
    | RED LPAR IDENTIFIER RPAR {

      //Check array input exists and it is valid
      t_axe_variable *arr = getVariable(program, $3);

      if(!arr){
         yyerror("The input variable doesn't exist");
         YYERROR;
      }

      if(!arr->arraySize){
         yyerror("The input array is not valid");
         YYERROR;
      }

      /* C CODE TO TRANSLATE
      
      int i;
      for(i=0, i<arraySize, i++){
         tmp = array[i]
         sum = sum + tmp
      }

      */

      //Register for the index
      int r_i = gen_load_immediate(program, 0);

      //Register for the sum
      int r_sum = gen_load_immediate(program, 0);
      $$ = create_expression(r_sum, 0);
      
      t_axe_label *l_loop = assignNewLabel(program);
      t_axe_label *l_exit = newLabel(program);

      //compute i - arraySize and, if = 0, exits the loop
      gen_subi_instruction(program, REG_0, r_i, arr -> arraySize);
      gen_beq_instruction(program, l_exit, 0);

      //compute the sum
      int r_tmp = loadArrayElement(program, $3, create_expression(r_i, REGISTER));
      gen_add_instruction(program, r_sum, r_sum, r_tmp, CG_DIRECT_ALL);

      //update array index and jump back to the beginning
      gen_addi_instruction(program, r_i, r_i, 1);
      gen_bt_instruction(program, l_loop, 0);    

      assignLabel(program, l_exit, 0);

      //free dynamically allocated identifiers
      free($3);
};
