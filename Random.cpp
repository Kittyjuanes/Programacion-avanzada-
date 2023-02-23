/* Autor: Juan Esteban Garzón
Fecha: 15-02-2023
Tema: VArrays, clase vector, aleatoriedad, funciones

Problema: Crear una forma para generar un conjunto de numeros aleatorios,
          tal que, se pueda contar  la frecuencia y poder graficar tipo histograma.

Se recomienda usar funciones, arrays y la clase vector de STL.
El conjunto de aleatorios se debera preguntar la cantidad de elementos al usuario.
Se recomienda hacer un menu.
*/

#include <iostream>
#include <stdlib.h>

using namespace std;


void crear(int* arreglo, int tamanio);//Se declara la funcion crear para generar los elementos del array
void histograma(int* arreglo, int* arreglo2,int* frec, int tamanio);//Se declara la funcion histograma que crea la grafica con las respectivas freuencias


int main()
{
    //Inicializamos punteros de tipo entero que apunten a un espacio vacio
    int* arreglo=NULL;
    int* arreglo2=NULL;
    int* frec=NULL;

    //Inicializamos la variable del tamaño de los arrays y la variable de opciones
    int tamanio, n;

    cout<<"Digite el tamanio de arreglo ";
    cin >> tamanio;
    cout<<endl;

    //Creamos arrays nuevos de tamaño 'tamanio'
    arreglo= new int[tamanio];
    arreglo2= new int[tamanio];
    frec= new int[tamanio];


    //Mostramos en pantalla el menu
    cout<<"Menu"<<endl;
    cout<<"1. Crear conjunto de numeros aleatorios"<<endl;
    cout<<"2. Contar frecuencia y graficar histograma"<<endl;
    cout<<"0. Salir"<<endl;
    cout<<"Digite su opcion ";
    cin >> n;

    while (n!=0)//Hacemos uso de un while, ya que no sabemos cuantas veces el ususario va a hacer uso del menu
    {
        switch(n)
        {
            case 1:
                crear(arreglo, tamanio);//Llamamos a las funcion crear
                break;

            case 2:
                histograma(arreglo, arreglo2, frec, tamanio);// Llamamos a las funcion histograma
                break;

            case 0:
                break;

        }

    cout<<"Menu"<<endl;
    cout<<"1. Crear conjunto de numeros aleatorios"<<endl;
    cout<<"2. Contar frecuencia"<<endl;
    cout<<"0. Salir"<<endl;
    cout<<"Digite su opcion ";
    cin >> n;

    }

    //Liberamos la memoria de los punteros
    delete [] arreglo;
    delete [] arreglo2;
    delete [] frec;

    arreglo=NULL;
    arreglo2=NULL;
    frec=NULL;

    return 0; 
}

void crear(int* arreglo, int tamanio)
{
    int maximo;

    cout<<"Determine el valor maximo del arreglo que sea entre 0 y 20: ";
    cin>>maximo;
    cout<<endl;

    for (int i = 0; i < tamanio; i++)
    {
        arreglo[i] = rand() % maximo;//Se modula por el numero maximo pedido por el usuario, ya que es el maximo
        cout<<arreglo[i]<<" ";
    }
    cout<<endl;

}

void histograma(int* arreglo, int* arreglo2,int* frec, int tamanio)
{
    int contador=1, k=0, rep=0, x;

    for (int i = 0; i < tamanio; i++)//Bucle para encontrar los numeros que se encuentrar en el arreglo
    {
        for (int j = i+1; j < tamanio; j++)
        {
            if (arreglo[i] == arreglo[j])
            {
                contador++;
            }
        }

        if (contador == 1)//Si contador es diferente a 1 significa que no necesitamos introducir el numero al arreglo2, ya que el arreglo2 es de los numeros del arreglo pero sin repetir
            {
                arreglo2[k] = arreglo[i];
                k++; //Contador para saber el tamaño del arreglo2
            }

        contador=1;//Se inicializa el contador
    }

    for (int i = 0; i < k; i++)//Bucle para saber la frecuencia de los numeros en el arreglo2
    {
        for (int j = 0; j <tamanio; j++)
        {
            if (arreglo2[i] == arreglo[j])
            {
                rep++;
            }
        }

        frec[i]=rep;//Se llena el arreglo frecuencia de los numeros
        rep=0;
    }

    cout<<"INDEX:\t"<<"VALOR:\t"<<"FRECUENCIA:\t"<<endl;//Se imprime en pantalla las frecuencias

    for (int i = 0; i < k; i++)
    {
        cout<<i<<"\t"<<arreglo2[i]<<"\t";
        x=frec[i];//Se declara el limite del bucle que prosigue para imprimir el histograma

        for (int j=0; j < x; j++)
        {
            cout<<"*";
        }

        cout<<endl;
    }

}