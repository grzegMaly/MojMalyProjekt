package db;

import osoba.Pacjent;

public class BDPacjent extends AbstrakcyjnaBazaDanych<Pacjent, Long> {

    @Override
    public Pacjent znajdzPoId(Long aLong) {
        return super.znajdzPoId(aLong);
    }

    @Override
    public Long dodaj(Pacjent objekt) {
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
