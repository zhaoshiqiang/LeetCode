/**
 * 《剑指offer》数组中出现次数超过一半的数字
 * Created by zhaoshq on 2017/8/10.
 */
public class Offer_Problem29 {

    public Integer moreThanHalfNum(int[] array){
        if (array == null || array.length == 0){
            return null;
        }
        int count = 0;
        Integer result = null;

        for (int i = 0; i < array.length; i++) {
            if (count == 0){
                //因为数字超过一半，所以result最后记录的一定是要找的数字
                result = array[i];
                count++;
            }else if (result == array[i]){
                //如果是该数字
                count++;
            }else {
                //如果是其他数字
                count--;
            }
        }
        if (checkMoreThanHalf(array,result)){
            return result;
        }else {
            return null;
        }
    }

    private boolean checkMoreThanHalf(int[] array, Integer result) {
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (result == array[i]){
                times++;
            }
        }
        if (times <<2 <= array.length){
            return false;
        }else {
            return true;
        }
    }
}
