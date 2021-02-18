import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class Exercise27_11 {

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("Smith");
        set.add("Anderson");
        set.add("Lewis");
        set.add("Cook");
        set.add("Smith");
        ArrayList<String> list = setToList(set);
        System.out.println(list);
    }

        public static <E> ArrayList<E> setToList(Set<E> s) {
        /*Insert your code here*/
            ArrayList<E> list = new ArrayList<>();
            for(E e: s){
                list.add(e);
            }
            return list;
    }
}

