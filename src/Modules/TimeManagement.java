package Modules;

public class TimeManagement {

    private long czasOstatniejGeneracji;
    private long roznicaCzasu = 0;
    private long odstepCzasu;

    public TimeManagement( long odstepCzasu ) {

        this.odstepCzasu = odstepCzasu;
        this.czasOstatniejGeneracji = getTime();
    }

    public boolean czyUplynalCzas() {

        obliczRozniceCzasu();

        if( roznicaCzasu >= odstepCzasu ) {
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
        return System.currentTimeMillis();
    }

}
