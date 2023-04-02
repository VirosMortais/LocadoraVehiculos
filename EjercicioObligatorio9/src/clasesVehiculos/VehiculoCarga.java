/**
 * 
 */
package clasesVehiculos;

/**
 * @author charl
 *
 */
public abstract class VehiculoCarga  extends Vehiculos{

	private static final float precioCarga = 20;
	private float pma;
	
	
	 //Constructores
    public VehiculoCarga(){
    }
    
    public VehiculoCarga(String matricula){
        super(matricula);
    }
    
    public VehiculoCarga(float pma, String matricula) {
        super(matricula);
        this.pma = pma;
    }
    
    public VehiculoCarga(float pma, String matricula, String marca, String color, int anyos){
        super(matricula, marca, color, anyos);
        this.pma = pma;
    }

	//Setters y Getters
	
	/**
	 * @return the preciocarga
	 */
	public static float getPreciocarga() {
		return precioCarga;
	}

	/**
	 * @return the pma
	 */
	public float getPma() {
		return pma;
	}

	/**
	 * @param pma the pma to set
	 */
	public void setPma(float pma) {
		this.pma = pma;
	}
	
	

	//Metodos abstractos

    @Override
    public abstract String info();
    @Override
    public abstract float precioAlquilerVehiculo(int dias);
}
