package rfe.bsu.laba1;

import java.util.Objects;

public class Milk extends Food{

    protected String fat = null;

    public Milk(String name, double colories, String fat) {
        super(name, colories);
        this.fat = fat;
    }

    public Milk(String name, String fat) {
        super(name);
        this.fat = fat;
        this.colories = calculateCalories();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Milk)) return false;
        if (!super.equals(o)) return false;
        Milk milk = (Milk) o;
        return Objects.equals(fat, milk.fat);
    }

    @Override
    public String toString() {
        return "Milk{" +
                "fat='" + fat + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int calculateCalories() {
        return (fat.length() * 100);
    }
}
