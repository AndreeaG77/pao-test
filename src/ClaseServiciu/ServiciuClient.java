package ClaseServiciu;

import Clase.Carte;
import Clase.Client;
import Interfete.InterfataClient;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class ServiciuClient implements InterfataClient {
    public Client[] citireDateClientImprumut(Scanner scanner, Client[] clImpr, Carte[] c){
        System.out.println("Introduceti datele personale: ");
        System.out.println("Nume: ");
        String nume = scanner.next();
        System.out.println("Prenume: ");
        String prenume = scanner.next();
        System.out.println("CNP: ");
        String cnp = scanner.next();
        LocalDate dataImprumutarii = LocalDate.now();
        System.out.println("Numele cartii: ");
        String numeCarte= scanner.nextLine();
        numeCarte+=scanner.nextLine();
        boolean verificareNume = verificaNume(numeCarte, c);
        if(verificareNume) {
            boolean disponibila = verificaDisponibilitate(numeCarte, c);
            if (disponibila) {
                Carte carteImprumutata = gasesteCarte(numeCarte, c);
                Client cl = new Client(nume, prenume, cnp, carteImprumutata);
                int nr = carteImprumutata.getNrExemplare();
                nr--;
                carteImprumutata.setNrExemplare(nr);
                clImpr = adaugaClient(clImpr, cl);
            } else System.out.println("Carte indisponibila");
        }
        else System.out.println("Nume invalid");
        return clImpr;
    }

    public Client[] citireDateClientRetur(Scanner scanner, Client[] clRetur, Client[] clImpr, Carte[] c){
        System.out.println("Introduceti datele personale: ");
        System.out.println("Nume: ");
        String nume = scanner.next();
        System.out.println("Prenume: ");
        String prenume = scanner.next();
        System.out.println("CNP: ");
        String cnp = scanner.next();
        System.out.println("Numele cartii: ");
        String numeCarte= scanner.nextLine();
        numeCarte+=scanner.nextLine();
        boolean verificareNume = verificaNume(numeCarte, c);
        if(verificareNume) {
            boolean verificareDate = verificaDate(clImpr, cnp, numeCarte);
            if(verificareDate) {
                Carte carteReturnata = gasesteCarte(numeCarte, c);
                Client cl = new Client(nume, prenume, cnp, carteReturnata);
                int nr = carteReturnata.getNrExemplare();
                nr++;
                carteReturnata.setNrExemplare(nr);
                clRetur = adaugaClient(clRetur, cl);
            }
            else System.out.println("Nu exista in istoric imprumutarea cartii " + numeCarte + " facuta de catre clientul cu cnp-ul: " + cnp);
        }
        else System.out.println("Nume invalid");
        return clRetur;
    }

    public boolean verificaNume(String numeCarte, Carte[] c){
        for(int i=0; i<c.length; i++){
            if(numeCarte.equals(c[i].getNume())) return true;
        }
        return false;
    }

    public boolean verificaDisponibilitate(String numeCarte, Carte[] c){
        for(int i=0; i<c.length; i++){
            if(numeCarte.equals(c[i].getNume())){
                if(c[i].getNrExemplare()>0) return true;
            }
        }
        return false;
    }

    public  Carte gasesteCarte(String numeCarte, Carte[] c){
        for(int i=0; i<c.length; i++){
            if(numeCarte.equals(c[i].getNume())){
                Carte cAux = c[i];
                return cAux;
            }
        }
        Carte cAux2 = c[0];
        return c[0];
    }

    public Client[] adaugaClient(Client[] clArray, Client cl){
        clArray = Arrays.copyOf(clArray, clArray.length + 1);
        clArray[clArray.length - 1] = cl;
        return clArray;
    }

    public boolean  verificaDate(Client[] clImpr, String cnp, String numeCarte){
        for(int i=0; i< clImpr.length; i++){
            Carte caux = clImpr[i].getCarteImprumutataReturnata();
            if(cnp.equals(clImpr[i].getCnp()) && numeCarte.equals(caux.getNume())) return true;
        }
        return false;
    }
}
