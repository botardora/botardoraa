package lab8;
import lab8.simple.*;
import lab8.composite.*;
public class Main {
    public static void main(String[] args) {
        Forest forest = new Forest();
        Field field1 = new Field();
        Field field2 = new Field();
        field1.add(new Grass());
        field1.add(new Flower());
        field2.add(new Mushroom());
        field2.add(new Mushroom());
        forest.add(field1);
        forest.add(field2);
        forest.add(new PineTree());
        forest.add(new OakTree());
        System.out.println(forest.getRepresentation());
        System.out.println(forest.getOxigenAmountPerYear());
        System.out.println(forest.getLifeTime());

    }
}