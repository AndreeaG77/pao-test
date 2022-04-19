package Clase;

public class Angajat {
    private String nume;
    private String prenume;
    public static final int SALARIU_BAZA = 2000;

    public Angajat(String nume, String prenume){
        this.nume = nume;
        this.prenume = prenume;
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

    public int getSalariu(){
        return this.SALARIU_BAZA;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", salariu=" + SALARIU_BAZA +
                '}';
    }
}
