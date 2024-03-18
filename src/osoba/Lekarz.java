package osoba;

import java.util.HashMap;
import java.util.Map;

public class Lekarz extends Osoba {

    private Map<Long, Osoba> pacjenci = new HashMap<>();
    private Long idPrzychodnia = null;

    private Lekarz() {
    }

    public void setIdPrzychodnia(Long idPrzychodnia) {
        this.idPrzychodnia = idPrzychodnia;
    }


    public static Lekarz dodajLekarz() {

        Osoba tempLekarz = new Lekarz();
        var lekarz = Osoba.dodajOsoba(tempLekarz);

        return (Lekarz) lekarz;
    }

    public static Lekarz edytujLekarz(Lekarz lekarz) {
        return (Lekarz) Osoba.edytujOsoba(lekarz);
    }

    @Override
    public String wypiszDane() {
        return "Lekarz: " + super.wypiszDane();
    }
}
