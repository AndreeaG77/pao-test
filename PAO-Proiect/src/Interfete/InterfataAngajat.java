package Interfete;

import Clase.Angajat;

import java.sql.SQLException;
import java.util.Scanner;

public interface InterfataAngajat {
    void vizualizareAngajati() throws SQLException;

    void citireDateAngajatNou(Scanner scanner) throws SQLException;

    void eliminaAngajat(Scanner scanner) throws  SQLException;
}
