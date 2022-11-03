package ejercicios;

public class Backtracking {

	// public static final int[] Datos = { 40, 30, 20, 10};
	// public static final int[] Indice = {39, 29, 19, 9};

	 public static final int[] Datos = { 10, 1, 7, 7 };
	 public static final int[] Indice = { 8, 4, 2, 1 };

	// public static final int[] Datos = { 2, 82, 64, 60 };
	// public static final int[] Indice = { 42, 22, 19, 9 };

	public static void main(String[] args) {

		System.out.println(">>" + procesar(Datos, Indice));
	}

	public static int procesar(int ds[], int cs[]) {
		// return calcular(ds, cs, 0, 0, 0);
		int[] a = new int[5];
		int[] b = new int[5];
		return calcularActualizado(ds, cs, 0, 0, 0, a, -1, b);
	}

	public static int calcular(int ds[], int cs[], int indice, int nivel, int suma) {

		if (nivel < ds.length) {
			return Math.max(calcular(ds, cs, indice + 1, nivel + 1, suma + Math.min(ds[nivel], cs[indice])),
					calcular(ds, cs, 0, nivel + 1, suma));

		} else {
			System.out.println(suma);
			return suma;

		}

	}

	public static int calcularActualizado(int ds[], int cs[], int indice, int nivel, int valorActual, int[] solActual,
			int valorOptimo, int[] solOptima) {
		int pos = 0;
		for (int i = -1; i < 1; i++) { //si es -1 reinicia, si es 0 trabaja
			if (nivel < ds.length) {
				solActual[pos] = i;
				pos++;
				if (i == 0) {
					valorActual += Math.min(ds[nivel], cs[indice]);
				}

				if (nivel == ds.length - 1) {
					System.out.println(">>"+valorActual);
					if (valorActual > valorOptimo) {
						valorOptimo = valorActual;
					}
				} else {
					if (i == 0) {
						valorOptimo = calcularActualizado(ds, cs, indice + 1, nivel + 1, valorActual, solActual,
								valorOptimo, solOptima);
					} else {
						valorOptimo = calcularActualizado(ds, cs, 0, nivel + 1, valorActual, solActual, valorOptimo,
								solOptima);
					}

				}
			}

		}

		return valorOptimo;
	}

}