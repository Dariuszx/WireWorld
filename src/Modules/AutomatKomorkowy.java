package Modules;

import Data.Parametry;
import Data.Siatka;
import Data.Zdarzenia;

public class AutomatKomorkowy implements Observer {

    private Parametry parametry;
    private Siatka aktualnaGeneracja;
    private ZarzadzanieCzasem zarzadzanieCzasem;


    public AutomatKomorkowy( Parametry parametry ) {

        this.parametry = parametry;
    }

    @Override
    public void update( Parametry parametry ) throws ObslugaBledow {

        /* Tutaj sprawdzam jaki przycisk został wciśnięty i odpowiednio reaguję */
        switch( parametry.getAutomatKomorkowyZdarzenie() ) {

            case START:
                zarzadzanieCzasem = new ZarzadzanieCzasem( parametry.getOdstepCzasu() );
                parametry.setGeneracjaStarted( true );

                break;
            case RESTART:

                zarzadzanieCzasem = new ZarzadzanieCzasem( parametry.getOdstepCzasu() );
                parametry.setGeneracjaStarted( true );
                parametry.getWygenerowanaSiatka().kopiujSiatke( parametry.getSiatka() );
                parametry.setGeneracjIndex( 0 );

                break;

            case STOP:
                parametry.setGeneracjIndex( 0 );
                parametry.setGeneracjaStarted( false );
                //TODO
                break;

            case PAUZA:

                parametry.setGeneracjaStarted( false );
                //TODO
                break;

        }

        parametry.setAutomatKomorkowyZdarzenie( Zdarzenia.NONE );

        //Jeżeli jest uruchomiony proces tworzenia generacji
        if( parametry.getGeneracjaStarted() == true && parametry.getGeneracjaIndex() < parametry.getIloscGeneracji() ) {

            //Sprawdzam czy od ostatniej generacji upłynął wymagany czas
            if( zarzadzanieCzasem.czyUplynalCzas() == true ) {

                //Jeżeli czas upłynał to tworzę nową generację
                stworzGeneracje();
                zarzadzanieCzasem.setCzasOstatniejGeneracji(); //ustawiam czas wygenerowania generacji
            }
        }
    }

    private void stworzGeneracje() {

        parametry.setGeneracjIndex( parametry.getGeneracjaIndex() + 1 ); //zwiększam index o 1

        System.out.println( "Upłynęło " + parametry.getOdstepCzasu() + " milisekund. Tworzę generację nr " + parametry.getGeneracjaIndex() );
        //TODO tworzenie generacji

    }
}
