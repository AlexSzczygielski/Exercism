import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

class AppointmentScheduler {
  private static final LocalTime AFTERNOON_START = LocalTime.of(12, 0);
  private static final LocalTime AFTERNOON_END = LocalTime.of(18, 0);
  private static final DateTimeFormatter DESCRIPTION_FORMAT = DateTimeFormatter
      .ofPattern("EEEE, MMMM d, yyyy, 'at' h:mm a", Locale.US);

  public LocalDateTime schedule(String appointmentDateDescription) {
    return LocalDateTime.parse(appointmentDateDescription, DateTimeFormatter.ofPattern("M/d/yyyy HH:mm:ss"));
  }

  public boolean hasPassed(LocalDateTime appointmentDate) {
    return appointmentDate.isBefore(LocalDateTime.now());
  }

  public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
    LocalTime appointmentTime = appointmentDate.toLocalTime();
    return !appointmentTime.isBefore(AFTERNOON_START) && appointmentTime.isBefore(AFTERNOON_END);
  }

  public String getDescription(LocalDateTime appointmentDate) {
    return "You have an appointment on " + appointmentDate.format(DESCRIPTION_FORMAT) + ".";
  }

  public LocalDate getAnniversaryDate() {
    return LocalDate.of(LocalDate.now().getYear(), 9, 15);
  }
}
