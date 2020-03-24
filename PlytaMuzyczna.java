package Wypozyczalnia;
//Wyjaśnienia takie jak w Ebook
public class PlytaMuzyczna extends Zbior {

    String gatunek;
    double dlugoscOdtwarzania;

    public PlytaMuzyczna(int id, int dataWydania, String autor, String tytul, String wydawnictwo, double wartosc) {
        super(id, dataWydania, autor, tytul, wydawnictwo, wartosc);
    }
}
