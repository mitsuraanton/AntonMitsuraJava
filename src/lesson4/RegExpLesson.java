package lesson4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpLesson {
    public static void main(String[] args) {
        // Для работы с регулярными выражениями Pattern и Matcher
        String regExp = "Java Junior";
        String someStr = "Java Junior";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(someStr);

        System.out.println(matcher.matches()); // вернет true в случае, если вся строка соответствует регулярному выражению
        someStr = "Java Junior Developer";
        pattern = Pattern.compile("developer$", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(someStr);
        System.out.println(matcher.find()); // вернет true, если в строке есть подстрока, которая удовлетворяет регулярному выражению

        someStr = "Java Junior Developer";
        pattern = Pattern.compile("[A-Z0-9]");
        pattern = Pattern.compile("[ert]");
        matcher = pattern.matcher(someStr);
        while (matcher.find()) System.out.println(matcher.group());

        // a.+o
        someStr = "Java Junior Developer";
        pattern = Pattern.compile("a.+o"); // жадный поиск
        matcher = pattern.matcher(someStr);
        while (matcher.find()) System.out.println(matcher.group());

        someStr = "Java Junior Developer";
        pattern = Pattern.compile("a.+?o"); // ленивый поиск
        matcher = pattern.matcher(someStr);
        while (matcher.find()) System.out.println(matcher.group());

        someStr = "Java Junior Developer";
        pattern = Pattern.compile("a.++o"); // сверхжадный поиск
        matcher = pattern.matcher(someStr);
        while (matcher.find()) System.out.println(matcher.group());

        // группировка + опережающие и ретроспективные проверки

        someStr = "";
        regExp = "(?=.*[0-9])(?=.*[,/?])(?=.*[A-Z])[0-9A-Za-z./?]{3,}";
        pattern = Pattern.compile(regExp);
        matcher = pattern.matcher(someStr);
        System.out.println(matcher.find());
        // ?= - опережающая проверка
        // для email
        // найтив все предложения в тексте (начинаются с заглавной буквы, оканчиваются на ? . !)
        regExp = "[A-Z].*?[?.!]]";
        // найти все слова, начинающиеся на f
        regExp = "^f";
        // номер телефона в формате +7xxx-xxx-xx-xx
        regExp = "\\+7[0-9]{3}-[0-9]{3}-[0-9]{2}-[0-9]{2}";

        // имеются 2 строки. Найти количество вхоэдения одной строки в другую

        // Даны 2 слова, состоящие из четного количества букв. Нужно составить третье слово из первой половины 1го и второй половины второго. БЕЗ РЕГЭКСПОВ

        // Найти самое длинное слово в предложении (при условии, что все слова разной длины) БЕЗ РЕГУЛЯРОК
    }
}
