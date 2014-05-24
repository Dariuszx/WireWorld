package Modules;

public interface Observable {

    public void dodajObserwatora( Observer o );

    public void usunObserwatora( Observer o );

    public void powiadomObserwatorow();
}
