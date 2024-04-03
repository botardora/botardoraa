import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
public class Virag {
    private int aktualisMeret;
    private int maxMeret;
    private Random random;
    private List<Color> szirmok;

    public Virag(int maxMeret) {
        this.maxMeret = maxMeret;
        this.random = new Random();
        this.aktualisMeret = 1;
        this.szirmok = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            szirmok.add(Color.PINK); //szirmok hozzaadasa
        }
    }

    public int getAktualisMeret() {
        return aktualisMeret;
    }

    public int getMaxMeret() {
        return maxMeret;
    }
    public List<Color> getSzirmok() {
        return szirmok;
    }

    public void novel() {
        if (aktualisMeret < maxMeret) {
            int novelmeny = random.nextInt(3); // Véletlenszerű növekedés
            aktualisMeret += novelmeny;
            if (aktualisMeret > maxMeret) {
                aktualisMeret = maxMeret;
            }
        }
    }
}

