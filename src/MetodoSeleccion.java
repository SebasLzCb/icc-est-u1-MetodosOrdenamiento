public class MetodoSeleccion {
    public int[] ordenar(int[] arreglo, boolean ascendente, boolean pasos) {
        int comparaciones = 0;
        int cambios = 0;

        for (int i = 0; i < arreglo.length - 1; i++) {
            int iM = i;
            for (int j = i + 1; j < arreglo.length; j++) {
                comparaciones++;
                if (pasos) {
                    System.out.println("Comparación " + comparaciones + ": " + arreglo[j] + " " + (ascendente ? "<" : ">") + " " + arreglo[iM]);
                }

                if ((ascendente && arreglo[j] < arreglo[iM]) || (!ascendente && arreglo[j] > arreglo[iM])) {
                    iM = j;
                }
            }

            if (i != iM) {
                cambios++;
                if (pasos) {
                    System.out.println("Intercambio: " + arreglo[i] + " <-> " + arreglo[iM]);
                }
                int aux = arreglo[i];
                arreglo[i] = arreglo[iM];
                arreglo[iM] = aux;

                if (pasos) {
                    printArray(arreglo, "Estado actual ->");
						System.out.println("");
                }
            } else if (pasos) {
                System.out.println("(No hay intercambio)");
                printArray(arreglo, "Estado actual ->");
					System.out.println("");
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
