//On Acse.lex
"inbounds" { return INBOUNDS; }

//On Acse.y
%token INBOUNDS

exp: //preserve existing rules
           |INBOUNDS LPAR IDENTIFIER ASSIGN IDENTIFIER LSQUARE exp RSQUARE RPAR {

            //Check that the destination is a scalar
            t_axe_variable *dest getVariable($3);

            if(!dest){
                yyerror("The destination doesn't exist");
                YYERROR;
            }

            if(dest -> isArray){
                yyerror("The destination variable is not a scalar");
                YYERROR;
            }

            //Check that the source is an array
            t_axe_variable *source getVariable($5);

            if(!source){
                yyerror("The source doesn't exist");
                YYERROR
            }

            if(!source -> isArray){
                yyerror("The source variable must be a scalar");
                YYERROR;
            }

            t_axe_expression geZero = handle_binary_comparison(program,
            $7, create_expression(0, IMMEDIATE), _GTEQ_);;

            t_axe_expression ltArraySize = handle_binary_comparison(program,
            $7, create_expression(v_src -> arraySize, IMMEDIATE), _LT_);

            t_axe_expression indexValid = handle_bin_numeric_op(program, geZero,
            ltArraySize, ANDL);

            int r_dest = get_symbol_location(program, $3, 0);

            if(indexValid.expression_type == IMMEDIATE) {

                if(indexValid != 0) {
                    int r_val = loadArrayElement(program, r_dest, r_val, 0);
                    gen_addi_instruction(program, r_dest, r_val, 0);
                } else {
                    gen_subi_instruction(program, REG_0, indexValid.value, 0);
                    t_axe_label *l_skip = newLabel(program);

                    gen_beq_instruction(program, l_skip, 0);

                    int r_val = loadArrayElement(program, $5, $7);

                    gen_addi_instruction(program, r_dest, r_val, 0);

                    assignLabel(program, l_skip);
                }
            }

            free($3);
            free($5);
    };           