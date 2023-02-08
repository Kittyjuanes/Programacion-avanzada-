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
    string x;

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
            cin.ignore();
            
            cout<<"Ingrese nombres del usuario"<<i+1<<endl;
            getline(cin,usuario[i].nombre);
            salida<<usuario[i].nombre<<endl;

            cout<<"Ingrese apellidos del usuario"<<+1<<endl;
            getline(cin,usuario[i].apellido);
            salida<<usuario[i].apellido<<endl;

            cout<<"Ingrese la edad del usuario"<<i+1<<endl;
            cin>>usuario[i].edad;
            salida<<usuario[i].edad<<endl;
        }

        salida.close();
    
    }

    entrada.open("Usuarios.txt", ios::app);

    if (!entrada)
    {
        cout<<"Error abriendo el fichero"<<endl;
        exit(1);
    }
    else
    {
        while (getline(entrada,x))
        {
            cout<<x<<endl;
        }

        entrada.close();      
    }
    


    delete [] usuario;
    usuario= NULL;

    return 0;
}
