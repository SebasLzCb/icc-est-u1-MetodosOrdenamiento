import java.util.Scanner; 

public class App {
    public static void main(String[] args) {
        
        MetodoBurbuja mB = new MetodoBurbuja();
        MetodoSeleccion mS = new MetodoSeleccion();
        MetodoInsercion mI = new MetodoInsercion();  
        MetodoBurbujaMejorado mBM = new MetodoBurbujaMejorado();

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
			
            int[] listadoOriginal = {12, -7, 25, 0, -15, 33, 19, -22, 5, 48, -3, 27, -30, 14, 7, -1, 41, 20, -11, 8};
			//int[] listadoOriginal = { 10, 9, 21, 5, 15, 2, -1, 0};
            int[] listado = listadoOriginal.clone(); 

            System.out.println("\n Métodos de ordenamiento");
            System.out.println("1-> Burbuja");
            System.out.println("2-> Selección");
            System.out.println("3-> Inserción");
            System.out.println("4-> Burbuja Mejorado");
            System.out.println("5-> Salir");


            int metodo = getValidInt(scanner, 1, 5, "Seleccione un método de ordenamiento (1-5)");

            if (metodo == 5) {
                System.out.println("Adiós");
                continuar = false;
                break;
            }

            System.out.println("¿Desea ver los pasos? (true/false):");
            boolean conPasos = scanner.nextBoolean();

            String[] posibles = {"A", "D"};
            String orden = getValidString(scanner, posibles, "¿Desea ordenar ascendentemente (A) o descendentemente (D)?");
            boolean ascendente = orden.equalsIgnoreCase("A");

            switch (metodo) {
                case 1:
                    System.out.println("Método Burbuja");
					System.out.println("Arreglo Original");
						printArray(listadoOriginal);
					System.out.println("");
                    int[] resultadosB = mB.ordenar(listado, ascendente, conPasos);
                    mostrarResultados(listado, resultadosB);
                    break;
                case 2:
                    System.out.println("Método Selección");
					System.out.println("Arreglo Original");
						printArray(listadoOriginal);
					System.out.println("");
                    int[] resultadosS = mS.ordenar(listado, ascendente, conPasos);
                    mostrarResultados(listado, resultadosS);
                    break;
                case 3:
                    System.out.println("Método Inserción");
					System.out.println("Arreglo Original");
					printArray(listadoOriginal);
					System.out.println("");
                    int[] resultadosI = mI.ordenar(listado, ascendente, conPasos);
                    mostrarResultados(listado, resultadosI);
                    break;
                case 4:
                    System.out.println("Método Burbuja Mejorado");
					System.out.println("Arreglo Original");
						printArray(listadoOriginal);
					System.out.println("");
                    int[] resultadosBM = mBM.ordenar(listado, ascendente, conPasos);
                    mostrarResultados(listado, resultadosBM);
                    break;
            }
        }
        scanner.close();
    }

    private static void mostrarResultados(int[] arreglo, int[] resultados) {
        System.out.println("Arreglo Ordenado");
        printArray(arreglo);
        System.out.println("Comparaciones -> " + resultados[0]);
        System.out.println("Cambios -> " + resultados[1]);
    }

    private static void printArray(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int getValidInt(Scanner scanner, int min, int max, String message) {
        int input;
        do {
            System.out.print(message + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Debe ingresar un número válido.");
                scanner.next();
            }
            input = scanner.nextInt();
        } while (input < min || input > max);
        return input;
    }

    public static String getValidString(Scanner scanner, String[] posibles, String message) {
        String input;
        boolean valido;
        do {
            System.out.print(message + ": ");
            input = scanner.next();
            valido = false;
            for (String posible : posibles) {
                if (input.equalsIgnoreCase(posible)) {
                    valido = true;
                    break;
                }
            }
        } while (!valido);
        return input;
    }
}