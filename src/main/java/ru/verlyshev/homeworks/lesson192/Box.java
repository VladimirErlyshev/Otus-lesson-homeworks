package ru.verlyshev.homeworks.lesson192;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> storage = new ArrayList<>();

    public void add(T fruit) {
        storage.add(fruit);
    }

    public int weight() {
        return storage.stream().map(Fruit::getWeight).reduce(0, Integer::sum);
    }

    public boolean compare(Box<?> box) {
        return this.weight() == box.weight();
    }

    public void shiftFruits(Box<? super T> srcBox) {
        srcBox.storage.addAll(this.storage);
        this.storage.clear();
    }
}
