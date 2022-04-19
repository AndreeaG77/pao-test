package Clase;

import java.util.Arrays;

public class Sectiune {
    private String nume;
    private Carte[] carti;

    public Sectiune(String nume, Carte[] carti){
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

    public Carte[] getCarti() {
        return carti;
    }
    public void setCarti(Carte[] carti) {
        this.carti = carti;
    }

    @Override
    public String toString() {
        return "Sectiune{" +
                "nume='" + nume + '\'' +
                ", carti=" + Arrays.toString(carti) +
                '}';
    }
}
