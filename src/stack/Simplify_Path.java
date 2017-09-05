package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**第71 简化路径
 * Given an absolute path for a file (Unix-style), simplify it.
     For example,
     path = "/home/", => "/home"
     path = "/a/./b/../../c/", => "/c"
 * Created by zhaoshiqiang on 2017/1/25.
 */
//栈
public class Simplify_Path {
    public static String simplifyPath(String path) {
        if (path == null || "".equals(path)){
            return null;
        }
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();
        //利用栈简化路径
        for (int i=0; i<strings.length; i++){
            String s = strings[i].trim();
            switch (s){
                case ".." : if (!stack.isEmpty())
                                stack.pop();
                            break;
                case ".": break;
                case "":break;
                default:stack.push(s);
            }
        }
        //将栈中元素弹出，此时list中元素是倒叙的
        List<String> list = new ArrayList<>();
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        //在目录间添加/
        StringBuffer buffer = new StringBuffer();
        for (int i=list.size()-1;i>=0;i--){
            buffer.append("/").append(list.get(i));
        }
        return "".equals(buffer.toString()) ? "/" : buffer.toString();

    }

    public static void main(String[] args){
        System.out.println(simplifyPath("/.."));
        System.out.println(simplifyPath("/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/abc/..."));
        System.out.println(simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
    }
}
