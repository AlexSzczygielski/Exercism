public class Lasagna {
  private static final int SINGLE_LAYER_PREP_TIME = 2; // used by preparationTimeInMinutes

  // define the 'expectedMinutesInOven()' method
  public int expectedMinutesInOven() {
    return 40;
  }

  // define the 'remainingMinutesInOven()' method
  public int remainingMinutesInOven(int minutesAlreadyInOven) {
    return expectedMinutesInOven() - minutesAlreadyInOven;
  }

  // define the 'preparationTimeInMinutes()' method
  public int preparationTimeInMinutes(int numberOfLayers) {
    // Check for negative numberOfLayers
    if (numberOfLayers < 0) {
      throw new IllegalArgumentException("numberOfLayers must be non negative, got: " + numberOfLayers);
    }
    return numberOfLayers * SINGLE_LAYER_PREP_TIME;
  }

  // define the 'totalTimeInMinutes()' method
  public int totalTimeInMinutes(int numberOfLayers, int minutesAlreadyInOven) {
    return preparationTimeInMinutes(numberOfLayers) + minutesAlreadyInOven;
  }
}
