package ro.ase.cts.singletonfacadefactorybuilder;

import java.sql.Connection;

public class Facade {
  
	public static boolean executieInterogare(TipInterogare tip, Comanda comanda)
	{
		boolean executieReusita=false;
		
		
		try {
			BazaDeDate bd=BazaDeDate.getInstanta();
			Connection conexiune = bd.getConexiune();
			bd.VerificaStabilireConexiuneBazaDeDate();
			InterogareSQL interogare=SimpleFactoryTipInterogare.getPrelucrare(tip);
			executieReusita=interogare.executaInterogareSQL(conexiune,comanda);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return executieReusita;
	}
}
