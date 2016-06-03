package ro.ase.cts.state;



public class ModificareStareComanda {
    Notificare stareCurenta;
    
    public ModificareStareComanda()
    {
    	stareCurenta=new StareComandaNepreluata();
    }
    
    public void setStare(StareComanda stare){
		if(stare == StareComanda.PRELUATA)
			this.stareCurenta = new StareComandaPreluata();
		else
			if(stare == StareComanda.NEPRELUATA)
				this.stareCurenta = new StareComandaNepreluata();
			
	}
    
    public void afisare(){
		this.stareCurenta.notifica();
	}
    
}
