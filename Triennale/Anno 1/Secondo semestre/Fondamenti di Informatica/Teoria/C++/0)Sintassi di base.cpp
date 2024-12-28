#include <iostream> /*import iostream library, that allows to
                    take inputs and return outputs */
                    
using namespace std; /*If not specified, it has to be written
                     wheneber we want to use an std instruction
                     as count, cin, endl etc,*/
/*If we know that we need only a limited set of operators from
a namespace, we can import them by writing using namespace::variable
for example, using std::cout*/                     

//customized namespace
namespace Test{
    int counter = 0;
}

int main(){
    cout << "Hello world"; //print Hello world
    cout << "Different ways to \nexecute new line" << endl;
    Test::counter; /*Generally, it can happen to have the same variable name
                for different namespaces. So generally, to not make errors,
                it can be preferred to use the namespace::variable writing*/
    cout << "Bye ;-)";
    return 0;                  //end program
}