package ar.edu.unju.fi.ed2026;

public class Queue<E> {

    // Arreglo donde guardamos los elementos
    private Object[] elementos;

    // Posición del primer elemento
    private int head;

    // Posición donde se agregará el próximo elemento
    private int tail;

    // Cantidad de elementos que tiene actualmente la cola
    private int cantidad;


    // Constructor
    public Queue(int capacidad) {

        elementos = new Object[capacidad];

        head = 0;
        tail = 0;
        cantidad = 0;
    }


    // =====================================================
    // OFFER
    // Agrega un elemento al final de la cola
    // Devuelve false si la cola está llena
    // =====================================================

    public boolean offer(E elemento) {

        if (cantidad >= elementos.length) {
            return false;
        }

        // Guardamos el elemento en la posición de tail
        elementos[tail] = elemento;

        // Avanzamos tail de forma circular
        tail = (tail + 1) % elementos.length;

        cantidad++;

        return true;
    }


    // =====================================================
    // ADD
    // Agrega un elemento al final de la cola
    // Si está llena, genera un error
    // =====================================================

    public boolean add(E elemento) {

        if (cantidad >= elementos.length) {
            throw new IllegalStateException("Cola llena");
        }

        elementos[tail] = elemento;

        // Avanzamos tail de forma circular
        tail = (tail + 1) % elementos.length;

        cantidad++;

        return true;
    }


    // =====================================================
    // POOL
    // Saca y devuelve el primer elemento
    // Devuelve null si la cola está vacía
    // =====================================================

    @SuppressWarnings("unchecked")
    public E pool() {

        if (cantidad == 0) {
            return null;
        }

        // Guardamos el elemento que está en head
        E elemento = (E) elementos[head];

        // Avanzamos head de forma circular
        head = (head + 1) % elementos.length;

        cantidad--;

        return elemento;
    }


    // =====================================================
    // REMOVE
    // Saca y devuelve el primer elemento
    // Si está vacía, genera un error
    // =====================================================

    @SuppressWarnings("unchecked")
    public E remove() {

        if (cantidad == 0) {
            throw new IllegalStateException("Cola vacía");
        }

        E elemento = (E) elementos[head];

        // Avanzamos head de forma circular
        head = (head + 1) % elementos.length;

        cantidad--;

        return elemento;
    }


    // =====================================================
    // PEEK
    // Devuelve el primer elemento SIN sacarlo
    // =====================================================

    @SuppressWarnings("unchecked")
    public E peek() {

        if (cantidad == 0) {
            return null;
        }

        return (E) elementos[head];
    }


    // =====================================================
    // HEAD
    // Devuelve la posición donde está el primer elemento
    // =====================================================

    public int head() {

        return head;
    }


    // =====================================================
    // TAIL
    // Devuelve la posición donde se agregará el próximo elemento
    // =====================================================

    public int tail() {

        return tail;
    }


    // =====================================================
    // ISEMPTY
    // Indica si la cola está vacía
    // =====================================================

    public boolean isEmpty() {

        return cantidad == 0;
    }


    // =====================================================
    // SIZE
    // Devuelve la cantidad de elementos
    // =====================================================

    public int size() {

        return cantidad;
    }


    // =====================================================
    // TOSTRING
    // Muestra los elementos respetando el orden de la cola
    // aunque head y tail hayan dado la vuelta
    // =====================================================

    @Override
    public String toString() {

        if (cantidad == 0) {
            return "[]";
        }

        String resultado = "[";

        // Comenzamos a recorrer desde head
        int posicion = head;

        // Recorremos solamente la cantidad de elementos existentes
        for (int i = 0; i < cantidad; i++) {

            resultado += elementos[posicion];

            if (i < cantidad - 1) {
                resultado += ", ";
            }

            // Avanzamos de forma circular
            posicion = (posicion + 1) % elementos.length;
        }

        resultado += "]";

        return resultado;
    }
}
