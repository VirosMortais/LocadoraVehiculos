/**
 * 
 */
package programa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import clasesVehiculos.*;

/**
 * 
 * La clase ProgramaMain es la clase principal del programa y es responsable de
 * proporcionar la interfaz de usuario. Esta clase contiene métodos para:
 * mostrar un menú de opciones añadir un vehículo obtener el precio de alquiler
 * de un vehículo mostrar el precio total de alquiler de todos los vehículos
 * almacenados
 * 
 * @author Charl
 * @version 1.0
 * @since 2023/04/02
 */
public class ProgramaMain {

	public static void main(String[] args) throws IOException {

		int opcion;
		do {
			opcion = opcionMenu();

			switch (opcion) {
			case 1:
				anadeVehiculo();
				break;
			case 2:
				obtienePrecioAlquiler();
				break;
			case 3:
				muestraTodosLosPrecios();
				break;
			default:
				System.out.println("Opción inválida.");
			}
		} while (opcion != 0);

		System.out.println("-----Gracias por ultilizar nuestra tienda-----");
	}

	/**
	 * 
	 * Muestra por pantalla el precio total de alquiler de todos los vehiculos
	 * almacenados en la lista de alquileres
	 * 
	 * por el numero de dias de alquiler especificado por el usuario.
	 * 
	 * @throws NumberFormatException si se introduce un valor no numérico.
	 * 
	 * @throws IOException           si ocurre un error al leer la entrada de datos.
	 */
	public static void muestraTodosLosPrecios() throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int dias;
		System.out.println("============================");
		// Asegura que el numero introduzido es positivo
		System.out.print("Introduce los dias de alquiler: ");
		dias = (int) makePositivo(Integer.parseInt(in.readLine()));

		Alquiler.precioAlquilerTotal(dias);

