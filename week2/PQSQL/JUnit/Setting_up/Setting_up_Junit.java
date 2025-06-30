package info;
import java.util.ArrayList;
import java.util.Iterator;

public class Iterator_demo {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }
}

