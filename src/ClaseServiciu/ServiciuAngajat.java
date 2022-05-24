package ClaseServiciu;

import Clase.Angajat;
import Clase.Bibliotecar;
import Clase.Bodyguard;
import Interfete.InterfataAngajat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ServiciuAngajat implements InterfataAngajat{
    public void vizualizareAngajati(ArrayList<Angajat> ang){
        int idx = 0;
        for(int i=0; i<ang.size(); i++) {
            idx = i+1;
            System.out.print(idx + ". " + ang.get(i).getNume() + " ");
            System.out.println(ang.get(i).getPrenume());
            int sal = ang.get(i).getSalariu();
            System.out.println("Salariu: " + sal);
            System.out.println(ang.get(i).toString());
        }
    }

    public ArrayList<Angajat> citireDateAngajatNou(Scanner scanner, ArrayList<Angajat> ang){
        System.out.println("Adauga informatiile despre noul angajat");
        System.out.println("Nume: ");
        String nume = scanner.next();
        System.out.println("Prenume: ");
        String prenume = scanner.next();
        System.out.println("Apasa 1 pentru BIBLIOTECAR / 2 pentru BODYGUARD: ");
        int i = scanner.nextInt();
        if(i==1){
            System.out.println("Grad: ");
            String grad = scanner.next();
            Bibliotecar angNou = new Bibliotecar(nume,prenume,grad);
            ang.add(angNou);
        }
        else {
            System.out.println("Firma securitate: ");
            String firmaSecuritate = scanner.next();
            Bodyguard angNou = new Bodyguard(nume, prenume, firmaSecuritate);
            ang.add(angNou);
        }
        return ang;
    }

    public ArrayList<Angajat> eliminaAngajat(ArrayList<Angajat> ang, int idx){
        ang.remove(idx-1);
        return ang;
    }
}
