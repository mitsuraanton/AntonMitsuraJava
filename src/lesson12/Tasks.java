package lesson12;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tasks {
    // map хранит login и город проживания. Написать метод, который принимает на вход мапу и город, и формирует список логинов, которые соответствуют переданному городу
    public static void main(String[] args) {

    }

    public static List<String> getPeopleByCity(Map<String, String> map, String city){
        ArrayList<String> loginList = new ArrayList<>();
        for (Map.Entry<String, String> entry: map.entrySet()){
            if (city != null && city.equals(entry.getValue())){
                loginList.add(entry.getKey());
            }
        }
        return loginList;
    }
}
