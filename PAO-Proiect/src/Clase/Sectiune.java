package Clase;

import java.util.Arrays;
import java.util.ArrayList;

public class Sectiune {
    private String nume;
    private ArrayList<Carte> carti;

    public Sectiune(String nume, ArrayList<Carte> carti){
        this.nume = nume;
        this.carti = carti;
    }


    // Getters and Setters

    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }

    public ArrayList<Carte> getCarti() {
        return carti;
    }
    public void setCarti(ArrayList<Carte> carti) {
        this.carti = carti;
    }

    @Override
    public String toString() {
        return "Sectiune{" +
                "nume='" + nume + '\'' +
                ", carti=" + carti.toString() +
                '}';
    }
}
