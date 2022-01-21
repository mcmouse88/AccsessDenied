package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        validateUser(getUserByLoginAndPassword(login, password));

        System.out.println("доступ разрешен");
    }

    public static User[] getUsers() {
        User user1 = new User("tonny123", "1234", "tonny123@gmail.com", 33);
        User user2 = new User("harry777", "abcd", "harry777@yandex.ru", 19);
        User user3 = new User("bruce321", "5050", "bruce321@icloud.com", 18);
        User user4 = new User("sam2006", "1212", "sam2006@mail.ru", 16);

        return new User[] {user1, user2, user3, user4};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18) {
            throw new AccessDeniedException("Доступ к ресурсу запрещен");
        }
    }
}
