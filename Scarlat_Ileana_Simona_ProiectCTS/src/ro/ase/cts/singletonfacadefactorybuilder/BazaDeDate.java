package ro.ase.cts.singletonfacadefactorybuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BazaDeDate {
	 private static BazaDeDate instantaBazaDeDate=null;
	
	 private static Connection conexiuneBazaDeDate=null;
	 
	 private BazaDeDate()
	 {
		 
	 }
	    
	    public static synchronized BazaDeDate getInstanta()
	    {
	        if(instantaBazaDeDate==null)
	        {
	            instantaBazaDeDate=new BazaDeDate();
	        }
	        return instantaBazaDeDate;
	    }
	    
	    public Connection getConexiune()
	    {
	        if(conexiuneBazaDeDate==null)
	        {
	            try
	            {
	                Class.forName("org.sqlite.JDBC");
	              
	                conexiuneBazaDeDate=DriverManager.getConnection("jdbc:sqlite:comenzi.sqlite");
	                 
	            }catch(ClassNotFoundException | SQLException e)
	            {
	               System.out.println(e);
	            }
	            
	        }
	        return conexiuneBazaDeDate;
	    }
	    
	     public void VerificaStabilireConexiuneBazaDeDate()
	    {
	        conexiuneBazaDeDate = getConexiune();
	        if(conexiuneBazaDeDate == null)
	        {
	            System.out.println("Nu s-a realizat conexiunea la baza de date");
	            System.exit(1);
	        }
	        else
	        {
	            System.out.println("S-a realizat conexiunea la baza de date");
	        }
	    }
	    
}
