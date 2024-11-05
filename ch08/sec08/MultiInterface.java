
package ch08.sec08;

public class MultiInterface {
    public static void main(String[] args) {

        RemoteControl rc = new SmartTelevision();
        rc.turnOn();
        rc.turnOff();

        Searchable search = new SmartTelevision();
        search.search("https://www.naver.com/");
    }
}
