package hackerrank;

import java.util.List;

public class FindTheSmallestMissingPositiveInteger {

    public int findSmallestMissingPositive(List<Integer> orderNumbers) {
        if (orderNumbers.isEmpty() || orderNumbers.size() > 1000) {
            return 1;
        }

        int size = orderNumbers.size();
        for (int i = 0; i < size; i++) {
            int cur = orderNumbers.get(i);
            while (cur > 0 && cur <= size && cur != orderNumbers.get(cur - 1)) {
                int temp = orderNumbers.get(cur - 1);
                orderNumbers.set(i, temp);
                orderNumbers.set(cur - 1, cur);
            }
        }

        for (int i = 0; i < size; i++) {
            int cur = orderNumbers.get(i);
            if (cur != i + 1) {
                return i + 1;
            }
        }
        return size + 1;
    }
}
