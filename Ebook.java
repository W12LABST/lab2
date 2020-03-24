package Wypozyczalnia;

public class Ebook extends Zbior {
//W każdej klasie znajdują się atrybuty z modyfikatorem dostępu "default", ponieważ dzięki temu łatwiej było mi stworzyć nowy obiekt
    int wagaPlikuEbook;
    int iloscStronEbook;
//Słowo kluczowe "super" potrzebne do wywołania metody klasy bazowej.
    public Ebook(int id, int dataWydania, String autor, String tytul, String wydawnictwo, double wartosc) {
        super(id, dataWydania, autor, tytul, wydawnictwo, wartosc);
    }
}
