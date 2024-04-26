package ian;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MergeSortedArray88 extends ListNode {
    public MergeSortedArray88(int val, ListNode next) {
        super(val, next);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, p3 = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p3] = nums1[p1];
                p1--;
            } else {
                nums1[p3] = nums2[p2];
                p2--;
            }
            p3--;
        }

        if (p1 < 0) {
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
        if (p2 < 0) {
            System.arraycopy(nums1, 0, nums1, 0, p1 + 1);
        }
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] n2 = new int[]{2, 5, 6};
        for (int i : n1) {
            System.out.print(i + " ");
        }
        merge(n1, 3, n2, 3);
        System.out.println();
        for (int i : n1) {
            System.out.print(i + " ");
        }
        assertTrue(Arrays.equals(n1, new int[]{1, 2, 2, 3, 5, 6}));
    }
}
