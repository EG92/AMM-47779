/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model;

/**
 *
 * @author Eleonora
 */

public class Cliente extends Utente {
     /**
     *
     * @param id
     * @param user
     * @param psw
     * @param Idc
     */
    public Cliente(int id, String user, String psw, int Idc){
        super(id,user,psw,Idc);
    }
}


