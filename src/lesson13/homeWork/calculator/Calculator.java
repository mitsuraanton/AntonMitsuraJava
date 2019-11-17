package lesson13.homeWork.calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static void main(String[] args) {
//        Калькулятор считывает с консоли одно из выражений (n+m / n-m / nХm / n/m, где n и m - целые числа) или exit для завершения работы.
//        Калькулятор выводит результат вычисления в консоль, после чего ожидает ввода нового выражения или exit для завершения работы.
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("Введите выражение для вычисления:");
            String inputExpression = in.nextLine();
            if ("exit".equals(inputExpression)) break;
            try {
                checkInputExpression(inputExpression);
            } catch (WrongOperatorException | MissingNOrMException | DividingByZeroOrNotIntValueException e) {
                System.out.println(e.getMessage());
            }
            if (inputExpression.contains("+")){
                int firstValue = Integer.valueOf(inputExpression.substring(0, inputExpression.indexOf("+")));
                int secondValue = Integer.valueOf(inputExpression.substring((inputExpression.indexOf("+") + 1)));
                System.out.println("Результат вычисления выражения " + inputExpression + " == " + (firstValue + secondValue));
            }
            else if (inputExpression.contains("-")){
                int firstValue = Integer.valueOf(inputExpression.substring(0, inputExpression.indexOf("-")));
                int secondValue = Integer.valueOf(inputExpression.substring((inputExpression.indexOf("-") + 1)));
                System.out.println("Результат вычисления выражения " + inputExpression + " == " + (firstValue - secondValue));
            }
            else if (inputExpression.contains("*")){
                int firstValue = Integer.valueOf(inputExpression.substring(0, inputExpression.indexOf("*")));
                int secondValue = Integer.valueOf(inputExpression.substring((inputExpression.indexOf("*") + 1)));
                System.out.println("Результат вычисления выражения " + inputExpression + " == " + (firstValue * secondValue));
            }
            else if (inputExpression.contains("/")){
                int firstValue = Integer.valueOf(inputExpression.substring(0, inputExpression.indexOf("/")));
                int secondValue = Integer.valueOf(inputExpression.substring((inputExpression.indexOf("/") + 1)));
                System.out.println("Результат вычисления выражения " + inputExpression + " == " + (firstValue / secondValue));
            }
        }
    }

    public static void checkInputExpression(String inputExpression) throws WrongOperatorException, MissingNOrMException, DividingByZeroOrNotIntValueException {
        if (!inputExpression.contains("+") && !inputExpression.contains("-") && !inputExpression.contains("*") && !inputExpression.contains("/")){
            throw new WrongOperatorException("Неверный оператор. Должен быть изсользован только один из следующих: + - * /");
        }
        String numberBeforeOperator = null;
        String operatorAndNumberAfterOperator = null;
        if (inputExpression.contains("+")){
            numberBeforeOperator = inputExpression.substring(0, (inputExpression.indexOf("+")));
            operatorAndNumberAfterOperator = inputExpression.substring(inputExpression.indexOf("+"));
        }
        if (inputExpression.contains("-")){
            numberBeforeOperator = inputExpression.substring(0, (inputExpression.indexOf("-")));
            operatorAndNumberAfterOperator = inputExpression.substring(inputExpression.indexOf("-"));
        }
        if (inputExpression.contains("*")){
            numberBeforeOperator = inputExpression.substring(0, (inputExpression.indexOf("*")));
            operatorAndNumberAfterOperator = inputExpression.substring(inputExpression.indexOf("*"));
        }
        if (inputExpression.contains("/")){
            numberBeforeOperator = inputExpression.substring(0, (inputExpression.indexOf("/")));
            operatorAndNumberAfterOperator = inputExpression.substring(inputExpression.indexOf("/"));
        }
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcherOfNumberBeforeOperator = pattern.matcher(numberBeforeOperator);
        Matcher matcherOfNumberAfterOperator = pattern.matcher(operatorAndNumberAfterOperator);
        if (!matcherOfNumberBeforeOperator.find() || !matcherOfNumberAfterOperator.find()){
            throw new MissingNOrMException("Отсутствует значение, надо которым нужно совершить операцию");
        }
        int intBeforeOperator;
        int intAfterOperator;
        try {
            intBeforeOperator = Integer.parseInt(numberBeforeOperator);
            intAfterOperator = Integer.parseInt(operatorAndNumberAfterOperator.substring(1));
        } catch (NumberFormatException e){
            throw new DividingByZeroOrNotIntValueException("Оба значения должны быть целочисленными");
        }
        if (inputExpression.contains("/") && intAfterOperator == 0)
            throw new DividingByZeroOrNotIntValueException("Деление на ноль");
    }
}
