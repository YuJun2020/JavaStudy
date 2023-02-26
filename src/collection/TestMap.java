package collection;

import java.util.*;

public class TestMap {
    public static void main(String[] args){
        List<String> list = Arrays.asList("A B C".split(" "));
        List<String> subList = list.subList(0, 1);
        //System.out.println(subList);
        //list.retainAll(subList);
        //list.add("1");

        ArrayList<String> newList = new ArrayList<>(list);
        newList.add("1");
        System.out.println(newList);
    }
}
class myMap extends AbstractMap<String, String> {
    @Override
    public Set<Entry<String, String>> entrySet() {
        return null;
    }
}
