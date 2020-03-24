package Wypozyczalnia;
//Wyjaśnienia takie jak w Ebook
public class Audiobook extends Zbior {

    int wagaPlikuAudiobook;
    double czasTrwaniaAudiobook;

    public Audiobook(int id, int dataWydania, String autor, String tytul, String wydawnictwo, double wartosc) {
        super(id, dataWydania, autor, tytul, wydawnictwo, wartosc);
    }
}
