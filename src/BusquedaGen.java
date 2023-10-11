import java.util.List;

public class BusquedaGen {

    //---LINEAL--------------------------------------------------------------
    public static <T> int lineal( List<T> miArray, T elemento){
        int i = 0;
        int posicion = -1;
        boolean encontrado = false;

        while( !encontrado && i < miArray.size() ){
            if ( elemento.equals( miArray.get(i)) ){
                posicion = i;
                encontrado = true;
            }
            i++;
        }

        return posicion;
    }

    //---BINARIA--------------------------------------------------------------
    public static <T  extends Comparable<T>> int binaria( List<T> miArray, T elemento){
        return buscar(miArray, elemento, 0 , miArray.size());
    }

    public static <T extends Comparable<T>> int buscar( List<T> miArray, T elemento, int inicio, int fin){
        int centro = (inicio + fin) / 2;

        if (fin < inicio){
            return -1;
        }

        if ( elemento.compareTo(miArray.get(centro)) < 0){
            return buscar(miArray, elemento, inicio, centro - 1);
        }

        if ( elemento.compareTo(miArray.get(centro)) > 0){
            return buscar(miArray, elemento, centro + 1, fin);
        }

        if ( elemento.equals(miArray.get(centro)) ){
            return centro;
        }
        return -1;
    }


}