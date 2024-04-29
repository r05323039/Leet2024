package ian;

import org.junit.jupiter.api.Assertions;

import java.util.List;

public class Triangle120 extends TestModel {

    Integer[][] memory;

    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        memory = new Integer[len][len];
        return minimumTotal(triangle, 0, 0);
    }

    private int minimumTotal(List<List<Integer>> triangle, int row, int column) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(column);
        }

        if (memory[row][column] != null) {
            return memory[row][column];
        }

        Integer value = triangle.get(row).get(column);

        int left = minimumTotal(triangle, row + 1, column);
        int right = minimumTotal(triangle, row + 1, column + 1);

        memory[row][column] = value + Math.min(left, right);
        
        return memory[row][column];
    }

    public static void main(String[] args) {
        Triangle120 instance = new Triangle120();
        List<List<Integer>> l1 = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
        );

        Assertions.assertEquals(11, instance.minimumTotal(l1));

        List<List<Integer>> l2 = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 9),
                List.of(4, 4, 8, 0)
        );
        Assertions.assertEquals(14, instance.minimumTotal(l2));

    }
}
