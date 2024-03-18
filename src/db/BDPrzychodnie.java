package db;

import przychodnia.Przychodnia;

public class BDPrzychodnie extends AbstrakcyjnaBazaDanych<Przychodnia, Long> {

    @Override
    public Przychodnia znajdzPoId(Long aLong) {
        return super.znajdzPoId(aLong);
    }

    @Override
    public Long dodaj(Przychodnia objekt) {
        return super.dodaj(objekt);
    }

    @Override
    public void wylistujWszystkie() {
        super.wylistujWszystkie();
    }

    @Override
    public void usun(Long aLong) {
        super.usun(aLong);
    }
}
