public enum TravelMethod {
  WALKING("by"),
  HORSEBACK("on");

  private final String methodPreposition;

  TravelMethod(String methodPreposition) {
    this.methodPreposition = methodPreposition;
  }

  public String getMethodPreposition() {
    return methodPreposition;
  }
}
