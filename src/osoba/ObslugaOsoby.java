package osoba;

import adres.Adres;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObslugaOsoby {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<String> opcje = new ArrayList<>(List.of("Imie", "Nazwisko", "Wiek", "adres.Adres"));

    public static Osoba dodajOsoba(Osoba osoba) {

        for (String opcja : opcje) {
            if (!podawanieWartosci(osoba, opcja)) {
                return null;
            }
        }

        return osoba;
    }

    public static Osoba edytujOsoba(Osoba osoba) {

        String message = "Podaj index elementu który chcesz zmienić lub \"exit\" żeby przerwać";
        System.out.println(message);
        System.out.println(opcje);
        boolean wynik = false;
        int index = 0;

        while (true) {

            String wartosc = scanner.nextLine();
            if (wartosc.equalsIgnoreCase("exit")) {
                break;
            }

            index = Integer.parseInt(wartosc);
            if (index < 0 || index > opcje.size() - 1) {
                System.out.println("Index out of range :(");
                System.out.println(message);
                continue;
            }
            break;
        }

        if (opcje.get(index).equals("adres.Adres")) {

            Adres adres = Adres.edytujAdres(osoba.getAdres());

            if (adres != null) {
                osoba.setAdres(adres);
                return osoba;
            }
        }

        wynik = podawanieWartosci(osoba, opcje.get(index));

        if (!wynik) {
            return null;
        }
        return osoba;
    }

    private static boolean podawanieWartosci(Osoba osoba, String nazwaPola) {

        if (nazwaPola.equals("adres.Adres")) {

            Adres adres = Adres.dodajAdres();

            if (adres == null) {
                return false;
            }
            osoba.setAdres(adres);
            return true;
        }

        String opcja = pobierzDane(nazwaPola);

        if (opcja != null) {

            switch (nazwaPola) {
                case "Imie" -> osoba.setImie(opcja);
                case "Nazwisko" -> osoba.setNazwisko(opcja);
                case "Wiek" -> osoba.setWiek(Integer.parseInt(opcja));
            }
        } else {
            return false;
        }

        return true;

    }

    private static String pobierzDane(String nazwaPola) {

        String wartosc;

        System.out.println("Podaj wartość dla " + nazwaPola + " lub \"exit\" żeby przerwać:");
        while (true) {
            wartosc = scanner.nextLine();

            if (wartosc.equalsIgnoreCase("exit")) {
                return null;
            }

            if (wartosc.isEmpty() || wartosc.isBlank()) {
                System.out.println("Błędne dane, jeszcze raz albo \"exit\":");
                continue;
            }
            break;
        }

        if (nazwaPola.equals("Wiek")) {
            try {
                Integer.parseInt(wartosc);
            } catch (NumberFormatException e) {
                return null;
            }
        }

        return wartosc;
    }
}
