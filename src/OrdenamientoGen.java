import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class OrdenamientoGen {
    
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

    public static <T extends Comparable<T>> void mergeSort( List<T> miArray, int n) {
        if (n < 2) {
            return;
        }

        int mid = n / 2;
    
        List left = new ArrayList<>();
        List right = new ArrayList<>();
       

        for (int i = 0; i < mid; i++) {
            left.set(i, miArray.get(i));
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
            right.set(i - mid, miArray.get(i));
        }
        ////
        mergeSort(l, mid);
        mergeSort(r, n - mid);
    
        merge(a, l, r, mid, n - mid);
    }
    public static void merge(
    int[] a, int[] l, int[] r, int left, int right) {
 
    int i = 0, j = 0, k = 0;
    while (i < left && j < right) {
        if (l[i] <= r[j]) {
            a[k++] = l[i++];
        }
        else {
            a[k++] = r[j++];
        }
    }
    while (i < left) {
        a[k++] = l[i++];
    }
    while (j < right) {
        a[k++] = r[j++];
    }
}

}