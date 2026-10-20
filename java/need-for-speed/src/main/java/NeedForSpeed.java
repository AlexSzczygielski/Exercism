class NeedForSpeed {
  private int speed;
  private int batteryLevel = 100;
  private final int batteryDrain;
  private int distanceDriven = 0;

  private static final int NITRO_SPEED = 50;
  private static final int NITRO_DRAINAGE = 4;

  NeedForSpeed(int speed, int batteryDrain) {
    this.speed = speed;
    this.batteryDrain = batteryDrain;

  }

  /**
   * Single source of truth for whether the car can drive: the battery must hold
   * at least as much charge as one drive consumes.
   */
  private boolean canDrive() {
    return batteryLevel >= batteryDrain;
  }

  /**
   * This does not use canDrive() as there is a possibility that canDrive() grows
   * beyond battery drainage.
   */
  public boolean batteryDrained() {
    return batteryLevel < batteryDrain;
  }

  public int distanceDriven() {
    return distanceDriven;
  }

  public void drive() {
    if (canDrive()) {
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
