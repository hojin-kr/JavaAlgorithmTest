import java.util.*;

public class MainController {
    public static void main(String[] args){



    }

    //1-2,8) Integer 로 이루어진 배열을 생성
    public static Integer[] RandomArrayGen(Integer randomArrayGen[], int bound){
        Random random = new Random();

        for(int i = 0; i < randomArrayGen.length; i++){
            //0 ~ 300까지의 유니크한 수 생성
            randomArrayGen[i] = random.nextInt(bound);

            //중복제거
            for(int j  = 0; j < i; j++){
                if(randomArrayGen[i] == randomArrayGen[j]){
                    j--;
                }
            }

        }

        return randomArrayGen;
    }

    //#####set으로 변환하여 집합 연산을 수행

    //3) 배열을 정렬 후 출력
    public static int[] SortArrayPrint(int sortArrayPrint[]){
        int[] result = Arrays.stream(sortArrayPrint).sorted().toArray();
        System.out.println(result.toString());

        return result;
    }

    //4-5) A - B 차집합을 구하고, 차집합을 출력하세요.
    public static int[] DifferenceSet(int A[], int B[]){
        int[] result =

        return
    }

    //6) A, B 교집합을 구하고, 교집합을 출력하세요.
    public static void Intersection(){

    }

    //7) A, B 합집합을 구하고, 합집합을 출력하세요.
    public static void Union(){

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
