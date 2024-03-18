import db.BazaDanych;
import db.BDPrzychodnie;
import przychodnia.Przychodnia;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AlfaIOmega {

    static {
        System.out.println("Witaj w kreatorze");
        awaiting(3);
        System.out.println("Poczuj się niczym Alfa i Omega");
        awaiting(2);
        System.out.println("Twórz i usuwaj, modyfikuj co ci się podoba");
        awaiting(1);
        System.out.println("Ale tylko w konteście przychodni medycznych");
        awaiting(1);
        System.out.println("No i tylko przy użyciu dostępnych narzędzi\n");
    }

    private static String opcje = """
            1. Dodaj przychodnię
            2. Edytuj dane przychodni
            3. Usuń przychodnię
            4. Wylistuj przychodnie
            5. Użyj przychodni
            6. Zakończ
            """;
    private static BazaDanych<Przychodnia, Long> przychodnie = new BDPrzychodnie();

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        String opcja;

        while (true) {
            System.out.println("Wybierz jedną z dostępnych opcji:");
            System.out.println(opcje);

            opcja = scanner.nextLine();
            switch (opcja) {
                case "1" -> {
                    Przychodnia przychodnia = Przychodnia.dodajPrzychodnie();
                    if (przychodnia == null) {
                        System.out.println("Nie udało się dodać przychodni");
                        continue;
                    }
                    Long id = przychodnie.dodaj(przychodnia);
                    System.out.println("Dodano przychodnie: " + przychodnie.znajdzPoId(id).wypiszDane());
                }
                case "2" -> {
                    System.out.println("Podaj id przychodni którą chcesz zedytować:");
                    Long id = Long.parseLong(scanner.nextLine());

                    Przychodnia przychodnia = przychodnie.znajdzPoId(id);
                    if (przychodnia == null) {
                        System.out.println("Nie udało się znaleźć przychodni :(");
                        continue;
                    }

                    przychodnia = Przychodnia.edytujPrzychodnie(przychodnia);
                }
                case "3" -> {
                    System.out.println("Podaj id przychodni:");
                    Long index = Long.parseLong(scanner.nextLine());

                    if (przychodnie.znajdzPoId(index) != null) {
                        przychodnie.usun(index);
                        System.out.println("Pomyślnie usunięto przychodnię");
                        continue;
                    }
                    System.out.println("Nie ma takiej przychodni");
                }
                case "4" -> przychodnie.wylistujWszystkie();
                case "5" -> {
                    System.out.println("Podaj id przychodni którą chcesz zarządzać:");
                    Long id = Long.parseLong(scanner.nextLine());

                    Przychodnia przychodnia = przychodnie.znajdzPoId(id);

                    if (przychodnia == null) {
                        System.out.println("Nie znaleziono przychodni :(");
                        continue;
                    }

                    przychodnia.run(id);
                }
                case "6" ->  {return;}
                default -> System.out.println("Niepoprawna opcja");
            }
        }
    }


    private static void awaiting(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
