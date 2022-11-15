import java.util.ArrayList;
import java.util.List;

public class RegisterOfPlants {
    public List<Plant> plantList = new ArrayList<>();

    public void addPlant (Plant newPlant) { plantList.add(newPlant);}

    public void removePlant(Plant plant) { plantList.remove(plant);}

    public List<Plant> getPlants() {
        return new ArrayList<>(plantList);
    }

}

