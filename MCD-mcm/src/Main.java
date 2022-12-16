import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int mcdResult = mcd(45, 60);
        System.out.println(mcdResult);
        System.out.println(mcm(56,156));
    }

    private static int mcd(int n1, int n2) {
        List<Integer> div1 = divisors(n1);
        List<Integer> div2 = divisors(n2);
        return maxCommon(div1, div2);
    }

    private static int maxCommon(List<Integer> div1, List<Integer> div2) {
        for (int i = div1.size() - 1; i >= 0; i--) {
            int element1 = div1.get(i);
            for (int j = div2.size() - 1; j >= 0; j--) {
                if (element1 == div2.get(j)) {
                    return element1;
                }
            }
        }
        return 0;
    }

    private static Map<Integer, Integer> groupByPotency(List<Integer> decompose) {
        Map<Integer, Integer> set = new HashMap<>();
        decompose.forEach(e -> {
            if (set.containsKey(e)) {
                set.put(e, set.get(e) * e);
            } else {
                set.put(e, e);
            }
        });
        return set;
    }

    private static int mcm(int n1, int n2) {
        List<Integer> decompose1 = decompose(n1);
        List<Integer> decompose2 = decompose(n2);
        Map<Integer, Integer> commonsNoCommons =
                getCommonsAndNoCommonsGreaterPow(groupByPotency(decompose1), groupByPotency(decompose2));
        return calculate(commonsNoCommons);
    }

    private static int calculate(Map<Integer, Integer> selectedValues) {
        int result = 1;
        for (Integer value : selectedValues.values()) {
            result *= value;
        }
        return result;
    }

    private static Map<Integer, Integer> getCommonsAndNoCommonsGreaterPow(
            Map<Integer, Integer> set1, Map<Integer, Integer> set2) {

        Map<Integer, Integer> selectedValues = new HashMap<>();
        filterValues(set1, selectedValues);
        filterValues(set2, selectedValues);
        return selectedValues;
    }

    private static void filterValues(Map<Integer, Integer> values,
                                                      Map<Integer, Integer> selectedValues) {
        values.forEach((key, value) -> {
            if (!selectedValues.containsKey(key)) {
                selectedValues.put(key, value);
            } else {
                if (selectedValues.get(key) < value) {
                    selectedValues.put(key, value);
                }
            }
        });
    }


    private static List<Integer> decompose(int number) {
        if (number == 1) {
            return new ArrayList<>();
        }

        int divisor = 2;
        while (number % divisor != 0) {
            divisor++;
        }
        List<Integer> result = decompose(number / divisor);
        result.add(divisor);
        return result;
    }

    private static List<Integer> divisors(int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
