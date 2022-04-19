package ClaseServiciu;

import Clase.Autor;
import Clase.Carte;
import Clase.Client;
import Clase.Sectiune;
import Interfete.InterfataCarte;

public class ServiciuCarte implements InterfataCarte {
    public void vizualizareListe(Client[] clImpr, Client[] clRetur){
        System.out.println("Lista clientilor care au imprumutat carti: ");
        int idx1 = 0;
        for(int i=0; i<clImpr.length; i++){
            idx1++;
            System.out.println(idx1 + ". " + clImpr[i].getNume() + " " + clImpr[i].getPrenume());
            System.out.println("CNP: " + clImpr[i].getCnp());
            Carte cAux = clImpr[i].getCarteImprumutataReturnata();
            System.out.println("Carte imprumutata:" + cAux.getNume());
            System.out.println("Data imprumutarii: " + clImpr[i].getDataImprumutariiReturului());
            System.out.println();
        }
        System.out.println("Lista clientilor care au returnat carti: ");
        int idx2 = 0;
        for(int i=0; i<clRetur.length; i++){
            idx2++;
            System.out.println(idx2 + ". " + clRetur[i].getNume() + " " + clRetur[i].getPrenume());
            System.out.println("CNP: " + clRetur[i].getCnp());
            Carte cAux = clRetur[i].getCarteImprumutataReturnata();
            System.out.println("Carte returnata:" + cAux.getNume());
            System.out.println("Data returului: " + clRetur[i].getDataImprumutariiReturului());
            System.out.println();
        }
    }

    public void vizualizeazaAutori(Autor[] aut){
        int idx = 0;
        for(int i=0; i<aut.length; i++) {
            idx = i+1;
            System.out.print(idx + ". " + aut[i].getPrenume() + " ");
            System.out.println(aut[i].getNume());
            System.out.println("Data nasterii: " + aut[i].getDataNasterii());
            System.out.println("Data decesului: " + aut[i].getDataDecesului());
        }
    }

    public void vizualizeazaCarti(Carte[] c){
        int idx = 0;
        for(int i=0; i<c.length; i++) {
            idx = i+1;
            System.out.print(idx + ". " + c[i].getNume() + " de ");
            Autor autorAux = c[i].getA();
            System.out.println(autorAux.getPrenume() + " " + autorAux.getNume());
        }
    }

    public void vizualizeazaSectiuni(Sectiune[] s){
        int idx = 0;
        for(int i=0; i<s.length; i++) {
            idx = i+1;
            System.out.println(idx + ". " + s[i].getNume());
        }
    }

    public void vizualizeazaCartiDupaAutor(String nume, Carte[] c){
        int idx = 0;
        int contor = 0;
        for(int i=0; i<c.length; i++){
            Autor autAux = c[i].getA();
            if(nume.equals(autAux.getNume())){
                idx++;
                System.out.println(idx + ". " + c[i].getNume());
                contor++;
            }
        }
        if(contor==0) System.out.println("Nu a fost gasit niciun rezultat pentru numele introdus");
    }

    public void vizualizeazaCartiDupaSectiune(String nume, Sectiune[] s){
        int idx = 0;
        int contor = 0;
        for(int i=0; i<s.length; i++){
            if(nume.equals(s[i].getNume())){
                Carte[] cAux = s[i].getCarti();
                for(int j=0; j<cAux.length; j++){
                    idx++;
                    System.out.println(idx + ". " + cAux[j].getNume());
                }
                contor=1;
            }
        }
        if(contor==0) System.out.println("Nu a fost gasit niciun rezultat pentru numele introdus");
    }
}
