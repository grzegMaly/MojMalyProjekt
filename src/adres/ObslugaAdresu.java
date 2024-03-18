package adres;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObslugaAdresu {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<String> opcje = new ArrayList<>(List.of("Kraj", "Wojewódzwto",
            "Kod Pocztowy", "Miasto", "Ulica"));

    private ObslugaAdresu() {}

    public static Adres dodajAdres(Adres adres) {

        for (String opcja : opcje) {
            if (!podawanieWartosci(adres, opcja)) {
                return null;
            }
        }

        return adres;
    }

    public static Adres edytujAdres(Adres adres) {

        /*
        * Tutaj już przez index elementu bo zbyt dużo czasu spędziłem na tym
        * żeby dopieścić dodawanie adresu i szczerze już mi się nie chciało
        * bawić z tym :)
        * */

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
            if (index >= 0 && index <= opcje.size() - 1) {
                wynik = podawanieWartosci(adres, opcje.get(index));
                break;
            }
            System.out.println("Index out of range :(");
            System.out.println(message);
        }

        if (!wynik) {
            return null;
        }
        return adres;

    }

    private static boolean podawanieWartosci(Adres adres, String nazwaPola) {

        if (nazwaPola.equals("Wojewódzwto")) {

            Wojewodztwo wojewodztwo = Wojewodztwo.pobierzWojewodztwo();

            if (wojewodztwo == null) {
                return false;
            }
            adres.setWojewodztwo(wojewodztwo);
            return true;
        }
        String opcja = pobierzDane(nazwaPola);

        if (opcja != null) {

            switch (nazwaPola) {
                case "Kraj" -> adres.setKraj(opcja);
                case "Kod Pocztowy" -> adres.setKodPocztowy(opcja);
                case "Miasto" -> adres.setMiasto(opcja);
                case "Ulica" -> adres.setUlica(opcja);
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
            if (wartosc.isBlank() || wartosc.isEmpty()) {
                System.out.println("Proszę podać wartość jeszcze raz lub \"exit\" żeby przerwać:");
                continue;
            } else if (wartosc.equalsIgnoreCase("exit")) {
                return null;
            }
            return wartosc;
        }
    }
}
