package binarySearch;

import java.util.ArrayList;
import java.util.List;

// leetcode 29  tags: Facebook
public class DivideIntegers {

    private static int HALF_INT_MIN = -1073741824;
    public int divide(int dividend, int divisor) {
        int quotient = 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isNeg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        while(dividend<=divisor){
            // dividend -= divisor;
            // quotient += isNeg ? -1: 1;
            int powerOfTwo = 1;
            int value = divisor;
            while(value >= HALF_INT_MIN && value+value>=dividend){
                value += value;
                powerOfTwo += powerOfTwo;
            }
            dividend -= value;
            quotient += isNeg ? -powerOfTwo: powerOfTwo;
        }
        return quotient;
    }

    // with saving powers
    public int divideV2(int dividendI, int divisorI) {
        int quotient = 0;
        if (dividendI == Integer.MIN_VALUE && divisorI == -1) {
            return Integer.MAX_VALUE;
        }
        long dividend = dividendI;
        long divisor = divisorI;
        boolean isNeg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        dividend = dividend < 0 ? -dividend : dividend;
        divisor = divisor < 0 ? -divisor : divisor;
        List<Long> multiples = new ArrayList<>();
        List<Long> quotients = new ArrayList<>();
        long currentMultiple = divisor;
        long currentQuotient = 1;
        while(dividend >= currentMultiple){
            quotients.add(currentQuotient);
            multiples.add(currentMultiple);
            currentMultiple += currentMultiple;
            currentQuotient += currentQuotient;
        }
        for(int i=multiples.size()-1;i>=0;i--){
            if(dividend >= multiples.get(i)){
                dividend -= multiples.get(i);
                quotient += quotients.get(i);
            }
            if(dividend<divisor) break;
        }

        return isNeg ? -quotient: quotient;
    }

    // right shift
    public int divideV3(int dividendI, int divisorI) {
        int quotient = 0;
        if (dividendI == Integer.MIN_VALUE && divisorI == -1) {
            return Integer.MAX_VALUE;
        }
        long dividend = dividendI;
        long divisor = divisorI;
        boolean isNeg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        dividend = dividend < 0 ? -dividend : dividend;
        divisor = divisor < 0 ? -divisor : divisor;
        long multiple = divisor;
        long powerOfTwo = 1;
        while(dividend >= multiple){
            multiple += multiple;
            powerOfTwo += powerOfTwo;
        }
        while(multiple>=divisor){
            if(dividend >= multiple){
                dividend -= multiple;
                quotient += powerOfTwo;
            }
            if(dividend<divisor) break;
            multiple = multiple >> 1;
            powerOfTwo = powerOfTwo >> 1;
        }

        return isNeg ? -quotient: quotient;
    }
}
