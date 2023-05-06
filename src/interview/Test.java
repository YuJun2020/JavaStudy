package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {

        aaa params = new aaa() {
            @Override
            public void run() {
                System.out.println("Anonymous Internal Class: ");
            }
        };

        aaa params1 = () -> System.out.println("Lambda: ");

        params.run();
        params1.run();
    }

    interface aaa {
        void run();
    }
}
