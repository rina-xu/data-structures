import java.util.LinkedList;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        LinkedList<String> reversed = new LinkedList<>();
        while (!strings.isEmpty()) {
            reversed.addLast(strings.removeLast());
        }
        for (String s : reversed) {
            strings.addLast(s);
        }
    }
}