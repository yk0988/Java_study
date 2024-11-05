package ch06.sec01.exam02;
//기호상수는 한번에 보기 편한 장점이 있음//
//static 고정//
//final 기호상수: 한번 지정하면 변동불가능 = 자바:콘스트//
public class Earth {
static  final double EARTH_RADIUS=6400;
static  final double EARTH_SUFACE;

static {
    EARTH_SUFACE=4*Math.PI*EARTH_RADIUS*EARTH_RADIUS;
}

}
