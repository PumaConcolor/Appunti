
public abstract class Volo {
	private String aeroportoPartenza;
	private String aeroportoArrivo;
	
	public Volo(String aeroportoPartenza, String aeroportoArrivo) {
		super();
		this.aeroportoPartenza = aeroportoPartenza;
		this.aeroportoArrivo = aeroportoArrivo;
	}
	
	public String getAeroportoPartenza() {
		return aeroportoPartenza;
	}
	public String getAeroportoArrivo() {
		return aeroportoArrivo;
	}
	
	public abstract int getNumeroTratte();
	
	public abstract int getDurataInMinuti();

	@Override
	public String toString() {
		return "Volo [getAeroportoPartenza()=" + getAeroportoPartenza() + ", getAeroportoArrivo()="
				+ getAeroportoArrivo() + ", getNumeroTratte()=" + getNumeroTratte() + ", getDurataInMinuti()="
				+ getDurataInMinuti() + "]";
	}

	

	
	
}