package Interfete;

import Clase.Carte;
import Clase.Client;

import java.util.ArrayList;
import java.util.Scanner;

public interface InterfataClient {
    ArrayList<Client> citireDateClientImprumut(Scanner scanner, ArrayList<Client> clImpr, ArrayList<Carte> c);

    ArrayList<Client> citireDateClientRetur(Scanner scanner, ArrayList<Client> clRetur, ArrayList<Client> clImpr, ArrayList<Carte> c);

    boolean verificaNume(String numeCarte, ArrayList<Carte> c);

    boolean verificaDisponibilitate(String numeCarte, ArrayList<Carte> c);

    Carte gasesteCarte(String numeCarte, ArrayList<Carte> c);

    boolean  verificaDate(ArrayList<Client> clImpr, String cnp, String numeCarte);
}
