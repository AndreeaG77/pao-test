package Interfete;

import Clase.Carte;
import Clase.Client;

import java.util.Scanner;

public interface InterfataClient {
    Client[] citireDateClientImprumut(Scanner scanner, Client[] clImpr, Carte[] c);

    Client[] citireDateClientRetur(Scanner scanner, Client[] clRetur, Client[] clImpr, Carte[] c);

    boolean verificaNume(String numeCarte, Carte[] c);

    boolean verificaDisponibilitate(String numeCarte, Carte[] c);

    Carte gasesteCarte(String numeCarte, Carte[] c);

    Client[] adaugaClient(Client[] clArray, Client cl);

    boolean  verificaDate(Client[] clImpr, String cnp, String numeCarte);
}
