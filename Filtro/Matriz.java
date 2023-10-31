import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Matriz<T extends Comparable<T>> {
    List<List<T>> columnas;
    Map<String, Integer> colLabels;
    Map<String, Integer> rowLabels;

    public Matriz(int cantidadColumnas) {
        if (cantidadColumnas < 1)
            throw new IllegalArgumentException("La longitud de columnas debe ser mayor a 0.");
        
        columnas = new ArrayList<>();
        colLabels = new HashMap<>();
        rowLabels = new HashMap<>();
        for(int j=0; j < cantidadColumnas; j++) {
            columnas.add(j, new ArrayList<>());
            colLabels.put(String.valueOf(j), j);
        }
    }

    public Matriz(int cantidadColumnas, String[] etiquetas) {
        this(cantidadColumnas);
        if (cantidadColumnas != etiquetas.length)
            throw new IllegalArgumentException("La longitud de etiquetas no coincide.");
        setEtiquetasColumnas(etiquetas);
    }

    public Matriz(T[][] matriz) {
        this(matriz[0].length);
        inicializarDesdeMatriz(matriz);
    }

    public Matriz(T[][] matriz, String[] etiquetasColumnas) {
        this(matriz[0].length, etiquetasColumnas);
        inicializarDesdeMatriz(matriz);
    }

    public Matriz(T[][] matriz, String[] etiquetasColumnas, String[] etiquetasFilas) {
        this(matriz, etiquetasColumnas);
        if (columnas.get(0).size() != etiquetasFilas.length)
            throw new IllegalArgumentException("La longitud de etiquetas de filas no coincide.");
        setEtiquetasFilas(etiquetasFilas);
    }

    public void setEtiquetasFilas(String[] etiquetas) {
        rowLabels.clear();
        for(int i=0; i < columnas.get(0).size(); i++) {
            rowLabels.put(etiquetas[i], i);
        }
    }

    public void setEtiquetasColumnas(String[] etiquetas) {
        colLabels.clear();
        for(int j=0; j < columnas.size(); j++) {
            colLabels.put(etiquetas[j], j);
        }
    }

    private void inicializarDesdeMatriz(T[][] matriz) {
        for(int j=0; j < columnas.size(); j++) {
            for(int i=0; i < matriz.length; i++) {
                columnas.get(j).add(i, matriz[i][j]);
            }
        }
        for(int i=0; i < columnas.get(0).size(); i++) {
            rowLabels.put(String.valueOf(i), i);
        }
    }

    public static <T extends Comparable<T>> Matriz<T> crearDesdeMatriz(T[][] matriz) {
        return new Matriz<>(matriz);
    }

    public T getCelda(String fila, String columna) {
        return columnas.get(colLabels.get(columna)).get(rowLabels.get(fila)); // columnas[columna][fila]
    }

    public void setCelda(int fila, int columna, T valor) {
        columnas.get(columna).set(fila, valor);
    }

    @Override
    public String toString() {

        String out = "  | ";
        String sep = " | ";
        for(String label : colLabels.keySet()) {
            out += label + sep;
        }
        out += "\n";
        for(String fila : rowLabels.keySet()) {
            out += fila + sep;
            for(String columna : colLabels.keySet()) {
                out += getCelda(fila, columna);
                out += sep;
            }
            out += "\n";
        }
        return out;
    }

    
    public String toString(List<String> rowLabelsFiltrado) {
        String out = "  | ";
        String sep = " | ";
        for(String label : colLabels.keySet()) {
            out += label + sep;
        }
        out += "\n";
        for(String fila : rowLabelsFiltrado) {
            out += fila + sep;
            for(String columna : colLabels.keySet()) {
                out += getCelda(fila, columna);
                out += sep;
            }
            out += "\n";
        }
        return out;
    }

    public String filtrar(String col , char operador, T valor) {

        //Creo un mapa con un caracter y un Predicate
        Map<Character, Predicate<T>> operadores = new HashMap<>();
        operadores.put('<', e -> e.compareTo(valor) < 0);
        operadores.put('>', e -> e.compareTo(valor) > 0);
        operadores.put('=', e -> e.compareTo(valor) == 0);
        operadores.put('!', e -> e.compareTo(valor) != 0);

        Predicate<T> condicion = operadores.get(operador);
        List<String> salida = new ArrayList<>();
        
        if (condicion != null) {
            for(String rowLabel : rowLabels.keySet()) {
                T valorAcomparar = columnas.get(colLabels.get(col)).get(rowLabels.get(rowLabel));
                if (condicion.test(valorAcomparar)) {
                salida.add(rowLabel);  
                }
            }
            return toString(salida);
        } else {
            return "Operador no válido: " + operador;
        }
    }

    // public String filtrarMenorA(String col, T val) {
       
    //     List<String> salida = new ArrayList<>();

    //     for(String rowLabel : rowLabels.keySet()) {
    //         T valorAcomparar = columnas.get(colLabels.get(col)).get(rowLabels.get(rowLabel));
    //         if (valorAcomparar.compareTo(val) < 0) {
    //             //salida.add(valorAcomparar);
    //             salida.add(rowLabel);
    //         }
    //     }
    //     return toString(salida);
    // }
}
