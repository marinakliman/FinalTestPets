package system;

// Базовый класс Animal
abstract class Animal {
    private String name;
    private int age;
    private String[] commands;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.commands = new String[0]; // Изначально пустой массив команд
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String[] getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        String[] newCommands = new String[commands.length + 1];
        System.arraycopy(commands, 0, newCommands, 0, commands.length);
        newCommands[commands.length] = command;
        commands = newCommands;
    }

    public abstract void makeSound();
}



