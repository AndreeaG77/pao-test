package ClaseServiciu;

import Clase.Autor;
import Clase.Carte;
import Clase.Client;
import Clase.Sectiune;
import Interfete.InterfataCarte;

import java.util.Arrays;

public class ServiciuCarte implements InterfataCarte {
    public void vizualizareListe(Client[] clImpr, Client[] clRetur){
        System.out.println("Lista clientilor care au imprumutat carti: ");
        Arrays.stream(clImpr).forEach(cl -> System.out.println(cl.toString()));

        System.out.println("Lista clientilor care au returnat carti: ");
        Arrays.stream(clRetur).forEach(cl -> System.out.println(cl.toString()));
    }

    public void vizualizeazaAutori(Autor[] aut){
        Arrays.stream(aut).forEach(a -> System.out.println(a.toString()));
    }

    public void vizualizeazaCarti(Carte[] c){
        Arrays.stream(c).forEach(carte -> System.out.println(carte.getNume() + " de " + carte.getA().getPrenume() + " " + carte.getA().getNume()));
    }

    public void vizualizeazaSectiuni(Sectiune[] s){
        Arrays.stream(s).forEach(sect -> System.out.println(sect.getNume()));
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
