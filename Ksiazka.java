package Wypozyczalnia;
//Wyjaśnienia takie jak w Ebook
public class Ksiazka extends Zbior {

    int liczbaStron;

    public Ksiazka(int id, int dataWydania, String autor, String tytul, String wydawnictwo, double wartosc) {
        super(id, dataWydania, autor, tytul, wydawnictwo, wartosc);
    }
}
