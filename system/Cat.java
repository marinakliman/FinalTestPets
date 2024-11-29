package system;

// Класс Cat
class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says Meow!");
    }
}