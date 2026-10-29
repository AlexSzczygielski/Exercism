class Fighter {

  boolean isVulnerable() {
    return true;
  }

  int getDamagePoints(Fighter fighter) {
    return 1;
  }
}

class Warrior extends Fighter {
  private static final int WARRIOR_OPPONENT_IS_VULNARABLE_DMG_POINTS = 10;
  private static final int WARRIOR_OPPONENT_IS_NOT_VULNARABLE_DMG_POINTS = 6;

  @Override
  public String toString() {
    return "Fighter is a Warrior";
  }

  @Override
  boolean isVulnerable() {
    return false;
  }

  @Override
  int getDamagePoints(Fighter fighter) {
    return fighter.isVulnerable() ? WARRIOR_OPPONENT_IS_VULNARABLE_DMG_POINTS
        : WARRIOR_OPPONENT_IS_NOT_VULNARABLE_DMG_POINTS;
  }
}

class Wizard extends Fighter {
  private boolean isSpellPrepared = false;
  private static final int SPELL_PREPARED_DMG_POINTS = 12;
  private static final int SPELL_NOT_PREPARED_DMG_POINTS = 3;

  @Override
  public String toString() {
    return "Fighter is a Wizard";
  }

  @Override
  boolean isVulnerable() {
    return !isSpellPrepared;
  }

  public void prepareSpell() {
    isSpellPrepared = true;
  }

  @Override
  int getDamagePoints(Fighter fighter) {
    return isSpellPrepared ? SPELL_PREPARED_DMG_POINTS : SPELL_NOT_PREPARED_DMG_POINTS;
  }
}
