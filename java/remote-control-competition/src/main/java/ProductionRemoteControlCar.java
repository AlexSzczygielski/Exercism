class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
  private int distanceDriven = 0;
  private int numberOfVictories = 0;
  private static final int PER_CALL_DISTANCE_DRIVEN = 10;

  @Override
  public void drive() {
    distanceDriven += PER_CALL_DISTANCE_DRIVEN;
  }

  @Override
  public int getDistanceTravelled() {
    return distanceDriven;
  }

  @Override
  public int compareTo(ProductionRemoteControlCar other) {
    return Integer.compare(other.getNumberOfVictories(), this.getNumberOfVictories());
  }

  public int getNumberOfVictories() {
    return numberOfVictories;
  }

  public void setNumberOfVictories(int numberOfVictories) {
    this.numberOfVictories = numberOfVictories;
  }
}
