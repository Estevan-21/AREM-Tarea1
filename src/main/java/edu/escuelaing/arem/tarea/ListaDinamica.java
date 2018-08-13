package edu.escuelaing.arem.tarea;

import java.util.Iterator;


/**
 * Lista Dinamica PIMO
 *
 * @author Vargas Brayam
 * 
 */
public class ListaDinamica<T> implements Iterable<T>{

    //Atributos
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int tamanio;

    public ListaDinamica() {
        primero = null;
        ultimo = null;
        tamanio = 0;
    }

    /**
     * Indica si esta la lista vacia o no
     *
     * @return tamanio
     */
    public boolean isEmpty() {
        return tamanio == 0;
    }

    /**
     * Devuelve el tamaño de la lista
     *
     * @return tamanio
     */
    public int size() {
        return tamanio;
    }

    /**
     * Devuelve el elemento en la posicion indicada
     *
     * @param indice    indice
     * @return elemento indicado
     */
    public T get(int indice) {

        //si esta vacio o el indice no es correcto, devuelve null
        if (isEmpty() || (indice < 0 || indice >= size())) {
            return null;
        } else if (indice == 0) {
            return getFirst(); //Cojo el primero
        } else if (indice == size() - 1) {
            return getLast(); //Cojo el ultimo
        } else {

            //Uso la funcion getNode para coger el nodo deseado
            Nodo<T> buscado = getNode(indice);

            return buscado.getElemento();

        }

    }

    /**
     * Devuelve el primer elemento, null si esta vacia la lista
     *
     * @return elemento
     */
    public T getFirst() {
        //Si esta vacia, no hay primero que coger
        if (isEmpty()) {
            return null;
        } else {
            return primero.getElemento();
        }
    }

    /**
     * Devuelve el ultimo elemento, null si esta vacia la lista
     *
     * @return ultimo elemento
     */
    public T getLast() {
        //Si esta vacia, no hay ultimo que coger
        if (isEmpty()) {
            return null;
        } else {
            return ultimo.getElemento();
        }
    }

    /**
     * Devuelve el nodo completo de una posicion concreta
     *
     * @param index indice
     * @return nodo
     */
    private Nodo<T> getNode(int index) {

        //si esta vacio o el indice no es correcto, devuelve null
        if (isEmpty() || (index < 0 || index >= size())) {
            return null;
        } else if (index == 0) {
            return primero; //devuelvo el primero
        } else if (index == size() - 1) {
            return ultimo; //devuelvo el ultimo
        } else {

            Nodo<T> buscado = primero;

            //Busco el nodo deseado con un recorrido
            int contador = 0;
            while (contador < index) {
                contador++;
                buscado = buscado.getSiguiente();
            }

            //Me devuelve el buscado
            return buscado;

        }

    }

    /**
     * Añade un elemento al final de la lista
     *
     * @param elemento elemento
     * @return elemento añadido
     */
    public T addLast(T elemento) {

        Nodo<T> aux;

        //Si esta vacia, hago lo mismo que si fuera añadir el primero
        if (isEmpty()) {
            return addFirst(elemento);
        } else {

            //Hago el intercambio
            aux = new Nodo<T>(elemento, null);

            ultimo.setSiguiente(aux);
            ultimo = aux;

        }

        //Aumento el tamanño
        tamanio++;
        return ultimo.getElemento();

    }

    /**
     * Añade el elemento al principio de la lista
     *
     * @param elemento elemento
     * @return elemento añadido
     */
    public T addFirst(T elemento) {

        Nodo<T> aux;

        //si esta vacia, el nodo será el primero y ultimo
        if (isEmpty()) {
            aux = new Nodo<T>(elemento, null);
            primero = aux;
            ultimo = aux;
        } else {
            //Hago el intercambio
            Nodo<T> primeroActual = primero;
            aux = new Nodo<T>(elemento, primeroActual);
            primero = aux;

        }

        //Aumento el tamanño
        tamanio++;
        return primero.getElemento();

    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    //Creo la clase interna MyIterator, que implementa la interfaz Iterator
    private class MyIterator<ListaDinamica> implements Iterator<T>{

        //Indica el siguiente elemento que se va a devolver 
        private int siguiente;
        
        //Indica si hay un elemento
        @Override
        public boolean hasNext() {
            return getNode(siguiente)!=null;
        }

        //Devuelve el elemento actual e incrementa al siguiente
        @Override
        public T next() {
            T elemento = getNode(siguiente).getElemento();
            siguiente++;
            return elemento;
        }
        
    }
    

}
