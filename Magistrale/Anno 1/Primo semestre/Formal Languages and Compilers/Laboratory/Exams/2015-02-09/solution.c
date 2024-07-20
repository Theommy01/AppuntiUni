//On acse.lex

"|" { return OR_OP; }
"!" { return NOT_OP; }
//Those 2 tokens are already defined

//On acse.y

exp: //preserve existing rules
    | exp NOT_OP {
        //factorial

        if($1.expression_type == IMMEDIATE){
            int fact = 1;
            int tmp = $1.value;
            while(tmp > 0) {
                fact = fact * tmp;
                tmp = tmp - 1;
            }
            $$ = create_expression(fact, IMMEDIATE);
        } else {
            //register initial value
            int r_tmp = getNewRegister(program);
            gen_add_instruction(program, r_tmp, REG_0, $1.value, CG_DIRECT_ALL);

            //Register for the result
            int r_fact = gen_load_immediate(program, 1);

            //translation of while loop
            t_axe_label *l_loop = assignNewLabel(program);
            t_axe_label *l_exit = newLabel(program);
            gen_subi_instruction(program, REG_0, r_tmp, 0);
            gen_beq_instruction(program, l_exit, 0);
            gen_mul_instruction(program, r_fact, r_fact, r_tmp, CG_DIRECT_ALL);
            gen_subi_instruction(program, r_tmp, r_tmp, 1):
            gen_bt_instruction(program, l_loop, 0);
            assignLabel(program, l_exit);

            $$ = create_expression(r_fact, REGISTER);
        }
    }
    | OR_OP exp OR_OP %prec NOT_OP {
        //absolute value

        if($2.expression_type == IMMEDIATE){
            int result = $2.value;
            if(result < 0) result = result * -1;
            $$ = create_expression(result, IMMEDIATE);
        } else {
            //register initial value
            int r_result = getNewRegister(program);
            gen_add_instruction(program, r_tmp, REG_0, $2.value, CG_DIRECT_ALL);

            //if result > 0, jump to the end
            t_axe_label *l_skip = newLabel(program);

            gen_bge_instruction(program, l_skip, 0);

            //otherwise, multiply by -1
            //notice it is the same as 0 - r_result
            gen_sub_instruction(program, r_result, REG_0, r_result, CG_DIRECT_ALL);
            assignLabel(program, l_skip);

            $$ = create_expression(r_result, REGISTER);
        }
    }