package hacker.rank;

import java.util.HashMap;
import java.util.Map;

public class Student {

    public Student(String name) {
        super();
        this.name = name;
    }

    public static void main(String[] args) {
        Map<Student, String> map = new HashMap<>();
        map.put(new Student("john"), "present");
        System.out.println(map.get(new Student("john")));
    }

    private String name;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}
