import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

class SalonCalendar {
  private static final int PAYDAY = 15;

  public LocalDate standingAppointment(int year, Month month, int occurrence, DayOfWeek dayOfWeek) {
    LocalDate date = LocalDate.of(year, month, 1);
    return date.with(TemporalAdjusters.dayOfWeekInMonth(occurrence, dayOfWeek));
  }

  public LocalDate lastAppointment(int year, Month month, DayOfWeek dayOfWeek) {
    LocalDate date = LocalDate.of(year, month, 1);
    return date.with(TemporalAdjusters.lastInMonth(dayOfWeek));
  }

  public LocalDate nextAvailable(LocalDate from, DayOfWeek dayOfWeek) {
    return from.with(TemporalAdjusters.nextOrSame(dayOfWeek));
  }

  public LocalDate bookkeepingDay(int year, Month month) {
    LocalDate date = LocalDate.of(year, month, 1);
    date = date.with(TemporalAdjusters.lastDayOfMonth());
    if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
      return date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
    }
    return date;
  }

  public LocalDate payday(int year, Month month) {
    LocalDate date = LocalDate.of(year, month, PAYDAY);
    return date.with(precedingWorkday());
  }

  public TemporalAdjuster precedingWorkday() {
    return t -> {
      DayOfWeek day = DayOfWeek.from(t);
      if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
        return t.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
      }
      return t;
    };
  }
}
