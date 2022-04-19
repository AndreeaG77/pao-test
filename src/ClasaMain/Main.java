package ClasaMain;

import Clase.*;
import ClaseServiciu.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Bibliotecar a1 = new Bibliotecar("Popescu", "Alexandru", "II");
        Bodyguard a2 = new Bodyguard("Vasilescu", "Robert", "BGS");
        Angajat[] ang = {a1,a2};

        Autor aut1 = new Autor("Rebreanu", "Liviu", "27-nov-1885", "1-sep-1944");
        Autor aut2 = new Autor("Dickens", "Charles", "7-feb-1812", "9-jun-1870");
        Autor aut3 = new Autor("Caragiale", "Ion Luca", "13-feb-1852", "9-jun-1912");
        Autor aut4 = new Autor("Shakespeare", "William", "26-apr-1564", "23-apr-1616");
        Autor[] aut = {aut1, aut2, aut3, aut4};

        Carte c1 = new Carte("Ion", aut1);
        Carte c2 = new Carte("Padurea Spanzuratilor", aut1);
        Carte c3 = new Carte("Amandoi", aut1);
        Carte c4 = new Carte("Marile Sperante", aut2);
        Carte c5 = new Carte("Colind de craciun", aut2);
        Carte c6 = new Carte("David Copperfield", aut2);
        Carte c7 = new Carte("O noapte furtunoasa", aut3);
        Carte c8 = new Carte("Napasta", aut3);
        Carte c9 = new Carte("O faclie de Paste", aut3);
        Carte c10 = new Carte("Imblanzirea scorpiei", aut4);
        Carte c11 = new Carte("Visul unei nopti de vara", aut4);
        Carte c12 = new Carte("Romeo si Julieta", aut4);
        Carte[] c = {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12};

        Carte[] carti1 = {c5,c6,c9};
        Carte[] carti2 = {c7,c10,c11};
        Carte[] carti3 = {c8,c12};
        Carte[] carti4 = {c4,c1,c2,c3};
        Sectiune s1 = new Sectiune("Nuvela", carti1);
        Sectiune s2 = new Sectiune("Comedie", carti2);
        Sectiune s3 = new Sectiune("Drama", carti3);
        Sectiune s4 = new Sectiune("Roman", carti4);
        Sectiune[] s = {s1,s2,s3,s4};

        Client[] clImprumut = {};
        Client[] clRetur = {};

        ServiciuAngajat sa = new ServiciuAngajat();
        ServiciuCarte sc = new ServiciuCarte();
        ServiciuClient scl = new ServiciuClient();

        Scanner scanner;
        scanner = new Scanner(System.in);

        int com;
        int ok=1;

        while(ok==1){
            System.out.println("Apasa 1 pentru ADMINISTRATOR");
            System.out.println("Apasa 2 pentru CLIENT");
            System.out.println("Apasa 10 pentru EXIT");
            com = scanner.nextInt();

            switch(com){
                case 1:{
                    int ok1=1;
                    int com1;
                    while(ok1==1){
                        System.out.println("Apasa 1 pentru VIZUALIZARE ANGAJATI");
                        System.out.println("Apasa 2 pentru ADAUGARE ANGAJAT");
                        System.out.println("Apasa 3 pentru CONCEDIERE ANGAJAT");
                        System.out.println("Apasa 4 pentru VIZUALIZARE LISTA CARTI IMPRUMUTATE/RETURNATE");
                        System.out.println("Apasa 10 pentru LOG OUT ADMINISTRATOR");
                        com1 = scanner.nextInt();
                        switch(com1){
                            case 1:{
                                sa.vizualizareAngajati(ang);
                                break;
                            }
                            case 2:{
                                ang = sa.citireDateAngajatNou(scanner, ang);
                                break;
                            }
                            case 3:{
                                int l = ang.length;
                                System.out.println("Alege un index intre 1 si " + l + " pentru a concedia angajatul cu indexul respectiv");
                                int idx = scanner.nextInt();
                                ang = sa.eliminaAngajat(ang, idx);
                                break;
                            }
                            case 4:{
                                sc.vizualizareListe(clImprumut, clRetur);
                                break;
                            }
                            case 10:{
                                ok1=0;
                                break;
                            }
                            default:{
                                System.out.println("COMANDA INCORECTA");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 2:{
                    int ok2=1;
                    int com2;
                    while(ok2==1){
                        System.out.println("Apasa 1 pentru VIZUALIZARE CARTI");
                        System.out.println("Apasa 2 pentru VIZUALIZARE AUTORI");
                        System.out.println("Apasa 3 pentru VIZUALIZARE SECTIUNI");
                        System.out.println("Apasa 4 pentru VIZUALIZARE CARTI DUPA AUTOR");
                        System.out.println("Apasa 5 pentru VIZUALIZARE CARTI DUPA SECTIUNE");
                        System.out.println("Apasa 6 pentru IMPRUMUTARE CARTE");
                        System.out.println("Apasa 7 pentru RETURNARE CARTE");
                        System.out.println("Apasa 10 pentru LOG OUT CLIENT");
                        com2 = scanner.nextInt();
                        switch(com2){
                            case 1:{
                                sc.vizualizeazaCarti(c);
                                break;
                            }
                            case 2:{
                                sc.vizualizeazaAutori(aut);
                                break;
                            }
                            case 3:{
                                sc.vizualizeazaSectiuni(s);
                                break;
                            }
                            case 4:{
                                System.out.println("Introduceti numele autorului: ");
                                String nume = scanner.next();
                                sc.vizualizeazaCartiDupaAutor(nume,c);
                                break;
                            }
                            case 5:{
                                System.out.println("Introduceti numele sectiunii: ");
                                String nume = scanner.next();
                                sc.vizualizeazaCartiDupaSectiune(nume,s);
                                break;
                            }
                            case 6:{
                                clImprumut = scl.citireDateClientImprumut(scanner, clImprumut, c);
                                break;
                            }
                            case 7:{
                                clRetur = scl.citireDateClientRetur(scanner, clRetur, clImprumut, c);
                                break;
                            }
                            case 10:{
                                ok2=0;
                                break;
                            }
                            default:{
                                System.out.println("COMANDA INCORECTA");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 10:{
                    ok=0;
                    break;
                }
                default:{
                    System.out.println("COMANDA INCORECTA");
                    break;
                }

            }
        }
    }
}