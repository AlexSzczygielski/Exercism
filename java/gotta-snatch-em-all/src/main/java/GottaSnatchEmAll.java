import java.util.List;
import java.util.Set;
import java.util.HashSet;

class GottaSnatchEmAll {

  static Set<String> newCollection(List<String> cards) {
    return new HashSet<>(cards);
  }

  static boolean addCard(String card, Set<String> collection) {
    return collection.add(card);
  }

  static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
    boolean iHaveSomethingNew = !theirCollection.containsAll(myCollection);
    boolean theyHaveSomethingNew = !myCollection.containsAll(theirCollection);

    return iHaveSomethingNew && theyHaveSomethingNew;
  }

  static Set<String> commonCards(List<Set<String>> collections) {
    // copy so retainAll doesn't modify the caller's set
    Set<String> common = new HashSet<>(collections.get(0));

    for (Set<String> collection : collections.subList(1, collections.size())) {
      common.retainAll(collection);
    }

    return common;
  }

  static Set<String> allCards(List<Set<String>> collections) {
    // Performs union on all sets.
    Set<String> allCards = new HashSet<>();

    for (Set<String> collection : collections) {
      allCards.addAll(collection);
    }

    return allCards;
  }
}
