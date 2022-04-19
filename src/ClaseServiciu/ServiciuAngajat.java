package ClaseServiciu;

import Clase.Angajat;
import Clase.Bibliotecar;
import Clase.Bodyguard;
import Interfete.InterfataAngajat;

import java.util.Arrays;
import java.util.Scanner;

public class ServiciuAngajat implements InterfataAngajat{
    public void vizualizareAngajati(Angajat[] ang){
        int idx = 0;
        for(int i=0; i<ang.length; i++) {
            idx = i+1;
            System.out.print(idx + ". " + ang[i].getNume() + " ");
            System.out.println(ang[i].getPrenume());
            int sal = ang[i].getSalariu();
            System.out.println("Salariu: " + sal);
            System.out.println(ang[i].toString());
        }
    }

    public Angajat[] citireDateAngajatNou(Scanner scanner, Angajat[] ang){
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
            ang = adaugaAngajat(ang, angNou);
        }
        else {
            System.out.println("Firma securitate: ");
            String firmaSecuritate = scanner.next();
            Bodyguard angNou = new Bodyguard(nume, prenume, firmaSecuritate);
            ang = adaugaAngajat(ang, angNou);
        }
        return ang;
    }

    public Angajat[] adaugaAngajat(Angajat[] ang, Angajat a){
        ang = Arrays.copyOf(ang, ang.length + 1);
        ang[ang.length - 1] = a;
        return ang;
    }

    public Angajat[] eliminaAngajat(Angajat[] ang, int idx){
        Angajat[] angAux = new Angajat[ang.length-1];
        int j = 0;
        for(int i=0; i< ang.length; i++){
            if(i != idx-1) angAux[j++] = ang[i];
        }
        return angAux;
    }
}
