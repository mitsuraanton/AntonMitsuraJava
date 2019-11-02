package lesson9;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class PlainFromSydney {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2019, Month.DECEMBER, 31, 19,00);
        ZonedDateTime sydneyDepartured = localDateTime.atZone(ZoneId.of("Australia/Sydney"));
        System.out.println("sydneyDepartured:" + sydneyDepartured);
        ZonedDateTime houstonArrived = sydneyDepartured.withZoneSameInstant(ZoneId.of("America/Chicago")).plusHours(15).plusMinutes(35);
        System.out.println("houstonArrived:" + houstonArrived);
        ZonedDateTime houstonDepartured = houstonArrived.plusHours(1).plusMinutes(45);
        System.out.println("houstonDepartured:" + houstonDepartured);
        ZonedDateTime washingtonArrived = houstonDepartured.withZoneSameInstant(ZoneId.of("America/New_York")).plusHours(2).plusMinutes(49);
        System.out.println("washingtonArrived:" + washingtonArrived);
        ZonedDateTime washingtonDepartured = washingtonArrived.plusHours(1).plusMinutes(6);
        System.out.println("washingtonDepartured:" + washingtonDepartured);
        ZonedDateTime ottavaArrived = washingtonDepartured.withZoneSameInstant(ZoneId.of("America/Toronto")).plusHours(1).plusMinutes(39);
        System.out.println("ottavaArrived:" + ottavaArrived);

        LocalDateTime localDateTimeOfLastMinuteOfTheYear = LocalDateTime.of(2019, Month.DECEMBER, 31, 23,59);
        ottavaArrived = localDateTimeOfLastMinuteOfTheYear.atZone(ZoneId.of("America/Toronto"));
        washingtonDepartured = ottavaArrived.withZoneSameInstant(ZoneId.of("America/New_York")).minusHours(1).minusMinutes(39);
        washingtonArrived = washingtonDepartured.minusHours(1).minusMinutes(6);
        houstonDepartured = washingtonArrived.withZoneSameInstant(ZoneId.of("America/Chicago")).minusHours(2).minusMinutes(49);
        houstonArrived = houstonDepartured.minusHours(1).minusMinutes(45);
        sydneyDepartured = houstonArrived.withZoneSameInstant(ZoneId.of("Australia/Sydney")).minusHours(15).minusMinutes(35);
        System.out.println("Должен отправиться из Сиднея, чтобы долететь до нового года:" + sydneyDepartured);
    }
}
