package Programa;

public class ListaPrioridad extends ListaCircular {
    
    public ListaPrioridad(){
        super();
    }
    
    @Override
    //insertar
    public boolean insertar (char dato, int prioridad){
        
        if(super.estaVacia()) return super.insertar(dato, prioridad);
        
        if(VerificarRepetidos(dato, prioridad)) return false;
        
        Nodo nuevo = new Nodo(dato, prioridad);
        if(nuevo == null) return false;
        
        if(prioridad > ini.getPrioridad()){
            nuevo.setDespues(ini);
            ini = nuevo;
            fin.setDespues(ini);
            return true;
        }
        
        if(prioridad <= fin.getPrioridad()){
            fin.setDespues(nuevo);
            fin = nuevo;
            fin.setDespues(ini);
            return true;
        }
        
        Nodo temp1 = ini.getDespues();
        Nodo temp2 = ini;
        
        while(!(prioridad > temp1.getPrioridad())){
            temp1 = temp1.getDespues();
            temp2 = temp2.getDespues();
        }
        
        temp2.setDespues(nuevo);
        nuevo.setDespues(temp1);
        
        return true;
    }
    
    //Eliminar
    public boolean eliminar(char dato, int prioridad){
        if(estaVacia()) 
        return false;
        
        if(ini.getDato() == dato && ini.getPrioridad() == prioridad){
            return eliminar();
        }

        for(Nodo ant = ini, temp = ini.getDespues(); temp != fin.getDespues(); ant = temp, temp = temp.getDespues()){
            if(temp.getDato() == dato && temp.getPrioridad() == prioridad){
                if(temp == fin){
                    fin.setDespues(null);
                    fin = ant;
                    ant.setDespues(ini);
                    temp = null;
                }else{
                    ant.setDespues(temp.getDespues());
                    temp.setDespues(null);
                    temp = null;
                }
                return true;
            }
        }
        return false;
    }
    
    //Verificador de si esta repetido el dato con la prioridad
    private boolean VerificarRepetidos(char dato, int prioridad){
        if(hayUnNodo()){
            if(ini.getDato() == dato && ini.getPrioridad() == prioridad){
                return true;
            }
        }
        for(Nodo i = ini; i != fin; i = i .getDespues()){
            if(i.getDato() == dato && i.getPrioridad() == prioridad){
                return true;
            }
        }
        return false;
    }     
}
