package math;

public class MaxSwap {

    public static void main(String[] args) {
        MaxSwap obj = new MaxSwap();
        System.out.println(obj.maximumSwap(98368));
    }

    public int maximumSwap(int num) {
        int input = num;
        int base = 1;
        int maxBase = 0;
        int max = -1;
        int delta = 0;
        while (num > 0) {
            int digit = num % 10;
            num = num / 10;
            if (digit > max) {
                max = digit;
                maxBase = base;
            } else if(digit < max){
                delta = (base - maxBase) * (max - digit);
            }
            base = base * 10;
        }
        return input + delta;

    }
}
