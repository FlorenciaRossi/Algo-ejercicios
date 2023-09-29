import java.util.ArrayList;

public class Ordenamiento {
    
    public static void bubbleSort( ArrayList<Integer> miArray){

        int temporal = 0;

         for(int i=0; i < miArray.size(); i++){  

            for(int j=1; j < ( miArray.size()-i ); j++){  
                if(miArray.get(j-1) > miArray.get(j)){  
                    //swap elements  
                    temporal = miArray.get(j-1);  
                    miArray.set( j-1, miArray.get(j));  
                    miArray.set(j, temporal);
                }  
                          
            }  
         }  

    }

    
    
}
