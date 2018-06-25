package edu.advanced.linked;

public class Lista {
    Nodo inicio;
    int tamanio = 0;

    /**
     * Crea una lista vacia
     */
    public Lista() {
        inicio = null;
    }

    public boolean esVacia() {
        return (inicio == null);
    }


    public void agregarAlFinal(int valor) {
        // Define un nuevo nodo.
        Nodo nuevo = new Nodo();
        // Agrega al valor al nodo.
        nuevo.setDato(valor);
        // Consulta si la lista esta vacia.
        if (esVacia()) {
            // Inicializa la lista agregando como inicio al nuevo nodo.
            inicio = nuevo;
            // Caso contrario recorre la lista hasta llegar al ultimo nodo
            //y agrega el nuevo.
        } else {
            // Crea ua copia de la lista.
            Nodo aux = inicio;
            // Recorre la lista hasta llegar al ultimo nodo.
            while (aux.getLink() != null) {
                aux = aux.getLink();
            }
            // Agrega el nuevo nodo al final de la lista.
            aux.setLink(nuevo);
        }
        // Incrementa el contador de tamaño de la lista
        tamanio++;
    }

    /**
     * Agrega un nuevo nodo al inicio de la lista.
     *
     * @param valor a agregar.
     */
    public void agregarAlInicio(int valor) {
        // Define un nuevo nodo.
        Nodo nuevo = new Nodo();
        // Agrega al valor al nodo.
        nuevo.setDato(valor);
        // Consulta si la lista esta vacia.
        if (esVacia()) {
            // Inicializa la lista agregando como inicio al nuevo nodo.
            inicio = nuevo;
            // Caso contrario va agregando los nodos al inicio de la lista.
        } else {
            // Une el nuevo nodo con la lista existente.
            nuevo.setLink(inicio);
            // Renombra al nuevo nodo como el inicio de la lista.
            inicio = nuevo;
        }
        // Incrementa el contador de tamaño de la lista.
        tamanio++;
    }

    public int getValor(int posicion) {
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y < que el numero de elementos del la lista.
        if (posicion >= 0 && posicion < tamanio) {
            // Consulta si la posicion es el inicio de la lista.
            if (posicion == 0) {
                // Retorna el valor del inicio de la lista.
                return inicio.getDato();
            } else {
                // Crea una copia de la lista.
                Nodo aux = inicio;
                // Recorre la lista hasta la posición ingresada.
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getLink();
                }
                // Retorna el valor del nodo.
                return aux.getDato();
            }
            // Devuelve un valor no valido en la lista.
        } else {
            return -10000;
        }
    }

    public boolean buscar(int referencia) {
        // Crea una copia de la lista.
        Nodo aux = inicio;
        // Bandera para indicar si el valor existe.
        boolean encontrado = false;
        // Recorre la lista hasta encontrar el elemento o hasta
        // llegar al final de la lista.
        while (aux != null && encontrado != true) {
            // Consulta si el valor del nodo es igual al de referencia.
            if (referencia == aux.getDato()) {
                // Canbia el valor de la bandera.
                encontrado = true;
            } else {
                // Avansa al siguiente. nodo.
                aux = aux.getLink();
            }
        }
        // Retorna el resultado de la bandera.
        return encontrado;
    }

    public void removerPorReferencia(int referencia) {
        // Consulta si el valor de referencia existe en la lista.
        if (buscar(referencia)) {
            // Consulta si el nodo a eliminar es el pirmero
            if (inicio.getDato() == referencia) {
                // El primer nodo apunta al siguiente.
                inicio = inicio.getLink();
            } else {
                // Crea ua copia de la lista.
                Nodo aux = inicio;
                // Recorre la lista hasta llegar al nodo anterior
                // al de referencia.
                while (aux.getLink().getDato() != referencia) {
                    aux = aux.getLink();
                }
                // Guarda el nodo siguiente del nodo a eliminar.
                Nodo siguiente = aux.getLink().getLink();
                // Enlaza el nodo anterior al de eliminar con el
                // sguiente despues de el.
                aux.setLink(siguiente);
            }
            // Disminuye el contador de tamaño de la lista.
            tamanio--;
        }
    }

}
  