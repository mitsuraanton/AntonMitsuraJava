package lesson19.homeWork.tasks.task1;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentTask {
    public static void main(String[] args) {
        //TODO: найти студентов с уникальными предметами. Задачу решать с использованием stream API
        // Должны быть с такими предметами, ни одного из которых нет ни у одного другого студента
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<String> subjectsOfStudent1 = new ArrayList<>();
        subjectsOfStudent1.add("Биология");
        subjectsOfStudent1.add("Математика");
        subjectsOfStudent1.add("Физика");
        students.add(new Student("Иванов", subjectsOfStudent1));

        ArrayList<String> subjectsOfStudent2 = new ArrayList<>();
        subjectsOfStudent2.add("Литература");
        subjectsOfStudent2.add("Физкультура");
        students.add(new Student("Петров", subjectsOfStudent2));

        ArrayList<String> subjectsOfStudent3 = new ArrayList<>();
        subjectsOfStudent3.add("География");
        subjectsOfStudent3.add("Физика");
        students.add(new Student("Сидоров", subjectsOfStudent3));

        ArrayList<String> subjectsOfStudent4 = new ArrayList<>();
        subjectsOfStudent4.add("География");
        subjectsOfStudent4.add("Физкультура");
        students.add(new Student("Ли", subjectsOfStudent4));

        ArrayList<String> subjectsOfStudent5 = new ArrayList<>();
        subjectsOfStudent5.add("Биология");
        subjectsOfStudent5.add("Русский язык");
        subjectsOfStudent5.add("Природоведение");
        students.add(new Student("Харли", subjectsOfStudent5));

        ArrayList<String> subjectsOfStudent6 = new ArrayList<>();
        subjectsOfStudent6.add("Материаловедение");
        subjectsOfStudent6.add("Английский язык");
        students.add(new Student("Освальд", subjectsOfStudent6));

        ArrayList<String> subjectsOfStudent7 = new ArrayList<>();
        subjectsOfStudent7.add("Труд");
        subjectsOfStudent7.add("Бухгалтерский учет");
        students.add(new Student("Зильберман", subjectsOfStudent7));

        students.stream().filter(student -> {
            for (Student studentIn : students) {
                if (studentIn.equals(student) && !(studentIn.getLogin().equals(student.getLogin()) && studentIn.getSubjects().equals(student.getSubjects()))) return false;
            }
            return true;
        })
                .forEach(System.out::println);
    }
}

class Student {
    // можно добавить дополнительные поля
    private String login;
    private List<String> subjects;

    public Student(String login, List<String> subjects) {
        this.login = login;
        this.subjects = subjects;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;

        for (int i = 0; i < getSubjects().size(); i++) {
            for (int j = 0; j < student.getSubjects().size(); j++) {
                if (getSubjects().get(i).equals(student.getSubjects().get(j)))
                    return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubjects());
    }

    @Override
    public String toString() {
        return "Student{" +
                "login='" + login + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
