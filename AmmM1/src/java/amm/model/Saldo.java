/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model;
import amm.factory.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Eleonora
 */
public class Saldo {
    private int IDConto;
    private double saldo;
    
    //Costruttore vuoto
    public Saldo(){
    
    }
    
    public Saldo(int id, double saldoI){
        this.IDConto = id;
        this.saldo = saldoI;
    }

    /**
     * @return the IDConto
     */
    public int getIDConto() {
        return IDConto;
    }

    /**
     * @param IDConto the IDConto to set
     */
    public void setIDConto(int IDConto) {
        this.IDConto = IDConto;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
 
}
