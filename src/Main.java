import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class Main {

    public static void main(String [ ] args){
        ArrayList<Integer> miArray = new ArrayList<Integer>();

        //agrgamos valores al array
        miArray.add(30);
        miArray.add(4);
        miArray.add(23);
        miArray.add(20);
        miArray.add(7);
        miArray.add(12);

        
        for(int i : miArray){
            System.out.println(i );
        }

        //OrdenamientoGen.insertionSort(miArray);
        Ordenamiento.mergeSort(miArray, miArray.size());
        System.out.println("array ordenado");

        for(int i : miArray){
            System.out.println(i );
        }
    }

    
    
}
