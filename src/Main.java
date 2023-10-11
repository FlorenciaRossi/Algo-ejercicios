import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String [ ] args){
        List<Integer> miArray = new ArrayList<Integer>();

        //agrgamos valores al array
        miArray.add(30);
        miArray.add(4);
        miArray.add(23);
        miArray.add(20);
        miArray.add(7);
        miArray.add(12);
        
        //PROBAMOS BUSQUEDA LIENAL
        int pos = BusquedaGen.lineal(miArray, 7);
        if (pos > -1 ){ System.out.println("Valor encontrado en la posición " + pos);}
        else { System.out.println("Valor no encontrado");}

        //PROBAMOS LOS ALGORITMOS DE ORDENAMIENTO
        OrdenamientoGen.bubbleSort(miArray);
        //OrdenamientoGen.selectionSort(miArray);
        //OrdenamientoGen.insertionSort(miArray);
        //OrdenamientoGen.mergeSort(miArray, miArray.size());
        //OrdenamientoGen.quickSort(miArray, 0, miArray.size() - 1);
        //System.out.println("array ordenado:");

        //VICUALIZAMOS EL ARRAY
        for(int i : miArray){
            System.out.println(i);
        }

        //PROBAMOS LA BUSQUEDA BINARIA EN UN ARRAY YA ORDENADO
        pos = BusquedaGen.binaria(miArray, 30);
        if (pos > -1 ){ System.out.println("Valor encontrado en la posición " + pos);}
        else { System.out.println("Valor no encontrado");}
    }

    
    
}
