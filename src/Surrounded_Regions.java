import java.util.*;

/**第130题
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 A region is captured by flipping all 'O's into 'X's in that surrounded region.
 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:
 X X X X
 X X X X
 X X X X
 X O X X
 * Created by zhaoshiqiang on 2017/1/11.
 */
//算法：BFS， 数据结构：队列
public class Surrounded_Regions {

    private int xmax;
    private int ymax;
    private Set<Node> visited = new HashSet<>();
    public void solve(char[][] board) {
        ymax = board.length;
        if (ymax == 0){
            return;
        }
        xmax = board[0].length;
        if (xmax == 0){
            return;
        }
        Queue<Node> queue = new LinkedList();
        //将矩形四周的0加入
        for (int j=0; j<ymax ;j++){
            if (board[j][0] == 'O'){
                Node n = new Node(0,j);
                if (!visited.contains(n)){
                    visited.add(n);
                    queue.offer(n);
                }
            }
        }
        for (int i=0; i<xmax; i++){
            if (board[0][i] == 'O'){
                Node n = new Node(i,0);
                if (!visited.contains(n)){
                    visited.add(n);
                    queue.offer(n);
                }
            }
        }
        for (int j=0; j<ymax ;j++){
            if (board[j][xmax-1] == 'O'){
                Node n = new Node(xmax-1,j);
                if (!visited.contains(n)){
                    visited.add(n);
                    queue.offer(n);
                }
            }
        }
        for (int i=0; i<xmax; i++){
            if (board[ymax-1][i] == 'O'){
                Node n = new Node(i,ymax-1);
                if (!visited.contains(n)){
                    visited.add(n);
                    queue.offer(n);
                }
            }
        }
        //bfs找到最后为0的点
        while (!queue.isEmpty()){
            Node node = queue.poll();
            getObynode(node.x,node.y,board,queue);
        }

        for (int i=0; i<xmax; i++){
            for (int j=0; j<ymax; j++){
                board[j][i]='X';
            }
        }
        for (Node node : visited){
            board[node.y][node.x]='O';
        }
    }

    private void getObynode(int x, int y,char[][] board,Queue<Node> queue){
        if (x-1 >=0){
            if (board[y][x-1] == 'O'){
                Node n = new Node(x-1,y);
                if (!visited.contains(n)){
                    visited.add(n);
                    queue.offer(n);
                }
            }
        }
        if (y-1 >=0){
            if (board[y-1][x] == 'O'){
                Node n = new Node(x,y-1);
                if (!visited.contains(n)){
                    visited.add(n);
                    queue.offer(n);
                }
            }
        }
        if (x+1 <xmax){
            if (board[y][x+1] == 'O'){
                Node n = new Node(x+1,y);
                if (!visited.contains(n)){
                    visited.add(n);
                    queue.offer(n);
                }
            }
        }
        if (y+1 <ymax){
            if (board[y+1][x] == 'O'){
                Node n = new Node(x,y+1);
                if (!visited.contains(n)){
                    visited.add(n);
                    queue.offer(n);
                }
            }
        }
    }

    class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (x != node.x) return false;
            return y == node.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public static void main(String[] args){
        char[][] board = new char[][]{"XXXX".toCharArray(),"XOOX".toCharArray(),"XXOX".toCharArray(),"XOXX".toCharArray()};
//        char[][] board = new char[][]{"OO".toCharArray(),"OO".toCharArray()};
        Surrounded_Regions regions = new Surrounded_Regions();
//        long startTime = System.currentTimeMillis();//获取当前时间
        regions.solve(board);
        for (int i=0; i<board.length; i++){
            System.out.println();
            for (int j=0; j<board.length; j++){
                System.out.print(board[i][j] + "  ");
            }
        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

}
