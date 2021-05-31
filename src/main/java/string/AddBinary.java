package string;

public class AddBinary {
    public static void main(String[] args) {
        AddBinary obj = new AddBinary();
        System.out.println(obj.addBinary("11", "1"));
        System.out.println(obj.addBinary("11", "11"));
        System.out.println(obj.addBinary("1", "111"));
        System.out.println(obj.addBinaryV2("11", "1"));
        System.out.println(obj.addBinaryV2("11", "11"));
        System.out.println(obj.addBinaryV2("1", "111"));
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = getValAtIndex(a, i--) + getValAtIndex(b, j--) + carry;
            carry = sum / 2;
            sb.append(sum % 2);
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }

    private int getValAtIndex(String s, int i) {
        return i >= 0 ? s.charAt(i) - '0' : 0;
    }

    public String addBinaryV2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int aValAtIndex = i >= 0 ? a.charAt(i--) - '0' : 0;
            int bValAtIndex = j >= 0 ? b.charAt(j--) - '0' : 0;
            sb.append(aValAtIndex ^ bValAtIndex ^ carry);
            carry = (aValAtIndex & bValAtIndex) | (aValAtIndex & carry) | (bValAtIndex & carry);
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
