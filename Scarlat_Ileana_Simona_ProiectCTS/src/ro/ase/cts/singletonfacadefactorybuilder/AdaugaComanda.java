package ro.ase.cts.singletonfacadefactorybuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdaugaComanda implements InterogareSQL{
	PreparedStatement pst=null;
    ResultSet rs=null;
    
	@Override
	
	public boolean executaInterogareSQL(Connection conexiune,Comanda comanda) {
		boolean executieReusita=false;
		   try{
	            String query="insert into comenziTabel (cod,preparateComandate,pretTotal,masa) values (?,?,?,?);";
	        
	             pst=conexiune.prepareStatement(query);
	             
	             pst.setString(1,comanda.getCod());
	             pst.setString(2, comanda.getPreparateComandate());
	             pst.setFloat(3, (float) comanda.getPretTotal());
	             pst.setInt(4,comanda.getMasa());

	            pst.executeUpdate();
	            
	            System.out.println("S-a inserat comanda");
	            executieReusita=true;
	            pst.close();
	            rs.close();
	            
	            
	            }
	       
	            catch(Exception e)
	            {
	                System.out.println(e.toString());
	            }
		
		
		return executieReusita;
		
	}
    
    
    
}
