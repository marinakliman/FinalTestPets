package system;

// Класс Hamster
class Hamster extends Animal {
    public Hamster(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " squeaks!");
    }
}