package lessons1_3;

public class TransferNumbersFrom10To16 {
    // 1. Написать программу перевода числа из 10 системы счисления в 16 систему счисления
    public static void main(String[] args) {
        int decimalNumber = 171;
        String hexademicalNumber = "";
        while (decimalNumber > 15){
            int modulo = decimalNumber%16;
            switch (modulo){
                case 10:
                    hexademicalNumber = hexademicalNumber + "A";
                    break;
                case 11:
                    hexademicalNumber = hexademicalNumber + "B";
                    break;
                case 12:
                    hexademicalNumber = hexademicalNumber + "C";
                    break;
                case 13:
                    hexademicalNumber = hexademicalNumber + "D";
                    break;
                case 14:
                    hexademicalNumber = hexademicalNumber + "E";
                    break;
                case 15:
                    hexademicalNumber = hexademicalNumber + "F";
                    break;
                default:
                    hexademicalNumber = hexademicalNumber + modulo;
            }
            decimalNumber = decimalNumber/16;
        }
        switch (decimalNumber){
            case 10:
                hexademicalNumber = hexademicalNumber + "A";
                break;
            case 11:
                hexademicalNumber = hexademicalNumber + "B";
                break;
            case 12:
                hexademicalNumber = hexademicalNumber + "C";
                break;
            case 13:
                hexademicalNumber = hexademicalNumber + "D";
                break;
            case 14:
                hexademicalNumber = hexademicalNumber + "E";
                break;
            case 15:
                hexademicalNumber = hexademicalNumber + "F";
                break;
            default:
                hexademicalNumber = hexademicalNumber + decimalNumber;
        }
        hexademicalNumber = new StringBuilder(hexademicalNumber).reverse().toString();
        System.out.println(hexademicalNumber);
    }
}
