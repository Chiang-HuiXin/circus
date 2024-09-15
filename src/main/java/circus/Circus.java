package circus;

import circus.animal.*;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

import static circus.animal.Animal.AnimalNameComparator;


public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("Number of animals in the array: " + animals.length);
        //animals[3] = new Elephant("Eli"); this doesn't work
        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));

        printAllAnimals(animalArrayList);
        printNumberOfAnimals("Size of our animal arraylist" + animalArrayList.size());

        Elephant strongOne = new Elephant("Strong One");
        animalArrayList.add(strongOne);

        printAllAnimals(animalArrayList);

        System.out.println("size of our animal arraylist: " + animalArrayList.size());

        System.out.println("StrongOne is in the position: " + (animalArrayList.indexOf(strongOne) + 1));

        animalArrayList.sort(AnimalNameComparator);
        printAllAnimals(animalArrayList);

        //makeAnimalsTalk();
        //System.out.println("Total value of animals " + calculateAssetValue(animals));
        //System.out.println("Total value of equipments " + calculateAssetValue(equipments));
    }

    private static void printNumberOfAnimals(String animalArrayList) {
        System.out.println(animalArrayList);
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for(Animal a : animalArrayList) {
            System.out.println(a);
        }
    }
}
