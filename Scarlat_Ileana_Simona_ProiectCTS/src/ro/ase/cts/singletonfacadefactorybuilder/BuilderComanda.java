package ro.ase.cts.singletonfacadefactorybuilder;

public class BuilderComanda {
   private Comanda comanda;
   
   public BuilderComanda(String codComanda) throws Exception
   {
	   if(codComanda.length()!=4 || codComanda.matches("[0-9]+")==false)
	   {
		   throw new Exception("Codul introdus nu are un format corespunzator (4 cifre)");
	   }
	   this.comanda=new Comanda(codComanda,"",0,0,"nepreluata");
   }
   
   public Comanda build()
   {
	   return this.comanda;
   }
   public BuilderComanda setPreparateComandate(String preparateComandate) throws Exception
   {
	   this.comanda.setPreparateComandate(preparateComandate);
	   return this;
   }
   
   public BuilderComanda setPretTotal(double pretTotal) throws Exception
   {
	   this.comanda.setPretTotal(pretTotal);
	   return this;
   }
   
   public BuilderComanda setMasa(int masa) throws Exception
   {
	   this.comanda.setMasa(masa);
	   return this;
   }
   
   public BuilderComanda setStareComanda(String stare)
   {
	   this.comanda.setStareComanda(stare);
	   return this;
   }
}
