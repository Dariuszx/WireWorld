package Modules;

import Data.Parametry;
import Data.Siatka;

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

            case WYSTARTOWANO:
                //TODO tutaj startuje
                zarzadzanieCzasem = new ZarzadzanieCzasem( parametry.getOdstepCzasu() );
                break;
            case STOP:
                //TODO
                break;
            case PAUZA:
                //TODO
                break;
            case RESTART:
                //TODO
                break;
        }
    }

    private void stworzGeneracje() {

    }
}
