import java.util.List;
import java.util.ArrayList;

public class OrdenamientoGen {
    
//---BUBBLE SORT--------------------------------------------------------------
    public static <T extends Comparable<T>> void bubbleSort( List<T> miArray){

        T temporal;

         for(int i=0; i < miArray.size(); i++){  

            for(int j=1; j < ( miArray.size()-i ); j++){  
                if(miArray.get(j-1).compareTo(miArray.get(j)) > 0){  
                    //swap elements  
                    temporal = miArray.get(j-1);  
                    miArray.set( j-1, miArray.get(j));  
                    miArray.set(j, temporal);
                }  
                          
            }  
         }  

    }
    
//---SELECTION SORT--------------------------------------------------------------
    public static <T extends Comparable<T>> void selectionSort( List<T> miArray){

        for (int i = 0; i < miArray.size() - 1; i++) {  
            int index = i;

            //busco el índice del menor
            for (int j = i + 1; j < miArray.size(); j++){  
                if (miArray.get(j).compareTo(miArray.get(index)) < 0) {  
                    index = j;   
                }  
            }  
            T smallerNumber = miArray.get(index);   
            miArray.set(index, miArray.get(i)); 
            miArray.set(i, smallerNumber);
        }  
    }

//---INSERTION SORT--------------------------------------------------------------
    public static <T extends Comparable<T>> void insertionSort( List<T> miArray){
    
        for (int j = 1; j < miArray.size(); j++) { 

            T key = miArray.get(j);  
            int i = j-1;  

            while ( (i > -1) && ( miArray.get(i).compareTo(key) > 0 ) ) {  
                miArray.set(i+1, miArray.get(i));
                i--;  
            }   
            miArray.set(i+1,  key);
        }  

    }

//---MERGE SORT-------------------------------------------------------------------
    public static <T extends Comparable<T>> void mergeSort( List<T> miArray, int n) {
        if (n < 2) {
            return;
        }

        int mid = n / 2;
    
        List<T> left = new ArrayList<>();
        List<T> right = new ArrayList<>();
       
        for (int i = 0; i < mid; i++) {
            left.add(i, miArray.get(i));
        }
        for (int i = mid; i < n; i++) {
            right.add(i - mid, miArray.get(i));
        }
       
        mergeSort(left, mid);
        mergeSort(right, n - mid);
    
        merge(miArray, left, right, mid, n - mid);
    }
    
    public static <T extends Comparable<T>> void merge(List<T> miArray, List<T> left, List<T> right, int l, int r) {
 
        int i = 0, j = 0, k = 0;

        while (i < l && j < r) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
               miArray.set(k++, left.get(i++));
            }
        else {
                miArray.set(k++, right.get(j++));
        }
    }
        while (i < l) {
            miArray.set(k++, left.get(i++));
        }
        while (j < r) {
            miArray.set(k++, right.get(j++));
        }
    }


//---QUICK SORT----------------------------------------------------------------------------------
    public static <T extends Comparable<T>> void quickSort(List<T> miArray, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(miArray, begin, end);
    
            quickSort(miArray, begin, partitionIndex-1);
            quickSort(miArray, partitionIndex+1, end);
        }
    }

    public static <T extends Comparable<T>> int partition(List<T> miArray, int begin, int end) {

        T pivot = miArray.get(end);
        int i = (begin-1);
    
        //arr[j] <= pivot
        for (int j = begin; j < end; j++) {

            if (miArray.get(j).compareTo(pivot) <= 0 ) {
                i++;
                T swapTemp = miArray.get(i);
                miArray.set(i, miArray.get(j));
                miArray.set(j, swapTemp);
            }
        }
        
        T swapTemp = miArray.get(i+1);
        miArray.set(i+1, miArray.get(end));
        miArray.set(end, swapTemp);
        return i+1;
    }
}