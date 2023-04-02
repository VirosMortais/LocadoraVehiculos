
package programa;

import clasesVehiculos.Vehiculos;
import java.util.ArrayList;

/**
 * 
 * La clase Alquiler representa un sistema de alquiler de vehículos, donde se
 * pueden añadir vehículos disponibles, calcular y mostrar el precio de alquiler
 * para un vehículo específico identificado por su matrícula, calcular y mostrar
 * el precio total del alquiler de todos los vehículos en el sistema y comprobar
 * si existe un vehículo en la lista con la matrícula especificada.
 * 
 * @author Charl
 * @version 1.0
 * @since 2023/04/02
 */

public class Alquiler {
	// Atributos
	/**
	 * Lista de vehículos disponibles en el sistema.
	 */
	private static ArrayList<Vehiculos> vehiculo = new ArrayList<>();
	/**
	 * El número de días durante los cuales se alquilarán los vehículos.
	 */
	private int dias;

	/**
	 * Calcula y muestra el precio de alquiler para un vehículo específico,
	 * identificado por su matrícula.
	 *
	 * @param matricula La matrícula del vehículo para el cual se desea calcular el
	 *                  precio de alquiler.
	 * @param dias      El número de días durante los cuales se alquilará el
	 *                  vehículo.
	 */
	public static void precioAlquilerM(String matricula, int dias) {
		boolean er = true;
		for (Vehiculos v : vehiculo) {
			if (matricula.matches(v.getMatricula())) {
				System.out.println("==========Alquiler============");
				System.out.print("Precio alquiller para: " + v.getClass().getSimpleName() + "\nCon la matricula: "
						+ matricula + "\nDurante: " + dias + " dias" + "\nPrecio: " + v.precioAlquilerVehiculo(dias)
						+ "$\n");
				er = false;
			}
		}

		if (er)
			System.err.println("No encontramos ningún vehiculo con esa matricula ");

	}

	/**
	 * Calcula y muestra el precio total del alquiler de todos los vehículos en el
	 * sistema.
	 *
	 * @param dias El número de días durante los cuales se alquilarán los vehículos.
	 */
	public static void precioAlquilerTotal(int dias) {
		for (Vehiculos v : vehiculo) {
			System.out.println("=========="+ v.getClass().getSimpleName() +"============");
			System.out.println(v.info());
			System.out.print("\nDurante: " + dias + " dias" +
							"\nPrecio: " + v.precioAlquilerVehiculo(dias) + "$\n");
			
		}
	}

	/**
	 * Comprueba si existe un vehículo en la lista con la matrícula especificada.
	 *
	 * @param matri La matrícula que se desea comprobar.
	 * @return true si existe un vehículo en la lista con la matrícula especificada,
	 *         false en caso contrario.
	 */
	public static boolean compMatri(String matri) {
		boolean comp = false;
		for (Vehiculos v : vehiculo) {
			if (matri.matches(v.getMatricula())) {
				comp = true;
			}
		}
		return comp;
	}

	/**
	 * Añade un vehículo a la lista de vehículos disponibles.
	 *
	 * @param v El vehículo que se desea añadir a la lista.
	 */
	public static void anadirVehiculo(Vehiculos v) {
		vehiculo.add(v);
	}

	// Setters y Getters

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

}