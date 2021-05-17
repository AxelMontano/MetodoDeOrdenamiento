package Programa;

public class Nodo {
    //Declarar variables
    private char dato;
    private Nodo despues;
    private int prioridad;

    public Nodo (char dato, int prioridad){
        this.dato = dato;
        this.despues= null;
        this.prioridad = prioridad;
    }

    //Get´s & Set´s
    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public Nodo getDespues() {
        return despues;
    }

    public void setDespues(Nodo despues) {
        this.despues = despues;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

}
