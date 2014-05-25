package Data;

import Modules.ObslugaBledow;

public class Parametry {

    private int iloscGeneracji = 10;
    private int odstepCzasu = 500;
    private String sciezkaDoPliku = "";
    private String plikZapisywanie = "";
    private Siatka wygenerowanaSiatka;
    private Siatka siatka;

    /* Dane Automatu Komorkowego */
    private boolean generacjaStart = false;
    private int generacjaIndex = 0;
    private Zdarzenia automatKomorkowyZdarzenie = Zdarzenia.NONE;


    public Parametry() {

        this.siatka = new Siatka();
        this.wygenerowanaSiatka = new Siatka();
    }

    public int getIloscGeneracji() {
        return iloscGeneracji;
    }

    public int getOdstepCzasu() {
        return odstepCzasu;
    }

    public String getSciezkaDoPliku() { return sciezkaDoPliku; }

    public String getPlikZapisywanie() { return plikZapisywanie; }

    public Siatka getWygenerowanaSiatka() { return wygenerowanaSiatka; }

    public boolean getGeneracjaStart() { return generacjaStart; }

    public Siatka getSiatka() { return siatka; }

    public int getGeneracjaIndex() { return generacjaIndex; }

    public Zdarzenia getAutomatKomorkowyZdarzenie() {

        return automatKomorkowyZdarzenie;
    }

    public void setPlikZapisywanie( String sciezkaDoPliku ) {

        this.plikZapisywanie = sciezkaDoPliku;
    }

    public void setIloscGeneracji( int iloscGeneracji ) throws ObslugaBledow {

        if( iloscGeneracji <= 0 || iloscGeneracji > 600000 ) throw new ObslugaBledow( "Nieakceptowalna ilość generacji." );
        else {
            this.iloscGeneracji = iloscGeneracji;
        }
    }

    public void setOdstepCzasu( int odstepCzasu ) throws ObslugaBledow {

        if( odstepCzasu < 0 || odstepCzasu > 10000 ) throw new ObslugaBledow( "Nieprawidłowy odstęp czasu pomiędzy generacjami." );
        else {
            this.odstepCzasu = odstepCzasu;
        }
    }

    public void setSciezkaDoPliku( String sciezka ) {
        sciezkaDoPliku = sciezka;
    }

    public void setWygenerowanaSiatka( Siatka siatka ) {

        this.wygenerowanaSiatka = siatka;
    }

    public void setGeneracjaStart( boolean value ) {
        generacjaStart = value;
    }

    public void setSiatka( Siatka siatka ) {

        this.siatka = siatka;
    }

    public void setGeneracjIndex( int index ) {

        this.generacjaIndex = index;
    }

    public void setAutomatKomorkowyZdarzenie( Zdarzenia e ) {

        this.automatKomorkowyZdarzenie = e;
    }

}
