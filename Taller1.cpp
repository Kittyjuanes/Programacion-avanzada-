/* Autor: Juan Esteban Garzón
Fecha: 15-02-2023
Tema: VArrays, clase vector, aleatoriedad, funciones

Problema: Crear una forma para generar un conjunto de numeros aleatorios,
          e imprimirlos con punteros.

Se recomienda usar funciones, arrays y la clase vector de STL.
El conjunto de aleatorios se debera preguntar la cantidad de elementos al usuario.
*/

#include <iostream>
#include <stdlib.h>
#include <time.h>//Libreria para saber el reloj interno del computador

using namespace std;

void crear(int array[]);//Creamos la funcion que genera los numeros aleatorios

int main()
{
    int array[10];
    int* ptr;//Inicializamos el puntero
    ptr = &array[0];//Hacemos que el puntero apunte al primer dato del array

    srand(time(NULL));//Inicializamos los numeros aleatorios

    crear(array);//Llamamos a la funcion

    for (int i = 0; i < 10; i++)
    {
        cout <<ptr[i]<< "\t";//Imprimimos el contenido del array usando el puntero
        cout<<ptr+i <<endl;// Imprimimos las direcciones del contenido del array usando el puntero
    }


}

void crear(int array[])
{
    for (int i = 0; i < 10; i++) 
    {
        array[i] = rand() % 25;//Generamos y almacenamos los numeros aleatorios
    }
}