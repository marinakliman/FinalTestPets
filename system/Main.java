package system;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PetRegistry registry = new PetRegistry();

        try (Counter counter = new Counter()) {
            boolean running = true;

            while (running) {
                System.out.println("1. Завести новое животное");
                System.out.println("2. Показать список животных");
                System.out.println("3. Обучить животное новым командам");
                System.out.println("4. Выйти");
                System.out.print("Выберите опцию: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Чистим буфер

                switch (option) {
                    case 1:
                        System.out.print("Введите имя животного: ");
                        String name = scanner.nextLine();
                        System.out.print("Введите возраст животного: ");
                        int age = scanner.nextInt();
                        scanner.nextLine(); // Чистим буфер
                        System.out.print("Введите тип животного (dog/cat/hamster): ");
                        String type = scanner.nextLine();

                        Animal animal;
                        if (type.equalsIgnoreCase("dog")) {
                            animal = new Dog(name, age);
                        } else if (type.equalsIgnoreCase("cat")) {
                            animal = new Cat(name, age);
                        } else if (type.equalsIgnoreCase("hamster")) {
                            animal = new Hamster(name, age);
                        } else {
                            System.out.println("Неизвестный тип животного!");
                            continue;
                        }

                        registry.addAnimal(animal);
                        counter.add(); // Увеличиваем счетчик
                        break;

                    case 2:
                        registry.listAnimals();
                        break;

                    case 3:
                        System.out.print("Введите имя животного для обучения: ");
                        String animalName = scanner.nextLine();
                        Animal foundAnimal = registry.findAnimalByName(animalName);
                        if (foundAnimal != null) {
                            System.out.print("Введите команду: ");
                            String command = scanner.nextLine();
                            foundAnimal.addCommand(command);
                            System.out.println(animalName + " обучено новой команде: " + command);
                        } else {
                            System.out.println("Животное не найдено!");
                        }
                        break;

                    case 4:
                        running = false;
                        break;

                    default:
                        System.out.println("Неверный выбор!");
                        break;
                }
            }

            System.out.println("Всего заведено животных: " + counter.getCount());
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}