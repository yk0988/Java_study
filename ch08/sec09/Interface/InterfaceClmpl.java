package ch08.sec09.Interface;

public class InterfaceClmpl implements InterfaceC {

    @Override
    public void methodA() {
        System.out.println("InterfaceClmpl_methodA()실행");
    }

    @Override
    public void methodB() {
        System.out.println("InterfaceClmpl_methodB()실행");
    }

    @Override
    public void methodC() {
        System.out.println("InterfaceClmpl_methodC()실행");
    }
}
