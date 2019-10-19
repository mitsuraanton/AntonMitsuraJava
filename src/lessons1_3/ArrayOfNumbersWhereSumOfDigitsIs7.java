package lessons1_3;

public class ArrayOfNumbersWhereSumOfDigitsIs7 {
    // 2. Дан массив целых чисел. Массив не отсортирован, числа могут повторяться. Необходимо найти в данном массиве такие числа n и m, чтобы их сумма была равна 7.
    public static void main(String[] args) {
        int[] inputArray = {86, 0, 26, -7, 1, 0, -1, 9, 8, 6, 5, 4, -1, 2, -2, 3, -3, 2, -5, 1};
        int firstNumber = 0;
        int secondNumber = 0;
        firstLoop: for (int i = 0; i < inputArray.length - 1; i++) {
            firstNumber = inputArray[i];
            for (int j = i + 1; j < inputArray.length; j++) {
                secondNumber = inputArray[j];
                if (firstNumber + secondNumber == 7) break firstLoop;
            }
        }
        System.out.printf("Первое число = %d, второе число = %d", firstNumber, secondNumber);
    }
}
