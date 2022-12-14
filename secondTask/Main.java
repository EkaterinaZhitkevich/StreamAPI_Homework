package secondtask;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Sam", "Alex", "George", "Jack", "Harry");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davis", "Adamson");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(names.get(new Random().nextInt(names.size())), families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100), Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)]));
        }
        long underage = persons.stream().filter(x -> x.getAge() >= 18).count();
        List<String> conscripts = persons.stream().filter(x -> x.getAge() >=18).filter(x -> x.getAge() <=27).
                filter(x-> x.getSex().equals(Sex.MAN)).map(x -> x.getFamily()).collect(Collectors.toList());
        List<Person> qualifiedSpecialists = persons.stream().filter(x -> x.getEducation().equals(Education.HIGHER))
                .filter(x->  (x.getAge() >= 18 && (x.getAge() <= 60 && x.getSex().equals(Sex.WOMAN) ||
                    x.getAge() <=65 && x.getSex().equals(Sex.MAN)))).sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());

        persons.forEach(System.out::println);
        System.out.println(underage);
        conscripts.forEach(System.out::println);
        qualifiedSpecialists.forEach(System.out::println);
    }
}
