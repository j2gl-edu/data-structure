package edu.advanced.linked;

public class Nodo {
    int dato;
    Nodo link;
  
    public Nodo() {
    }
    public void setDato(int valor) {
      dato = valor;
    }
    public void setLink(Nodo siguiente) {
      link = siguiente;
    }
  
    public int getDato() {
      return dato;
    }
    public Nodo getLink() {
      return link;
    }
  }
  