class NeedForSpeed {
  private int speed;
  private int batteryLevel = 100;
  private final int batteryDrain;
  private int distanceDriven = 0;

  private final static int NITRO_SPEED = 50;
  private final static int NITRO_DRAINAGE = 4;

  NeedForSpeed(int speed, int batteryDrain) {
    this.speed = speed;
    this.batteryDrain = batteryDrain;

  }

  public boolean batteryDrained() {
    return batteryLevel < batteryDrain ? true : false;
  }

  public int distanceDriven() {
    return distanceDriven;
  }

  public void drive() {
    if (batteryLevel >= batteryDrain) {
      distanceDriven += speed;
      batteryLevel -= batteryDrain;
    }
  }

  public static NeedForSpeed nitro() {
    return new NeedForSpeed(NITRO_SPEED, NITRO_DRAINAGE);
  }

  /**
   * Helper method to calculate the maximum distance a car can drive, at a given
   * moment
   */
  public int maxPossibleDistance() {
    int drives = batteryLevel / batteryDrain;
    return drives * speed;
  }
}

class RaceTrack {
  private final int trackDistance;

  RaceTrack(int distance) {
    this.trackDistance = distance;
  }

  public boolean canFinishRace(NeedForSpeed car) {
    return car.maxPossibleDistance() >= trackDistance;
  }
}
