public class BitwiseProblems {

    //check the number is even or odd
    public static boolean checkEven(int n){
        if((n&1) == 0){
            System.out.println(n + " is Even");
            return true;
        }else{
            System.out.println(n + " is Odd");
            return false;
        }
    }

    //check is number is power of 2 or not
    //solution:1
    public static void idPowerTwoBrute(int n){
        int count = 0;
        while(n != 0){
            if((n&1)==1){
                count++;
            }
            n = n>>1;
        }
        if(count > 1){
            System.out.println(n + " is not Power of 2");
        }else{
            System.out.println(n + " is Power of 2");
        }
    }
    //solution:2
    public static void idPowerTwo(int n){
        if((n & (n-1)) == 0){
            System.out.println(n + " is Power of 2");
        }else{
            System.out.println(n + " is not Power of 2");
        }
    }

    //swap two numbers using XOR
    public static void swap(int a, int b){
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a + " a is Swapped");
        System.out.println(b + " b is Swapped");
    }


    public static void main(String[] args) {
        //checkEven(6);
        //idPowerTwo(8);
        //swap(4,5);
    }
}
