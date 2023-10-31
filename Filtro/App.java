public class App {
        public static void main(String[] args) {
        Integer[][] m1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8}
        };
        String[] cols = {"A", "B", "C", "D"};
        String[] filas = {"x", "y"};
        Matriz<Integer> miMatriz = new Matriz<>(m1, cols, filas);
        // Matriz<Integer> miMatriz = Matriz.crearDesdeMatriz(m1);
        miMatriz.setCelda(0, 0, 9);
        System.out.println(miMatriz);
        //System.out.println(miMatriz.getCelda("x", "C"));
    
        System.out.println(miMatriz.filtrar("A", '<', 6));
        
    }
}
