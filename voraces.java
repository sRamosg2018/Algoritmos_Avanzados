package ejercicios;

public class voraces {

	static int[] ts = { 1, 5, 3, 2, 4 };

	public static void main(String[] args) {

		tareas(ordenacionInsercion(ts.clone()), 2);

	}

	public static int tareas(int[] ts, int n) {
		int tareasPorProcesador = ts.length / n;

		if ((ts.length % n) != 0)
			tareasPorProcesador++;

		int[][] procesadores = new int[n][tareasPorProcesador];

		int indiceTareas = 0;

		// Se recorre el array de indices para asignar cada uno de estos valores a su
		// procesador correspondiente
		int i = 0;
		while (i < ts.length) {
			for (int j = 0; j < n && i < ts.length; j++) {
				procesadores[j][indiceTareas] = ts[i];
				i++;
			}
			indiceTareas++;

		}

		int suma = sumaTiempos(procesadores, n, tareasPorProcesador);
		System.out.println("Suma final = " + suma);

		return 0;

	}

	public static int[] ordenacionInsercion(int[] array) {
		int index, aux;

		for (int i = 1; i < array.length; i++) {
			index = array[i];
			aux = i - 1;
			while (aux > 0 && array[aux] > index) {
				array[aux + 1] = array[aux];
				aux = aux - 1;
			}
			array[aux + 1] = index;

		}
		return array;

	}

	public static int sumaTiempos(int[][] array, int n, int tareasPorProcesador) {

		int suma = 0;
		int auxSuma, aux, j; // relativas a cada iteracion del bucle

		for (int i = 0; i < n; i++) {

			aux = 0;
			auxSuma = 0;
			j = 0;

			while (j < tareasPorProcesador) {
				if (array[i][j] > 0) { // Solo las tareas con valor > 0 pueden ser realizadas, algo con tiempo negativo
										// o 0 no se puede considerar tarea
					auxSuma += array[i][j] + aux;
					aux = array[i][j] + aux;

				}

				j++;
			}
			suma += auxSuma;

		}
		return suma;
	}

}
