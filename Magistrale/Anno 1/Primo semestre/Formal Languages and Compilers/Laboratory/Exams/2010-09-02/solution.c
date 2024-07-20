//On Acse.lex
"vec_add"  {return VEC_ADD; }
"vec_sub"  {return VEC_SUB; }

//On Acse.y
%token VEC_ADD
%token VEC_SUB

statements: //preserve existing rules
           |vec_statement SEMI {/*Does nothing*/}
           | SEMI
;           

vec_statement: vec_add {/*Does nothing*/}
            | vec_sub {/*Does nothing*/}
;

vec_add: VEC_ADD LPAR IDENTIFIER COMMA IDENTIFIER COMMA IDENTIFIER RPAR {
    //Check that all the vectors have the same lenght
    t_axe_variable *vecsum getVariable($3);
    t_axe_variable *vec1 getVariable($5);
    t_axe_variable *vec2 getVariable($7);

    if(vec1 -> arraySize != vec2 -> arraySize || vec1 -> arraySize != vecsum -> arraySize){
        yyerror("The dimensions are not matching");
        YYERROR;
    }

    /*C CODE TO TRANSLATE

    int i=0;
    int tmp1=0;
    int tmp2=0;
    int tmp3=0;
    for(i=0, i<vecsumSize, i++){
        tmp1=vec1[i];
        tmp2=vec2[i];
        tmp3=vec3[i];
        tmp3=tmp1+tmp2;
    }
    */

   //reserve registers for the various elements
   int r_i = genLoadImmediate(program, 0);
   int r_tmp3 = genLoadImmediate(program, 0);

   //assign labels
   t_axe_label *l_exit = newLabel(program);
   t_axe_label *l_condition = assignNewLabel(program);

   //compute i-vecsumSize
   gen_subi_instruction(program, REG_0, r_i, vecsum -> arraySize);
   //if i-vecsumSize = 0, exit the loop
   gen_beq_instruction(program, l_exit, 0);

   //perform sum operation
   //Declare the register for extracting the values from vec1 and vec2
   int r_tmp1 = loadArrayElement(program, $5, create_expression(r_i, REGISTER));
   int r_tmp2 = loadArrayElement(program, $7, create_expression(r_i, REGISTER));
   
   //sum the elements and store the result in r_tmp3. Every time the condition
   //is executed, tmp3 will be overwritten no matter its content
   gen_add_instruction(program, r_tmp3, r_tmp1, t_tmp2, CG_DIRECT_ALL);
   
   //Store the result in vecsum[i]
   storeArrayElement(program, $3, create_expression(r_i, REGISTER), create_expression(r_tmp3, REGISTER));

   //update the array index
   gen_addi_instruction(program, r_i, r_i, 1);

   //Branch true that will surely take me back to l_condition label
   gen_bt_instruction(program, l_condition, 0);

   //Label that points out of the loop
   assignLabel(program, l_exit, 0);

   //free dynamically allocated identifiers
   free($3);
   free($5);
   free($7);
};                       


vec_sub: VEC_SUB LPAR IDENTIFIER COMMA IDENTIFIER COMMA IDENTIFIER RPAR {
    //Check that all the vectors have the same lenght
    t_axe_variable *vecdiff getVariable($3);
    t_axe_variable *vec1 getVariable($5);
    t_axe_variable *vec2 getVariable($7);

    if(vec1 -> arraySize != vec2 -> arraySize || vec1 -> arraySize != vecdiff -> arraySize){
        yyerror("The dimensions are not matching");
        YYERROR;
    }

    /*C CODE TO TRANSLATE

    int i=0;
    int tmp1=0;
    int tmp2=0;
    int tmp3=0;
    for(i=0, i<vecsumSize, i++){
        tmp1=vec1[i];
        tmp2=vec2[i];
        tmp3=vec3[i];
        tmp3=tmp1-tmp2;
    }
    */

   //reserve registers for the various elements
   int r_i = genLoadImmediate(program, 0);
   int r_tmp3 = genLoadImmediate(program, 0);

   //assign labels
   t_axe_label *l_exit = newLabel(program);
   t_axe_label *l_condition = assignNewLabel(program);

   //compute i-vecsumSize
   gen_subi_instruction(program, REG_0, r_i, vecdiff -> arraySize);
   //if i-vecdiffSize = 0, exit the loop
   gen_beq_instruction(program, l_exit, 0);

   //perform substraction operation
   //Declare the register for extracting the values from vec1 and vec2
   int r_tmp1 = loadArrayElement(program, $5, create_expression(r_i, REGISTER));
   int r_tmp2 = loadArrayElement(program, $7, create_expression(r_i, REGISTER));
   
   //subtract the elements and store the result in r_tmp3. Every time the condition
   //is executed, tmp3 will be overwritten no matter its content
   gen_sub_instruction(program, r_tmp3, r_tmp1, t_tmp2, CG_DIRECT_ALL);
   
   //Store the result in vecdiff[i]
   storeArrayElement(program, $3, create_expression(r_i, REGISTER), create_expression(r_tmp3, REGISTER));

   //update the array index
   gen_addi_instruction(program, r_i, r_i, 1);

   //Branch true that will surely take me back to l_condition label
   gen_bt_instruction(program, l_condition, 0);

   //Label that points out of the loop
   assignLabel(program, l_exit, 0);

   //free dynamically allocated identifiers
   free($3);
   free($5);
   free($7);
};