import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Plant implements Comparable <Plant> {
    private String name;            // Název rostliny
    private String notes;           // poznámka
    private LocalDate planted;     // Kdy byla rostlina vysazena
    private LocalDate watering;     // Datum poslední zálivky
    private int frequencyOfWatering;   // Frekvence zálivky ve dnech



    // KONSTRUKTORY
    public Plant(String name, String notes, int frequencyOfWatering, LocalDate planted, LocalDate watering) throws PlantException {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        setWatering(watering);
        setFrequencyOfWatering(frequencyOfWatering);
    }

    public Plant(String name, int frequencyOfWatering, LocalDate planted) throws PlantException {
        this.name = name;
        this.notes = null;
        this.planted = planted;
        this.watering = LocalDate.now();
        setFrequencyOfWatering(frequencyOfWatering);
    }

    public Plant(String name) {
        this.name = name;
        this.notes = null;
        this.planted = LocalDate.now();
        this.watering = LocalDate.now();
        this.frequencyOfWatering = 7;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering) throws PlantException {
        if (watering.isBefore(planted)) {
            throw new PlantException("Zadali jste nesprávné datum  - poslední zálivka nemůže být před datumem vysazení rostliny!!!");
        }
        this.watering = watering;
    }

    public int getFrequencyOfWatering() throws PlantException {
        if (frequencyOfWatering <= 0) {
            throw new PlantException("Nesprávná hodnota frekvence zálivky, zadali jste: " + frequencyOfWatering);
        }
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) {
        this.frequencyOfWatering = frequencyOfWatering;
    }

    @Override
    public String toString() {
        return name + '\t' +
                " - poznámka: '" + notes + '\'' +
                " ,vysazena: " + planted +
                " ,poslední zálivka: " + watering +
                " ,frekvence zálivky: " + frequencyOfWatering + " dny" + '}' +
                '\n';
    }

    // METODA PRO VÝPIS TEXTOVÉHO ŘETĚZCE, která vrátí název květiny, datum poslední zálivky a datum doporučené další zálivky

    public String getWateringInfo() {
        return name + '\t'
                + " poslední zálivka: " + watering +
                ", další zálivka: " + frequencyOfWatering +
                '}';
    }



    // ŘAZENÍ PODLE JMÉNA
    public int compareTo(Plant plant2) {
        int compareNames =
                this.getName().compareTo(plant2.getName());
        return compareNames;
    }

    // METODA PRO URČENÍ,ZDA BYLA ROSTLINA VYSAZENA V UPLYNULÉM POSLEDNÍM MĚSÍCI
    public String datePlantedInThisMonth() {
        LocalDate datePlanted = this.planted;
        LocalDate today = LocalDate.now();
        String isBetween = "";
        if (ChronoUnit.MONTHS.between(datePlanted, today) < 1) {
            isBetween = "JE";
        } else {
            isBetween = "NENÍ";
        }
        return  datePlanted + " " + isBetween
                        + " vysazena v uplynulém posledním měsíci! ("+getName()+")";

    }

}


