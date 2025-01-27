package interfaces;

import java.util.ArrayList;

public class ListDemo {

    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(10);

        int i = intList.get(0);
        int j = intList.get(1);
        System.out.println(i + j);
    }
}
