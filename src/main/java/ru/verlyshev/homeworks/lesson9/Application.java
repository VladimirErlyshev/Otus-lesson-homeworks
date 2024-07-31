package ru.verlyshev.homeworks.lesson9;

public class Application {
    public static void main(String[] args) {
        User[] users = new User[]{
                new User("Алехин", "Артем", "Ярославович", "1960", "dev0@ya.ru"),
                new User("Бычков", "Алексей", "Тимофеевич", "2000", "dev1@ya.ru"),
                new User("Мещеряков", "Александр", "Алиевич", "1989", "dev2@ya.ru"),
                new User("Иванов", "Илья", "Максимович", "1957", "dev3@ya.ru"),
                new User("Горбунов", "Константин", "Дмитриевич", "1995", "dev4@ya.ru"),
                new User("Комаров", "Фёдор", "Александрович", "1980", "dev5@ya.ru"),
                new User("Островский", "Глеб", "Семёнович", "1970", "dev6@ya.ru"),
                new User("Рябов", "Давид", "Лукич", "1999", "dev7@ya.ru"),
                new User("Суслов", "Даниил", "Александрович", "1998", "dev8@ya.ru"),
                new User("Ильин", "Артём", "Маркович", "2010", "dev9@ya.ru"),
        };

        for (var user : users) {
            if (user.getAge() > 40) {
                user.showInfo();
            }
        }
    }
}
