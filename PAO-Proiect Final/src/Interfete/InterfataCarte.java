package Interfete;

import Clase.Autor;
import Clase.Carte;
import Clase.Client;
import Clase.Sectiune;
import java.util.ArrayList;

public interface InterfataCarte {

    void vizualizeazaAutori(ArrayList<Autor> aut);

    void vizualizeazaCarti(ArrayList<Carte> c);

    void vizualizeazaSectiuni(ArrayList<Sectiune> s);

    void vizualizeazaCartiDupaAutor(String nume, ArrayList<Carte> c);

    void vizualizeazaCartiDupaSectiune(String nume, ArrayList<Sectiune> s);
}
