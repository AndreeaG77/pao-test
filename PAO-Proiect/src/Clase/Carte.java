package Clase;


public class Carte {
    private String nume;
    static int nrExemplare = 10;
    Clase.Autor a;

    public Carte(String nume, Autor a){
        this.nume = nume;
        this.a = a;
    }

    // Getters and Setters

    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }

    public static int getNrExemplare() {return nrExemplare;}
    public static void setNrExemplare(int nrExemplare) {nrExemplare = nrExemplare;}

    public Autor getA() {
        return a;
    }
    public void setA(Autor a) {
        this.a = a;
    }


    @Override
    public String toString() {
        return "Carte{" +
                "nume='" + nume + '\'' +
                ", a=" + a +
                '}';
    }
}
