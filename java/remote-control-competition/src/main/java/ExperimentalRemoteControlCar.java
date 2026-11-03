public class ExperimentalRemoteControlCar implements RemoteControlCar {
  private int distanceDriven = 0;
  private static final int PER_CALL_DISTANCE_DRIVEN = 20;

  @Override
  public void drive() {
    distanceDriven += PER_CALL_DISTANCE_DRIVEN;
  }

  @Override
  public int getDistanceTravelled() {
    return distanceDriven;
  }
}
