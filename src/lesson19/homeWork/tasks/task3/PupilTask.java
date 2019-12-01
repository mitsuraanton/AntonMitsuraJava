package lesson19.homeWork.tasks.task3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class PupilTask {
    public static void main(String[] args) {
        // Используя Stream API:
        ArrayList<Pupil> students = new ArrayList<>();
        students.add(new Pupil(9,"Иванов", Pupil.Gender.MALE, LocalDate.of(2011, 01, 30)));
        students.add(new Pupil(8,"Поночка", Pupil.Gender.FEMALE, LocalDate.of(2006, 02, 17)));
        students.add(new Pupil(7,"Сидоров", Pupil.Gender.MALE, LocalDate.of(2007, 05, 06)));
        students.add(new Pupil(6,"Ксенофонтова", Pupil.Gender.FEMALE, LocalDate.of(2005, 07, 26)));
        students.add(new Pupil(5,"Петров", Pupil.Gender.MALE, LocalDate.of(2008, 11, 23)));
        students.add(new Pupil(4,"Рубиконова", Pupil.Gender.FEMALE, LocalDate.of(2004, 10, 11)));
        students.add(new Pupil(3,"Губернаторов", Pupil.Gender.MALE, LocalDate.of(2009, 9, 02)));
        students.add(new Pupil(2,"Широкоформатная", Pupil.Gender.FEMALE, LocalDate.of(2003, 12, 22)));
        students.add(new Pupil(1,"Быстрый", Pupil.Gender.MALE, LocalDate.of(2010, 01, 19)));

        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>
        Map<Pupil.Gender, ArrayList<Pupil>> map = students.stream().collect(Collectors.groupingBy(Pupil::getGender, Collectors.toCollection(ArrayList::new)));
        System.out.println(map.get(Pupil.Gender.MALE));
        System.out.println(map.get(Pupil.Gender.FEMALE));
        // 2. Найти средний возраст учеников
//        Optional<LocalDate> optional = students.stream().reduce((x, y) -> x + y);
//        System.out.println(optional.get());

        Object averaging = students.stream()
                .map(student -> student.getBirth().toEpochDay())
                .collect(Collectors.collectingAndThen(
                        Collectors.averagingLong(Long::longValue),
                        it -> it.longValue()
                ));


        // 3. Найти самого младшего ученика

        // 4. Найти самого старшего ученика

        // 5. Собрать учеников в группы по году рождения

        // 6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль

        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)

        // 8. Вывести в косоль всех учеников в возрасте от N до M лет

        // 9. Собрать в список всех учеников с именем=someName

        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
    }
}
