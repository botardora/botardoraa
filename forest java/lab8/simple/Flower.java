package lab8.simple;
//import interface Plant;
import lab8.Plant;
public class Flower implements Plant{
    public double oxigenAmount = 5;
    public int lifetime = 2;
    public String repres = "F";


    @Override
    public double getOxigenAmountPerYear() {
        return oxigenAmount;
    }

    @Override
    public int getLifeTime() {
        return lifetime;
    }

    @Override
    public String getRepresentation() {
        return repres;
    }


}
