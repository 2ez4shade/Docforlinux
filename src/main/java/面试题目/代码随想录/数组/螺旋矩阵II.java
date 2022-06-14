package 面试题目.代码随想录.数组;

/**
 * @author: shade
 * @date: 2022/4/29 23:09
 * @description:
 */
public class 螺旋矩阵II {
    public static int[][] spiralMatrix(int n) {
        int[][] res = new int[n][n];
        //定义循环次数
        int loop = n / 2;
        //定义初始位置
        int x = 0;
        int y = 0;
        //定义初始偏移量
        int offset = 1;
        //定义填充数字
        int count = 0;
        //中间位置索引
        int mid = n / 2;
        while (loop > 0) {
            int x1 = x;
            int y1 = y;
            //从左到右
            for (; y1 < y + n - offset; y1++) {
                res[x][y1] = ++count;
            }
            //从上到下
            for (; x1 < x + n - offset; x1++) {
                res[x1][y1] = ++count;
            }
            //从右到左
            for (; y1 > y; y1--) {
                res[x1][y1] = ++count;
            }
            //从下到上
            for (; x1 > x; x1--) {
                res[x1][y1] = ++count;
            }
            x++;
            y++;
            offset += 2;
            loop--;
        }
        if (n % 2 == 1) {
            res[mid][mid] = count;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ints = spiralMatrix(10);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
