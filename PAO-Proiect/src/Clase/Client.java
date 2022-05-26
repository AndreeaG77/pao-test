package Clase;

import java.time.LocalDate;
import java.util.Objects;

public class Client {
    private String nume;
    private String prenume;
    private String cnp;
    private LocalDate dataImprumutariiReturului;
    private Carte carteImprumutataReturnata;

    public Client(){
        this.cnp= "-1";
    }

    public Client(String nume, String prenume, String cnp, Carte carteImprumutataReturnata){
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
        this.dataImprumutariiReturului = LocalDate.now();
        this.carteImprumutataReturnata = carteImprumutataReturnata;
    }

    // Getters and Setters

    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getCnp() {
        return cnp;
    }
    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public LocalDate getDataImprumutariiReturului() {
        return dataImprumutariiReturului;
    }
    public void setDataImprumutariiReturului(LocalDate dataImprumutariiReturului) {
        this.dataImprumutariiReturului = dataImprumutariiReturului;
    }

    public Carte getCarteImprumutataReturnata() {return carteImprumutataReturnata;}
    public void setCarteImprumutataReturnata(Carte carteImprumutataReturnata) {this.carteImprumutataReturnata = carteImprumutataReturnata;}

    @Override
    public String toString() {
        return "Nume client: " + nume + " " + prenume +
                ", cnp: " + cnp +
                ", data Imprumutarii/Returnarii: " + dataImprumutariiReturului +
                ", carte Imprumutata/Returnata: " + carteImprumutataReturnata.getNume();
    }

}