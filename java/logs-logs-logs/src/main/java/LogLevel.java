public enum LogLevel {
  UNKNOWN("UNKNOWN", 0),
  TRACE("TRC", 1),
  DEBUG("DBG", 2),
  INFO("INF", 4),
  WARNING("WRN", 5),
  ERROR("ERR", 6),
  FATAL("FTL", 42);

  private final String shortName;
  private final int number;

  LogLevel(String shortName, int number) {
    this.shortName = shortName;
    this.number = number;
  }

  public String getShortName() {
    return shortName;
  }

  public int getNumber() {
    return number;
  }

  public static LogLevel fromShortName(String shortName) {
    for (LogLevel level : values()) {
      if (level.shortName.equals(shortName)) {
        return level;
      }
    }

    return LogLevel.UNKNOWN;
  }
}
