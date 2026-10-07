public class CarsAssemble {

  private final static int HOURLY_PRODUCTION_RATE = 221; // Number of cars produced during a single hour, defined as
                                                         // const

  public double productionRatePerHour(int speed) {

    return speed * HOURLY_PRODUCTION_RATE * successRateCoefficient(speed);
  }

  /**
   * Helper function responsible for success rate logic
   */
  private double successRateCoefficient(int speed) {

    if (speed < 5) {
      return 1.0;
    } else if (speed <= 8) {
      return 0.9;
    } else if (speed == 9) {
      return 0.8;
    }

    return 0.77;
  }

  public int workingItemsPerMinute(int speed) {
    return (int) (productionRatePerHour(speed) / 60);
  }
}
