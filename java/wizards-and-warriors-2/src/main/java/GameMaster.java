public class GameMaster {
  private static final TravelMethod DEFAULT_TRAVEL_METHOD = TravelMethod.WALKING;

  public String describe(Character character) {
    return "You're a level " + character.getLevel() + " " + character.getCharacterClass() + " with "
        + character.getHitPoints()
        + " hit points.";
  }

  public String describe(Destination destination) {
    return "You've arrived at " + destination.getName() + ", which has " + destination.getInhabitants()
        + " inhabitants.";
  }

  public String describe(TravelMethod travelMethod) {
    return "You're traveling to your destination " + travelMethod.getMethodPreposition() + " "
        + travelMethod.toString().toLowerCase() + ".";
  }

  public String describe(Character character, Destination destination, TravelMethod travelMethod) {
    return describe(character) + " " + describe(travelMethod) + " " + describe(destination);
  }

  public String describe(Character character, Destination destination) {
    return describe(character, destination, DEFAULT_TRAVEL_METHOD);
  }
}
