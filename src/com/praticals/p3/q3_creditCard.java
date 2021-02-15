package com.praticals.p3;
import java.util.Scanner;

public class q3_creditCard {
    public static boolean isCard(String cardNum){
//        digit length limit
        if (cardNum.length()<13 || cardNum.length()>16){return false;}
//        starter limit
        char firstNum = cardNum.charAt(0);
        switch (firstNum){
            case '4': case '5': case '6': break;
            case '3':
                if (cardNum.charAt(1)=='7'){break;}
            default:
                return false;
        }
//        luhn check
        return (luhn(cardNum, 0) + luhn(cardNum, 1)) % 10 == 0;
//        int evenSum = luhn(cardNum, 0), oddSum = luhn(cardNum, 1);
//        System.out.println(evenSum);
//        System.out.println(oddSum);
//        if ((evenSum+oddSum)%10 == 0){return true;}
    }

    public static int luhn(String cardNum, int reminder){
        int sum = 0;
        int starter = (reminder==0)?cardNum.length()-1:cardNum.length()-2;
        for(int i = starter; i>=0; i-=2){
            int digit = cardNum.charAt(i) - '0';
            if(reminder == 1){
                digit *= 2;
                digit = (digit < 10)?digit:(1+digit-10);
            }
            sum += digit;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true){
            String usrInput = scan.next();
            System.out.println(isCard(usrInput));
        }
    }
}
