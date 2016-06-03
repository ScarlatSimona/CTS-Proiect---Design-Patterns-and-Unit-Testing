package ro.ase.cts.singletonfacadefactorybuilder;

public class Comanda {

	
	private String cod;
	private String preparateComandate;
	private double pretTotal;
	private int masa;
	
	private String stareComanda;

	public Comanda(String cod, String preparateComandate, float pretTotal, int masa, String stareComanda) {
		super();
		this.cod = cod;
		this.preparateComandate = preparateComandate;
		this.pretTotal = pretTotal;
		this.masa = masa;
		this.stareComanda = stareComanda;
	}

	public Comanda() {
		super();
	}

	public String getCod() {
		return cod;
	}

	public String getPreparateComandate() {
		return preparateComandate;
	}

	public double getPretTotal() {
		return pretTotal;
	}

	public int getMasa() {
		return masa;
	}

	public String getStareComanda() {
		return stareComanda;
	}

	public void setCod(String cod) throws Exception {
		if(cod.length()!=4 || cod.matches("[0-9]+")==false)
		{
			throw new Exception("Codul comenzii nu are un format corespunzator (4 cifre)");
		}
		else
			this.cod=cod;
	}

	public void setPreparateComandate(String preparateComandate) throws Exception {
		if(preparateComandate==null)
		{
			throw new Exception("Trebuie sa alegeti cel putin un preparat");
		}
		else
		this.preparateComandate = preparateComandate;
	}

	public void setPretTotal(double pretTotal) throws Exception {
		if(pretTotal<=0)
		{
			throw new Exception("Pretul nu poate avea o valoare negativa");
		}
		else
		this.pretTotal = pretTotal;
	}

	public void setMasa(int masa) throws Exception {
		if(masa<=0 || masa>40)
		{
			throw new Exception("Masa inexistenta in cantina");
		}
		else this.masa = masa;
		
	}

	public void setStareComanda(String stareComanda) {
		this.stareComanda = stareComanda;
	}
	
	
}
