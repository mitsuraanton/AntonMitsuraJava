package lesson11.homeWork.task;

import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // TODO:  Подсчитать количество сообщений для каждого приоритела
        //  Ответ в консоль
        int numberOfLowPriorities = 0;
        int numberOfMediumPriorities = 0;
        int numberOfHighPriorities = 0;
        int numberOfUrgentPriorities = 0;
        for (Message message: messageList){
            switch (message.getPriority()){
                case LOW:
                    numberOfLowPriorities++;
                    break;
                case MEDIUM:
                    numberOfMediumPriorities++;
                    break;
                case HIGH:
                    numberOfHighPriorities++;
                    break;
                case URGENT:
                    numberOfUrgentPriorities++;
                    break;
            }
        }
        System.out.println("Количество сообщений с приоритетом LOW: " + numberOfLowPriorities);
        System.out.println("Количество сообщений с приоритетом MEDIUM: " + numberOfMediumPriorities);
        System.out.println("Количество сообщений с приоритетом HIGH: " + numberOfHighPriorities);
        System.out.println("Количество сообщений с приоритетом URGENT: " + numberOfUrgentPriorities);
    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
        Map<Integer, Integer> numberOfMessagesWithCode = new HashMap<>();
        for (Message message: messageList){
            if (!numberOfMessagesWithCode.containsKey(message.getCode())) numberOfMessagesWithCode.put(message.getCode(), 0);
            numberOfMessagesWithCode.put(message.getCode(), numberOfMessagesWithCode.get(message.getCode()) + 1);
        }
        numberOfMessagesWithCode.forEach((k, v) -> System.out.println("Количество сообщение для кода: " + k + " == " + v));
    }

    public static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        HashSet set = new HashSet<>();
        for (Message message: messageList) set.add(message);
        System.out.println("Количество уникальных сообщений: " + set.size());
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList){
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        LinkedHashSet<Message> set = new LinkedHashSet<>();
        for (Message message: messageList) set.add(message);
        List<Message> outputMessageList = new ArrayList<>();
        outputMessageList.addAll(set);
        return outputMessageList;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority){
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
        ArrayList<Message> outputMessageList = new ArrayList<>(messageList);
        System.out.println(outputMessageList);
        outputMessageList.removeIf(message -> message.getPriority().equals(priority));
        System.out.println(outputMessageList);
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority){
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
        ArrayList<Message> outputMessageList = new ArrayList<>(messageList);
        System.out.println(outputMessageList);
        outputMessageList.removeIf(message -> !message.getPriority().equals(priority));
        System.out.println(outputMessageList);
    }

    public static void main(String[] args) {
        // вызов методов
    }


}
