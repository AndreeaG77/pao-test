package ClaseServiciu;

import Clase.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ServiciuCitire {
    public Angajat[] citireAngajati() throws IOException{
        Angajat[] ang = {};
        try {
            Scanner scaner = new Scanner(new File("C:\\Users\\CiuriBuri.CiuriBuri-PC\\Desktop\\pao\\pao_lab_2022\\PAO-Proiect\\src\\FisiereCSV\\Angajat.txt"));
            scaner.useDelimiter(",");
            Bibliotecar a1 = new Bibliotecar(scaner.next(),scaner.next(),scaner.next());
            Bodyguard a2 = new Bodyguard(scaner.next().strip(),scaner.next(),scaner.next());

            ang = Arrays.copyOf(ang, ang.length + 1);
            ang[ang.length - 1] = a1;
            ang = Arrays.copyOf(ang, ang.length + 1);
            ang[ang.length - 1] = a2;

            return ang;
        } catch (IOException e) {
            System.out.print("eroare la citire");
        }
        return ang;
    }

    public Autor[] citireAutori() throws IOException{
        Autor[] aut = {};
        try {
            Scanner scaner = new Scanner(new File("C:\\Users\\CiuriBuri.CiuriBuri-PC\\Desktop\\pao\\pao_lab_2022\\PAO-Proiect\\src\\FisiereCSV\\Autor.txt"));
            scaner.useDelimiter(",");
            while (scaner.hasNext()) {
                Autor a = new Autor(scaner.next().strip(),scaner.next(),scaner.next(),scaner.next());
                aut = Arrays.copyOf(aut, aut.length + 1);
                aut[aut.length - 1] = a;
            }
            return aut;
        } catch (IOException e) {
            System.out.print("eroare la citire");
        }
        return aut;
    }

    public Carte[] citireCarti() throws IOException{
        Carte[] c = {};
        try {
            Scanner scaner = new Scanner(new File("C:\\Users\\CiuriBuri.CiuriBuri-PC\\Desktop\\pao\\pao_lab_2022\\PAO-Proiect\\src\\FisiereCSV\\Carte.txt"));
            scaner.useDelimiter(",");
            while (scaner.hasNext()) {
                String numeCarte = scaner.next().strip();
                Autor a = new Autor(scaner.next(),scaner.next(),scaner.next(),scaner.next());
                Carte crt = new Carte(numeCarte, a);
                c = Arrays.copyOf(c, c.length + 1);
                c[c.length - 1] = crt;
            }
            return c;
        } catch (IOException e) {
            System.out.print("eroare la citire");
        }
        return c;
    }

    public Sectiune[] citireSectiune(Carte[] c) throws IOException{
        Sectiune[] s = {};
        try {
            Scanner scaner = new Scanner(new File("C:\\Users\\CiuriBuri.CiuriBuri-PC\\Desktop\\pao\\pao_lab_2022\\PAO-Proiect\\src\\FisiereCSV\\Sectiune.txt"));
            scaner.useDelimiter(",");

            Carte[] carti1 = {c[4],c[5],c[8]};
            Sectiune s1 = new Sectiune(scaner.next(), carti1);
            s = Arrays.copyOf(s, s.length + 1);
            s[s.length - 1] = s1;

            Carte[] carti2 = {c[6],c[9],c[10]};
            Sectiune s2 = new Sectiune(scaner.next(), carti2);
            s = Arrays.copyOf(s, s.length + 1);
            s[s.length - 1] = s2;

            Carte[] carti3 = {c[7],c[11]};
            Sectiune s3 = new Sectiune(scaner.next(), carti3);
            s = Arrays.copyOf(s, s.length + 1);
            s[s.length - 1] = s3;

            Carte[] carti4 = {c[3],c[0],c[2],c[3]};
            Sectiune s4 = new Sectiune(scaner.next(), carti4);
            s = Arrays.copyOf(s, s.length + 1);
            s[s.length - 1] = s4;

            return s;
        } catch (IOException e) {
            System.out.print("eroare la citire");
        }
        return s;
    }
}
