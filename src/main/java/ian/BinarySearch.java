package ian;

public class BinarySearch {

    public int basic(int[] nums, int target) {
        // 704
        int leftIndex = 0;
        int rightIndex = nums.length;

        while (leftIndex < rightIndex) {
            int middle = leftIndex / 2 + rightIndex / 2;
            if (target < nums[middle]) {
                rightIndex = middle;
            } else if (nums[middle] < target) {
                leftIndex = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public int basicRecursion(int[] nums, int target) {
        return basicRecursion(nums, target, 0, nums.length);
    }

    private int basicRecursion(int[] nums, int target, int left, int right) {
        if (left >= right) {
            return -1;
        }

        int middle = left + right >>> 1;

        if (target < nums[middle]) {
            return basicRecursion(nums, target, left, middle);
        } else if (nums[middle] < target) {
            return basicRecursion(nums, target, middle + 1, right);
        } else {
            return middle;
        }
    }

    public int searchInsert(int[] nums, int target) {
        // 35
        int leftIndex = 0;
        int rightIndex = nums.length;

        while (leftIndex < rightIndex) {
            int middle = leftIndex / 2 + rightIndex / 2;
            if (target < nums[middle]) {
                rightIndex = middle;
            } else if (nums[middle] < target) {
                leftIndex = middle + 1;
            } else {
                return middle;
            }
        }
        return leftIndex;
    }

    public int[] searchRange(int[] nums, int target) {
        // 34
        int rightIndex = rightMost(nums, target);
        int leftIndex = leftMost(nums, target);
        int[] result = new int[2];
        result[0] = leftIndex;
        result[1] = rightIndex;
        return result;
    }

    private int rightMost(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int result = -1;
        while (leftIndex <= rightIndex) {
            int middle = (leftIndex + rightIndex) >>> 1;
            if (nums[middle] < target) {
                leftIndex = middle + 1;
            } else if (target < nums[middle]) {
                rightIndex = middle - 1;
            } else {
                result = middle;
                leftIndex = middle + 1;
            }
        }
        return result;
    }

    private int leftMost(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int result = -1;
        while (leftIndex <= rightIndex) {
            int middle = (leftIndex + rightIndex) >>> 1;
            if (nums[middle] < target) {
                leftIndex = middle + 1;
            } else if (target < nums[middle]) {
                rightIndex = middle - 1;
            } else {
                result = middle;
                rightIndex = middle - 1;
            }
        }
        return result;
    }
}
