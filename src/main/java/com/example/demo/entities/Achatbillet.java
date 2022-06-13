package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


public class Achatbillet {

    String typebillet;
    String depart;
    String destination;
    String voldepart;
    String volretour;
    String adultes;
    String jeunes;
    String enfants;
    String bebes;
    String classe;



    public Achatbillet(String typebillet, String depart, String destination, String voldepart, String volretour, String adultes, String jeunes, String enfants, String bebes, String classe) {
        this.typebillet = typebillet;
        this.depart = depart;
        this.destination = destination;
        this.voldepart = voldepart;
        this.volretour = volretour;
        this.adultes = adultes;
        this.jeunes = jeunes;
        this.enfants = enfants;
        this.bebes = bebes;
        this.classe = classe;
    }

    public Achatbillet() {

    }

    public String getTypebillet() {
        return typebillet;
    }

    public void setTypebillet(String typebillet) {
        this.typebillet = typebillet;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getVoldepart() {
        return voldepart;
    }

    public void setVoldepart(String voldepart) {
        this.voldepart = voldepart;
    }

    public String getVolretour() {
        return volretour;
    }

    public void setVolretour(String volretour) {
        this.volretour = volretour;
    }

    public String getAdultes() {
        return adultes;
    }

    public void setAdultes(String adultes) {
        this.adultes = adultes;
    }

    public String getJeunes() {
        return jeunes;
    }

    public void setJeunes(String jeunes) {
        this.jeunes = jeunes;
    }

    public String getEnfants() {
        return enfants;
    }

    public void setEnfants(String enfants) {
        this.enfants = enfants;
    }

    public String getBebes() {
        return bebes;
    }

    public void setBebes(String bebes) {
        this.bebes = bebes;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
}
