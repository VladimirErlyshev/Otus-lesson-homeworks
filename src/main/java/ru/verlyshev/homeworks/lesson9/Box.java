package ru.verlyshev.homeworks.lesson9;

class Box {
    private final String width;
    private final String length;
    private final String height;
    private String color;
    private boolean isOpen;
    private String item;

    public Box(String width, String length, String height, String color) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
        System.out.println("Цвет коробки изменен на " + color);
    }

    public void open() {
        if (!isOpen) {
            isOpen = true;
            System.out.println("Коробка стала открытой");
        } else {
            System.out.println("Коробка уже открыта");
        }
    }

    public void close() {
        if (isOpen) {
            isOpen = false;
            System.out.println("Коробка стала закрытой");
        } else {
            System.out.println("Коробка уже закрыта");
        }
    }

    public void putItem(String item) {
        if (!isOpen) {
            System.out.println("Предмет положить нельзя, так как коробка закрыта");
        } else if (!this.item.isEmpty()) {
            System.out.println("В коробке уже есть предмет");
        } else {
            this.item = item;
            System.out.println("Предмет " + item + " положен в коробку");
        }
    }

    public void removeItem() {
        if (!isOpen) {
            System.out.println("Предмет убрать нельзя, так как коробка закрыта");
        } else if (item.isEmpty()) {
            System.out.println("В коробке нет предмета");
        } else {
            item = "";
            System.out.println("Из коробки убран предмет");
        }
    }

    public void showInfo() {
        System.out.println("Ширина коробки " + width);
        System.out.println("Длина коробки " + length);
        System.out.println("Высота коробки " + height);
        System.out.println("Цвет коробки " + color);
        if (isOpen) {
            System.out.println("Коробка открыта");
        } else {
            System.out.println("Коробка закрыта");
        }
        if (item.isEmpty()) {
            System.out.println("В коробке нет предмета");
        } else {
            System.out.println("В коробке лежит предмет " + item);
        }
    }
}
