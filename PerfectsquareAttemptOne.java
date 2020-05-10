/*So, we can conclude, a number cannot be an exact or perfect square if:

-        it ends in 2, 3,7 or 8

-        it terminates in an odd number of zeros

-        its last digit is 6 but its penultimate (tens) digit is even

-        its last digit is not 6 but its penultimate (tens) digit is odd

-        its last digit is 5 but its penultimate (tens) digit is other than 2

-        its last 2 digits are not divisible by 4 if it is even numbe */
class Solution {
    public boolean isPerfectSquare(int num) {
        int lastdigit = num%10;
        int lastBeforeDigit = getTenthPlaceDigit(num);
        boolean isNotPerfect = (lastdigit == 2 || lastdigit == 3 || lastdigit == 7 || lastdigit == 8);
        if(isNotPerfect) {
            System.out.println("Condition 1");
            return false;
        }
        int digitalRoot = (num - 1) % 9 + 1;
        isNotPerfect = !(digitalRoot == 1 || digitalRoot == 4 || digitalRoot == 7 || digitalRoot == 9);
        if(isNotPerfect) {
            System.out.println("Condition 2");
            return false;    
        }
        isNotPerfect = (lastdigit == 6) && ((lastBeforeDigit & 1) == 0);
        if(isNotPerfect) {
            System.out.println("Condition 3");
            return false;
        }
        isNotPerfect = (lastdigit != 6) && ((lastBeforeDigit & 1) != 0);
        if(isNotPerfect) {
            System.out.println("Condition 4");
            return false;
        }
        isNotPerfect = (lastdigit == 5) && (lastBeforeDigit != 2);
        if(isNotPerfect) {
            System.out.println("Condition 5");
            return false;
        }
        int l = getLastTwoDigit(lastdigit, lastBeforeDigit);
        isNotPerfect = (l % 4 != 0) && ((l & 1) == 0);
        if(isNotPerfect) {
            System.out.println("Condition 6");
            return false;
        }
        int noOfZeros = numOfZeros(num, 0);
        isNotPerfect = ((noOfZeros & 1) != 0);
        if(isNotPerfect) {
            System.out.println("Condition 7");
            return false;    
        }
        return true;
        
    }
    
    private int numOfZeros(int n, int count) {
        if(n == 0) {
            return 1;
        }
        if(n % 10 != 0) {
            return count;
        }
        return numOfZeros(n/10, count+1);
    }
    
    private int getTenthPlaceDigit(int n) {
        n = n/10;
        return n%10;
    }
    
    private int getLastTwoDigit(int lastDigit, int lastBeforeDigit) {
        return (lastBeforeDigit*10) + lastDigit;
    }
}
