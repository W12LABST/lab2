package Wypozyczalnia;
//Wyjaśnienia takie jak w Ebook
public class Film extends Zbior {

    String gatunekFilmu;
    double dlugoscOdtwarzaniaFilmu;

    public Film(int id, int dataWydania, String autor, String tytul, String wydawnictwo, double wartosc) {
        super(id, dataWydania, autor, tytul, wydawnictwo, wartosc);
    }
}
