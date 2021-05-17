package Programa;

public class ListaSimple{
    protected Nodo ini;
    protected Nodo fin;

    public ListaSimple() {
        ini = fin= null;
    }
        
    //Insertar
    public boolean insertar(char dato, int prioridad){ 
        if (ini == null) {
            ini = fin = new Nodo(dato, prioridad);
            return true;
        }

        if (ini == fin) {
            fin = new Nodo(dato, prioridad);
            ini.setDespues(ini);
            return true;
        }

        fin.setDespues(new Nodo(dato, prioridad));
        fin = fin.getDespues();
        return true;
    }
        
    //Eliminar
    public boolean eliminar(){
        if (fin == null) {
            return false;
        }

         if (ini == fin) {
            ini = fin = null;
            return true;
        }

        Nodo temp = ini;
        ini = temp.getDespues();
        temp.setDespues(null);
        temp = null;
        return true;
    }
    
    //Get´s
    public Nodo getIni() {
        return ini;
    }

    public Nodo getFin() {
        return fin;
    }
    
    //EstaVacia
    protected boolean estaVacia(){
        return ini == null && fin == null;
    }
    
    //HayUnNodo
    protected boolean hayUnNodo(){
        return ini == fin;
    }  
}
