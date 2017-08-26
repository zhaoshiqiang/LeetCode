package other;

import java.io.*;

/**
 *
 * Created by zhaoshiqiang on 2017/8/18.
 */
//C程序的注释用/* */来表示。请写一个程序，将输入的C程序源代码中的注释去掉，输出去掉注释之后的源代码。
// 用于测试的C代码保证符合语法，不使用C++的//注释语法。
// 注意，C语言不允许出现嵌套注释。具体来说，对于/* /* * /”* /”，如果不允许嵌套注释，那么它表示字符串”* / “；
// 如果允许嵌套注释，它表示一个引号”。字符串中出现的注释符 / * 属于字符串的一部分，注释中出现的双引号”属于注释的一部分。
public class Remove_Comments {
    public static String removeComments(String curr){
        StringBuffer buf = new StringBuffer();
        //标识是否在引号内
        boolean isQuote = false;
        long codelength = curr.length();
        for (int i = 0; i < codelength; i++) {
            if (!isQuote){
                //在引号外
                //遇到//注释
                if (curr.charAt(i) == '/' && i+1<codelength && curr.charAt(i+1)=='/'){
                    i++;
                    while ( i<codelength && curr.charAt(i) != '\n'){
                        i++;
                    }
                }else if (curr.charAt(i) == '/' && i+1<codelength && curr.charAt(i+1)=='*'){    //遇到/*
                    while (!(i < codelength && curr.charAt(i) == '*'
                            && i+1<codelength && curr.charAt(i+1)=='/')){
                        i++;
                    }
                    i++;
                }else if (curr.charAt(i) == '"'){   //遇到"
                    buf.append(curr.charAt(i));
                    isQuote = true;
                }else {
                    //不是注释内容，正常添加
                    buf.append(curr.charAt(i));
                }
            }else {
                //如果在引号内，则全部添加。第二个是引号内的"
                while ( (i<codelength && curr.charAt(i) != '"') || (curr.charAt(i-1)=='\\' && curr.charAt(i) == '"')){
                    buf.append(curr.charAt(i++));
                }
                buf.append(curr.charAt(i));
                isQuote = false;
            }
        }
        return buf.toString();
    }

    public static void main(String[] args) throws Exception {
        File file = new File("E:\\ProgramZhaoShiqiang\\LeetCode\\src/tree.Recover_Binary_Search_Tree.java");
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuffer sb = new StringBuffer();
        String temp;
        while ( (temp = bf.readLine()) != null){
            sb.append(temp);
            sb.append("\n");
        }
        System.out.println(removeComments(sb.toString()));
    }
}
