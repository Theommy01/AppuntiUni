//On Acse.lex
"@" { return SCALAR; }

//On Acse.y

%token SCALAR

exp: //preserve existing rules
    | IDENTIFIER SCALAR IDENTIFIER {
      
      //Verify correctness of array inputs
      t_axe_variable *arr1 getVariable(program, $1);
      if(!arr1){
         yyerror("The first array input doesn't exist");
         YYERROR;
      }
      if(!arr1->isArray){
         yyerror("The first array input is not valid");
         YYERROR;
      }

      t_axe_variable *arr2 getVariable(program, $3);
      if(!arr2){
         yyerror("The second array input doesn't exist");
         YYERROR;
      }
      if(!arr2->isArray){
         yyerror("The second array input is not valid");
         YYERROR;
      }

      //if the dimensions are not the same, result in an error
      if(arr1->arraySize != arr2->arraySize){
         yyerror("The array sizes are different");
         YYERROR;
      }

      /* C CODE TO TRANSLATE
      
      int scalar = 0
      int i = 0
      int prod = 0
      for(i=0, i<arraySize, i++){
         tmp1 = arr1[i]
         tmp2 = arr2[i]
         prod = tmp1 + tmp2
         scalar = scalar + prod
      }
      */

      //register for the result
      int r_scalar = gen_load_immediate(program, 0);
      $$ = create_expression(r_scalar, REGISTER);

      //register for the current array index
      int r_i = gen_load_immediate(program, 0);

      //register for prod
      int r_prod = gen_load_immediate(program, 0);

      //label that exits the loop
      t_axe_label *l_exit = newLabel(program);

      //label that points to the beginning of the loop
      t_axe_label *l_condition = assignNewLabel(program);

      //compute i - arraySize (we will use arr1, but remember we
      //already verified that the sizes are the same)
      gen_subi_instruction(program, REG_0, r_i, arr1 -> arraySize);

      //If it is = 0, exit the loop
      gen_beq_instruction(program, l_exit, 0);

      //Compute the scalar product

      //extract arr1[i] and arr2[i]
      int r_tmp1 = loadArrayElement(program, $1, create_expression(r_i, REGISTER));
      int r_tmp2 = loadArrayElement(program, $3, create_expression(r_i, REGISTER));

      //Multiply the two values
      gen_mul_instruction(program, r_prod, r_tmp1, r_tmp2, CG_DIRECT_ALL);

      //Update the result
      gen_add_instruction(program, r_scalar, r_scalar, r_prod, CG_DIRECT_ALL);

      //Compute i++ and turn back to the beginning
      gen_addi_instruction(program, r_i, r_i, 1);
      gen_bt_instruction(program, l_condition, 0);

      assignLabel(program, l_exit, 0);

      //Free dynamically allocated identifiers
      free($1);
      free($3);
}
;