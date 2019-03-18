import java.text.CollationElementIterator;
import java.util.*;

public class MainController {
    public static void main(String[] args){

        ArrayData integerArrayData = new ArrayData();

        //초기 배열 데이터 생성 (bound:랜덤값 범위, size:배열의 크기)
        integerArrayData.setA(RandomArrayGen(301,integerArrayData.getA().length));
        integerArrayData.setB(RandomArrayGen(301,integerArrayData.getB().length));

        SortArrayPrint(integerArrayData.getA(), integerArrayData.getB());
        //4) A - B
        DifferenceSet(integerArrayData.getA(), integerArrayData.getB());
        //5) B - A
        DifferenceSet(integerArrayData.getB(), integerArrayData.getA());

    }

    //1-2,8) Integer 로 이루어진 배열을 생성
    public static Integer[] RandomArrayGen(int bound, int index){
        Random random = new Random();
        Integer[] randomArrayGen = new Integer[index];
        //중복제거
        for(int i = 0; i < index; i++){
            randomArrayGen[i] = random.nextInt(bound);
            for(int j = 0; j < i; j++){
                if(randomArrayGen[i] == randomArrayGen[j])
                    i--;
            }
        }
        return randomArrayGen;

    }

    //#####set으로 변환하여 집합 연산을 수행

   //3) 배열을 정렬 후 출력
    public static void SortArrayPrint(Integer[] integerArraySortA,Integer[] integerArraySortB ){
        Arrays.sort(integerArraySortA);
        Arrays.sort(integerArraySortB);
        System.out.println("output A : " + Arrays.toString(integerArraySortA));
        System.out.println("output B : " + Arrays.toString(integerArraySortB));


    }

    //4-5) A - B 차집합을 구하고, 차집합을 출력하세요.
    public static void DifferenceSet(Integer[] integerArrayDifferA, Integer[] integerArrayDifferB){
        Set mySetA = new TreeSet();
        Set mySetB = new TreeSet();
        Collections.addAll(mySetA, integerArrayDifferA);
        Collections.addAll(mySetB, integerArrayDifferB);

        mySetA.removeAll(mySetB);

        System.out.println("차" + Arrays.toString(mySetA.toArray()));
    }

    //6) A, B 교집합을 구하고, 교집합을 출력하세요.
    public static void Intersection(Integer[] integerArrayIntersecA, Integer[] integerArrayIntercB){
        

    }

    //7) A, B 합집합을 구하고, 합집합을 출력하세요.
    public static void Union(){

    }

    //배열(Array)를 집합(Set) 자료형으로 변환
    public static Set toSet(Integer[] convert){
        Set result = new HashSet();
        Collections.addAll(result, convert);

        return result;
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
