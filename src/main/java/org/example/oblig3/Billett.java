package org.example.oblig3;

public class Billett {
    private String fornavn;
    private String etternavn;
    private String filmer;
    private String antall;
    private String nummer;
    private String epost;
    public Billett(String filmer, String antall, String fornavn, String etternavn, String nummer, String epost){
        this.fornavn = fornavn;
        this.etternavn=etternavn;
        this.filmer=filmer;
        this.antall=antall;
        this.nummer=nummer;
        this.epost=epost;
    }
    public Billett(){

    }
    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getFilmer() {
        return filmer;
    }

    public void setFilmer(String filmer) {
        this.filmer = filmer;
    }

    public String getAntall() {
        return antall;
    }

    public void setAntall(String antall) {
        this.antall = antall;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }


}
