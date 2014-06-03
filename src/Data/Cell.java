package Data;

import Modules.ErrorHandling;

public class Cell {

    private int condition = 0;

    public Cell( int condition ) {

        this.condition = condition;
    }

    /* GET FUNCTIONS */
    public int getCondition() {

        return condition;
    }

    /* SET FUNCTIONS */
    public void setCondition( int condition ) throws ErrorHandling {

        if( condition > 3 ) throw new ErrorHandling( "Niepoprawny condition komórki." );
        this.condition = condition;
    }
}
