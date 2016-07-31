/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.factory;

import amm.model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Eleonora
 */

public class OggettiFactory {
    
     /* Attributi */
    private static OggettiFactory singleton;
    String connectionString;
    
    public static OggettiFactory getInstance() {
        if (singleton == null) {
            singleton = new OggettiFactory();
        }
        return singleton;
    }
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
            return this.connectionString;
    }
    
    // costruttore vuoto
    private OggettiFactory(){
    }
    
    //Lista Oggetti
    public ArrayList<Oggetti> getOggettiList() throws SQLException
    {
        ArrayList<Oggetti> listaOggetti = new ArrayList();
        
        //Connessione al db
        try(Connection conn = DriverManager.getConnection(connectionString, "eleonora", "47779");
            Statement stmt = conn.createStatement())
        {
            //Query
            String sql = "SELECT * FROM Oggetti";
            ResultSet set = stmt.executeQuery(sql);
            
            //Aggiungo i risultati ottenuti nella lista
            while(set.next())
            {
                int id = set.getInt("IDOggetto");
                String nome = set.getString("NomeOggetto");
                String imm = set.getString("ImmagineURL");
                String descr = set.getString("Descrizione");
                int prezzo = set.getInt("PrezzoOggetto");
                int q = set.getInt("Quantita");
                int idv = set.getInt("IDVend");
                Oggetti o = new Oggetti(id, nome, imm, descr, prezzo, q, idv);
                listaOggetti.add(o);
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(OggettiFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaOggetti;
    }
    
    //Oggetto per ID
    
    public Oggetti getOggettiId(int id){
        Oggetti o = null;
        // Query
        String sql = "SELECT * FROM Oggetti WHERE IDOggetto = ?";
        
        //Connessione al db
        try(Connection conn = DriverManager.getConnection(connectionString, "eleonora", "47779");
            PreparedStatement stmt = conn.prepareStatement(sql)) {
           
            stmt.setInt(1, id);
            ResultSet set = stmt.executeQuery();
            
            if(set.next()) 
            {
                String nome = set.getString("NomeOggetto");
                String imm = set.getString("ImmagineURL");
                String descr = set.getString("Descrizione");
                int prezzo = set.getInt("PrezzoOggetto");
                int q = set.getInt("Quantita");
                int idv = set.getInt("IDVend");
               
                o = new Oggetti(id,nome,imm,descr,prezzo,q,idv);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(OggettiFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return o;
    }
    
    //Lista oggetti con Venditore come parametro
    
    public ArrayList<Oggetti> getOggettiVend(int idv){
        ArrayList<Oggetti> lista = new ArrayList<>();
        
        // Lista articoli 
        if(VenditoreFactory.getInstance().getVenditoreId(idv) != null){
            //Query
            String sql = "SELECT * FROM Oggetti WHERE IDVend = ?";
            
            //Connessione al db
            try(Connection conn = DriverManager.getConnection(connectionString, "eleonora", "47779");
                PreparedStatement stmt = conn.prepareStatement(sql)) {
                // Si associano valori e posizioni di placeholder
                stmt.setInt(1, idv);
                ResultSet set = stmt.executeQuery();
                /* Scorro tutti i risultati ottenuti aggiungendoli alla lista che poi sarà restituita al chiamante */
                while (set.next()) 
                {
                    int id = set.getInt("IDOggetto");
                    String nome = set.getString("NomeOggetto");
                    String imm = set.getString("ImmagineURL");
                    String descr = set.getString("Descrizione");
                    int prezzo = set.getInt("PrezzoOggetto");
                    int q = set.getInt("Quantita");
                    //int idv = set.getInt("IDVend");
                    Oggetti o = new Oggetti(id, nome, imm, descr, prezzo, q, idv);

                    lista.add(o);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(OggettiFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
        else
            return null;
        
        return lista;
    }
    
    //Eliminazione Oggetto
    
    public boolean rimuoviOggetto(int id){
        boolean remove = false;
        //Query
        String sql = "DELETE FROM Oggetti WHERE IDOggetto = ?";
        
        //Connessione al db
        try(Connection conn = DriverManager.getConnection(connectionString, "eleonora", "47779");
            PreparedStatement stmt = conn.prepareStatement(sql)) 
        {
           
            stmt.setInt(1, id);
            
            int rows = stmt.executeUpdate();
            //Verifico se la Query è stata eseguita correttamente
            if(rows == 1) 
                remove = true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(OggettiFactory.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        //il metodo restituisce false se la query non è stata eseguita correttamente
        return remove;
    }
    
    //Inserimento Nuovo Oggetto
    public boolean aggiungiOggetto(Oggetti o){
        boolean insert = false;
        //Query
        String query = "INSERT INTO Oggetti (IDOggetto,NomeOggetto,ImmagineUrl,Descrizione,PrezzoOggetto,Quantita,IDVend"
                + "VALUES (default, ?, ?, ?, ?, ?, ?)";
        
        //Connessione al db
        try(Connection conn = DriverManager.getConnection(connectionString, "eleonora", "47779");
            PreparedStatement stmt = conn.prepareStatement(query))
        {
            // Si associano valori e posizioni di placeholder
            stmt.setString(1, o.getNome());
            stmt.setString(2, o.getURL());
            stmt.setString(3, o.getDescrizione());
            stmt.setDouble(4, o.getPrezzo());
            stmt.setInt(5, o.getQuantita());
            stmt.setInt(6, o.getIDVend());
            
            int rows = stmt.executeUpdate();
            //Verifico se la Query è stata eseguita correttamente
            if(rows == 1)
                insert = true; 
        }
        catch(SQLException ex)
        {
            Logger.getLogger(OggettiFactory.class.getName()).log(Level.SEVERE, null, ex);  
        }
        
         //il metodo restituisce false se la query non è stata eseguita correttamente
        return insert;
    }
    
    //Modifica Oggetto
    public boolean modificaOggetto(Oggetti o){
        boolean alter = false;
        /* Definisco la query per modificare l'oggetto, vengono sempre modificati tutti i campi, quelli che l'utente non
           ha specificato sono reimpostati uguali ai precedenti, in modo da eseguire una uery che vada bene sempre */
        String sql = " UPDATE Oggetti SET NomeOggetto = ? ,ImmagineUrl = ?,Descrizione = ?,PrezzoOggetto = ?,Quantita = ?,IDVend = ?"
                    + "WHERE IDOggetto = ? ";
        
        //Connessione
        try(Connection conn = DriverManager.getConnection(connectionString, "eleonora", "47779");
            PreparedStatement stmt = conn.prepareStatement(sql)) 
        {
            // Si associano valori e posizioni di placeholder
            stmt.setString(1, o.getNome());
            stmt.setString(2, o.getURL());
            stmt.setString(3, o.getDescrizione());
            stmt.setDouble(4, o.getPrezzo());
            stmt.setInt(5, o.getQuantita());
            stmt.setInt(6, o.getIDVend());
            stmt.setInt(7, o.getId());
            
            int rows = stmt.executeUpdate();
           //Verifico se la Query è stata eseguita correttamente
            if(rows == 1) 
                alter = true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(OggettiFactory.class.getName()).log(Level.SEVERE, null, ex);
        } 
        //il metodo restituisce false se la query non è stata eseguita correttamente
        return alter;
    }
    
    //Ricerca oggetti
    
    public ArrayList<Oggetti> ricercaOggetto(String pattern) {
        ArrayList<Oggetti> lista = new ArrayList<>();
        //Query
        String sql = "SELECT * FROM Oggetti WHERE NomeOggetto LIKE ? OR Descrizione LIKE ?";         
        
        //Connessione al db
        try(Connection conn = DriverManager.getConnection(connectionString, "eleonora", "47779");
            PreparedStatement stmt = conn.prepareStatement(sql)) 
        {
            // Assegna dati
            pattern = "%"+pattern+"%";
            stmt.setString(1, pattern);
            stmt.setString(2, pattern);
            ResultSet set = stmt.executeQuery();
            
            while (set.next()) 
            {
                int id = set.getInt("IDOggetto");
                String nome = set.getString("NomeOggetto");
                String imm = set.getString("ImmagineURL");
                String descr = set.getString("Descrizione");
                double prezzo = set.getDouble("PrezzoOggetto");
                int q = set.getInt("Quantita");
                int idv = set.getInt("IDEVned");
                Oggetti o = new Oggetti(id, nome, imm, descr, prezzo, q, idv);             
                lista.add(o);
            }
        }
        catch(SQLException ex) 
        {
           Logger.getLogger(OggettiFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return lista;
    }  
    
    
}
