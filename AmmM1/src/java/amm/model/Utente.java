/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model;

import amm.factory.*;

/**
 *
 * @author Eleonora
 */

public abstract class Utente {
     /* Attributi */
    private int id;
    private String user;
    private String psw; 
    private int idC;
    
    public Utente(){}

    /*Costruttori*/    
    public Utente(int id, String user, String psw, int idC) {
        this.id = id;
        this.user = user;
        this.psw = psw;
        this.idC = idC;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the psw
     */
    public String getPsw() {
        return psw;
    }

    /**
     * @param psw the psw to set
     */
    public void setPsw(String psw) {
        this.psw = psw;
    }

    /**
     * @return the idC
     */
    public int getIdC() {
        return idC;
    }

    /**
     * @param idC the idC to set
     */
    public void setIdC(int idC) {
        this.idC = idC;
    }

    /** Restituisce il saldo dell'utente
     *  @return saldo dell'utente
    */
    public double getSaldoUtente() {
        Saldo contoUtente = SaldoFactory.getInstance().getSaldoID(idC);
        return contoUtente.getSaldo();
    }
}
   