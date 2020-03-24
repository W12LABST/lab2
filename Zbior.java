package Wypozyczalnia;
//Klasa, po której dziedziczą wszystkie zbiory w tym programie.
public class Zbior {
    private int id;
    private int dataWydania;
    private String autor;
    private String tytul;
    private String wydawnictwo;
    private double wartosc;
//Konstruktor ze słowem kluczowym "this" do przekazywania wartości. Nie wolno napisać np. x = x.
    public Zbior(int id, int dataWydania, String autor, String tytul, String wydawnictwo, double wartosc){
        this.id = id;
        this.dataWydania = dataWydania;
        this.autor = autor;
        this.tytul = tytul;
        this.wydawnictwo = wydawnictwo;
        this.wartosc = wartosc;
    }
//Metoda, której używam do wyświetlenia zawartośći w zasobach wypożyczalni.
    public void wyswietlanieZawartosci(){
        System.out.print(dataWydania +"\t\t"+ tytul +"\t\t\t\t"+ autor);
    }
//Metoda do wyświetlenia tytułu w aktualnie wypożyczonych pozycjach.
    public void wyswietlanieTytylu(){
        System.out.print(tytul + "\t");
    }
}
