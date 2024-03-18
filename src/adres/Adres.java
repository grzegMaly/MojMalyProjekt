package adres;

public class Adres {

    private String kraj;
    private Wojewodztwo wojewodztwo = Wojewodztwo.MALOPOLSKIE;
    private String kodPocztowy;
    private String miasto;
    private String ulica;

    private Adres() {}


    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public void setWojewodztwo(Wojewodztwo wojewodztwo) {
        this.wojewodztwo = wojewodztwo;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public static Adres dodajAdres() {

        Adres adres = new Adres();
        return ObslugaAdresu.dodajAdres(adres);
    }

    public static Adres edytujAdres(Adres adres) {

        Adres tempAdres = adres;
        tempAdres = ObslugaAdresu.edytujAdres(tempAdres);
        if (tempAdres != null) {
            return tempAdres;
        }

        System.out.println("Nie dokonano żadnych zmian");
        return adres;

    }

    public String wypiszDane() {
        return "Ul. " + ulica + " " + kodPocztowy + " " + miasto +
                ", " + kraj + " " + wojewodztwo.getNazwa();
    }
}
