package ejercicios;

public class voraces {

	static int[] usuario = { 4, 3, 1, 2, 5 };

	public static void main(String[] args) {

		tareas(usuario, 2);
	}

	public static int tareas(int[] ts, int n) {
		int[] arrayIndicesOrdenados = ordenacionInsercion(ts);
		int[] tareas = new int[n];
		int sumaTotal = 0;

		for (int i = 0; i < ts.length;) {

			tareas[i % n] += ts[arrayIndicesOrdenados[i]];
			sumaTotal += tareas[i % n];
			i++;
		}

		System.out.println("Suma final = " + sumaTotal);

		return sumaTotal;

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
