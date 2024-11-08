package ch16.sec05.exam03;

public class Member {
    private String id;
    private String name;

    public Member(String id) {
        this.id = id;
        System.out.println("Memder(String id)");
    }

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("Memder(String id)");
    }

    @Override
    public String toString() {
        String info="{id:"+id+"name:"+name+"}";
        return info;
    }
}

