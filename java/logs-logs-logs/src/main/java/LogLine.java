public class LogLine {
  private static final String MESSAGE_SEPARATOR = ": ";
  private static final String LEVEL_START = "[";
  private static final String LEVEL_END = "]";
  private final LogLevel level;
  private final String messagePart;

  public LogLine(String logLine) {
    if (logLine.indexOf(LEVEL_START) == -1 || logLine.indexOf(LEVEL_END) == -1
        || logLine.indexOf(MESSAGE_SEPARATOR) == -1) {
      throw new IllegalArgumentException("Wrong log line format: " + logLine);
    }
    level = LogLevel.fromShortName(
        logLine.substring(logLine.indexOf(LEVEL_START) + LEVEL_START.length(), logLine.indexOf(LEVEL_END)));
    messagePart = logLine.substring(logLine.indexOf(MESSAGE_SEPARATOR) + MESSAGE_SEPARATOR.length());
  }

  public LogLevel getLogLevel() {
    return level;
  }

  public String getOutputForShortLog() {
    return level.getNumber() + ":" + messagePart;
  }
}
