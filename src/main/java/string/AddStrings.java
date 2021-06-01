package string;

// leetcode 415  tags: Facebook
public class AddStrings {
    public static void main(String[] args) {
        AddStrings obj = new AddStrings();
        System.out.println(obj.addStrings("11", "123"));
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = getIntAtIndex(num1, i--) + getIntAtIndex(num2, j--) + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }

    private int getIntAtIndex(String s, int i) {
        return i >= 0 ? s.charAt(i)-'0' : 0;
    }
}
