package db;

import osoba.Lekarz;

public class BDLekarz extends AbstrakcyjnaBazaDanych<Lekarz, Long> {

    @Override
    public Lekarz znajdzPoId(Long aLong) {
        return super.znajdzPoId(aLong);
    }

    @Override
    public Long dodaj(Lekarz objekt) {
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
