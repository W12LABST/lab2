
/**początek części "statycznej" programu*/
/**czyli te informacje pozostają niezmienne w czasie jego trwania*/

package Wypozyczalnia;
import java.io.IOException;
import java.util.Scanner;
import java.sql.Timestamp;
// Exception niezbędny do robienia pauz w programie poprzez System.in.read(), po wywołaniu tej metody program czeka na reakcję użytkownika.
// Timestamp do sczytywania daty z systemu. Szczegóły w dalszej części komentarza.
// Słowo kluczowe "throws" dodane automatycznie przez edytor. Program przechodzi do miejsca obsługi wyjątku

public class Wypozyczalnia {
    public static void main(String[] args) throws IOException {
        //Tu tworzone są instancje klas, czyli obiekty:
        //-------------------------
        Ksiazka Mechanika = new Ksiazka(481759, 2012, "Jan Kowalski", "Mechanika", "Pwr", 50);
        Mechanika.liczbaStron = 350;
        //-------------------------
        PlytaMuzyczna BestHits = new PlytaMuzyczna(719765, 1985, "The Band", "Best Hits", "EMI", 200);
        BestHits.dlugoscOdtwarzania = 46.35;
        BestHits.gatunek = "rock";
        //-------------------------
        Film Documentary = new Film(581476, 2019, "BBC", "Dokument przyrodniczy", "BBC", 50);
        Documentary.dlugoscOdtwarzaniaFilmu = 123.58;
        Documentary.gatunekFilmu = "Dokument";
        //-------------------------
        Audiobook Wojna = new Audiobook(493285, 2020, "Marcin Maliniak", "Wojna", "eKsiążka", 20);
        Wojna.czasTrwaniaAudiobook = 452.47;
        Wojna.wagaPlikuAudiobook = 15;
        //-------------------------
        Ebook Historia = new Ebook(189327, 2015, "Adam Baranowski", "Historia", "eKsiążka", 20);
        Historia.wagaPlikuEbook = 45;
        Historia.iloscStronEbook = 500;
        //-------------------------

        /**koniec części "statycznej" programu*/

        /**początek części inicjacyjnej programu*/
        /**te informacje są nadane odgórnie oraz modyfikowane w części dynamicznej programu*/

        //Wartości domyslne zmiennych utworzone w tym miejscu i celu aby możliwe było wykonywanie dalszych operacji na nich
        //poprzez ich modyfikację w instrukcjach sterujących w sposób przyjmowania wartości lokalnie wywołanych metod i stanów logicznych,
        //aby uniknąć sytuacji, w której mamy do czynienia z tworzeniem zmiennych w instrukcjach sterujących, które nie koniecznie
        //muszą być później używane. W końcu chcemy aby te zmienne przyjmowały wartości w zależności od obecnej sytuacji.

        //Zmienna odpowiadająca za przechowywanie informacji o karach finansowych
        double karyFinansowe = 0;

        //Stany logiczne odpowiadające za przechowywanie pozycji u klienta wypożyczalni
        boolean czyWypozyczone1 = false;
        boolean czyWypozyczone2 = false;
        boolean czyWypozyczone3 = false;
        boolean czyWypozyczone4 = false;
        boolean czyWypozyczone5 = false;

        //triggery służące do blokady naliczania kar finansowych. Dzieki nim kara jest naliczana tylko raz. W całym programie są trzy moduły
        //odpowiadające za naliczanie kar w celu wykonania tej czynności niezależnie od miejsca przebywania użytkownika w strukturze programu
        //trigger się uaktywnia w czasie naliczenia kary raz powodując blokadę naliczenia tej kary dla danej pozycji w pozostałych modułach sprawdzających
        boolean timetrigg1 = false;
        boolean timetrigg2 = false;
        boolean timetrigg3 = false;
        boolean timetrigg4 = false;
        boolean timetrigg5 = false;

        //Timestampy. Zasada działania wartości domyślnej taka sama jak powyżej. Program dyskretnie monitoruje czas aktualny systemu w celu
        //porównania go z czasem wypożyczenia, którejś z pozycji
        Timestamp defaultTime = Timestamp.valueOf("2000-01-01 00:00:00.00");
        Timestamp czasWypozyczenia1 = Timestamp.valueOf("2000-01-01 00:00:00.00");
        Timestamp czasWypozyczenia2 = Timestamp.valueOf("2000-01-01 00:00:00.00");
        Timestamp czasWypozyczenia3 = Timestamp.valueOf("2000-01-01 00:00:00.00");
        Timestamp czasWypozyczenia4 = Timestamp.valueOf("2000-01-01 00:00:00.00");
        Timestamp czasWypozyczenia5 = Timestamp.valueOf("2000-01-01 00:00:00.00");

        /**koniec inicjacyjnej części programu*/

        /**początej części dynamicznej programu*/
        /**informacje w tej części są poddawane stałej modyfikacji w trakcie użytkowania programu*/

        //Pętla główna części dynamicznej programu. Odpowiada za wyświetlanie menu głównego. Oraz możlwość wejścia do
        //innych pętli wewnątrz niej. W programie zostały użyte rózne formy instrukcji sterujących. Zasada działania:
        //sczytanie znaku z klawiatury poprzez char wyborKlienta = scan.next().charAt(0);. Nastepnie sprawdzenie przypadku
        //przed odpowiednie instrukcje sterujące.
        while(true) {
            /** Moduł sprawdzający #1 odpowiadający za:
             * sczytanie czasu systemowego
             * sprawdzenie różnicy czasów przez metodę klasy głównej (jej opis na samym dole kodu)
             * naliczenie kary finansowej w danym miejscu przebywania użytkownika
             * zablokowanie możliwości jej naliczenia w reszcie modułów*/
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            defaultTime = timestamp;
            if((roznicaCzasow(defaultTime, czasWypozyczenia1)) && czyWypozyczone1 && !timetrigg1){
                timetrigg1 = true;
                karyFinansowe = karyFinansowe + 10;
            }
            if((roznicaCzasow(defaultTime, czasWypozyczenia2)) && czyWypozyczone2 && !timetrigg2){
                timetrigg2 = true;
                karyFinansowe = karyFinansowe + 10;
            }
            if((roznicaCzasow(defaultTime, czasWypozyczenia3)) && czyWypozyczone3 && !timetrigg3){
                timetrigg3 = true;
                karyFinansowe = karyFinansowe + 10;
            }
            if((roznicaCzasow(defaultTime, czasWypozyczenia4)) && czyWypozyczone4 && !timetrigg4){
                timetrigg4 = true;
                karyFinansowe = karyFinansowe + 10;
            }
            if((roznicaCzasow(defaultTime, czasWypozyczenia5)) && czyWypozyczone5 && !timetrigg5){
                timetrigg5 = true;
                karyFinansowe = karyFinansowe + 10;
            }

            //pętla odpowiadająca za "czyszczenie" konsoli. Użyta wielokrotnie w programie.
            for (int i = 0; i < 20; i++) System.out.println(" ");
            System.out.println("\t\t\t\t\tWitaj w wypożyczalni multimedialnej!\n\n");
            if(karyFinansowe > 0){System.out.println("\t\t\t\t\tKonto zablokowane, opłać kary finansowe oraz oddaj pozycje.");}
            Scanner scan = new Scanner(System.in);
            System.out.print("\t\t\t\t\t\t  \n\n\t\t\t\t\tAby wejść na swoje konto wciśnij enter:");
            System.in.read();
                while (true) {
                    for (int i = 0; i < 20; i++) System.out.println(" ");
                    System.out.println("\t\t\t\t\t   Jesteś na koncie klienta.");

                    //Tutaj program sprawdza i wypisuje co zostało wypożyczone. Jest też podawana informacja o zaległościach finansowych oraz blokadzie konta.
                    System.out.print("Wypożyczone pozycje:\t");
                    if(czyWypozyczone1){ Mechanika.wyswietlanieTytylu(); }
                    if(czyWypozyczone2){ BestHits.wyswietlanieTytylu(); }
                    if(czyWypozyczone3){ Documentary.wyswietlanieTytylu(); }
                    if(czyWypozyczone4){ Wojna.wyswietlanieTytylu(); }
                    if(czyWypozyczone5){ Historia.wyswietlanieTytylu(); }
                    if(!czyWypozyczone1 && !czyWypozyczone2 && !czyWypozyczone3 && !czyWypozyczone4 && !czyWypozyczone5){System.out.print("brak");}
                    System.out.println("\nZaległosci finansowe:\t" + karyFinansowe + "\tPLN");
                    if(karyFinansowe > 0){System.out.println("Konto zablokowane, opłać kary finansowe oraz oddaj pozycje.");}
                    System.out.println("\nWciśnij:\n(z + enter) aby skorzystać z zasobów wypożyczalni\n(o + enter) aby oddać pozycje oraz opłacić ew. kary\n(jakikolwiek inny znak + enter) aby wyjść do menu głównego.\n\n");
                    char wyborKlienta = scan.next().charAt(0);

                    /**Moduł sprawdzający #2. Funkcja taka jak #1*/
                    Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
                    defaultTime = timestamp1;
                    if((roznicaCzasow(defaultTime, czasWypozyczenia1)) && czyWypozyczone1 && !timetrigg1){
                        timetrigg1 = true;
                        karyFinansowe = karyFinansowe + 10;
                    }
                    if((roznicaCzasow(defaultTime, czasWypozyczenia2)) && czyWypozyczone2 && !timetrigg2){
                        timetrigg2 = true;
                        karyFinansowe = karyFinansowe + 10;
                    }
                    if((roznicaCzasow(defaultTime, czasWypozyczenia3)) && czyWypozyczone3 && !timetrigg3){
                        timetrigg3 = true;
                        karyFinansowe = karyFinansowe + 10;
                    }
                    if((roznicaCzasow(defaultTime, czasWypozyczenia4)) && czyWypozyczone4 && !timetrigg4){
                        timetrigg4 = true;
                        karyFinansowe = karyFinansowe + 10;
                    }
                    if((roznicaCzasow(defaultTime, czasWypozyczenia5)) && czyWypozyczone5 && !timetrigg5){
                        timetrigg5 = true;
                        karyFinansowe = karyFinansowe + 10;
                    }

                    //Do zasobów mają doste tylko ci użytkownicy, którzy mają odblokowane konto. Ich naliczone kary muszą wtey wynosić 0 PLN.
                    if (wyborKlienta == 'z' && karyFinansowe == 0) {
                        while (true) {
                            for (int i = 0; i < 20; i++) System.out.println(" ");
                            System.out.println("\t\t\t\t\t   Zasoby wypożyczalni:");
                            System.out.print("\t\t\t\t\t   (1)");
                            Mechanika.wyswietlanieZawartosci();
                            System.out.print("\n\t\t\t\t\t   (2)");
                            BestHits.wyswietlanieZawartosci();
                            System.out.print("\n\t\t\t\t\t   (3)");
                            Documentary.wyswietlanieZawartosci();
                            System.out.print("\n\t\t\t\t\t   (4)");
                            Wojna.wyswietlanieZawartosci();
                            System.out.print("\n\t\t\t\t\t   (5)");
                            Historia.wyswietlanieZawartosci();
                            System.out.println("\n\t\t\t\t\t   (6)Wyjście do menu klienta");
                            System.out.print(" Wciśnij (nr opcji + enter) aby wypożyczyć daną pozycję lub powrócić do menu klienta: ");
                            char wyborKlienta2 = scan.next().charAt(0);

                            /**Moduł sprawdzający #3. Funkcja taka jak #1*/
                            Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
                            defaultTime = timestamp2;
                            if((roznicaCzasow(defaultTime, czasWypozyczenia1)) && czyWypozyczone1 && !timetrigg1){
                                timetrigg1 = true;
                                karyFinansowe = karyFinansowe + 10;
                            }
                            if((roznicaCzasow(defaultTime, czasWypozyczenia2)) && czyWypozyczone2 && !timetrigg2){
                                timetrigg2 = true;
                                karyFinansowe = karyFinansowe + 10;
                            }
                            if((roznicaCzasow(defaultTime, czasWypozyczenia3)) && czyWypozyczone3 && !timetrigg3){
                                timetrigg3 = true;
                                karyFinansowe = karyFinansowe + 10;
                            }
                            if((roznicaCzasow(defaultTime, czasWypozyczenia4)) && czyWypozyczone4 && !timetrigg4){
                                timetrigg4 = true;
                                karyFinansowe = karyFinansowe + 10;
                            }
                            if((roznicaCzasow(defaultTime, czasWypozyczenia5)) && czyWypozyczone5 && !timetrigg5){
                                timetrigg5 = true;
                                karyFinansowe = karyFinansowe + 10;
                            }

                            //Brak możliwości wypożyczenia dwa razy tej samej pozycji.
                            if(wyborKlienta2 == '1'&& czyWypozyczone1 || wyborKlienta2 == '2' && czyWypozyczone2 || wyborKlienta2 == '3' && czyWypozyczone3 ||
                                    wyborKlienta2 =='4' && czyWypozyczone4 || wyborKlienta2 == '5' && czyWypozyczone5){
                                for (int i = 0; i < 20; i++) System.out.println(" "); System.out.println("Już to wypożyczyłeś"); System.in.read();}

                            //Tutaj jest kod odpowiedzialny za możliwość wypożyczenia danej pozycji. Jest sczytywany czas systemowy wypożyczenia
                            //i przekazywany do zmiennej zadeklarowanej w części inicjacyjnej programu oraz jest ustawiany status wypożyczenia
                            //blokujący możliwość ponownego wypożyczenia tej samej pozycji.
                            if (wyborKlienta2 == '1' && !czyWypozyczone1 && karyFinansowe == 0) {
                                for (int i = 0; i < 20; i++) System.out.println(" ");
                                czyWypozyczone1 = true;
                                Timestamp wypozyczenie1 = new Timestamp(System.currentTimeMillis());
                                czasWypozyczenia1 = wypozyczenie1;
                                System.out.println("\t\t\t\t\t   Wypożyczyłeś pozycje nr 1.");
                                System.in.read();
                            }
                            if (wyborKlienta2 == '2' && !czyWypozyczone2 && karyFinansowe == 0) {
                                for (int i = 0; i < 20; i++) System.out.println(" ");
                                czyWypozyczone2 = true;
                                Timestamp wypozyczenie2 = new Timestamp(System.currentTimeMillis());
                                czasWypozyczenia2 = wypozyczenie2;
                                System.out.println("\t\t\t\t\t   Wypożyczyłeś pozycje nr 2.");
                                System.in.read();
                            }
                            if (wyborKlienta2 == '3' && !czyWypozyczone3 && karyFinansowe == 0) {
                                for (int i = 0; i < 20; i++) System.out.println(" ");
                                czyWypozyczone3 = true;
                                Timestamp wypozyczenie3 = new Timestamp(System.currentTimeMillis());
                                czasWypozyczenia3 = wypozyczenie3;
                                System.out.println("\t\t\t\t\t   Wypożyczyłeś pozycje nr 3.");
                                System.in.read();
                            }
                            if (wyborKlienta2 == '4' && !czyWypozyczone4 && karyFinansowe == 0) {
                                for (int i = 0; i < 20; i++) System.out.println(" ");
                                czyWypozyczone4 = true;
                                Timestamp wypozyczenie4 = new Timestamp(System.currentTimeMillis());
                                czasWypozyczenia4 = wypozyczenie4;
                                System.out.println("\t\t\t\t\t   Wypożyczyłeś pozycje nr 4.");
                                System.in.read();
                            }
                            if (wyborKlienta2 == '5' && !czyWypozyczone5 && karyFinansowe == 0) {
                                for (int i = 0; i < 20; i++) System.out.println(" ");
                                czyWypozyczone5 = true;
                                Timestamp wypozyczenie5 = new Timestamp(System.currentTimeMillis());
                                czasWypozyczenia5 = wypozyczenie5;
                                System.out.println("\t\t\t\t\t   Wypożyczyłeś pozycje nr 5.");
                                System.in.read();
                            }
                            if(wyborKlienta2 == '6') break;
                            else if(karyFinansowe != 0) break;
                        }
                    }
                    //Opcja służąca do wyrównania rachunków z wypożyczalnią. Warto zauważyć, że zmienne przyjmują takie same wartości jak w części
                    //inicjacyjnej programu. Program jest jednak stosunkowo mocno uproszczony, musimy bowiem oddać wszystkie swoje wypożyczone
                    //pozycje.
                    else if(wyborKlienta == 'o'){
                        czyWypozyczone1 = false;
                        czyWypozyczone2 = false;
                        czyWypozyczone3 = false;
                        czyWypozyczone4 = false;
                        czyWypozyczone5 = false;
                        timetrigg1 = false;
                        timetrigg2 = false;
                        timetrigg3 = false;
                        timetrigg4 = false;
                        timetrigg5 = false;
                        czasWypozyczenia1 = Timestamp.valueOf("2000-01-01 00:00:00.00");
                        czasWypozyczenia2 = Timestamp.valueOf("2000-01-01 00:00:00.00");
                        czasWypozyczenia3 = Timestamp.valueOf("2000-01-01 00:00:00.00");
                        czasWypozyczenia4 = Timestamp.valueOf("2000-01-01 00:00:00.00");
                        czasWypozyczenia5 = Timestamp.valueOf("2000-01-01 00:00:00.00");
                        karyFinansowe = 0;
                    }
                    else break;
                }

        }
    }
        /**koniec części dynamicznej programu*/

        /**metoda klasy głównej*/
        /**celem tej metody jest porównanie czasu wypożyczenia pozycji z czasem "aktualnym". Tak na prawdę jest to czas przejścia pomiędzy
         * różnymi etapami w menu. Metoda get time operuje w ms.*/

    private static boolean roznicaCzasow(Timestamp t1, Timestamp t2) {
        if((t1.getTime() - t2.getTime()) > 10000){
            return true;
        } else {return false;}
    }

}
