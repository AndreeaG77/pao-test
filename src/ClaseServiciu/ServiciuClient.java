package ClaseServiciu;

import Clase.Carte;
import Clase.Client;
import Interfete.InterfataClient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ServiciuClient implements InterfataClient {
    public ArrayList<Client> citireDateClientImprumut(Scanner scanner, ArrayList<Client> clImpr, ArrayList<Carte> c){
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
                clImpr.add(cl);
            } else System.out.println("Carte indisponibila");
        }
        else System.out.println("Nume invalid");
        return clImpr;
    }

    public ArrayList<Client> citireDateClientRetur(Scanner scanner, ArrayList<Client> clRetur, ArrayList<Client> clImpr, ArrayList<Carte> c){
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
                clRetur.add(cl);
            }
            else System.out.println("Nu exista in istoric imprumutarea cartii " + numeCarte + " facuta de catre clientul cu cnp-ul: " + cnp);
        }
        else System.out.println("Nume invalid");
        return clRetur;
    }

    public boolean verificaNume(String numeCarte, ArrayList<Carte> c){
        for(int i=0; i<c.size(); i++){
            if(numeCarte.equals(c.get(i).getNume())) return true;
        }
        return false;
    }

    public boolean verificaDisponibilitate(String numeCarte, ArrayList<Carte> c){
        for(int i=0; i<c.size(); i++){
            if(numeCarte.equals(c.get(i).getNume())){
                if(c.get(i).getNrExemplare()>0) return true;
            }
        }
        return false;
    }

    public Carte gasesteCarte(String numeCarte, ArrayList<Carte> c){
        for(int i=0; i<c.size(); i++){
            if(numeCarte.equals(c.get(i).getNume())){
                Carte cAux = c.get(i);
                return cAux;
            }
        }
        Carte cAux2 = c.get(0);
        return c.get(0);
    }

    public boolean  verificaDate(ArrayList<Client> clImpr, String cnp, String numeCarte){
        for(int i=0; i< clImpr.size(); i++){
            Carte caux = clImpr.get(i).getCarteImprumutataReturnata();
            if(cnp.equals(clImpr.get(i).getCnp()) && numeCarte.equals(caux.getNume())) return true;
        }
        return false;
    }
}
