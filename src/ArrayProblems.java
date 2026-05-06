import java.util.HashMap;
import java.util.Map;

public class ArrayProblems {

    //array printer
    static void getPrinter(int[] resArr){
        for (int r : resArr){
            System.out.print(r + ", ");
        }
    }
    //Find the average of array elements
    static double getAverage(int[] arr){
        double sum = 0;
        for (int n : arr){
            sum += n ;
        }
        int size = arr.length;
        return sum / size;
    }

    //Multiply each element of array by 10
    static int[] getMultiplyArr(int[] arr){
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i] * 10;
        }
        return res;
    }

    //search for an element in an array linear search
    static boolean getElement(int[] arr, int target) {
        boolean b = false;
        for (int i : arr) {
            b = i == target;
        }
        return b;
    }

    //get maximum element in array
    static int getMaxi(int[] arr){
        int max = arr[0];
        for (int i : arr) {
            if (max < i){
                max = i;
            }
        }
        return max;
    }
    //get maximum element in array
    static int getMaxiByMath(int[] arr){
        int max = arr[0];
        for (int m : arr){
            max = Math.max(max, m);
        }
        return max;
    }

    //return sum of +Ve and -Ve sum
    static int []  getPositiveAndNegativeSum(int[] arr){
        int pos = 0;
        int neg = 0;
        for (int r : arr){
            if (r > 0){
                pos += r;
            }else{
                neg += r;
            }
        }
        return new int[]{pos, neg};
    }

    //count of zeros and one
    static int[] getZeroOneCount(int [] arr){
        int zero = 0;
        int one = 0;
        for (int a : arr){
            if (a == 0){
                zero++;
            }else if (a == 1){
                one++;
            }
        }
        return new int[]{zero, one};
    }

    //find the first unsorted element in sorted array
    static int getFirstElement(int[] arr){
        int curr = arr[0];
        for (int a : arr){
            if(curr <= a){
                curr = a;
            }else{
                return a;
            }
        }
        return -1;
    }

    //swap alternative element in an array
    static int[] getAlternative(int[] arr){
        int size = arr.length;
        for (int i = 1; i < size; i+=2) {
            int temp = arr[i-1];
            arr[i-1] =  arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    //print array of intersection element between two array
//    static int[] getInterSectionElement(int[] arr1 , int[] arr2){
//
//    }

    //print alternative extreme element of an array
    static int[] getExtreme(int[] arr) {
        int size = arr.length;
        int[] res = new int[size];
        int i = 0, j = size-1, p = 0;
        while(i < j){

            res[p++] = arr[i++];
            res[p++] = arr[j--];
        }
        if (i == j) {
            res[p] = arr[i];
        }
        return res;
    }

    //reverse an array
    static int[] reverseArray(int[] arr){
        int size = arr.length;
        int i = 0, j = size - 1;
        while (i < j){
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
        return arr;
    }

    //shift array element one position
    static int[] shiftBy1(int[] arr){
        int size = arr.length;
        int temp = arr[size - 1];
        for (int a = size - 1; a > 0; a--) {
            arr[a] = arr[a-1];
        }
        arr[0] = temp;
        return arr;
    }

    //print mode of an array
    static  int getMode(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        for (int a : arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int max = -1;
        int res = -1;

        for(Map.Entry<Integer,Integer> en : map.entrySet()){
            int val =  en.getValue();
            if(max < val){
                max = val;
                res = en.getKey();
            }
        }
        return res;
    }

    //print mode of an array
    static  void getHighLowestFreq(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        for (int a : arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int max = Integer.MIN_VALUE;
        int maxRes = 0;
        int min = Integer.MAX_VALUE;
        int minRes = 0;
        for(Map.Entry<Integer,Integer> en : map.entrySet()){
            int val =  en.getValue();
            if(max < val){
                max = val;
                maxRes = en.getKey();
            }
            if(min > val){
                min = val;
                minRes = en.getKey();
            }
        }
        System.out.println("Maximum frequency: " + maxRes);
        System.out.println("Lowest frequency: " + minRes);
    }

    //sort an array of 0 and 1
    static int[] getSortedZeroOne(int[] arr){
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            if (arr[i] == 0){
                i++;
            }else if(arr[j] == 1){
                j--;
            }else if(arr[i] == 1 && arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,1,1,0,0,1};
        getPrinter(getSortedZeroOne(arr));
    }
}
