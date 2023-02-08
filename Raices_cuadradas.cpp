/*
Autor: Juan Esteban Garzón
Fecha: 8-02-2023

Vamos a computar raices cuadradas
*/

#include <iostream>
#include <cmath>
//Se crea el dominio de la biblioteca iostream "GLOBAL" y cmath para funciones matematicas//

using namespace std;

//Se crea la función principal//
int main()
{
    double x1=4.0, x2=12.25, x3=0.0121;

    cout<<"Numero---------Raiz cuadrada"<<endl;
    cout<<x1<<"-----------"<<sqrt(x1)<<endl;
    cout<<x2<<"-----------"<<sqrt(x2)<<endl;
    cout<<x3<<"-----------"<<sqrt(x3)<<endl;
    return 0;
}