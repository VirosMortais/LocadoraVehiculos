
package clasesVehiculos;

/**
 * La clase Furgoneta representa un tipo de vehículo de carga con un peso máximo
 * autorizado (PMA) que se utiliza para transportar mercancías. Hereda de la
 * clase abstracta VehiculoCarga. Además, tiene un método getter y setter para el número de ruedas.
 * 
 * 
 * @author Charl
 * @version 1.0
 * @since 2023/04/02
 */
public class Camion extends VehiculoCarga {
	private final static float PRECIO_FIJO = 40;

	private int ruedas;

	// constructor
	public Camion(float pma, String matricula, String marca, String color, int anyos, int ruedas) {
		super(pma, matricula, marca, color, anyos);
		this.ruedas = ruedas;
	}

	public Camion(float pma, String matricula, int anyos) {
		super(pma, matricula);
		setAnios(anyos);
	}

	public int getRuedas() {
		return ruedas;
	}

	public void setRuedas(int ruedas) {
		this.ruedas = ruedas;
	}

	// Metodos Abstractos

	/**
	 * Calcula el precio del alquiler del Camion durante un número de días
	 * determinado
	 * 
	 * @param dias El número de días del alquiler
	 * @return El precio del alquiler del Camion
	 */

	@Override
	public float precioAlquilerVehiculo(int dias) {
		float precio;
		precio = (float) ((VehiculoCarga.getPreciocarga() * getPma()) + (getPreciob() * (float) dias) + PRECIO_FIJO);
		return precio;
	}

	/**
	 * Devuelve la información del Camion
	 * 
	 * @return La información del Camion
	 */
	@Override
	public String info() {
		String infocamion;
		infocamion = "Matricula: " + getMatricula() + "\nMarca: "
				+ getMarca() + "\nColor: " + getColor() + "\nAños: " + getAnios() + "\nPeso: " + getPma();
		return infocamion;
	}

}