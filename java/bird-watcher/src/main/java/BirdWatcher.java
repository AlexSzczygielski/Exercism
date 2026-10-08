
class BirdWatcher {
  private final int[] birdsPerDay;

  public BirdWatcher(int[] birdsPerDay) {
    this.birdsPerDay = birdsPerDay.clone();
  }

  public static int[] getLastWeek() {
    return new int[] { 0, 2, 5, 3, 7, 8, 4 };
  }

  public int getToday() {
    return birdsPerDay[birdsPerDay.length - 1];
  }

  public void incrementTodaysCount() {
    birdsPerDay[(birdsPerDay.length - 1)]++;
  }

  public boolean hasDayWithoutBirds() {
    for (int dailyBirds : birdsPerDay) {
      if (dailyBirds == 0) {
        return true;
      }
    }

    return false;
  }

  public int getCountForFirstDays(int numberOfDays) {
    // Used clamping instead of strict checking, as that's what the tests required
    int limit = Math.min(numberOfDays, birdsPerDay.length);

    int countForFirstDays = 0;
    for (int i = 0; i < limit; i++) {
      countForFirstDays += birdsPerDay[i];
    }

    return countForFirstDays;
  }

  public int getBusyDays() {
    int busyDaysCount = 0;

    for (int dailyBirds : birdsPerDay) {
      if (dailyBirds >= 5) {
        busyDaysCount++;
      }
    }

    return busyDaysCount;
  }
}
