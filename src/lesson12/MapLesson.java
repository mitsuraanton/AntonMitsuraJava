package lesson12;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class MapLesson {
    public static void main(String[] args) throws IOException {
        User user1 = new User("qwe", "123", Role.USER);
        User user2 = new User("asd", "346", Role.ADMIN);
        User user3 = new User("zxc", "968", Role.USER);
        User user4 = new User("rty", "346", Role.ADMIN);

        System.out.println("---HashMap---");
        // для объектов, которые используются в качестве ключей, обязательно должны быть переопределены методы equals и hashCode
        // null можно использовать в качестве ключа
        HashMap<String, User> userHashMap = new HashMap<>();
        userHashMap.put(user1.getLogin(), user1);
        userHashMap.put(user2.getLogin(), user2);
        userHashMap.put(user3.getLogin(), user3);
        userHashMap.put(user4.getLogin(), user4);
        userHashMap.put(null, null);

        userHashMap.remove("zxc");
        userHashMap.remove("hhh");

        System.out.println(userHashMap);
        System.out.println(userHashMap.get("asd"));
        System.out.println(userHashMap.get("hhh"));

        // перебор
        for (Map.Entry<String, User> entry: userHashMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("---EnumMap---");
        // enum используется в качестве ключей. null нельзя использовать в качестве ключа
        EnumMap<Role, ArrayList<User>> enumMap = new EnumMap<>(Role.class);
        enumMap.put(Role.USER, new ArrayList<>(Arrays.asList(user1, user3)));
        enumMap.put(Role.ADMIN, new ArrayList<>(Arrays.asList(user2, user4)));

        System.out.println(enumMap.get(Role.USER));

        User user5 = new User("newUser", "444", Role.USER);
        enumMap.get(user5.getRole()).add(user5);

        WeakHashMap<Object, String> weakHashMap = new WeakHashMap<>();
        Object weakHashKey = new Object();
        String weakHashVal = "Str";

        HashMap<Object, String> objectHashMap = new HashMap<>();
        Object hashMapKey = new Object();
        String hashMapVal = "Str";
        objectHashMap.put(hashMapKey, hashMapVal);

        weakHashKey = null;
        hashMapKey = null;

        System.gc();

        System.out.println(weakHashMap);
        System.out.println(objectHashMap);

        System.out.println("---TreeMap---");
        // основан на красночерном дереве
        // сортировка по ключам
        // null не может быть использован в качестве ключа
        TreeMap<String, User> treeMap = new TreeMap<>();
        treeMap.put(user1.getLogin(), user1);
        treeMap.put(user2.getLogin(), user2);
        treeMap.put(user3.getLogin(), user3);
        treeMap.put(user4.getLogin(), user4);
        System.out.println(treeMap);

        ClassLoader loader = MapLesson.class.getClassLoader();
        File file = new File(loader.getResource("resources/wp.txt").getFile());

        List<String> strings = Files.readAllLines(file.toPath());
        numberOfWordOccuranceInText(strings, "he");

    }

    public static long numberOfWordOccuranceInText(List<String> strings, String wordToSearch){
        long numberOfWordOccuranceinText = 0L;
        for (String string: strings){
            if (string.contains(wordToSearch)) numberOfWordOccuranceinText++;
        }
        return numberOfWordOccuranceinText;
    }

    public static HashMap<Integer, HashSet<String>> separateWordsByLettersNumber(List<String> strings){
        HashMap<Integer, HashSet<String>> map = new HashMap<>();
        for (String string: strings){
            String[] words = string.split(" ");
            String[]tokens = string.split(" |--");

        }

        return map;
    }
}
