package ClaseServiciu;

import Clase.Autor;
import Clase.Carte;
import Clase.Client;
import Clase.Sectiune;
import Interfete.InterfataCarte;
import java.util.Arrays;
import java.util.ArrayList;

public class ServiciuCarte implements InterfataCarte {

    public void vizualizeazaAutori(ArrayList<Autor> aut){
        aut.stream().forEach(a -> System.out.println(a.toString()));
    }

    public void vizualizeazaCarti(ArrayList<Carte> c){
        c.stream().forEach(carte -> System.out.println(carte.getNume() + " de " + carte.getA().getPrenume() + " " + carte.getA().getNume()));
    }

    public void vizualizeazaSectiuni(ArrayList<Sectiune> s){
        s.stream().forEach(sect -> System.out.println(sect.getNume()));
    }

    public void vizualizeazaCartiDupaAutor(String nume, ArrayList<Carte> c){
        int idx = 0;
        int contor = 0;
        for(int i=0; i<c.size(); i++){
            Autor autAux = c.get(i).getA();
            if(nume.equals(autAux.getNume())){
                idx++;
                System.out.println(idx + ". " + c.get(i).getNume());
                contor++;
            }
        }
        if(contor==0) System.out.println("Nu a fost gasit niciun rezultat pentru numele introdus");
    }

    public void vizualizeazaCartiDupaSectiune(String nume, ArrayList<Sectiune> s){
        int idx = 0;
        int contor = 0;
        for(int i=0; i<s.size(); i++){
            if(nume.equals(s.get(i).getNume())){
                ArrayList<Carte> cAux = s.get(i).getCarti();
                for(int j=0; j<cAux.size(); j++){
                    idx++;
                    System.out.println(idx + ". " + cAux.get(j).getNume());
                }
                contor=1;
            }
        }
        if(contor==0) System.out.println("Nu a fost gasit niciun rezultat pentru numele introdus");
    }
}
