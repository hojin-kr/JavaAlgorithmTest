import java.text.CollationElementIterator;
import java.util.*;

public class MainController {
    public static void main(String[] args) {

        ArrayData integerArrayData = new ArrayData();

        //초기 배열 데이터 생성 (bound:랜덤값 범위, size:배열의 크기)
        integerArrayData.setA(RandomArrayGen(301, integerArrayData.getA().length));
        integerArrayData.setB(RandomArrayGen(301, integerArrayData.getB().length));

        //Collection set으로 변환하고 처리를 할까?, 출력도 하나의 메소드로 몰고 리턴으로 값 주도록하고
        Set mySetA = new TreeSet();
        Set mySetB = new TreeSet();
        Collections.addAll(mySetA, integerArrayData.getA());
        Collections.addAll(mySetB, integerArrayData.getB());

        SortArrayPrint(integerArrayData.getA(), integerArrayData.getB());

        System.out.println(integerArrayData.getA().length +"^^^"+ integerArrayData.getB().length + "#####");

        //4) A - B
        DifferenceSet(mySetA, mySetB);
        //5) B - A
        DifferenceSet(mySetB, mySetA);
        //6) A n B
        Intersection(mySetA, mySetB);
        //7) A + B
        Union(mySetA, mySetB);
    }

    //1-2,8) Integer 로 이루어진 배열을 생성
    public static Integer[] RandomArrayGen(int bound, int index) {
        Random random = new Random();
        Integer[] randomArrayGen = new Integer[index];
        //중복제거
        for (int i = 0; i < index; i++) {
            randomArrayGen[i] = random.nextInt(bound);
            for (int j = 0; j < i; j++) {
                if (randomArrayGen[i] == randomArrayGen[j])
                    i--;
            }
        }
        return randomArrayGen;

    }

    //#####set으로 변환하여 집합 연산을 수행

    //3) 배열을 정렬 후 출력
    public static void SortArrayPrint(Integer[] integerArraySortA, Integer[] integerArraySortB) {
        Arrays.sort(integerArraySortA);
        Arrays.sort(integerArraySortB);
        System.out.println("output A : " + Arrays.toString(integerArraySortA));
        System.out.println("output B : " + Arrays.toString(integerArraySortB));


    }

    //4-5) A - B 차집합을 구하고, 차집합을 출력하세요.
    public static void DifferenceSet(Set integerArrayDifferA, Set integerArrayDifferB) {
        integerArrayDifferA.removeAll(integerArrayDifferB);

        System.out.println("차" + Arrays.toString(integerArrayDifferA.toArray()));
    }

    //6) A, B 교집합을 구하고, 교집합을 출력하세요.
    public static void Intersection(Set integerArrayInterA, Set integerArrayInterB) {
        integerArrayInterB.retainAll(integerArrayInterA);

        System.out.println("교" + Arrays.toString(integerArrayInterA.toArray()));

    }

    //7) A, B 합집합을 구하고, 합집합을 출력하세요.
    public static void Union(Set integerArrayUnionA, Set integerArrayUnionB) {
        integerArrayUnionA.addAll(integerArrayUnionB);

        System.out.println("합" + Arrays.toString(integerArrayUnionA.toArray()));


    }

    //8) A, B 합집합에서 A, B 교집합을 뺀 차집합을 출력하세요.
    public static void UnionIntersectionDiffer(){

    }

}