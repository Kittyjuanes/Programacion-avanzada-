#include <iostream>
#include <fstream>
#include <string>

using namespace std;

struct Usuario
{
    int edad;
    string nombre;
    string apellido;
};


int main()
{

    Usuario* usuario=NULL;

    ifstream entrada;
    ofstream salida;
    int num;

    salida.open("Usuarios.txt", ios::app);

    if (!salida)
    {
        cout<<"No se pudo abrir el fichero"<<endl;
        exit(1);
    }
    else
    {
        cout<<"Digite el numero de usuarios a ingresar"<<endl;
        cin>>num;

        usuario= new Usuario[num];

        for (int i = 0; i < num; i++)
        {
            usuario[i].edad=0+i;
            cout<<usuario[i].edad;
        }
        

    }
    


    return 0;
}
