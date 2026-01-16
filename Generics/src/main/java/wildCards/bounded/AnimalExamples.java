package wildCards.bounded;

import java.util.ArrayList;
import java.util.List;

public class AnimalExamples {

    public static void main(String[] args) {

        Dog dog1 = new Dog();
        Cat cat1 = new Cat();

        //Arrays work in the following way
        Dog[] dogsArray = { dog1 };
        Cat[] catsArray = { cat1 };

        checkAnimal(dogsArray); // this is fine we can pass an array of dog to animal
        checkAnimal(catsArray); // this too is fine

        //arrays are fine as there is no type erasure

        //-------------------------------------------------

        //You can add dogs and cats to a collection
        List<Animal> animals = new ArrayList<>();
        animals.add(dog1);
        animals.add(cat1);

        // this works fine as the compiler is happy knowing that within the method checkAnimalGen
        // you could add anything as long as it was an animal
        checkAnimalGen(animals);

        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog1);

        //checkAnimalGen(dogGen);  required List<Animal> not List<Dog>. Issues in case of adding
        checkAnimalGenSafe(animals); // works as usual
        checkAnimalGenSafe(dogs); // now works

        checkAnimalGenSafeAnimalAdd(animals);
        //checkAnimalGenSafeAnimalAdd(dogList);  nope, trying to add something lower than animal

        checkAnimalGenSafeDogAdd(animals);
        checkAnimalGenSafeDogAdd(dogs); // now safe to do
    }

    // only accessing here, no inserting
    private static void checkAnimal(Animal[] animals){
        for(Animal a: animals){
            a.checkup();
        }
    }

    private static void checkAnimalGen(List<Animal> animals) {
        for(Animal a: animals){
            a.checkup();
        }
    }

    // ? extends Animal lets the compiler know you wont be putting anything in the collection
    // and so you can pass in anything that extends Animal as it will be a safe get.
    private static void checkAnimalGenSafe(List<? extends Animal> animals) {
        for(Animal a: animals){
            a.checkup();
        }
    }

    private static void checkAnimalGenAdd(List<? extends Animal> animals) {
        //animals.add(new Dog());  compiler error as you are trying to add to this collection
    }

    private static void checkAnimalGenSafeAnimalAdd(List<? super Animal> animals) {
        //this is fine as you can add a dog to a list of animals
        //and you can only pass in List<Animal> or higher
        animals.add(new Dog());
    }

    private static void checkAnimalGenSafeDogAdd(List<? super Dog> animals) {
        //this is fine as you can add a dog to a list of dogs
        animals.add(new Dog());
    }
}
