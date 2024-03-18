package adres;

import java.util.Scanner;

public enum Wojewodztwo {
    DOLNOSLASKIE("Dolnośląskie"),
    KUJAWSKO_POMORSKIE("Kujawsko-Pomorskie"),
    LUBELSKIE("Lubelskie"),
    LUBUSKIE("Lubuskie"),
    LODZKIE("Łódzkie"),
    MALOPOLSKIE("Małopolskie"),
    MAZOWIECKIE("Mazowieckie"),
    OPOLSKIE("Opolskie"),
    PODKARPACKIE("Podkarpackie"),
    PODLASKIE("Podlaskie"),
    POMORSKIE("Pomorskie"),
    SLASKIE("Śląskie"),
    SWIETOKRZYSKIE("Świętokrzyskie"),
    WARMINSKO_MAZURSKIE("Warmińsko-Mazurskie"),
    WIELKOPOLSKIE("Wielkopolskie"),
    ZACHODNIO_POMORSKIE("Zachodnio-Pomorskie");

    private final String nazwa;

    Wojewodztwo(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public static Wojewodztwo betterValueOf(String wojewodztwo) {
        for (Wojewodztwo w : Wojewodztwo.values()) {
            if (w.getNazwa().equalsIgnoreCase(wojewodztwo)) {
                return w;
            }
        }
        return null;
    }

    public static void wylistujWszystkie() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int index = i * 4 + j;
                System.out.print(Wojewodztwo.values()[index].getNazwa() + ", ");
            }
            System.out.println();
        }
    }

    public static Wojewodztwo pobierzWojewodztwo() {

        Scanner scanner = new Scanner(System.in);
        String w;

        System.out.println("Proszę podać nazwę Województwa z listy lub \"exit\" żeby przerwać: ");
        wylistujWszystkie();

        while (true) {

            w = scanner.nextLine();

            if (w.equalsIgnoreCase("exit")) {
                return null;
            }

            Wojewodztwo wojewodztwo = betterValueOf(w);
            if (wojewodztwo != null) {
                return wojewodztwo;
            }

            System.out.println("Żle podana nazwa, proszę podać jeszcze raz, albo \"exit\" żeby przerwać:");

        }
    }
}