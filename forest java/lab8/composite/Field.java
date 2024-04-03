package lab8.composite;
import lab8.Plant;

import java.util.*;

public class Field implements Plant{
    private HashSet<Plant> set;
    public Field(){
        set = new HashSet<>();
    }
    public void add(Plant plant){
        set.add(plant);
    }
    public void remove(Plant plant){
        set.remove(plant);
    }

    @Override
    public double getOxigenAmountPerYear() {
        double totalOxigen = 0;
        for (Plant plant : set)
            totalOxigen += plant.getOxigenAmountPerYear(); //osszeadjuk a novenyek oxigentermeleset
        return totalOxigen;
    }

    @Override
    public int getLifeTime() {
        int maxLife = 0;
        for (Plant plant : set)
            maxLife = Math.max(maxLife, plant.getLifeTime()); //maximum elettartam kivalasztasa az eltarolt ertek es az eppen meghivodo fuggveny kozul
        return maxLife;
    }
    @Override
    public String getRepresentation() {
        StringBuilder representation = new StringBuilder("["); //felepitunk egy stringet
        Iterator<Plant> iterator = set.iterator(); //ennek a segitsegevel megyunk vegig a hashseten
        while (iterator.hasNext()) {
            representation.append(iterator.next().getRepresentation());
            if (iterator.hasNext()) {
                representation.append(", "); //csak akkor ad hozza vesszot, ha van kovetkezo elem
            }
        }
        representation.append("]");
        return representation.toString();
    }
}
