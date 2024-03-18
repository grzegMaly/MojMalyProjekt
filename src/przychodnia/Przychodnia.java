package przychodnia;

import adres.Adres;
import baseEntity.PodstawowaEncja;
import db.BDLekarz;
import db.BDPacjent;
import db.BazaDanych;
import osoba.Lekarz;
import osoba.Pacjent;

import java.util.Scanner;

public class Przychodnia extends PodstawowaEncja {

    private static final Scanner scanner = new Scanner(System.in);
    private String nazwa;
    private Adres adres;
    private BazaDanych<Lekarz, Long> bdLekarze = new BDLekarz();
    private BazaDanych<Pacjent, Long> bdPacjenci = new BDPacjent();

    private Przychodnia() {
    }

    public Adres getAdres() {
        return adres;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    String opcje = """
            Wybierz jedną z dostępnych opji
            1. Dodaj lekarza
            2. Edytuj dane lekarza
            3. Wylistuj lekarzy
            4. Usuń lekarz
            5. Dodaj pacjenta
            6. Edytuj dane pacjenta
            7. Wylistuj pacjentów
            8. Usuń pacjenta
            9. Zakończ
            """;

    public void run(Long idPrzychodni) {

        String opcja;
        System.out.println("Witaj w przychodni");

        while (true) {
            System.out.println(opcje);
            opcja = scanner.nextLine();

            switch (opcja) {
                case "1" -> {
                    Lekarz lekarz = Lekarz.dodajLekarz();
                    if (lekarz == null) {
                        System.out.println("Nie udało się dodać lekarza");
                        continue;
                    }
                    Long id = bdLekarze.dodaj(lekarz);
                    lekarz.setIdPrzychodnia(idPrzychodni);
                    System.out.println("Dodano lekarza: " + bdLekarze.znajdzPoId(id).wypiszDane());
                }
                case "2" -> {
                    System.out.println("Podaj id lekarza:");
                    Long id = Long.parseLong(scanner.nextLine());
                    Lekarz lekarz = bdLekarze.znajdzPoId(id);

                    if (lekarz == null) {
                        System.out.println("Nie udało się znaleźć lekarza :(");
                        continue;
                    }

                    lekarz = Lekarz.edytujLekarz(lekarz);
                }
                case "3" -> bdLekarze.wylistujWszystkie();
                case "4" -> {
                    System.out.println("Podaj id lekarza:");
                    Long index = Long.parseLong(scanner.nextLine());

                    if (bdLekarze.znajdzPoId(index) != null) {
                        bdLekarze.usun(index);
                        System.out.println("Pomyślnie usunięto lekarza");
                        continue;
                    }
                    System.out.println("Nie ma takiego lekarza");
                }
                case "5" -> {

                    Pacjent pacjent = Pacjent.dodajPacjent();
                    if (pacjent == null) {
                        System.out.println("Nie udało się dodać pacjenta");
                        continue;
                    }

                    System.out.println("Podaj id lekarza do przypisania:");
                    Long idLekarz = Long.parseLong(scanner.nextLine());
                    if (bdLekarze.znajdzPoId(idLekarz) == null) {
                        System.out.println("Nie ma takiego lekarza, sprawdź poprawność id albo go dodaj");
                        continue;
                    }

                    Long id = bdPacjenci.dodaj(pacjent);
                    pacjent.setIdPrzychodnia(idPrzychodni);
                    pacjent.setIdLekarz(idLekarz);

                    System.out.println("Dodano pacjenta: " + bdPacjenci.znajdzPoId(id).wypiszDane());
                }
                case "6" -> {
                    System.out.println("Podaj id pacjenta:");
                    Long id = Long.parseLong(scanner.nextLine());
                    Pacjent pacjent = bdPacjenci.znajdzPoId(id);

                    if (pacjent == null) {
                        System.out.println("Nie udało się znaleźć pacjenta :(");
                        continue;
                    }

                    pacjent = Pacjent.edytujPacjent(pacjent);
                }
                case "7" -> bdPacjenci.wylistujWszystkie();
                case "8" -> {
                    System.out.println("Podaj id pacjenta:");
                    Long index = Long.parseLong(scanner.nextLine());

                    if (bdPacjenci.znajdzPoId(index) != null) {
                        bdPacjenci.usun(index);
                        System.out.println("Pomyślnie usunięto pacjenta");
                        continue;
                    }
                    System.out.println("Nie ma takiego pacjenta");
                }
                case "9" -> {
                    return;
                }
                default -> System.out.println("Niepoprawna opcja\n");

            }
        }
    }

    public static Przychodnia dodajPrzychodnie() {

        Przychodnia przychodnia = new Przychodnia();
        return ObslugaPrzychodni.dodajPrzychodnie(przychodnia);
    }

    public static Przychodnia edytujPrzychodnie(Przychodnia przychodnia) {

        Przychodnia tempPrzychodnia = przychodnia;
        tempPrzychodnia = ObslugaPrzychodni.edytujPrzychodnie(tempPrzychodnia);

        if (tempPrzychodnia != null) {
            return tempPrzychodnia;
        }

        System.out.println("Nie dokonano żadnych zmian");
        return przychodnia;
    }


    public Lekarz dodajLekarzDoPrzychodni() {
        Lekarz lekarz = Lekarz.dodajLekarz();
        return null;
    }

    public String wypiszDane() {
        return "Przychodnia " + nazwa + " " + adres.wypiszDane();
    }
}
