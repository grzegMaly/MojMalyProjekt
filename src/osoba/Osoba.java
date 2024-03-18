package osoba;

import adres.Adres;
import baseEntity.PodstawowaEncja;

public abstract class Osoba extends PodstawowaEncja {


    private String imie;
    private String nazwisko;
    private int wiek;
    private Adres adres;

    Osoba() {
    }


    public void setImie(String imie) {
        this.imie = imie;
    }


    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }


    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public static Osoba dodajOsoba(Osoba osoba) {

        return ObslugaOsoby.dodajOsoba(osoba);
    }

    public static Osoba edytujOsoba(Osoba osoba) {

        var tempOsoba = osoba;
        tempOsoba = ObslugaOsoby.edytujOsoba(tempOsoba);

        if (tempOsoba != null) {
            return tempOsoba;
        }

        System.out.println("Nie dokonano żadnych zmian");
        return osoba;
    }

    @Override
    public String wypiszDane() {
        return imie + " " + nazwisko + " " + wiek + " lat, " + adres.wypiszDane();
    }
}
