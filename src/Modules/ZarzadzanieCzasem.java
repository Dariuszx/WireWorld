package Modules;

public class ZarzadzanieCzasem {

    private long czasOstatniejGeneracji;
    private long roznicaCzasu;
    private long odstepCzasu;

    public ZarzadzanieCzasem( int odstepCzasu ) {

        this.odstepCzasu = odstepCzasu;
    }

    public boolean czyUplynalCzas() {

        obliczRozniceCzasu();

        if( roznicaCzasu >= odstepCzasu ) {
            setCzasOstatniejGeneracji();
            return true;
        }
        return false;
    }

    public void setCzasOstatniejGeneracji() {

        czasOstatniejGeneracji = getTime();
    }

    private void obliczRozniceCzasu() {

        roznicaCzasu = getTime() - czasOstatniejGeneracji;
    }

    public long getTime() {
        return ( System.nanoTime() / 1000000 );
    }

}