		// Para que el usuario tenga que pulsar alguna tecla(Aceptar) para continar
		System.out.println("\n\nPulse cualquier tecla para continuar...");
		in.readLine();
	}

	/**
	 * 
	 * Obtiene el precio del alquiler de un vehículo según su matrícula y número de
	 * días de alquiler.
	 * 
	 * @throws IOException si hay un error al leer la entrada del usuario.
	 */
	public static void obtienePrecioAlquiler() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String matricula;
		int dias;
		System.out.println("============================");
		// comprueba si el formato de matricula esta bien
		do {
			System.out.print("Introduce la matricula: ");
			matricula = in.readLine();
		} while (compMatricula(matricula));

		// Asegura que el numero introduzido es positivo
		System.out.print("Introduce los dias de alquiler: ");
		dias = (int) makePositivo(Integer.parseInt(in.readLine()));

		Alquiler.precioAlquilerM(matricula, dias);

		// Para que el usuario tenga que pulsar alguna tecla(Aceptar) para continar
		System.out.println("\n\nPulse cualquier tecla para continuar...");
		in.readLine();
	}

	/**
	 * 
	 * Solicita al usuario que seleccione una opción del menú y devuelve la opción
	 * seleccionada como un entero.
	 * 
	 * Las opciones disponibles son:
	 * 
	 * Añadir vehículo. Obtener precio de alquiler. Mostrar todos los precios.
	 * 
	 * @return El número entero correspondiente a la opción seleccionada por el
	 *         usuario.
	 * 
	 * @throws IOException Si hay un error al leer la entrada del usuario.
	 */
	public static int opcionMenu() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("============Menu============" + "\n1. Añade Vehiculo." + "\n2. Obtiene precio alquiler."
				+ "\n3. Muestra todos los precios." + "\nOpcion: ");
		int op = Integer.parseInt(in.readLine());

		return op;
	}

	/**
	 * 
	 * Este método muestra un menú para agregar un vehículo al sistema y solicita al
	 * usuario que introduzca los detalles del vehículo. Primero verifica el formato
	 * de la matrícula y el año de fabricación, y luego llama al método
	 * agregaNuevoVehiculo() para agregar el vehículo al sistema. El método
	 * agregaNuevoVehiculo() muestra otro menú para que el usuario seleccione el
	 * tipo de vehículo a agregar y solicita los detalles específicos de cada tipo
	 * de vehículo. Finalmente, llama al método correspondiente para agregar el
	 * vehículo seleccionado al sistema.
	 * 
	 * @throws IOException si hay un error de entrada/salida durante la ejecución
	 *                     del método
	 */
	public static void anadeVehiculo() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String matricula;
		String marca;
		String color;
		int anios = -1;

		System.out.println("============================");
		System.out.println("Introduz la seguinte informacion del vehiculo.");

		// comprueba si el formato de matricula esta bien
		do {
			System.out.print("Introduce la matricula: ");
			matricula = in.readLine();
		} while (compMatricula(matricula));
		matricula = matricula.toUpperCase();

		System.out.print("Introduce la marca: ");
		marca = in.readLine();

		System.out.print("Introduce el color: ");
		color = in.readLine();

		// Comprueba si el formato de anio esta bien
		while (anios < 0) {
			System.out.print("Introduce el año de fabricación (AAAA): ");
			String input = in.readLine();
			if (compAnio(input)) {
				anios = Integer.parseInt(input);
			} else {
				System.out.println(
						"El año debe tener el formato AAAA y ser un número entero positivo. Inténtalo de nuevo.");
			}
		}

		agregaNuevoVehiculo(matricula, marca, color, anios);

		// Para que el usuario tenga que pulsar alguna tecla(Aceptar) para continar
		System.out.println("\n\nPulse cualquier tecla para continuar...");
		in.readLine();
	}

	/**
	 * 
	 * Muestra un menú para añadir un vehículo al sistema. El usuario selecciona el
	 * tipo de vehículo
	 * 
	 * a añadir y se solicitan los datos necesarios para cada tipo de vehículo.
	 * Llama a los métodos
	 * 
	 * correspondientes para añadir el vehículo al sistema.
	 * 
	 * @param matricula la matrícula del vehículo a añadir
	 * 
	 * @param marca     la marca del vehículo a añadir
	 * 
	 * @param color     el color del vehículo a añadir
	 * 
	 * @param anios     la antigüedad del vehículo a añadir
	 * 
	 * @throws NumberFormatException si hay un error de formato en la entrada del
	 *                               usuario
	 * 
	 * @throws IOException           si hay un error de entrada/salida durante la
	 *                               ejecución del método
	 */
	public static void agregaNuevoVehiculo(String matricula, String marca, String color, int anios)
			throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int op, plazas, metros, ruedas;
		float pma;

		System.out.println("============================");
		System.out.print("Que tipo de vehiculo quieres añadir?" + "\n1. Coche." + "\n2. MicroBus." + "\n3. Camion."
				+ "\n4. Furgoneta" + "\nOpcion: ");
		op = Integer.parseInt(in.readLine());
		System.out.println("============================");
		switch (op) {
		case 1:
			// Pide las plazas del coche
			System.out.print("Introduce el número de plazas: ");
			plazas = (int) makePositivo(Integer.parseInt(in.readLine()));
			// Llama el metodo anadeCoche
			anadeCoche(matricula, marca, color, anios, plazas);
			break;
		case 2:
			// Pide las plazas del MicroBus
			System.out.print("Introduce el número de plazas: ");
			plazas = makePositivo(Integer.parseInt(in.readLine()));
			// Pide los metros del MicroBus
			System.out.print("Introduce el tamaño en 'Metros': ");
			metros = makePositivo(Integer.parseInt(in.readLine()));

			// Llama el metodo anadeMicroBus
			anadeMicroBus(matricula, marca, color, anios, plazas, metros);
			break;
		case 3:
			// Pide el pma del camion
			System.out.print("Introduce el PMA(Peso máximo autorizado en toneladas): ");
			pma = Float.parseFloat(in.readLine());
			// Pide la cantidad de ruedas del Camion
			System.out.print("Introduce la cantidad de ruedas: ");
			ruedas = makePositivo(Integer.parseInt(in.readLine()));
			// Llama al metodo anadeCamion
			anadeCamion(pma, matricula, marca, color, anios, ruedas);
			break;
		case 4:
			// Pide el pma de la Furgoneta
			System.out.print("Introduce el PMA(Peso máximo autorizado en toneladas): ");
			pma = Float.parseFloat(in.readLine());
			// Llama al metodo anadeFurgoneta
			anadeFurgoneta(pma, matricula, marca, color, anios);
			break;
		}
	}

	/**
	 * Añade un Furgoneta a la lista de vehículos disponibles en el sistema de
	 * alquiler.
	 *
	 * @param matricula La matrícula del Furgoneta a añadir.
	 * @param marca     La marca del Furgoneta a añadir.
	 * @param color     El color del Furgoneta a añadir.
	 * @param anios     El número de años que lleva en circulación el Furgoneta a
	 *                  añadir.
	 * @param plazas    El número de plazas que tiene el Furgoneta a añadir.
	 */
	public static void anadeFurgoneta(float pma, String matricula, String marca, String color, int anios) {
		Alquiler.anadirVehiculo(new Furgoneta(pma, matricula, marca, color, anios));

		System.out.println("Furgoneta añadido con éxito.");
	}

	/**
	 * Añade un Camion a la lista de vehículos disponibles en el sistema de
	 * alquiler.
	 *
	 * @param matricula La matrícula del Camion a añadir.
	 * @param marca     La marca del Camion a añadir.
	 * @param color     El color del Camion a añadir.
	 * @param anios     El número de años que lleva en circulación el Camion a
	 *                  añadir.
	 * @param plazas    El número de plazas que tiene el Camion a añadir.
	 */
	public static void anadeCamion(float pma, String matricula, String marca, String color, int anios, int ruedas) {

		Alquiler.anadirVehiculo(new Camion(pma, matricula, marca, color, anios, ruedas));

		System.out.println("Camion añadido con éxito.");
	}

	/**
	 * Añade un MicroBus a la lista de vehículos disponibles en el sistema de
	 * alquiler.
	 *
	 * @param matricula La matrícula del MicroBus a añadir.
	 * @param marca     La marca del MicroBus a añadir.
	 * @param color     El color del MicroBus a añadir.
	 * @param anios     El número de años que lleva en circulación el MicroBus a
	 *                  añadir.
	 * @param plazas    El número de plazas que tiene el MicroBus a añadir.
	 */
	public static void anadeMicroBus(String matricula, String marca, String color, int anios, int plazas, int metros) {
		Alquiler.anadirVehiculo(new MicroBus(matricula, marca, color, anios, plazas, metros));

		System.out.println("MicroBus añadido con éxito.");
	}

	/**
	 * Añade un coche a la lista de vehículos disponibles en el sistema de alquiler.
	 *
	 * @param matricula La matrícula del coche a añadir.
	 * @param marca     La marca del coche a añadir.
	 * @param color     El color del coche a añadir.
	 * @param anios     El número de años que lleva en circulación el coche a
	 *                  añadir.
	 * @param plazas    El número de plazas que tiene el coche a añadir.
	 */
	public static void anadeCoche(String matricula, String marca, String color, int anios, int plazas) {
		Alquiler.anadirVehiculo(new Coche(matricula, marca, color, anios, plazas));

		System.out.println("Coche añadido con éxito.");
	}

	/**
	 * 
	 * Devuelve el valor absoluto de un número, convirtiéndolo en positivo si es
	 * negativo.
	 * 
	 * @param num El número del cual se desea obtener el valor absoluto.
	 * 
	 * @return El valor absoluto del número proporcionado.
	 */
	public static int makePositivo(int num) {
		if (num < 0)
			num = -num;

		return num;
	}

	/**
	 * 
	 * Comprueba si un año es válido.
	 * 
	 * @param anio El año que se desea comprobar.
	 * 
	 * @return true si el año es válido (tiene 4 dígitos y es mayor que 0), false en
	 *         caso contrario.
	 */
	public static boolean compAnio(String anio) {
		boolean comp = true;
		if (anio.length() == 4 && anio.matches("\\d+")) {
			int anioInt = Integer.parseInt(anio);
			if (anioInt <= 0) {
				comp = false;
			}
		} else {
			comp = false;
		}

		return comp;
	}

	/**
	 * 
	 * Comprueba si la matrícula es válida y si existe un vehículo en la lista con
	 * esa matrícula.
	 * 
	 * @param matri La matrícula que se desea comprobar.
	 * @return true si la matrícula es válida y no existe un vehículo en la lista
	 *         con esa matrícula, false en caso contrario.
	 */
	public static boolean compMatricula(String matri) {
		boolean comp = true;

		if (matri.matches("\\d{4}[a-zA-Z]{3}")) {
			comp = false;
			if (Alquiler.compMatri(matri)) {
				comp = true;
				System.out.println("\n\n\n\n\n\n");

				System.out.println("+-------------------------------+");
				System.out.println("|     Matricula ya existe       |");
				System.out.println("+-------------------------------+");
				System.out.println("\n\n ");
			}
		} else {
			System.out.println("\n\n\n\n\n\n");

			System.out.println(
					"+-------------------------------------------------------------------------------------------+");
			System.out.println(
					"|Introduce la matrícula (debe tener 4 números seguidos de 3 letras, sin espacios ni guiones)|");
			System.out.println(
					"+-------------------------------------------------------------------------------------------+");
			System.out.println("\n\n ");
		}

		return comp;
	}
}
