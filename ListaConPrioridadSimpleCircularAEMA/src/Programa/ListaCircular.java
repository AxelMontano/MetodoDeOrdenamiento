package Programa;

public class ListaCircular extends ListaSimple{

    public ListaCircular() {
        super();
    }
        
    @Override
    //Insertar
    public boolean insertar(char dato, int prioridad){
        if (super.insertar(dato, prioridad)) {
            fin.setDespues(ini);
            return true;
        }
        return false;
    }
    
    @Override
    //Eliminar
    public boolean eliminar(){ 

        if (super.eliminar() && fin != null) {
            fin.setDespues(ini);
            return true;
        }
        
        if(!(estaVacia())) 
        fin.setDespues(ini);
        return true;     
    }  
}
