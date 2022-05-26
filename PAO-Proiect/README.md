# PAO-Proiect
Proiectul implementeaza o aplicatie de gestiune a unei biblioteci.
Obiectele folosite sunt: Client, Autor, Carte, Sectiune, Angajat, Bodyguard, Bibliotecar.

Actiunile/Interogarile sunt:
1. Vizualizare lista angajati
2. Adaugare angajat
3. Eliminare angajat
4. Vizualizare lista carti
5. Vizualizare lista autori
6. Vizualizare lista sectiuni
7. Cautare carti dupa autor
8. Cautare carti dupa sectiune
9. Imprumutare carte
10. Returnare carte
11. Vizualizare lista clienti care au imprumutat/returnat o carte

Reguli de functionare:
1. Un client poate imprumuta/returna o singura carte pe inregistrare
2. O carte nu poate fi returnata daca in istoric nu exista o astfel de inregistrare (se face cautare dupa cnp si numele cartii)
3. Se presupune ca un client o sa imprumute o anumita carte o singura data (ex: Clientul X nu o sa imprumute de mai multe ori cartea "Marile Sperante")
4. Exista 10 exemplare din fiecare carte, daca toate cele 10 carti sunt imprumutate, la a 11a solicitare se va afisa textul "Carte indisponibila"
5. Se tin evidenta clientilor care au imprumutat carti si care au returnat carti in 2 array-uri separate
