package osoba;

public class Pacjent extends Osoba {

    private Long idLekarz = null;
    private Long idPrzychodnia = null;

    private Pacjent() {}

    public void setIdLekarz(Long idLekarz) {
        this.idLekarz = idLekarz;
    }

    public void setIdPrzychodnia(Long idPrzychodnia) {
        this.idPrzychodnia = idPrzychodnia;
    }

    public static Pacjent dodajPacjent() {

        Osoba tempPacjent = new Pacjent();
        var pacjent = Osoba.dodajOsoba(tempPacjent);

        return (Pacjent) pacjent;
    }

    public static Pacjent edytujPacjent(Pacjent pacjent) {
        return (Pacjent) Osoba.edytujOsoba(pacjent);
    }

    @Override
    public String wypiszDane() {
        return "Pacjent: " + super.wypiszDane();
    }
}
