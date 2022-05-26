package Clase;

public class Bodyguard extends Angajat{
    private String firmaSecuritate;

    public Bodyguard(String nume, String prenume, String firmaSecuritate) {
        super(nume, prenume);
        this.firmaSecuritate = firmaSecuritate;
    }

    public int getSalariu() {
        return this.SALARIU_BAZA + 1500;
    }

    // Getters and Setters

    public String getFirmaSecuritate() {
        return firmaSecuritate;
    }
    public void setFirmaSecuritate(String firmaSecuritate) {
        this.firmaSecuritate = firmaSecuritate;
    }

    @Override
    public String toString() {
        return "Bodyguard" + "\n" +
                "firmaSecuritate: " + firmaSecuritate;
    }
}
