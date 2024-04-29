package ian;

import java.util.Arrays;

class Recursion {

    public int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public void reversePrint(String text) {
        if (text.isEmpty()) {
            return;
        }
        int lastIndex = text.length() - 1;
        System.out.println(text.charAt(lastIndex));
        reversePrint(text.substring(0, lastIndex));
    }

    public void sort(int[] nums) {
        sort(nums, nums.length);
    }

    private void sort(int[] num, int range) {
        if (range == 0) {
            return;
        }

        int r = 0;
        for (int i = 0; i < range - 1; i++) {
            if (num[i] > num[i + 1]) {
                int t = num[i + 1];
                num[i + 1] = num[i];
                num[i] = t;
                r = i;
            }
        }
        sort(num, r);
    }

    public int fibonacci(int n) {
        int[] cache = new int[n + 1];//避免重複計算
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;

        return fibonacciCalculate(n, cache);
    }

    private int fibonacciCalculate(int n, int[] cache) {
        if (cache[n] != -1) {
            return cache[n];
        }
        cache[n] = fibonacciCalculate(n - 1, cache) + fibonacciCalculate(n - 2, cache);
        return cache[n];
    }
}
