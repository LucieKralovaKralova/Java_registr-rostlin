import java.time.LocalDate;
import java.util.List;

public class Main {
    public static final String FILENAME = "kvetiny.txt";
    public static void main(String[] args) throws PlantException {

        RegisterOfPlants register = new RegisterOfPlants();
        try {
            register.readPlantsFromFile(FILENAME);
        } catch (PlantException e){
            System.err.println("Chyba při čtení souboru: "+e.getLocalizedMessage());
        }

        System.out.println("Informace o zálivce: ");
        for (Plant plant: register.plantList){
            System.out.println(plant.getWateringInfo());
        }

        register.plantList.remove(2);
        register.addPlant(new Plant("Bazalka v kuchyni","", 3, LocalDate.of(2021,9, 4), LocalDate.of(2021, 9, 4)));
        System.out.println("Výpis květin: ");
        List<Plant>plants = register.getPlants();
        System.out.println(plants);



    }

}