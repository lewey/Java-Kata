package lists.linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListExample {
    public static void main(String args[]){
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.add("Item1");
        linkedList.add("Item5");
        linkedList.add("Item3");
        linkedList.add("Item6");
        linkedList.add("Item2");

        ListIterator<String> listIterator = linkedList.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }

        System.out.println();

        // adding at the front and back
        linkedList.addFirst("firstItem");
        linkedList.addLast("lastItem");

        for(String listItem: linkedList){
            System.out.println(listItem);
        }

        System.out.println();

        //getting and setting
        System.out.println(linkedList.get(1));

        linkedList.set(1,"new second item");
        System.out.println(linkedList.get(1));

        //removing
        linkedList.removeFirst();
        linkedList.removeLast();

        System.out.println();

        for(String listItem: linkedList){
            System.out.println(listItem);
        }

        // remove at a set position
        linkedList.remove(2);
    }
}
