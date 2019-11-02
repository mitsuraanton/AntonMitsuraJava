package lesson9;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class CalendarOfLessons {
    public static void main(String[] args) {
//        Наши занятия закончатся 20 января 2020 года. Сколько занятий осталось, если они проходят 3 раза в неделю (пн, ср, пт). Праздничные дни не учитывать.
        LocalDate localDate = LocalDate.now();
        int numberOfRemainedLessons = 0;
        while (localDate.isBefore(LocalDate.of(2020, 1, 21))){
            if (localDate.getDayOfWeek().equals(DayOfWeek.MONDAY) || localDate.getDayOfWeek().equals(DayOfWeek.WEDNESDAY) || localDate.getDayOfWeek().equals(DayOfWeek.FRIDAY)){
                if (!localDate.isEqual(LocalDate.of(2019, 11, 04))
                        && (localDate.isBefore(LocalDate.of(2020, 1, 1)) || localDate.isAfter(LocalDate.of(2020, 1, 8)))){
                    numberOfRemainedLessons++;
                }
            }
            localDate = localDate.plusDays(1);
        }
        System.out.println(numberOfRemainedLessons);
    }
}
