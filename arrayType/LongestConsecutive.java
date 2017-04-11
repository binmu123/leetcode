package cn.neu.niuke.leetcode.arrayType;

import java.util.HashSet;

public class LongestConsecutive {
    //最长连续字符(原串位置不用连接)
	//如果没有时间复杂度要求，可以使用排序在查找，这样时间复杂度最低可以做到O(nlogn)
	//但是要求时间复杂度为O(N)这只能牺牲空间换取时间，使用hashset来标志访问的元素
	//然后在每一个元素往左和往右查找，看最长的长度。
	public static void longestConsecutive(int[] nums){
		HashSet<Integer> hash=new HashSet<Integer>();
		for(int i:nums)//标志
			hash.add(i);
		int longest=0;
		for(int i:nums){
			int length=1;
			for(int j=i-1;hash.contains(j);j--){//向左统计个数
				hash.remove(j);
				length++;
			}
			for(int j=i+1;hash.contains(j);j++){//向右统计个数
				hash.remove(j);
				length++;
			}
			longest=Math.max(longest,length);//记录最大长度
		}
		System.out.println(longest);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] nums={400,4,200,3,2,1,43,5};
        longestConsecutive(nums);
	}

}
