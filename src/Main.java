import java.util.ArrayList;

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

        //OrdenamientoGen.bubbleSort(miArray);
        //OrdenamientoGen.selectionSort(miArray);
        //OrdenamientoGen.insertionSort(miArray);
        //OrdenamientoGen.mergeSort(miArray, miArray.size());
        OrdenamientoGen.quickSort(miArray, 0, miArray.size() - 1);
        System.out.println("array ordenado:");

        for(int i : miArray){
            System.out.println(i);
        }
    }

    
    
}
