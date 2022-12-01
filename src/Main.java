import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

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


        System.out.println("ŘAZENÍ ROSTLIN:");
        // plants.sort(Comparator.reverseOrder());
        // plants.sort(Plant::compareTo);
        Collections.sort(plants);
        plants.forEach(c -> System.out.println(c.getName()));
        Collections.sort(plants, new PlantComparator());
        plants.forEach(c -> System.out.println(c.getWatering()+" "+c.getName()));

        System.out.println("ANALÝZA:");
        Set<Plant> plantSet = new HashSet<>(plants);
        System.out.println("* Kdy byli vysazeny nějaké květiny:");
        plantSet.forEach(plant -> System.out.println(plant.getPlanted()+" "+plant.getName()));

        System.out.println("Byla nějaká rostlina vysazena v posledním měsíci?");
        for (Plant plant: register.plantList){
            System.out.println(plant.datePlantedInThisMonth());
        }


    }

}