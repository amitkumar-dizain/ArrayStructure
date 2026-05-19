import java.util.*;

public class AdvanceArrayProblems {
    //array printer
    static void getPrinter(int[] resArr){
        for (int r : resArr){
            System.out.print(r + ", ");
        }
    }

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { nums[map.get(complement)], nums[i] };
            }
            map.put(nums[i] , i);
        }

        return  new int[] {};
    }
    //Three sum
    //Solution 1
    static List<List<Integer>> threeSum(int[] nums,int target){
        Set<List<Integer>> set = new HashSet<>();
        int comp = 0;
        for (int i = 0; i < nums.length; i++) {
            Map<Integer,Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                comp = target - nums[i] - nums[j];
                if (map.containsKey(comp)) {
                    List<Integer> threeSum = Arrays.asList(nums[i],nums[j],comp);
                    Collections.sort(threeSum);
                    set.add(threeSum);
                }
                map.put(nums[j],j );
            }
        }
        return new ArrayList<>(set);
    }

    //Solution 2
    static List<List<Integer>> bestThreeSum(int[] nums,int target){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //if(i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length-1;
            while(left < right){
                int sum =  nums[i] +  nums[left] + nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return  res;
    }

    //remove duplicates from sorted array
    static int removeSortedDuplicates(int[] nums) {
        int res = 0;
        int i = 0 ;
        for (int j = 1; j < nums.length ; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
                res++;
            }
        }
        return res + 1;
    }
    //removeDuplicates from sortes array
    public int removeDuplicates(int[] nums) {
        Set<Integer> res = new HashSet<>();
        for(int a : nums){
            res.add(a);
        }
        return res.size();
    }
    //find first repeating elements
    static int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i :  nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if(map.get(i) > 1){
               return i;
            }
        }
        return -1;
    }
    //Find Pivot index
    static int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        int res = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            map.put(i,leftSum);
        }
        for (int j = nums.length-1; j >= 0; j--) {
            rightSum += nums[j];
            if(map.containsValue(rightSum) && map.get(j)==rightSum){
                res = j;
            }
            map.put(j,rightSum);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-1,0,0,-1,-1};
        //int target = 4;
        //System.out.println(threeSum(nums, target));
        //System.out.println(bestThreeSum(nums,target));
        //System.out.println(removeSortedDuplicates(nums));
        //System.out.println(firstUniqueFreq(nums));
        System.out.println(pivotIndex(nums));

    }
}
