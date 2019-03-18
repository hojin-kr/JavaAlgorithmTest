import java.text.CollationElementIterator;
import java.util.*;

public class MainController {
    public static void main(String[] args) {

        ArrayData integerArrayData = new ArrayData();

        //초기 배열 데이터 생성 (bound:랜덤값 범위, size:배열의 크기)
        integerArrayData.setA(RandomArrayGen(301, integerArrayData.getA().length));
        integerArrayData.setB(RandomArrayGen(301, integerArrayData.getB().length));

        //1-3)랜덤 생성된 A, B 배열 출력
        SortArrayPrint(integerArrayData.getA(), integerArrayData.getB());

        //4) A - B
        setPrint(DifferenceSet(integerArrayData.getA(), integerArrayData.getB()));
        //5) B - A
        setPrint(DifferenceSet(integerArrayData.getB(), integerArrayData.getA()));
        //6) A n B
        setPrint(Intersection(integerArrayData.getA(), integerArrayData.getB()));
        //7) A + B
        setPrint(Union(integerArrayData.getA(), integerArrayData.getB()));
        //8) (A + B) - (A n B)
        setPrint(UnionIntersectionDiffer(integerArrayData.getA(), integerArrayData.getB()));
    }

    //1-2,8) Integer 로 이루어진 배열을 생성
    public static Integer[] RandomArrayGen(int bound, int index) {
        Random random = new Random();

        Set randomArrayGen = new TreeSet();
        Integer[] resultArray = new Integer[index];

        while(randomArrayGen.size() < index){
            Integer rand = random.nextInt(bound);
            randomArrayGen.add(rand);
        }
        for(int i = 0; i < randomArrayGen.size(); i++){
            resultArray[i] = Integer.valueOf(randomArrayGen.toArray()[i].toString());
        }

        return resultArray;

    }

    //#####set으로 변환하여 집합 연산을 수행

    //3)출력
    public static void SortArrayPrint(Integer[] printA, Integer[] printB){
        System.out.println("output A : " + Arrays.toString(printA));
        System.out.println("output B : " + Arrays.toString(printB));
    }

    //3)출력 (집합 연산 이후)
    public static void setPrint(Set A){
        System.out.println(Arrays.toString(A.toArray()));
    }

    //4-5) A - B 차집합을 구하고, 차집합을 출력하세요.
    public static Set DifferenceSet(Integer[] integerArrayDifferA, Integer[] integerArrayDifferB) {
        Set mySetA = new TreeSet();
        Set mySetB = new TreeSet();
        Collections.addAll(mySetA, integerArrayDifferA);
        Collections.addAll(mySetB, integerArrayDifferB);

        mySetA.removeAll(mySetB);
        return mySetA;
    }

    //6) A, B 교집합을 구하고, 교집합을 출력하세요.
    public static Set Intersection(Integer[] integerArrayInterA, Integer[] integerArrayInterB) {
        Set mySetA = new TreeSet();
        Set mySetB = new TreeSet();
        Collections.addAll(mySetA, integerArrayInterA);
        Collections.addAll(mySetB, integerArrayInterB);

        mySetA.retainAll(mySetB);
        return mySetA;
    }

    //7) A, B 합집합을 구하고, 합집합을 출력하세요.
    public static Set Union(Integer[] integerArrayUnionA, Integer[] integerArrayUnionB) {
        Set mySetA = new TreeSet();
        Set mySetB = new TreeSet();
        Collections.addAll(mySetA, integerArrayUnionA);
        Collections.addAll(mySetB, integerArrayUnionB);

        mySetA.addAll(mySetB);
        return mySetA;
    }

    //8) A, B 합집합에서 A, B 교집합을 뺀 차집합을 출력하세요.
    public static Set UnionIntersectionDiffer(Integer[] integerArrayUnionInterA , Integer[] integerArrayUnionInterB ){
        Set mySetA = new TreeSet();
        Set mySetB = new TreeSet();
        Collections.addAll(mySetA, integerArrayUnionInterA);
        Collections.addAll(mySetB, integerArrayUnionInterB);

        mySetA = Union(integerArrayUnionInterA, integerArrayUnionInterB);
        mySetB = Intersection(integerArrayUnionInterA, integerArrayUnionInterB);

        mySetA.removeAll(mySetB);

        return mySetA;
    }

}