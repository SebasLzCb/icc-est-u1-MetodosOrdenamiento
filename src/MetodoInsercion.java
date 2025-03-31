public class MetodoInsercion {
    public int[] ordenar(int[] arr, boolean ascendente, boolean pasos) {
        int comparaciones = 0;
        int cambios = 0;

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0) {
                comparaciones++;
                if (pasos) {
                    System.out.println("Comparación " + comparaciones + ": " 
                        + arr[j] + (ascendente ? " > " : " < ") + key);
                }

                if ((ascendente && arr[j] > key) || (!ascendente && arr[j] < key)) {
                    if (pasos) {
                        System.out.println("Intercambio: " + arr[j] + " <-> " + key);
                    }
                    arr[j + 1] = arr[j];
                    arr[j] = key;     
                    cambios++;

                    if (pasos) {
                        printArray(arr, "Estado actual ->");
						  System.out.println("");
                    }
                    j--;
                } else {
 
                    if (pasos) {
                        System.out.println("(No hay intercambio)");
                        printArray(arr, "Estado actual ->");
						  System.out.println("");
                    }
                    break;
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
