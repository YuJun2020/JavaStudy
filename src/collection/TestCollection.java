package collection;


import java.util.*;

public class TestCollection {
    public static void main(String[] args){
        Collection<String>collection = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        Comparator<String> caseInsensitiveOrder = String.CASE_INSENSITIVE_ORDER;
        Queue<String> strings1 = new LinkedList<>();

    }


}

class Gerbil{
    private int gerbilNumber;
    public Gerbil (int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    @Override
    public String toString() {
        return "Gerbil{" +
                "gerbilNumber=" + gerbilNumber +
                '}';
    }

    public void hop(){System.out.println("沙鼠" + this.gerbilNumber + "正在跳跃...");

    }
}