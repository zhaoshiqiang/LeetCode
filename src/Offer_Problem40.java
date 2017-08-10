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
        for (int i : array){
            number ^= i;
        }

        int index = findFisrtBitIs1(number);
        int number1=0;
        int number2=0;
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
