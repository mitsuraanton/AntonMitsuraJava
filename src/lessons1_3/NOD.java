package lessons1_3;

public class NOD {
    public static void main(String[] args) {
        //  Посчитать наибольший общий делитель НОД
        //Наибольший общий делитель (НОД) двух данных чисел «a» и «b» — это наибольшее число, на которое оба числа «a» и «b» делятся без остатка.
        int a = 17;
        int b = 9;
        int minValueOfTwo = (a<b) ? a :b;
        for (int i = minValueOfTwo; i > 0; i--) {
            if ( (a % i == 0) && (b % i == 0) ){
                System.out.printf("Наибольший общий делитель чисел %d и %d = %d", a, b, i);
                break;
            }
        }
    }
}
