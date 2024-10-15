public class p54 {
    public static void main(String[] args) {
        //문자열 타입 """ 큰 따옴표 세개면 작성된 그대로 문자열 저장됨//

        String str1 = "" +
                "{\n" +
                "\t\"id\":\"winter\",\n" +
                "\t\"name\":\"눈송이\",\n" +
                "}";

        String str2 = """
                {
                "id:"winter",
                "name":눈송이" 
                }
     
                  """;
        System.out.println(str1);
        System.out.println("-------------------------");
        System.out.println(str2);
        System.out.println("-------------------------");

        String str = """
    나는 자바를
    학습합니다.
    자바는 어려워요ㅠㅠ흐흐흑
    """;

        System.out.println(str);
     }
    }
