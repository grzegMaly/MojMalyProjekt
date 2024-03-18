package przychodnia;

import adres.Adres;

import java.util.Scanner;

public class ObslugaPrzychodni {

    private static final Scanner scanner = new Scanner(System.in);

    public static Przychodnia dodajPrzychodnie(Przychodnia przychodnia) {

        String nazwa;

        System.out.println("Podaj nazwę przychodni lub \"exit\" żeby przerwać: ");

        while (true) {
            nazwa = scanner.nextLine();

            if (nazwa.equalsIgnoreCase("exit")) {
                return null;
            }

            if (!nazwa.isEmpty() && !nazwa.isBlank()) {
                break;
            }
            System.out.println("Zła wartość, jeszcze raz lub \"exit\": ");
        }

        Adres adres = Adres.dodajAdres();

        if (adres != null) {
            przychodnia.setNazwa(nazwa);
            przychodnia.setAdres(adres);
            return przychodnia;
        }
        return null;
    }

    public static Przychodnia edytujPrzychodnie(Przychodnia przychodnia) {

        String opcja;
        System.out.println("1 dla modyfikacji Nazwy, 2 dla modyfikacji Adresu:");

        while (true) {
            opcja = scanner.nextLine();

            switch (opcja) {
                case "1" -> {
                    return edycjaNazwy(przychodnia);
                }
                case "2" -> {
                    return edycjaAdresu(przychodnia);
                }
                default -> {
                    if (opcja.equalsIgnoreCase("exit")) {
                        return null;
                    }
                    System.out.println("Zła wartość. 1 dla Nazwy, 2 dla Adresu, \"exit\" żeby wyjść:");
                }
            }
        }
    }

    private static Przychodnia edycjaNazwy(Przychodnia p) {
        System.out.println("Podaj nową nazwę lub \"exit\" żeby przerwać:");
        String nazwa = scanner.nextLine();

        while (true) {

            if (nazwa.equalsIgnoreCase("exit")) {
                return null;
            }

            if (!nazwa.isBlank() && !nazwa.isEmpty()) {
                p.setNazwa(nazwa);
                return p;
            }
            System.out.println("Podaj jeszcze raz lub \"exit\":");
        }
    }

    private static Przychodnia edycjaAdresu(Przychodnia p) {
        Adres adres = Adres.edytujAdres(p.getAdres());

        if (adres != null) {
            p.setAdres(adres);
            return p;
        }
        return null;
    }
}
