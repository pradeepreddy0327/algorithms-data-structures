package leetcode;

public class WaterJugProblem {

	
	// leetcode problem : 365
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canMeasureWater(int x, int y, int z) {
        int a = Math.min(x,y);
        int b = Math.max(x,y);
        return z==0 || (a+b>=z && z%gcd(b,a)==0);
    }
    
    int gcd(int a, int b){
        return b == 0?a:gcd(b,a%b);
    }
}
