package cn.neu.niuke.leetcode.arrayType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
	//twosum1  查询数组中是否存在两数之和 
	//最low的方法 暴力搜索时间复杂度为O(N^2)
	//简便方法时间复杂度为O(N) 扫描一遍  其实也可以先排序，但是要求返回位置索引索引不适合打乱原本顺序
    public static int[] twoSumI(int[] nums,int aim){
    	int[] result=new int[2];
    	HashMap<Integer,Integer> flag=new HashMap<Integer,Integer>();
    	for(int i=0;i<nums.length;i++){
    		if(!flag.containsKey(nums[i])){
    			if(flag.containsKey(aim-nums[i])){
    				result[0]=i;
    				result[1]=flag.get(aim-nums[i]);
    			}else
    			flag.put(nums[i], i);
    		}
    	}
    	System.out.println(result[0]+" "+result[1]);
    	return result;
    }
    //查询数组中是否存在三个数a、b、c使其a+b+c=target
    public static void twoSumII(int[] nums,int target){
    	//先排序，然后左右夹逼  时间复杂度为O（n^2）
    	List<List<Integer>> result=new ArrayList<>();
    	Arrays.sort(nums);
    	for(int i=0;i<nums.length-2;i++){
    		if (i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    ++j;
                    while(nums[j] == nums[j-1] && j < k) ++j;
                } else if(nums[i] + nums[j] + nums[k] > target) {
                    --k;
                    while(nums[k] == nums[k+1] && j < k) --k;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    ++j;//既然已经=target了，如果单独移动j或者k肯定都不会符合（除了存在相同数），所以两者一个+一个-
                    --k;
                    while(nums[j] == nums[j-1] && j < k) ++j;
                    while(nums[k] == nums[k+1] && j < k) --k;
                }
            }
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] nums={1,2,9,4,5,7};
        twoSumI(nums,6);
	}

}
