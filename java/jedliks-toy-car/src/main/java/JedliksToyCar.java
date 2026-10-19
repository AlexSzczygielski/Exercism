public class JedliksToyCar {
  private int distanceDriven = 0;
  private int batteryLevel = 100;

  public static JedliksToyCar buy() {
    return new JedliksToyCar();
  }

  public String distanceDisplay() {
    return "Driven " + Integer.toString(distanceDriven) + " meters";
  }

  public String batteryDisplay() {
    return (batteryLevel > 0) ? "Battery at " + Integer.toString(batteryLevel) + "%" : "Battery empty";
  }

  public void drive() {
    if (batteryLevel > 0) {
      distanceDriven = distanceDriven + 20;
      batteryLevel--;
    }
  }
}
