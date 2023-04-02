
package clasesVehiculos;

/**
 * La clase Furgoneta representa un tipo de vehículo de carga con un peso máximo
 * autorizado (PMA) que se utiliza para transportar mercancías. Hereda de la clase
 * abstracta VehiculoCarga.
 * 
 * @author Charl
 * @version 1.0
 * @since 2023/04/02
 */
public class Furgoneta extends VehiculoCarga {

	// constructores
	public Furgoneta(float pma, String matricula, String marca, String color, int anyos) {
		super(pma, matricula, marca, color, anyos);

	}

	public Furgoneta(float pma, String matricula, int anios) {
		super(pma, matricula);
		super.setAnios(anios);
	}

	// Metodos Abstractos

	/**
	 * Calcula el precio del alquiler del Furgoneta durante un número de días
	 * determinado
	 * 
	 * @param dias El número de días del alquiler
	 * @return El precio del alquiler del Furgoneta
	 */
	@Override
	public float precioAlquilerVehiculo(int dias) {
		float precio;
		precio = (float) ((VehiculoCarga.getPreciocarga() * getPma()) + (getPreciob() * (float) dias));
		return precio;
	}

	/**
	 * Devuelve la información del Furgoneta
	 * 
	 * @return La información del Furgoneta
	 */
	@Override
	public String info() {
		String infoFurgo;

		infoFurgo =  "Matricula: " + getMatricula() + "\nMarca: "
				+ getMarca() + "\nColor: " + getColor() + "\nAños: " + getAnios() + "\nPMA: " + getPma()
				+ " toneladas ";

		return infoFurgo;
	}
}