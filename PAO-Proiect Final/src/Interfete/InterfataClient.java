package Interfete;

import Clase.Carte;
import Clase.Client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public interface InterfataClient {
     void creareTabelClientImprumut() throws SQLException;

     void creareTabelClientRetur() throws SQLException;

    Client citireDateClientImprumut(Scanner scanner, ArrayList<Carte> c) throws SQLException;

    Client citireDateClientRetur(Scanner scanner, ArrayList<Carte> c) throws SQLException;

    boolean verificaNume(String numeCarte) throws SQLException;

    boolean verificaDisponibilitate(String numeCarte) throws SQLException;

    Carte gasesteCarte(String numeCarte, ArrayList<Carte> c);

    boolean  verificaDate(String cnp, String numeCarte);

    void updateCarte1(String numeCarte) throws SQLException;

    void updateCarte2(String numeCarte) throws SQLException;

    void vizualizareListe() throws  SQLException;
}
