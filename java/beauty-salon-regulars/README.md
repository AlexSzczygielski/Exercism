# Beauty Salon Regulars

Welcome to Beauty Salon Regulars on Exercism's Java Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

## Temporal Adjusters

When working with `java.time` objects like `LocalDate`, you often need to perform complex date adjustments, such as finding the "second Tuesday of the month".
Instead of calculating this manually, you can use **`TemporalAdjusters`**.

The `java.time.temporal.TemporalAdjusters` (note the plural 's') utility class provides static methods for many common date adjustments.
You apply these adjustments using the `.with()` method on a temporal object (like `LocalDate`).

```exercism/note
Using `with(TemporalAdjuster)` returns a _new_ instance and does not update the existing instance, as `java.time` objects are immutable.
```

```java
import java.time.LocalDate;
import java.time.Month;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;

LocalDate date = LocalDate.of(2024, Month.AUGUST, 15); // 2024-08-15 (a Thursday)

// Use a predefined adjuster: find the last day of the month
LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
// => 2024-08-31
```

Here are some key adjusters useful for scheduling calculations:

### Finding Ordinal Day of Week

Use `dayOfWeekInMonth(int ordinal, DayOfWeek dayOfWeek)` to find the nth occurrence of a day of the week.

```java
// Find the second Tuesday of August 2024
LocalDate secondTuesday = date.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.TUESDAY));
// => 2024-08-13
```

### Finding First/Last Day of Week in Month

Use `firstInMonth(DayOfWeek dayOfWeek)` or `lastInMonth(DayOfWeek dayOfWeek)`.

```java
// Find the last Monday of August 2024
LocalDate lastMonday = date.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY));
// => 2024-08-26
```

### Relative Adjustments (Next/Previous)

Adjusters like `next()`, `previous()`, `nextOrSame()`, and `previousOrSame()` find the next or previous occurrence of a given day of the week, relative to the current date.

- `next()`/`previous()`: Excludes the current date if it matches.
- `nextOrSame()`/`previousOrSame()`: Includes the current date if it matches.

```java
LocalDate thursday = LocalDate.of(2024, Month.AUGUST, 15); // A Thursday

// Find the next Thursday (exclusive)
LocalDate nextThursday = thursday.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
// => 2024-08-22

// Find the next Thursday (inclusive) - returns the same date
LocalDate nextOrSameThursday = thursday.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));
// => 2024-08-15

// Find the previous Monday (exclusive)
LocalDate previousMonday = thursday.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
// => 2024-08-12
```

### Custom Adjusters

`TemporalAdjuster` is a functional interface, so you can write an adjuster of your own as a lambda that takes the temporal to adjust and returns the adjusted one.
It is applied with `.with()` just like the predefined adjusters, and it can use them internally.

```java
import java.time.temporal.TemporalAdjuster;

// An adjuster that moves a weekend date to the following Monday
TemporalAdjuster skipWeekend = temporal -> {
    DayOfWeek day = DayOfWeek.from(temporal);
    if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
        return temporal.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
    }
    return temporal;
};

LocalDate saturday = LocalDate.of(2024, Month.AUGUST, 17);
LocalDate monday = saturday.with(skipWeekend);
// => 2024-08-19
```

Using these adjusters from the `TemporalAdjusters` class can greatly simplify date manipulation tasks.

## Instructions

The beauty salon in New York that you helped in the Booking Up For Beauty exercise has been doing well, and many of its clients have become regulars.
Instead of booking every visit separately, a regular has a standing arrangement: "every second Tuesday", "the last Friday of the month", and so on.
The owner has asked you for a helper that works out the dates behind these arrangements, as well as the dates of the salon's own monthly routine.

## 1. Find a regular's standing appointment

Implement the `SalonCalendar.standingAppointment()` method that takes a year, a month, an occurrence (`1` for the first, `2` for the second, and so on) and a day of the week.
It returns the date of that occurrence of the day of the week within the month:

```java
SalonCalendar calendar = new SalonCalendar();
calendar.standingAppointment(2024, Month.AUGUST, 2, DayOfWeek.TUESDAY);
// => LocalDate.of(2024, 8, 13)
```

## 2. Find a regular's last-of-the-month appointment

Some regulars prefer the last occurrence of their day in the month.
Implement the `SalonCalendar.lastAppointment()` method that takes a year, a month and a day of the week, and returns the date of the last occurrence of that day of the week within the month:

```java
SalonCalendar calendar = new SalonCalendar();
calendar.lastAppointment(2024, Month.AUGUST, DayOfWeek.FRIDAY);
// => LocalDate.of(2024, 8, 30)
```

## 3. Find the next available day for a walk-in

A client at the front desk asks for "the next Saturday".
If the day they ask on is already a Saturday, they mean that very day.
Implement the `SalonCalendar.nextAvailable()` method that takes a date and a day of the week, and returns the first date on or after the given date that falls on that day of the week:

```java
SalonCalendar calendar = new SalonCalendar();
calendar.nextAvailable(LocalDate.of(2024, 8, 15), DayOfWeek.SATURDAY);
// => LocalDate.of(2024, 8, 17)
calendar.nextAvailable(LocalDate.of(2024, 8, 17), DayOfWeek.SATURDAY);
// => LocalDate.of(2024, 8, 17)
```

## 4. Find the bookkeeping day

The salon closes its books on the last day of each month.
The salon is closed on weekends, though, so when the last day of the month falls on a Saturday or a Sunday, the books are closed on the Friday before.
Implement the `SalonCalendar.bookkeepingDay()` method that takes a year and a month, and returns the bookkeeping day of that month:

```java
SalonCalendar calendar = new SalonCalendar();
calendar.bookkeepingDay(2024, Month.SEPTEMBER);
// => LocalDate.of(2024, 9, 30)
calendar.bookkeepingDay(2024, Month.AUGUST);
// => LocalDate.of(2024, 8, 30)
```

## 5. Reuse the weekend rule for payday

Staff are paid on the 15th of every month, with the same weekend rule: when the 15th falls on a Saturday or a Sunday, payday is the Friday before.
Rather than writing the rule a second time, turn it into a reusable adjuster.

Implement the `SalonCalendar.precedingWorkday()` method that returns a `TemporalAdjuster` which leaves a weekday unchanged and moves a Saturday or a Sunday back to the preceding Friday.
Then implement the `SalonCalendar.payday()` method, which takes a year and a month, using that adjuster:

```java
SalonCalendar calendar = new SalonCalendar();
LocalDate.of(2024, 6, 15).with(calendar.precedingWorkday());
// => LocalDate.of(2024, 6, 14)
calendar.payday(2024, Month.JUNE);
// => LocalDate.of(2024, 6, 14)
calendar.payday(2024, Month.AUGUST);
// => LocalDate.of(2024, 8, 15)
```

Feel free to go back and use the adjuster in `bookkeepingDay()` as well.

## Source

### Created by

- @rabestro