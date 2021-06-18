import javax.swing.JOptionPane;

/*Equipo:
    Axel Michell ventura Almeida Montaño
    Iván Santillán carrillo
    Ricardo Javier Elizondo López
    //Kevin Jair barrera san juan
    */

public class OrdenamientosInternos {
    private int A[], temp;
    
    public boolean Generar(){
        int tam = Integer.parseInt(JOptionPane.showInputDialog("¿CUANTOS NUMEROS DESEA GENERAR"));
        A = new int [tam];
        for(int i =0; i < A.length; i++){
            A[i] = (int)(Math.random()*1000);
            for(int s = 0;s < i; s++ ){
                if (A[i] == A[s]){
                    A[i] = (int)(Math.random()*100);
                }
            }
        }
        return true;
    }
    public boolean burbuja(int []array){
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1;j++){
                if(array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        return true;
    }
    
    public boolean quicksort1(int []array){
        return quicksort2(array,0,array.length-1);
    }
    
    public boolean quicksort2(int []array, int izq, int der){
        int pivote=izq;
        int i=izq;
        int j=der;
        pivote=array[(izq+der)/2];
        do{
            while(array[i]<pivote){
                i++;
            }
            while(array[j]>pivote){
                j--;
            }
            if(i<=j){
                temp=array[i];
                array[i]=array[j];
                array[j]=temp;
                i++;
                j--;
            }
        }while(i<=j);
        if(izq<j){
            quicksort2(array,izq,j);
        }
        if(i<der){
            quicksort2(array,i,der);
        }
        return true;
    }
    
    public boolean shell(int []array){
        int salto,temp;
        salto=array.length/2;    
        while(salto>0){
            for(int i=salto;i<array.length;i++){
                int j=i-salto;
                while(j>=0){
                   int k=j+salto;
                   if(array[j]<=array[k]){
                       j=-1;
                   }else{
                       temp=array[j];
                       array[j]=array[k];
                       array[k]=temp;
                       j=j-salto;
                   }
                }
            }
            salto=salto/2;
        }
        return true;
    }
    
    public boolean radix(int []array){
        int h,i,j;
        for(h=Integer.SIZE-1;h>=0;h--){
            int temp[]=new int[array.length];
             j=0;
            for(i=0;i<array.length;i++){
                boolean mover=array[i]<<h>=0;
                if(h==0 ? !mover:mover){
                    temp[j]=array[i];
                    j++;
                }else{
                    array[i-j]=array[i];
                }
            }
            for(i=j;i<temp.length;i++){
                temp[i]=array[i-j];
            }
            array=temp;
        }
        return true;
    }
    
    public int[] CopiaA(){
        return A;
    }
}
