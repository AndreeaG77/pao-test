package Clase;

public class Autor {
    private String nume;
    private String prenume;
    private String dataNasterii;
    private String dataDecesului;

    public Autor(String nume, String prenume, String dataNasterii, String dataDecesului){
        this.nume = nume;
        this.prenume = prenume;
        this.dataNasterii = dataNasterii;
        this.dataDecesului = dataDecesului;
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

    public String getDataNasterii() {
        return dataNasterii;
    }
    public void setDataNasterii(String dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public String getDataDecesului() {
        return dataDecesului;
    }
    public void setDataDecesului(String dataDecesului) {
        this.dataDecesului = dataDecesului;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", dataNasterii='" + dataNasterii + '\'' +
                ", dataDecesului='" + dataDecesului + '\'' +
                '}';
    }

}
