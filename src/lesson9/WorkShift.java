package lesson9;

import java.time.LocalTime;

public class WorkShift {
    public static void main(String[] args) {
//        Есть три рабочие смены:
//        с 7:00 до 15:00
//        с 15:00 до 23:00
//        с 23:00 до 7:00
//        Определить какая сейчас смена (относительно текущего времени)
        LocalTime thirdShiftEndAndFirstShiftBegin = LocalTime.of(7, 0);
        LocalTime firstShiftEndAndSecondShiftBeginning = LocalTime.of(15, 0);
        LocalTime secondShiftEndAndThirdShiftBeginning = LocalTime.of(23, 0);
        LocalTime currentTime = LocalTime.now();
        if (currentTime.isAfter(thirdShiftEndAndFirstShiftBegin) && currentTime.isBefore(firstShiftEndAndSecondShiftBeginning))
            System.out.println("Сейчас первая смена");
        if (currentTime.isAfter(firstShiftEndAndSecondShiftBeginning) && currentTime.isBefore(secondShiftEndAndThirdShiftBeginning))
            System.out.println("Сейчас вторая смена");
        if (currentTime.isAfter(secondShiftEndAndThirdShiftBeginning) || currentTime.isBefore(thirdShiftEndAndFirstShiftBegin))
            System.out.println("Сейчас третья смена");
    }
}
