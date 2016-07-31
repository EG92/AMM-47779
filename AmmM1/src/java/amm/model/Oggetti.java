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

public class Oggetti {
    /* Attributi */
    int IDOggetto;
    String NomeOggetto;
    String ImmagineUrl;
    String Descrizione;
    double PrezzoOggetto;
    int Quantita;
    private int IDVend;
  

// Costruttore alternativo

public Oggetti(int id,String nome,String imm,String descr,double prezzo,int q,int idv)
{
    this.IDOggetto = id;
    this.NomeOggetto = nome;
    this.ImmagineUrl = imm;
    this.Descrizione = descr;
    this.PrezzoOggetto = prezzo;
    this.Quantita = q;
    this.IDVend = idv;
}
    
    
    /**
     * @return id
     */
    public int getId() {
        return IDOggetto;
    }

    /**
     * @param ID id to set
     */
    public void setId(int ID) {
        this.IDOggetto = ID;
    }
    
    /**
     * @return Nome
     */
    public String getNome() {
        return NomeOggetto;
    }

    /**
     * @param Nome nome to set
     */
    public void setNome(String Nome) {
        this.NomeOggetto = Nome;
    }
    
    /**
     * @return URL
     */
    public String getURL() {
        return ImmagineUrl;
    }

    /**
     * @param URL id to set
     */
    public void setURL(String URL) {
        this.ImmagineUrl = URL;
    }
    
    
    /**
     * @return Descrizione
     */
    public String getDescrizione() {
        return Descrizione;
    }

    /**
     * @param Descrizione id to set
     */
    public void setDescrizione(String Descrizione) {
        this.Descrizione = Descrizione;
    }
   
    /*
     * @return quantita
     */
    public int getQuantita() {
        return Quantita;
    }

    /**
     * @param Quantita id to prezzo
     */
    public void setQuantita(int Quantita) {
        this.Quantita = Quantita;
    }

    
    /**
     * @return prezzo
     */
    public double getPrezzo() {
        return PrezzoOggetto;
    }

    /**
     * @param Prezzo id to prezzo
     */
    public void setPrezzo(double Prezzo) {
        this.PrezzoOggetto = Prezzo;
    }

    /**
     * @return the IDVend
     */
    public int getIDVend() {
        return IDVend;
    }

    /**
     * @param IDVend the IDVend to set
     */
    public void setIDVend(int IDVend) {
        this.IDVend = IDVend;
    }
    
}