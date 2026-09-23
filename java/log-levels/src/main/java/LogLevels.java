public class LogLevels {

  public static String message(String logLine) {
    int colonPosition = logLine.indexOf(":");
    return logLine.substring(colonPosition + 1).trim();
  }

  public static String logLevel(String logLine) {
    int closeBracketPosition = logLine.indexOf("]");
    return logLine.substring(1, closeBracketPosition).toLowerCase();
  }

  public static String reformat(String logLine) {
    return message(logLine) + " (" + logLevel(logLine) + ")";
  }
}
