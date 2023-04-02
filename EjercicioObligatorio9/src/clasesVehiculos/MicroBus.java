
package clasesVehiculos;

/**
 * La clase MicroBus representa un tipo de vehículo que cuenta con un número de
 * plazas y metros cuadrados determinados. Extiende la clase Vehiculos y
 * sobrescribe sus métodos abstractos para calcular el precio del alquiler y
 * obtener la información del vehículo.
 * 
 * @author charl
 * @version 1.0
 * @since 2023/04/02
 */

public class MicroBus extends Vehiculos {

	private final static int PRECIO_PLAZA = 2;
	private int plazas;
	private int metros;

	// constructores
	public MicroBus() {
	}

	public MicroBus(String matricula, int anyos, int plazas, int metros) {
		super(matricula, anyos);
		this.plazas = plazas;
		this.metros = metros;
	}

	public MicroBus(String matricula, String marca, String color, int anios, int plazas, int metros) {
		super(matricula, marca, color, anios);
		this.plazas = plazas;
		this.metros = metros;
	}

	public MicroBus(String matricula) {
		super(matricula);
	}

	// Setters y Getters
	public static int getPrecioPlaza() {
		return PRECIO_PLAZA;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public int getMetros() {
		return metros;
	}

	public void setMetros(int metros) {
		this.metros = metros;
	}

	// Metodos Abstractos

	/**
	 * Calcula el precio del alquiler del Microbus durante un número de días
	 * determinado
	 * 
	 * @param dias El número de días del alquiler
	 * @return El precio del alquiler del MicroBus
	 */
	@Override
	public float precioAlquilerVehiculo(int dias) {
		float precio;
		precio = (getPreciob() * (float) dias);
		precio += ((float) getPlazas() * 1.5f * (float) dias);
		precio += ((float) getPlazas() * PRECIO_PLAZA);
		return precio;
	}

	/**
	 * Devuelve la información del MicroBus
	 * 
	 * @return La información del MicroBus
	 */
	@Override
	public String info() {
		String infomicroB;

		infomicroB = "Matricula: " + getMatricula() + "\nMarca: "
				+ getMarca() + "\nColor: " + getColor() + "\nAños: " + getAnios() + "\nPlazas: " + getPlazas()
				+ "\nMetros: " + getMetros();
		return infomicroB;
	}

}
