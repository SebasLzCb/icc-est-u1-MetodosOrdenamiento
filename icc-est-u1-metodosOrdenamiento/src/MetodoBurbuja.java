public class MetodoBurbuja {
    public int[] ordenar(int[] arreglo, boolean ascendente, boolean pasos) {
        int n = arreglo.length;
        int comparaciones = 0;
        int cambios = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparaciones++;

                if (pasos) {
                    System.out.println("Comparación " + comparaciones + ": " + arreglo[j] + " " + (ascendente ? ">" : "<") + " " + arreglo[j + 1]);
                }

                if ((ascendente && arreglo[j] > arreglo[j + 1]) || (!ascendente && arreglo[j] < arreglo[j + 1])) {
                    if (pasos) {
                        System.out.println("Intercambio: " + arreglo[j] + " <-> " + arreglo[j + 1]);
                    }
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    cambios++;

                    if (pasos) {
                        printArray(arreglo, "Estado actual ->");
							System.out.println("");
						 
                    }
                } else {
                    if (pasos) {
                        System.out.println("(No hay intercambio)");
                        printArray(arreglo, "Estado actual ->");
							System.out.println("");
                    }
                }
			
            }
        }

        System.out.println("--FIN DEL METODO--");
        return new int[]{comparaciones, cambios};
    }

    private void printArray(int[] arreglo, String mensaje) {
        System.out.print(mensaje + " ");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
