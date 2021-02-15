package com.praticals.p3;

public class q1_prime10 {
    public static void main(String[] args) {
        int primeCount=0, current = 0;
        while(primeCount < 10) {
            if(isPrime(current)){
                System.out.print(current+", ");
                primeCount ++;
            }
            current ++;
        }
    }

    public static boolean isPrime(int number){
        int small=2;
        if (number <= 1){
            return false;
        }
        while(small <= number/2){
            if (number % small == 0){
                return false;
            }
            small ++;
        }
        return true;
    }
}
