package db;

import baseEntity.PodstawowaEncja;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class AbstrakcyjnaBazaDanych<T extends PodstawowaEncja, ID extends Long>
        implements BazaDanych<T, ID> {

    private Map<Long, T> mapa = new HashMap<>();

    @Override
    public T znajdzPoId(ID id) {
        return mapa.get(id);
    }

    @Override
    public ID dodaj(T objekt) {

        if (objekt != null) {
            if (objekt.getId() == null) {
                objekt.setId(getNextId());
            }
            mapa.putIfAbsent(objekt.getId(), objekt);
        }

        return (ID) objekt.getId();
    }

    @Override
    public void wylistujWszystkie() {
        mapa.forEach((id, t) -> System.out.println("Id: " + id + ", Nazwa " + t.wypiszDane()));
    }

    @Override
    public void usun(ID id) {
        mapa.remove(id);
    }

    private Long getNextId() {
        Long nextId = null;
        try {
            nextId = Collections.max(mapa.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }

        return nextId;
    }
}
