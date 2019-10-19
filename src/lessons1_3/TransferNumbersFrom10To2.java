package lessons1_3;

public class TransferNumbersFrom10To2 {
    // 1. Написать программу перевода числа из 10 системы счисления в 2 систему счесления
    public static void main(String[] args) {
        int decimalNumber = 17;
        String binaryNumber = "";
        while (decimalNumber > 1){
            binaryNumber = binaryNumber + decimalNumber%2;
            decimalNumber = decimalNumber/2;
        }
        binaryNumber = binaryNumber + decimalNumber;
        binaryNumber = new StringBuilder(binaryNumber).reverse().toString();
        System.out.println(binaryNumber);
    }
}
