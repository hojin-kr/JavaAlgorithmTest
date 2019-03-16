import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainController {
    public static void main(String[] args){

        ArrayData arrayData = new ArrayData();

        //1. 유니크한 랜덤번호 생성 0~300
        arrayData.setA(RandomNumGen(300, 300));
        //2. 유니크한 랜덤번호 생성 0~100
        arrayData.setB(RandomNumGen(300, 100));

        //3. A, B 배열 오름차순 정렬 ( 이후 모든 결과는 오름차훈 정렬 후 출력)
        //Ineger[] 언박싱, => int[] 형식으로 변환
        int[] A = toPrimitive(arrayData.getA());
        int[] B = toPrimitive(arrayData.getB());
        //정렬
        Arrays.sort(A);
        Arrays.sort(B);
        //출력
        System.out.println("output A : " + Arrays.toString(A) + "\n" + "output B : " + Arrays.toString(B));

        //4. A - B (차집합) 출력



    }

        //기능 가지는 메소드들 다른 클래스 하나에 새로 작성?



    //numbound 만큼 유니크한 랜덤값을 생성함 , taregtarray에 생성한 것 저장
    public static Integer[] RandomNumGen(int numbound, int arraybound){
        Random random = new Random();
        Integer[] targetarray = new Integer[arraybound];

        for(int i = 0; i < targetarray.length; i++){
            targetarray[i] = random.nextInt(numbound);

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
