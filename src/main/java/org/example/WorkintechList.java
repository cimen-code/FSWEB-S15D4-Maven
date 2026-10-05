package org.example;

import java.util.ArrayList;
import java.util.Comparator;

public class WorkintechList extends ArrayList<Object> {

    @Override
    public boolean add(Object element) {

        if (contains(element)) {
            return false;
        }

        return super.add(element);
    }

    @Override
    public void add(int index, Object element) {

        if (!contains(element)) {
            super.add(index, element);
        }
    }

    public void sort() {

        super.sort(new Comparator<Object>() {
            @Override
            public int compare(Object first, Object second) {

                if (first == null && second == null) {
                    return 0;
                }

                if (first == null) {
                    return -1;
                }

                if (second == null) {
                    return 1;
                }

                if (first instanceof Number && second instanceof Number) {
                    double firstNumber = ((Number) first).doubleValue();
                    double secondNumber = ((Number) second).doubleValue();

                    return Double.compare(firstNumber, secondNumber);
                }

                return first.toString().compareTo(second.toString());
            }
        });
    }

    @Override
    public boolean remove(Object element) {

        boolean removed = super.remove(element);

        sort();

        return removed;
    }
}
