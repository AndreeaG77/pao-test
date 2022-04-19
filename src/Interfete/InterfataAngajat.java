package Interfete;

import Clase.Angajat;

import java.util.Scanner;

public interface InterfataAngajat {
    void vizualizareAngajati(Angajat[] ang);

    Angajat[] adaugaAngajat(Angajat[] ang, Angajat a);

    Angajat[] citireDateAngajatNou(Scanner scanner, Angajat[] ang);

    Angajat[] eliminaAngajat(Angajat[] ang, int idx);
}
