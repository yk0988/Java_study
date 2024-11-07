public class RefernceVariable {
    public static void main(String[] args) {

        // 배열 변수 arr1, arr2, arr3 선언
        int[] arr1;  // 첫 번째 배열 선언
        int[] arr2;  // 두 번째 배열 선언
        int[] arr3;  // 세 번째 배열 선언

        // arr1 배열에 {1, 2, 3} 값을 갖는 배열을 할당
        arr1 = new int[]{1, 2, 3};

        // arr2 배열에 {1, 2, 3} 값을 갖는 배열을 할당
        arr2 = new int[]{1, 2, 3};

        // arr3 배열에 arr2의 참조를 할당 (arr3와 arr2는 같은 배열 객체를 참조)
        arr3 = arr2;

        // arr1과 arr2가 같은 객체를 참조하는지 비교
        // arr1과 arr2는 각각 독립적인 배열 객체를 참조하므로 비교 결과는 false
        System.out.println(arr1 == arr2);  // false 출력

        // arr2와 arr3가 같은 객체를 참조하는지 비교
        // arr2와 arr3는 동일한 배열 객체를 참조하므로 비교 결과는 true
        System.out.println(arr2 == arr3);  // true 출력
    }
}
