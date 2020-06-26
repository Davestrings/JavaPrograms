package recursion;

public class Power {
    public static int power(int base, int exponent) {
        int a = 1;

        if(exponent == 1) {
            return a * base;
        }else if(exponent == 0){
            return 1;
        }else {
            return (a *= base) * power(base, exponent-1);
        }
    }
    public static  int efficientPower(int base, int exponent){
        if(exponent !=0){
            return base * efficientPower(base, exponent-1);
        }else
            return 1;
    }
}
