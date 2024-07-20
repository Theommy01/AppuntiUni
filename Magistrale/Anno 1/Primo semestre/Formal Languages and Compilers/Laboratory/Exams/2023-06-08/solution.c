//On Acse.lex
"replace" { return REPLACE; }

//On Acse.y
%token REPLACE

statement: //preserve existing rules
           |REPLACE LPAR IDENTIFIER COMMA exp COMMA exp RPAR {
            
            //check that the array is an array
            t_axe_variable *arr getVariable($3);
            if(!arr->isArray){
                yyerror("Invalid array input");
                YYERROR;
            }

            /*

            C CODE TO TRANSLATE

            array, int exp1, int exp2;
            for(i=0, i<arraySize, i++){
                if(array[i]==exp1){
                    array[i]=exp2
                }
            }

            */

            //Register for the counter
            int r_i = gen_load_immediate(program, 0);

            //label that exits the for
            t_axe_label *l_exit = newLabel(program, 0);

            //label that points at the beginning of the for
            t_axe_label *l_condition = assignNewLabel(program, 0);

            //if i-arraySize=0, exit the loop
            gen_subi_instruction(program, REG_0, r_i, arr->arraySize);
            gen_beq_instruction(program, l_exit, 0);

            //CONTENT OF THE LOOP

            //extract element array[i]
            int arr_i = loadArrayElement(program, $3, create_expression(r_i, REGISTER));

            //label for skipping if instructions
            t_axe_label *l_skip = newLabel(program);

            //Perform arr[i]-exp1

            if($5.expression_type == IMMEDIATE){
                gen_subi_instruction(program, REG_0, arr_i, $5.value);
            } else {
                //if it is not an immediate it is a register
                gen_subi_instruction(program, REG_0, arr_i, $5.value, CG_DIRECT_ALL);
            }

            //if arr[i]-exp1 != 0, skip the substitution
            gen_bne_instruction(program, l_skip, 0);

            //if we are inside if, store exp2 in arr[i]
            storeArrayElement(program, $3, create_expression(r_i, REGISTER), $7);

            assignLabel(program, l_skip, 0);
            
            //increment i
            gen_addi_instruction(program, r_i, r_i, 1);

            //Go back to the beginning of the for
            gen_bt_instruction(program, l_condition, 0);

            //label that points out of the loop
            assignLabel(program, l_exit, 0);

            //free the dynamically allocated identifiers
            free($3);
           }
           | SEMI
;           