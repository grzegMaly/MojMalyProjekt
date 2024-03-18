package db;

public interface BazaDanych<T, ID> {

    T znajdzPoId(ID id);
    ID dodaj(T objekt);
    void wylistujWszystkie();
    void usun(ID id);
}
