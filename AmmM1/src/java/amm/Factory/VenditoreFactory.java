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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Eleonora
 */
public class VenditoreFactory {
    /* Attributi */
    private static VenditoreFactory singleton;
    String connectionString;
    
    public static VenditoreFactory getInstance() {
        if (singleton == null) {
            singleton = new VenditoreFactory();
        }
        return singleton;
    }
    
    //Metodo set: Stringa per la connessione al db
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    //Metodo get: Stringa per la connessione al db
    public String getConnectionString(){
            return this.connectionString;
    }
    
    /* Costruttore vuoto */
    private VenditoreFactory(){
    
    }
    
    
    // Lista di tutti i venditori
    public List<Venditore> getListaVenditori() {
        List<Venditore> listaVenditori = new ArrayList<>(); 
       //Apro la connessione con il db
        try(Connection conn = DriverManager.getConnection(connectionString, "eleonora", "47779");
                Statement stmt = conn.createStatement()) {
 
            String sql = "SELECT * FROM Venditore"; // Query
            ResultSet set = stmt.executeQuery(sql);

            while (set.next())
            {
                int id = set.getInt("IDVenditore");
                String user = set.getString("UserVenditore");
                String psw = set.getString("PswVenditore");
                int Idc = set.getInt("IDContoV");
                Venditore v = new Venditore(id, user, psw, Idc);
                listaVenditori.add(v);
            }
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(VenditoreFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVenditori;
    }
    
    // Ricerca Venditore per id
    public Venditore getVenditoreId(int id)
    {
        Venditore venditore = null;
        String query = "SELECT * FROM Venditore WHERE IDVenditore = ?"; // Query
        
        // Connessione al db 
        try(Connection conn = DriverManager.getConnection(connectionString, "eleonora", "47779");
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            // Associo valori e posizioni di placeholder
            stmt.setInt(1, id);
            ResultSet set = stmt.executeQuery(); //eseguo la query
            
            if(set.next()) 
            {
                int idV = set.getInt("IDVenditore");
                String user = set.getString("UserVenditore");
                String psw = set.getString("PswVenditore");
                int Idc = set.getInt("IDContoV");
                venditore = new Venditore(idV, user, psw, Idc);
            }
        } 
        catch(SQLException ex) 
        {
            Logger.getLogger(VenditoreFactory.class.getName()).log(Level.SEVERE, null, ex);  
        }
        return venditore; 
    } 
    
    // Ricerca per User e Password
    public Venditore cercaVenditore(String user, String psw)
    {
        Venditore venditore = null;
        String query = "SELECT * FROM Venditore WHERE UserVenditore = ? and PswVenditore = ?"; //Query
        
        try (Connection conn = DriverManager.getConnection(connectionString, "eleonora", "47779");
            PreparedStatement stmt = conn.prepareStatement(query)){
            
            // Si associano valori e posizioni 
            stmt.setString(1, user);
            stmt.setString(2, psw);
            
            ResultSet set = stmt.executeQuery(); //Esegui la query
            
            if(set.next())
            {
                int idV = set.getInt("IDVenditore");
                String usern = set.getString("UserVenditore");
                String pssw = set.getString("PswVenditore");
                int Idc = set.getInt("IDContoV");
                venditore = new Venditore(idV, usern, pssw, Idc);
            }
        }catch (SQLException ex) {
            Logger.getLogger(VenditoreFactory.class.getName()).log(Level.SEVERE, null, ex);
          }
        return venditore;
       
    } 

}