package Modules;

import Data.Events;
import Data.Parameters;
import Data.Mesh;

public class AutomatKomorkowy implements Observer {

    private Parameters parameters;
    private Mesh aktualnaGeneracja;
    private ZarzadzanieCzasem zarzadzanieCzasem;


    public AutomatKomorkowy( Parameters parameters ) {

        this.parameters = parameters;
    }

    @Override
    public void update( Parameters parameters ) throws ErrorHandling {

        /* Tutaj sprawdzam jaki przycisk został wciśnięty i odpowiednio reaguję */
        switch( parameters.getEventOccurred() ) {

            case START:
                zarzadzanieCzasem = new ZarzadzanieCzasem( parameters.getInterval() );
                parameters.setGeneracjaStarted( true );

                break;
            case RESTART:

                zarzadzanieCzasem = new ZarzadzanieCzasem( parameters.getInterval() );
                parameters.setGeneracjaStarted( true );
                parameters.getMesh().copyMesh(parameters.getGeneratedMesh());
                parameters.setGeneracjIndex( 0 );

                break;

            case STOP:
                parameters.setGeneracjIndex( 0 );
                parameters.setGeneracjaStarted( false );
                break;

            case PAUSE:
                parameters.setGeneracjaStarted( false );
                break;

        }

        parameters.setEventOccurred(Events.NONE);

        //Jeżeli jest uruchomiony proces tworzenia generacji
        if( parameters.getGeneracjaStarted() == true && parameters.getIndexOfGenerations() < parameters.getNumberOfGenerations() ) {

            //Sprawdzam czy od ostatniej generacji upłynął wymagany czas
            if( zarzadzanieCzasem.czyUplynalCzas() == true ) {

                //Jeżeli czas upłynał to tworzę nową generację
                stworzGeneracje();
                //System.out.println( "TWORZĘ GENERACJĘ NR " + parameters.getIndexOfGenerations() );
                zarzadzanieCzasem.setCzasOstatniejGeneracji(); //ustawiam czas wygenerowania generacji
            }
        }
    }

    private void stworzGeneracje() throws ErrorHandling {

        parameters.setGeneracjIndex( parameters.getIndexOfGenerations() + 1 ); //zwiększam index o 1

        //System.out.println( "Upłynęło " + parameters.getInterval() + " milisekund. Tworzę generację nr " + parameters.getIndexOfGenerations() );

        Mesh tmp = new Mesh(); //Mesh tymczasowa

        parameters.getGeneratedMesh().copyMesh(tmp); //Kopiuję siatkę aktualnej generacji do zmiennej tymczasowej

        Zasady zasady = new Zasady( parameters.getGeneratedMesh() );

        for( int i=0; i < tmp.getNumberOfColumns(); i++ ) {

            for( int j=0; j < tmp.getNumberOfRows(); j++ ) {

                if( tmp.getCell(i, j).getCondition() != 0 )
                    zasady.zmienStan( i, j, tmp.getCell(i, j) );
            }
        }

        //Już po generacji, kopiuję siatkę tmp do Siatki wygenerowanaSiatka
        tmp.copyMesh(parameters.getGeneratedMesh());

        new WyswietlSiatke( parameters.getGeneratedMesh() );

    }
}
