public class CarsAssemble {

    private final static int HOURLY_PRODUCTION_RATE = 221; //Number of cars produced during a single hour, defined as const

    public double productionRatePerHour(int speed) {
        double successRateCoefficient = 1.0;

        if(speed >= 5 && speed <= 8){
            successRateCoefficient = 0.9;
        }
        if(speed == 9){
            successRateCoefficient = 0.8;
        }
        if(speed > 9){
            successRateCoefficient = 0.77;
        }

        return speed * HOURLY_PRODUCTION_RATE * successRateCoefficient;
        }


    public int workingItemsPerMinute(int speed) {
        return (int) productionRatePerHour(speed)/60;
    }
}
