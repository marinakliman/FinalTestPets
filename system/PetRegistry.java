package system;

import java.util.ArrayList;
import java.util.Scanner;

class PetRegistry {
    private ArrayList<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void listAnimals() {
        for (Animal animal : animals) {
            System.out.println(animal.getName() + " (Age: " + animal.getAge() + ")");
            System.out.println("Commands: " + String.join(", ", animal.getCommands()));
        }
    }

    public Animal findAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }
}