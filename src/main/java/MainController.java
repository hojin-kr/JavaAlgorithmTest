import java.util.Arrays;
import java.util.Random;

public class MainController {
    public static void main(String[] args){

        ArrayData arrayData = new ArrayData();

        //유니크한 랜덤번호 생성
        arrayData.setA(RandomNumGen(300));
        arrayData.setB(RandomNumGen(100));

        //Ineger[] 언박싱, => int[] 형식으로 변환
        int[] A = toPrimitive(arrayData.getA());
        int[] B = toPrimitive(arrayData.getB());

        
        //결과 출력
        System.out.println("output A : " + Arrays.toString(A) + "\n" + "output B : " + Arrays.toString(B));
    }




    //arraybound 만큼 유니크한 랜덤값을 생성함 , taregtarray에 생성한 것 저장
    public static Integer[] RandomNumGen(int arraybound){
        Random random = new Random();
        Integer[] targetarray = new Integer[arraybound];

        for(int i = 0; i < targetarray.length; i++){
            targetarray[i] = random.nextInt(arraybound);

            //중복 생성된 번호를 체크하고 확인될 시 i를 -1 하여 랜덤번호 재생성
            for(int j = 0; j < i; j++){
                if(targetarray[i] == targetarray[j]){
                    //중복 제거, 같은 값을 찾을 경우 카운트를 -1 하여 번호를 다시 생성하도록함
                    i--;
                }
            }
        }
        return targetarray;

    }

    //convert Integer[] to int[]
    public static int[] toPrimitive(Integer[] IntegerArray) {

        int[] result = new int[IntegerArray.length];
        for (int i = 0; i < IntegerArray.length; i++) {
            result[i] = IntegerArray[i].intValue();
        }
        return result;
    }



}
