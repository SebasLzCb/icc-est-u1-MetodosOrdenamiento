public class MetodoBurbujaMejorado {

    public int[] ordenar(int[] arreglo, boolean ascendente, boolean pasos) {
        int tam = arreglo.length;
        int contComparaciones = 0;
        int contCambios = 0;

        for (int i = 0; i < tam - 1; i++) {
            boolean huboCambio = false;
            for (int j = 0; j < tam - 1 - i; j++) {
                contComparaciones++;
                if (pasos) {
                    System.out.println("Comparación " + contComparaciones + ": " + arreglo[j] + " " + (ascendente ? ">" : "<") + " " + arreglo[j + 1]);
                }

                if ((ascendente && arreglo[j] > arreglo[j + 1]) || (!ascendente && arreglo[j] < arreglo[j + 1])) {
                    contCambios++;
                    if (pasos) {
                        System.out.println("Intercambio: " + arreglo[j] + " <-> " + arreglo[j + 1]);
                    }
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    huboCambio = true;
                }

                if (pasos) {
                    printArray(arreglo, "Estado actual ->");
					System.out.println("");
                }
				
            }

            if (!huboCambio) break; 
        }

        System.out.println("--FIN DEL METODO--");
		System.out.println(" ");
        return new int[]{contComparaciones, contCambios};
    }

    private void printArray(int[] arreglo, String mensaje) {
        System.out.print(mensaje + " ");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}