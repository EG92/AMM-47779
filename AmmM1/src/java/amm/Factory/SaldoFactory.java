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

public class SaldoFactory {
    
     /* Attributi */
    private static SaldoFactory singleton;
    String connectionString;
    
    public static SaldoFactory getInstance() {
        if (singleton == null) {
            singleton = new SaldoFactory();
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
    private SaldoFactory(){
    }
    
    
    // Lista Conti
    
    public ArrayList<Saldo> getContiList() {
        ArrayList<Saldo> listaConti = new ArrayList<>();
        
        try(Connection conn = DriverManager.getConnection(connectionString, "eleonora", "47779");
            Statement stmt = conn.createStatement()) 
        {
            // Query
            String sql = "SELECT * FROM Saldo";
            ResultSet set = stmt.executeQuery(sql);
            while (set.next()) 
            {
                int idConto = set.getInt("id");
                double saldo = set.getDouble("saldo");
                Saldo s = new Saldo(idConto, saldo);
                listaConti.add(s);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(SaldoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaConti;
    } 
    // Conto per ID
        public Saldo getSaldoID(int id){
        Saldo s = null;
        /* Definisco la query per restituire il conto dato l'id, essendo parametrica inserisco un ? al posto dell'id 
           del conto, e poi lo setto dopo*/
        String sql = "SELECT * FROM Saldo WHERE id = ?";
        
        /* Apro la connessione al db e creo il prepare Statement per la query usando un try with-resources, in questo
           modo sono sicura che le risorse saranno chiuse in ogni caso */
        try(Connection conn = DriverManager.getConnection(connectionString, "eleonora", "47779");
            PreparedStatement stmt = conn.prepareStatement(sql)) 
        {
            // Si associano valori e posizioni di placeholder
            stmt.setInt(1, id);
            ResultSet set = stmt.executeQuery();
           
            if(set.next()) 
            {
                int idConto = set.getInt("id");
                double saldo = set.getDouble("saldo");
                s = new Saldo(idConto, saldo);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(SaldoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }  

}