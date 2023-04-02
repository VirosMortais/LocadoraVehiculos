/**
 * 
 */
package clasesVehiculos;

/**
 * 
 * La clase Vehiculos es una clase abstracta que define los atributos y métodos
 * comunes que deben tener todos los vehículos de la empresa de alquiler. Los
 * atributos que se definen son matrícula, marca, color, años y precio base de
 * alquiler. Los métodos que se definen son setters y getters para cada uno de
 * los atributos, un constructor por defecto y otros constructores que permiten
 * crear vehículos con diferentes atributos. También se definen dos métodos
 * abstractos, "info()" y "precioAlquilerVehiculo()", que deben ser
 * implementados por las clases hijas.
 * 
 * @author charl
 * @version 1.0
 * @since 2023/04/02
 */
public abstract class Vehiculos {

	// Atributos
	private String matricula;
	private String marca;
	private String color;
	private int anios;
	private static final float precioB = 50;

	// Constructores
	public Vehiculos() {
	}

	public Vehiculos(String matricula) {
		this.matricula = matricula;
	}

	public Vehiculos(String matricula, int anio) {
		this.matricula = matricula;
		this.anios = anio;
	}

	public Vehiculos(String matricula, String marca, String color, int anio) {
		this.matricula = matricula;
		this.marca = marca;
		this.color = color;
		this.anios = anio;
	}

	// Setters y Getters
	/**
	 * @return the preciob
	 */
	public static float getPreciob() {
		return precioB;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	// Metodos

	/**
	 * @return the anio
	 */
	public int getAnios() {
		return anios;
	}

	/**
	 * @param anio the anio to set
	 */
	public void setAnios(int anio) {
		this.anios = anio;
	}

	// métodos abstractos
	public abstract String info();

	public abstract float precioAlquilerVehiculo(int dias);

}
