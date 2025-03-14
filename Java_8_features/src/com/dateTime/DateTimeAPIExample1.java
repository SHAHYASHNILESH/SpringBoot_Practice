package com.dateTime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeAPIExample1 {

	public static void main(String[] args) {

		LocalDate now = LocalDate.now();
		System.out.println(now);

		LocalDate myDate = LocalDate.of(2018, 1, 1);
		System.out.println(myDate);

		System.out.println(now.getDayOfMonth());
		System.out.println(now.getMonthValue());
		System.out.println(now.getMonth());
		System.out.println(now.getYear());

		LocalDate minusDays = now.minusDays(1);
		LocalDate minusDays2 = now.minusMonths(100);

		System.out.println(minusDays);
		System.out.println(minusDays2);

		if (now.isAfter(minusDays)) {

			System.out.println("I am inside");
		}

		LocalTime now2 = LocalTime.now();
		System.out.println(now2);

		LocalTime myTime = LocalTime.of(10, 10, 10);
		System.out.println(myTime);

		String time = "10:20:35";
		LocalTime myTime2 = LocalTime.parse(time);
		System.out.println(myTime2);

		LocalTime plusHours = now2.plusHours(1);
		System.out.println(plusHours);

		LocalTime minusMinutes = now2.minusMinutes(60);
		System.out.println(minusMinutes);

		if (now2.isAfter(minusMinutes)) {

			System.out.println("I am here...");
		}

		LocalDateTime now3 = LocalDateTime.now();
		System.out.println(now3);

		LocalDateTime mydateTime = LocalDateTime.of(2018, 1, 1, 10, 10, 10);
		System.out.println(mydateTime);

		LocalDateTime mydateTime2 = LocalDateTime.parse("2018-01-01T10:20:30");
		System.out.println(mydateTime2);

		ZonedDateTime now4 = ZonedDateTime.now();
		System.out.println(now4);
		System.out.println(now4.getZone());

		ZoneId.getAvailableZoneIds().forEach(System.out::println);

		ZonedDateTime zonedDateTime = ZonedDateTime.of(2018, 1, 1, 10, 10, 10, 0, ZoneId.of("America/New_York"));
		System.out.println(zonedDateTime);

		ZonedDateTime zonedDateTime2 = ZonedDateTime.parse("2018-01-01T10:20:30+05:00[Asia/Kolkata]");
		System.out.println(zonedDateTime2);

		Instant now5 = Instant.now();
		System.out.println(now5);

		int sum = 0;
		for (int i = 0; i < 1000000; i++) {
			sum += i;
		}

		Instant now6 = Instant.now();

		Duration between = Duration.between(now5, now6);
		System.out.println(between);

		Duration duration = Duration.of(1, ChronoUnit.MILLIS);
		System.out.println(duration);

		int compareTo = duration.compareTo(between);
		System.out.println(compareTo);

		LocalDate d1 = LocalDate.now();
		LocalDate d2 = LocalDate.of(2018, 1, 1);
		Period between2 = Period.between(d1, d2);
		System.out.println(between2);

		LocalDate now7 = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String format = now7.format(formatter);
		System.out.println(format);

		String parsedDate = "12/03/2025";
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(parsedDate, ofPattern);
		System.out.println(localDate);
	}
}
