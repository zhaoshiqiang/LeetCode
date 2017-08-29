package dynamic_programming;

/**第96题 生成二叉搜索树
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

     For example,
     Given n = 3, there are a total of 5 unique BST's.
 * Created by zhaoshiqiang on 2017/1/3.
 */
//区间动态规划
public class Unique_Binary_Search_Trees {
    public static int numTrees(int n) {
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        int[] results = new int[n+1];
        results[1]=1;
        results[0]=1;
        /**
         * 假设 results(i) 表示已升序排序的数组 [0,i] 所存在的不同BST的集合，
         * 则results(i)可以看出将0~i-1拆分成两段，前段作为i的父节点，后端作为i的左节点，将前段种类*后端种类则为这次分段的总数
         * 将这些总数求和，则为results(i)
         * */
        for (int i=2; i<=n; i++){
            for (int j=0; j<i; j++){
                results[i]=results[i]+results[j]*results[i-1-j];
            }
        }
        return results[n];
    }

    public static void main(String[] args){
        System.out.println(numTrees(9));
    }
}
