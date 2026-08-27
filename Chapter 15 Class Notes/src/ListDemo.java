import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        // the addLast method can be used to populate a list
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Tony");
        staff.addLast("Steve");
        staff.addLast("Wanda");
        staff.addLast("Dr. Strange");

        System.out.println(staff);
        //The list is currently Tony, Steve, Wanda, Dr. Strange
        /*
            The listIterator method creates a new list iterator that is positioned at the head of the list.
            The | is used to represent the iterator position
         */
        ListIterator<String> iterator = staff.listIterator(); // |Tony, Steve, Wanda, Dr. Strange

        /* The next method advances the iterator over the next element in the list */
        iterator.next(); // Tony | Steve, Wanda, Dr. Strange
        
        /* The next method also returns the elemnet the iterator passes over */
        String avenger = iterator.next(); 
        System.out.println(avenger); // should print Steve

        /* The iterator add method isnerts an element at the iterator position
            The interator is then positioned AFTER the element that was added
         */
        iterator.add("Natasha"); // Tony, Steve, Natasha | Wanda, Dr. Strange
        iterator.add("Bruce"); // Tony, Steve, Natasha, Bruce | Wanda, Dr. Strange

        System.out.println(staff); 

        /* The remove method removes the element returned by the last call to next or previous
        The remove method can ONLY be called after calling next or previous
        The remove method CANNOT be called after calling add
         */
        iterator.next(); // Tony, Steve, Natasha, Bruce, Wanda | Dr. Strange
        iterator.remove(); // removes Wanda from the list -> Tony, Steve, Natasha, Bruce | Dr. Strange

        System.out.println(staff);

        /* The set method updates the element returned by the last call to next or previous */
        iterator.previous(); // Tony, Steve, Natasha | Bruce, Dr. Strange
        iterator.set("T'Challa"); // Tony, Steve, Natasha | T'Challa, Dr. Strange

        System.out.println(staff);

        /* The hasNext method is used to determine if there is a next node after the iterator. 
        The hasNext method is often used in the condition of a while loop 
        */
       iterator = staff.listIterator(); // |Tony, Steve, Natasha, T'Challa, Dr. Strange
       while (iterator.hasNext()){
        String n = iterator.next();
        if (n.equals("Natasha")){ //Tony, Steve, Natasha | T'Challa, Dr. Strange
            iterator.remove(); //Tony, Steve | T'Challa, Dr. Strange
        }
       }// Tony, Steve, T'Challa, Dr. Strange |
      

       /* Enhanced for loops work with linked lists 
          The enhanced for loop AUTOMATICALLY creates an iterator */
       for (String n : staff){
        System.out.println(n+" ");
       }

       /*
        ConcurrentModificationException

        CANNOT modify a linked list while using an iterator
        UNLESS you use the iterator to do the modification
       */

       iterator = staff.listIterator(); // |Tony, Steve, T'Challa, Dr. Strange
       while (iterator.hasNext()) {
            String n = iterator.next();
            if (n.equals("Tony")){
                //staff.remove("Tony"); CocurrentModificationException
            }
       }

       for (String n : staff){
        if (n.equals ("Tony")){
            staff.add("Peter");
        }
       }



    }
}