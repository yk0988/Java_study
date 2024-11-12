package movie2;


import java.util.List;

public class Seats {
    public static final int MAX_ROW = 5;
    public static final int MAX_COL = 9;
    private String[][] map = new String[MAX_ROW][MAX_COL];

    // 생성자
    public Seats(List<Reservation> reservations) throws Exception {
        // 맵 초기화
        for (int i = 0; i < MAX_ROW; i++) {
            for (int j = 0; j < MAX_COL; j++) {
                map[i][j] = "O"; // O는 비어 있는 좌석을 의미
            }
        }

        // 예약된 좌석 표시
        for (int i = 0; i < reservations.size(); i++) {
            Reservation r = reservations.get(i);
            String seatName = r.getSeatName();
            mark(seatName);
        }
    }

    // 좌석 현황 출력
    public void show() {
        System.out.println("------------------");
        System.out.println("-------스크린-------");
        System.out.println("------------------");
        for (int i = 0; i < MAX_ROW; i++) {
            System.out.printf("%c ", 'A' + i);
            for (int j = 0; j < MAX_COL; j++) {
                System.out.printf("%s ", map[i][j]);
            }
            System.out.println();
        }

        System.out.println(" 1 2 3 4 5 6 7 8 9");
    }

    // 좌석을 예약
    public void mark(String seatName) throws Exception {
        if (seatName.length() != 2 && seatName.length() != 3) {
            throw new Exception("좌석명 형식 오류");
        }

        char rowChar = seatName.charAt(0);  // 예: A
        int row = rowChar - 'A';  // 'A'는 0으로 계산
        int col = Integer.parseInt(seatName.substring(1)) - 1;  // 예: 1 -> 0, 10 -> 9

        if ("x".equals(map[row][col])) {
            throw new Exception("예매된 좌석");
        }
        map[row][col] = "x";
    }
}
