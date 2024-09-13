package ru.verlyshev.homeworks.lesson11;

import java.util.ArrayList;
import java.util.List;

import static ru.verlyshev.homeworks.lesson11.Position.*;

public class PersonDataBase {
    private List<Person> persons = new ArrayList<>();

    private final List<Position> MANAGER_POSITION = List.of(MANAGER, DIRECTOR, BRANCH_DIRECTOR, SENIOR_MANAGER);

    public PersonDataBase(List<Person> persons) {
        this.persons = persons;
    }

    public Person findById(long id) {
        return persons.stream().filter(person -> person.getId() == id).findFirst().orElseThrow();
    }

    public void add(Person person) {
        persons.add(person);
    }

    public boolean isManager(Person person) {
        return MANAGER_POSITION.contains(person.getPosition());
    }

    public boolean isEmployee(Long id) {
        return !MANAGER_POSITION.contains(findById(id).getPosition());
    }

    public List<Person> getPersons() {
        return persons;
    }
}
