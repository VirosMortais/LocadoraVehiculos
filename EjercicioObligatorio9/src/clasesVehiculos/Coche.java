
package clasesVehiculos;

/**
 * La clase Coche representa un vehículo de tipo coche que hereda de la clase
 * Vehiculos. Contiene los atributos plazas, heredados de Vehiculos, y los
 * métodos get y set para dicho atributo. Además, implementa los métodos
 * abstractos precioAlquilerVehiculo y info de la clase Vehiculos.
 * 
 * @author Charl
 * @version 1.0
 * @since 2023/04/02
 */
public class Coche extends Vehiculos {
	// atributos
	private int plazas;

	// constructor
	public Coche(String matricula, int anyos, int plazas) {
		super(matricula, anyos);
		this.plazas = plazas;
	}

	public Coche(String matricula, String marca, String color, int anios, int plazas) {
		super(matricula, marca, color, anios);
		this.plazas = plazas;
	}

	public Coche() {
	}

	// get y set
	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

//Metodos Abstractos

	/**
	 * Calcula el precio del alquiler del Coche durante un número de días
	 * determinado
	 * 
	 * @param dias El número de días del alquiler
	 * @return El precio del alquiler del Coche
	 */
	@Override
	public float precioAlquilerVehiculo(int dias) {
		float precio;
		precio = (getPreciob() * (float) dias) + ((float) getPlazas() * 1.5f * (float) dias);
		return precio;
	}

	/**
	 * Devuelve la información del Coche
	 * 
	 * @return La información del Coche
	 */
	@Override
	public String info() {
		String infococh;

		infococh = "Matricula: " + getMatricula() + "\nMarca: "
				+ getMarca() + "\nColor: " + getColor() + "\nAños: " + getAnios() + "\nPlazas: " + getPlazas();

		return infococh;
	}

}