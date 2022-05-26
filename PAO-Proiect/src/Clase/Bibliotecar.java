package Clase;


public class Bibliotecar extends Angajat{
    // grad = I/II/III/debutant
    private String grad;

    public Bibliotecar(String nume, String prenume, String grad) {
        super(nume, prenume);
        this.grad = grad;
    }

    public int getSalariu() {
        return this.SALARIU_BAZA + 2000;
    }

    // Getters and Setters

    public String getGrad() {
        return grad;
    }
    public void setGrad(String grad) {
        this.grad = grad;
    }

    @Override
    public String toString() {
        return "Bibliotecar" + "\n" +
                "grad: " + grad;
    }
}
