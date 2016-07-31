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
public class Venditore extends Utente {
    public Venditore(int id, String user, String psw, int Idc){
        super(id,user,psw,Idc);
    }

}

/*
// metodo che restituisce la lista di oggetti associata al vendtore

 public ArrayList<Oggetti> getAutoInVendita() {
        return CarSaleFactory.getInstance().getAutoSaleBySeller(getId());
    }*/ 