package InsertSort;
import java.util.Scanner;
public class InsertSort {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("请输入数字：");
        String input=in.nextLine();
        String[] arry=input.split(",");
        int[] nums=new int[arry.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(arry[i]);
        }
        InsertSort(nums);
        for(int s:nums){
            System.out.println(s);
        }
    }
    public static void InsertSort(int[] nums) {
        for(int i=1;i<nums.length;i++){
            int j=i-1;
            int standardNumber=nums[i];
            while(j>=0&&nums[j]>standardNumber){
                nums[j+1]=nums[j];//比standardNUmber大的插在它后面；
                j--;
            }
            nums[j+1]=standardNumber;
        }
    }
}
