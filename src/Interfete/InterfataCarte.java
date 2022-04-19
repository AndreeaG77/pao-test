package Interfete;

import Clase.Autor;
import Clase.Carte;
import Clase.Client;
import Clase.Sectiune;

public interface InterfataCarte {
    void vizualizareListe(Client[] clImpr, Client[] clRetur);

    void vizualizeazaAutori(Autor[] aut);

    void vizualizeazaCarti(Carte[] c);

    void vizualizeazaSectiuni(Sectiune[] s);

    void vizualizeazaCartiDupaAutor(String nume, Carte[] c);

    void vizualizeazaCartiDupaSectiune(String nume, Sectiune[] s);
}
