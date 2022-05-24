package ClaseServiciu;

import Clase.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ServiciuCitire {

    private static ServiciuCitire sc;

    private ServiciuCitire() {}

    public static ServiciuCitire getSeriviciuCitire() {
        if (sc == null)
            sc = new ServiciuCitire();
        return sc;
    }

    public ArrayList<Angajat> citireAngajati() throws IOException{
        ArrayList<Angajat> ang = new ArrayList<>();
        try {
            String path = System.getProperty("user.dir") + "\\src\\FisiereCSV\\Angajat.txt";
            Scanner scaner = new Scanner(new File(path));
            scaner.useDelimiter(",");
            Bibliotecar a1 = new Bibliotecar(scaner.next(),scaner.next(),scaner.next());
            Bodyguard a2 = new Bodyguard(scaner.next().strip(),scaner.next(),scaner.next());

            ang.add(a1);
            ang.add(a2);

            return ang;
        } catch (IOException e) {
            System.out.print("Eroare la citire Angajat");
        }
        return ang;
    }

    public ArrayList<Autor> citireAutori() throws IOException{
        ArrayList<Autor> aut = new ArrayList<>();
        try {
            String path = System.getProperty("user.dir") + "\\src\\FisiereCSV\\Autor.txt";
            Scanner scaner = new Scanner(new File(path));
            scaner.useDelimiter(",");
            while (scaner.hasNext()) {
                Autor a = new Autor(scaner.next().strip(),scaner.next(),scaner.next(),scaner.next());
                aut.add(a);
            }
            return aut;
        } catch (IOException e) {
            System.out.print("Eroare la citire Autor");
        }
        return aut;
    }

    public ArrayList<Carte> citireCarti() throws IOException{
        ArrayList<Carte> c = new ArrayList<>();
        try {
            String path = System.getProperty("user.dir") + "\\src\\FisiereCSV\\Carte.txt";
            Scanner scaner = new Scanner(new File(path));
            scaner.useDelimiter(",");
            while (scaner.hasNext()) {
                String numeCarte = scaner.next().strip();
                Autor a = new Autor(scaner.next(),scaner.next(),scaner.next(),scaner.next());
                Carte crt = new Carte(numeCarte, a);
                c.add(crt);
            }
            return c;
        } catch (IOException e) {
            System.out.print("Eroare la citire Carte");
        }
        return c;
    }

    public ArrayList<Sectiune> citireSectiune(ArrayList<Carte> c) throws IOException{
        ArrayList<Sectiune> s = new ArrayList<>();
        try {
            String path = System.getProperty("user.dir") + "\\src\\FisiereCSV\\Sectiune.txt";
            Scanner scaner = new Scanner(new File(path));
            scaner.useDelimiter(",");

            ArrayList<Carte> carti1 = new ArrayList<>();
            carti1.add(c.get(4));
            carti1.add(c.get(5));
            carti1.add(c.get(8));
            Sectiune s1 = new Sectiune(scaner.next(), carti1);
            s.add(s1);

            ArrayList<Carte> carti2 = new ArrayList<>();
            carti2.add(c.get(6));
            carti2.add(c.get(9));
            carti2.add(c.get(10));
            Sectiune s2 = new Sectiune(scaner.next(), carti2);
            s.add(s2);

            ArrayList<Carte> carti3 = new ArrayList<>();
            carti3.add(c.get(7));
            carti3.add(c.get(11));
            Sectiune s3 = new Sectiune(scaner.next(), carti3);
            s.add(s3);

            ArrayList<Carte> carti4 = new ArrayList<>();
            carti4.add(c.get(3));
            carti4.add(c.get(0));
            carti4.add(c.get(2));
            carti4.add(c.get(3));
            Sectiune s4 = new Sectiune(scaner.next(), carti4);
            s.add(s4);

            return s;
        } catch (IOException e) {
            System.out.print("Eroare la citire sectiune");
        }
        return s;
    }
}
