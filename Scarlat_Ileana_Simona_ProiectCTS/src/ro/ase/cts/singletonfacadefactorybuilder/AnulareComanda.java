package ro.ase.cts.singletonfacadefactorybuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AnulareComanda implements InterogareSQL{
	PreparedStatement pst=null;
    ResultSet rs=null;
	@Override
	public boolean executaInterogareSQL(Connection conexiune,Comanda comanda) {
		boolean executieReusita=false;
		try
        {
            String query="delete from comenziTabel where cod='"+comanda.getCod()+"'";
            pst=conexiune.prepareStatement(query);
            pst.execute();
           executieReusita=true;
           
        }catch(Exception e)
        {
            System.out.println(e.toString());
        }
		
		return executieReusita;
		
	}

}
