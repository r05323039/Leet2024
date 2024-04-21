package ian;

public class Recursion {

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
}
