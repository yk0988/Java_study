package ch16.sec05.exam03;

public class ConstructReference {
    public static void main(String[] args) {
        Peson peson =new Peson();

        Member m1 = peson.getMember1(Member::new);
        System.out.println(m1);
        System.out.println();

        Member m2 = peson.getMember2(Member::new);
        System.out.println(m2);
    }
}
