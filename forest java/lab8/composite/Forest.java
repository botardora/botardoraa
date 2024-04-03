package lab8.composite;
import lab8.Plant;

import java.util.ArrayList;
import java.util.Iterator;

public class Forest implements Plant{
    private ArrayList<Plant> list;
    public Forest(){
        list = new ArrayList<>();
    }
    public void add(Plant plant){
        list.add(plant);
    }
    public void remove(Plant plant){
        list.remove(plant);
    }

    @Override
    public double getOxigenAmountPerYear() {
        double totalOxigen = 0;
        for (Plant plant : list)
            totalOxigen += plant.getOxigenAmountPerYear(); //osszeadjuk a novenyek oxigentermeleset
        return totalOxigen;
    }

    @Override
    public int getLifeTime() {
        int maxLife = 0;
        for (Plant plant : list)
            maxLife = Math.max(maxLife, plant.getLifeTime()); //maximum elettartam kivalasztasa az eltarolt ertek es az eppen meghivodo fuggveny kozul
        return maxLife;
    }

    @Override
    public String getRepresentation() {
        StringBuilder representation = new StringBuilder("{");
        Iterator<Plant> iterator = list.iterator();
        while (iterator.hasNext()) {
            representation.append(iterator.next().getRepresentation());
            if (iterator.hasNext()) {
                representation.append(", ");
            }
        }
        representation.append("}");
        return representation.toString();
    }
}
