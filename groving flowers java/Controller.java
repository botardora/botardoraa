import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Virag> viragok;

    public Controller(int viragSzam, int maxMeret) {
        viragok = new ArrayList<>();
        for (int i = 0; i < viragSzam; i++) {
            viragok.add(new Virag(maxMeret));
        }
    }

    public List<Virag> getViragok() {
        return viragok;
    }

    public void novekedes() {
        for (Virag virag : viragok) {
            virag.novel();
        }
    }
}


