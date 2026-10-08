class SqueakyClean {
  static String clean(String identifier) {
    StringBuilder builder = new StringBuilder();
    boolean capitalizeNext = false;

    for (char ch : identifier.toCharArray()) {
      char converted = ch;
      switch (ch) {
        case '4' -> converted = 'a';
        case '3' -> converted = 'e';
        case '0' -> converted = 'o';
        case '1' -> converted = 'l';
        case '7' -> converted = 't';
      }

      if (Character.isWhitespace(converted)) {
        builder.append('_');
      } else if (converted == '-') {
        // Skipping dash
        capitalizeNext = true;
      } else if (!Character.isLetter(converted)) {
        continue;
      } else if (capitalizeNext) {
        builder.append(Character.toUpperCase(converted));
        capitalizeNext = false;
      } else {
        builder.append(converted);
      }
    }

    return builder.toString();
  }
}
