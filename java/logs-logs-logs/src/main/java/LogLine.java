public class LogLine {
  private final LogLevel level;
  private final String messagePart;

  public LogLine(String logLine) {
    level = LogLevel.fromShortName(logLine.substring(1, logLine.indexOf(']')));
    messagePart = logLine.substring(logLine.indexOf(':') + 2);
  }

  public LogLevel getLogLevel() {
    return level;
  }

  public String getOutputForShortLog() {
    return level.getNumber() + ":" + messagePart;
  }
}
