package com.example.leetcodedemo.JianZhiOffer.JZ68;
import java.util.*;
/**
 * @description:
 * @author: wjl
 * @date: 2026/9/22
 */

class TreeNode {
  int val = 0;
  TreeNode left = null;
  TreeNode right = null;
  public TreeNode(int val) {
    this.val = val;
  }
}

public class Demo_01 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @param p int整型
     * @param q int整型
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        // write code here
        //  抓住特点  搜索树永远是   左边的比右边的小
        //  先统计出两条路径
        List<Integer> path_p = getPath(root, p);
        List<Integer> path_q = getPath(root, q);
        //  找到第一个  出现不同的地方
        int commonHeader = -1;
        for(int i = 0, j = 0;i<path_p.size()&&j<path_q.size();i++,j++){
            Integer pNum = path_p.get(i);
            Integer qNum = path_q.get(j);
            if(pNum.equals(qNum)){
                // 如果  一样就记录下来
                commonHeader = pNum;
            }else{
                return commonHeader;
            }

        }
        return commonHeader;
    }


    //  统计出  寻找  目标值经过的路径
    // 因为是二叉搜索树  左边的 一定比右边的小
    private List<Integer>  getPath(TreeNode root,int target){
        List<Integer> res = new ArrayList<>();
        while(root!=null){
            int val = root.val;
            res.add(val);
            // 判断
            //  如果发现小了  就去右边
            //  如果发现大了  就去左边
            if(val<target){
                root = root.right;
            }
            else if(val> target){
                root = root.left;
            }else{
                return res;
            }
        }
        return new ArrayList<>();
    }
}
