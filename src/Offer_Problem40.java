/**
 * 《剑指offer》数组中只出现一次的数字
 * Created by zhaoshq on 2017/8/10.
 */
public class Offer_Problem40 {

    public void findNumsAppearOnce(int[] array){
        if (array == null){
            return;
        }
        //将number与数组中每个数进行异或操作
        int number = 0;
        //我们可以想一想“异或”运算的一个性质。任何一个数字异或它自己都是0，
        // 那么我们依次异或数组中的每一个数字，得到的结果就会是只出现一次的2个数字的异或结果。
        for (int i : array){
            number ^= i;
        }

        //因为这两个数字不同，所以异或结果肯定不为0，且能够区分开这两个数字的地方就是异或结果中为1的位。
        int index = findFisrtBitIs1(number);
        int number1=0;
        int number2=0;
        //我们就可以把原来数组中的数字按照第n位是否为1分为两部分，
        // 每一部分就会只包含一个只出现一次的数字，且其他的数字都是成对出现。
        // 接下来只要分别对这两个数组求异或，就能找出每部分只出现一次的数字。
        for (int i : array){
            if (isBit1(i,index)){
                number1^=i;
            }else {
                number2^=i;
            }
        }
        System.out.println(number1);
        System.out.println(number2);
    }

    private boolean isBit1(int number, int index) {
        number = number>>index;
        return (number&1) == 0;
    }

    private int findFisrtBitIs1(int number) {

        int indexBit = 0;
        while ((number&1) == 0){
            number = number>>1;
            indexBit++;
        }
        return indexBit;
    }
}
