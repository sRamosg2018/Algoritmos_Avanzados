package ejercicios;

public class voraces {

	static int[] usuario = { 5, 2, 3, 4, 1 };

	public static void main(String[] args) {

		tareas(ordenacionInsercion(usuario), 2);

	}

	public static int tareas(int[] ts, int n) {

		int[] tareas = new int[n];

		// tareas[indiceProcesador][0]: Guarda la suma total del procesador

		// tareas[indiceProcesador][1]: Guarda la suma de los números adicionales
		// a sumar en cada nueva iteración

		int sumaTotal = 0;
		int indiceProcesador = 0;

		for (int i = 0; i < ts.length;) {

			if (indiceProcesador < n) {
				tareas[indiceProcesador] += usuario[ts[i]];
				sumaTotal += tareas[indiceProcesador];
				indiceProcesador++;
				i++;

			} else {
				indiceProcesador = 0;
			}

		}

		System.out.println("Suma final = " + sumaTotal);

		return 0;

	}

	public static int[] ordenacionInsercion(int[] v) {
		int[] v2 = new int[v.length];
		v2[0] = 0;
		for (int i = 1; i < v.length; i++) {
			int aux = v[i];
			int j;
			for (j = i - 1; j >= 0 && v[v2[j]] > aux; j--)
				v2[j + 1] = v2[j];
			v2[j + 1] = i;
		}

		return v2;
	}
}
