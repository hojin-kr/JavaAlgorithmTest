# JavaAlgorithm : SET
자바를 이용해서 유니크한 랜덤값을 가지는 배열을 생성하고 배열을 사용해서 다양한 집합 연산을 수행합니다.

![집합연산결과](https://user-images.githubusercontent.com/22079767/54604075-40d22680-4a89-11e9-8333-1bbb8d7a9a1a.png)

![반복테스팅](https://user-images.githubusercontent.com/22079767/54604095-49c2f800-4a89-11e9-9633-5ff11d95054b.png)

### 배열 생성, 정렬, 중복제거
~~~
    public static Integer[] RandomArrayGen(int bound, int index) {
        Random random = new Random();
        //TreeSet의 특성상 중복이 제거되고 정렬되어 저장됨
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
~~~

Collection TreeSet에 원하는 크기 만큼 랜더 값을 생성하도록하여 자동으로 중복이 제거되고 정렬이되어 저장되도록함.

### 집합 연산
~~~ 
    public static Set Intersection(Integer[] integerArrayInterA, Integer[] integerArrayInterB) {
        Set mySetA = new HashSet();
        Set mySetB = new HashSet();
        Collections.addAll(mySetA, integerArrayInterA);
        Collections.addAll(mySetB, integerArrayInterB);

        mySetA.retainAll(mySetB);
        return mySetA;
    }
~~~ 
Integer[] 인자를 받아서 집합 연산을 수행학 위해 Set 자료형을 변환하여 removeAll(), retainAll(), addAll() 집합 연산 메소드르 사용
