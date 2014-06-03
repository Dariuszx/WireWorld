package Modules;

import Data.Parameters;

public interface Observer {

    public void update( Parameters parameters ) throws ErrorHandling;
}
