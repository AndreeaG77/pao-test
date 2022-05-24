package ClasaMain;

import Clase.*;
import ClaseServiciu.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{
        ServiciuCitire sCitire = ServiciuCitire.getSeriviciuCitire();
        ArrayList<Autor> aut = new ArrayList<>();
        ArrayList<Carte> c = new ArrayList<>();
        ArrayList<Angajat> ang = new ArrayList<>();
        ArrayList<Sectiune> s = new ArrayList<>();

        try{
            aut = sCitire.citireAutori();

        } catch (IOException e) {
            System.out.print("eroare la citire");
        }

        try{
            c = sCitire.citireCarti();
        } catch (IOException e) {
            System.out.print("eroare la citire");
        }

        try{
            s = sCitire.citireSectiune(c);
        } catch (IOException e) {
            System.out.print("eroare la citire");
        }

        try{
            ang = sCitire.citireAngajati();
        } catch (IOException e) {
            System.out.print("eroare la citire");
        }

        ArrayList<Client> clImprumut = new ArrayList<>();
        ArrayList<Client> clRetur = new ArrayList<>();

        ServiciuAngajat sa = new ServiciuAngajat();
        ServiciuCarte sc = new ServiciuCarte();
        ServiciuClient scl = new ServiciuClient();

        ServiciuScriereGeneric ssg = ServiciuScriereGeneric.getServiciuScriereGeneric();

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
                                ssg.scriereGenerica("VIZUALIZARE ANGAJATI", null);
                                break;
                            }
                            case 2:{
                                ang = sa.citireDateAngajatNou(scanner, ang);
                                ssg.scriereGenerica("AGAUGARE ANGAJAT", null);
                                break;
                            }
                            case 3:{
                                int l = ang.size();
                                System.out.println("Alege un index intre 1 si " + l + " pentru a concedia angajatul cu indexul respectiv");
                                int idx = scanner.nextInt();
                                ang = sa.eliminaAngajat(ang, idx);
                                ssg.scriereGenerica("CONCEDIERE ANGAJAT", null);
                                break;
                            }
                            case 4:{
                                sc.vizualizareListe(clImprumut, clRetur);
                                ssg.scriereGenerica("VIZUALIZARE LISTA CARTI IMPRUMUTATE/RETURNATE", null);
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
                                ssg.scriereGenerica("VIZUALIZARE CARTI", null);
                                break;
                            }
                            case 2:{
                                sc.vizualizeazaAutori(aut);
                                ssg.scriereGenerica("VIZUALIZARE AUTORI", null);
                                break;
                            }
                            case 3:{
                                sc.vizualizeazaSectiuni(s);
                                ssg.scriereGenerica("VIZUALIZARE SECTIUNI", null);
                                break;
                            }
                            case 4:{
                                System.out.println("Introduceti numele autorului: ");
                                String nume = scanner.next();
                                sc.vizualizeazaCartiDupaAutor(nume,c);
                                ssg.scriereGenerica("VIZUALIZARE CARTI DUPA AUTOR", null);
                                break;
                            }
                            case 5:{
                                System.out.println("Introduceti numele sectiunii: ");
                                String nume = scanner.next();
                                sc.vizualizeazaCartiDupaSectiune(nume,s);
                                ssg.scriereGenerica("VIZUALIZARE CARTI DUPA SECTIUNE", null);
                                break;
                            }
                            case 6:{
                                clImprumut = scl.citireDateClientImprumut(scanner, clImprumut, c);
                                ssg.scriereGenerica("IMPRUMUTARE CARTE", null);
                                ssg.scriereGenerica(clImprumut.get(clImprumut.size()-1), "ListaClientiImprumut.txt");
                                break;
                            }
                            case 7:{
                                clRetur = scl.citireDateClientRetur(scanner, clRetur, clImprumut, c);
                                ssg.scriereGenerica(clRetur.get(clRetur.size()-1), "ListaClientiRetur.txt");
                                ssg.scriereGenerica("RETURNARE CARTE", null);
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