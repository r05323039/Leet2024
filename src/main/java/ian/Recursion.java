package ian;

public class Recursion {

    public int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public void reversePrint(String text) {
        if(text.isEmpty()){
            return;
        }
        int lastIndex = text.length() - 1;
        System.out.println(text.charAt(lastIndex));
        reversePrint(text.substring(0, lastIndex));
    }
}
