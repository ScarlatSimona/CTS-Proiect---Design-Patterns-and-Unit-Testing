package ro.ase.cts.singletonfacadefactorybuilder;

import java.sql.Connection;

public interface InterogareSQL {
  public abstract boolean executaInterogareSQL(Connection conexiune,Comanda comanda);
}
