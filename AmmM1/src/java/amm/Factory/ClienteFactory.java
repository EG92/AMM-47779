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
/*
 *
 * @author Eleonora
 */
public class ClienteFactory {
   
     /* Attributi */
    private static ClienteFactory singleton;
    private String connectionString;
    
    public static ClienteFactory getInstance() {
        if (singleton == null) {
            singleton = new ClienteFactory();
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
    private ClienteFactory(){
    }
    
    //Lista di tutti i Clienti
    public List<Cliente> getListaClienti()
    {
        List<Cliente> listaClienti = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(connectionString, "eleonora", "47779");
                Statement stmt = conn.createStatement()) {
            
            //Query
            String sql = "SELECT * FROM Cliente"; 
            ResultSet set = stmt.executeQuery(sql);

            while(set.next()) 
            {
                int id = set.getInt("IDCliente");
                String user = set.getString("UserCliente");
                String psw = set.getString("PswCliente");
                int Idc = set.getInt("IDContoC");
                Cliente c = new Cliente(id,user,psw,Idc);
                listaClienti.add(c);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ClienteFactory.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return listaClienti;
    }
    
    
    // Ricerca Cliente per ID
    public Cliente getClienteId(int id)
    {
        Cliente cliente = null;
        String query = "SELECT * FROM Cliente WHERE IDCliente = ?"; // Query
     
        // Connessione al db
        try(Connection conn = DriverManager.getConnection(connectionString, "eleonora", "47779");
                PreparedStatement stmt = conn.prepareStatement(query)) {
            // associo valori e posizioni di placeholder
            stmt.setInt(1, id);
            ResultSet set = stmt.executeQuery();
            
            if(set.next()) 
            {
                //c = new Cliente();
                int idU = set.getInt("IDCliente"); // ID cliente
                String user = set.getString("UserCliente"); //username
                String psw = set.getString("PswCliente"); //password
                int idc = set.getInt("IDContoC"); //Id conto associato al cliente
                cliente = new Cliente(idU,user,psw,idc);
            }
        } 
        catch(SQLException ex)
        {
            //ex.printStackTrace();
            Logger.getLogger(ClienteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cliente;
    }


    // Ricerca per User e Password
    
    public Cliente cercaCliente(String user, String psw)
    {
        Cliente cliente = null;
        String query = "SELECT * FROM Cliente WHERE UserCliente = ? and PswCliente = ?"; // Query
        
        // Connessione al db
        try(Connection conn = DriverManager.getConnection(connectionString, "eleonora", "47779");
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            // Si associano valori e posizioni 
            stmt.setString(1, user);
            stmt.setString(2, psw);
            ResultSet set = stmt.executeQuery();
            
            //Effettua un ciclo sulle righe restituite
            if(set.next())
            {
                int id = set.getInt("IDCliente"); //Id Cliente
                String username = set.getString("UserCliente"); //username
                String pswd = set.getString("PswCliente"); //password
                int idC = set.getInt("IDContoC"); //Id conto associato al cliente
                cliente = new Cliente(id,username,pswd,idC);
            }
        }
        catch (SQLException ex) 
        {
            //ex.printStackTrace();
            Logger.getLogger(ClienteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }
    
}
