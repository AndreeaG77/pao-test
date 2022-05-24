package Interfete;

import Clase.Angajat;

import java.util.ArrayList;
import java.util.Scanner;

public interface InterfataAngajat {
    void vizualizareAngajati(ArrayList<Angajat> ang);

    ArrayList<Angajat> citireDateAngajatNou(Scanner scanner, ArrayList<Angajat> ang);

    ArrayList<Angajat> eliminaAngajat(ArrayList<Angajat> ang, int idx);
}
