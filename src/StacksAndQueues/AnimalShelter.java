package StacksAndQueues;

import StacksAndQueues.AnimalShelter.Shelter.Dog;

import CtCILibrary.MyGenericLinkedList;

public class AnimalShelter {

    public static class Shelter {
        private MyGenericLinkedList<AnimalContainer> dogs = new MyGenericLinkedList<>();
        private MyGenericLinkedList<AnimalContainer> cats = new MyGenericLinkedList<>();
        private MyGenericLinkedList<Animal> animals = new MyGenericLinkedList<>();

        public void enqueue(Animal a) {
            MyGenericLinkedList.LinkedListNode<Animal> pointer = animals.add(a);
            AnimalContainer animalContainer = new AnimalContainer(a, pointer);
            if (a instanceof Cat) {
                cats.add(animalContainer);
            } else if (a instanceof Dog) {
                dogs.add(animalContainer);
            }
        }

        public Dog dequeueDog() {
            AnimalContainer dogContainer = dogs.removeFirst();
            animals.removeNode(dogContainer.pointer);
            return (Dog) dogContainer.a;
        }

        public Cat dequeueCat() {
            AnimalContainer catContainer = cats.removeFirst();
            animals.removeNode(catContainer.pointer);
            return (Cat) catContainer.a;
        }

        public Animal dequeueAny() {
            Animal animal = animals.removeFirst();
            if (animal instanceof Cat) {
                cats.removeFirst();
            } else {
                dogs.removeFirst();
            }
            return animal;
        }

        public abstract static class Animal { String name;
            public Animal(String name) {
                this.name = name;
            }
        }
        public static class Dog extends Animal {
            public Dog(String name) {
                super(name);
            }
        };
        public static class Cat extends Animal {
            public Cat(String name) {
                super(name);
            }
        };
        private static class AnimalContainer {
            Animal a;
            MyGenericLinkedList.LinkedListNode<Animal> pointer;
            public AnimalContainer(Animal a, MyGenericLinkedList.LinkedListNode<Animal> pointer) {
                this.a = a;
                this.pointer = pointer;
            }
        }
    }

    public static void main(String[] args) {
        Dog ury = new Dog("Ury");
        Dog sam = new Dog("Sam");
        Shelter.Cat luna = new Shelter.Cat("Luna");
        Dog felipe = new Dog("felipe");

        Shelter shelter = new Shelter();
        shelter.enqueue(felipe);
        shelter.enqueue(luna);
        shelter.enqueue(sam);
        shelter.enqueue(ury);

        System.out.println(shelter.dequeueAny().name);
        System.out.println(shelter.dequeueCat().name);
        System.out.println(shelter.dequeueDog().name);
        System.out.println(shelter.dequeueAny().name);
    }
}
