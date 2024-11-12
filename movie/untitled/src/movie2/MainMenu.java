package movie2;

import java.io.IOException;
import java.util.ArrayList;

public class MainMenu extends AbstractMenu {

    private static final MainMenu instance = new MainMenu(null);
    private static final String MAIN_MENU_TEXT =
                    "1. 영화 예매하기\n" +
                    "2. 예매 확인하기\n" +
                    "3. 예매 취소하기\n" +
                    "4. 관리자 메뉴로 이동\n" +
                    "q 종료\n\n" +
                    "메뉴를 선택하세요:";

    //private 생성자
    public MainMenu(Menu prevMenu) {
        super(MAIN_MENU_TEXT, prevMenu);
    }

    public static MainMenu getInstance() {
        return instance;
    }

    @Override
    public Menu next() {
        switch (scanner.nextLine()) {
            case "1": //예매
                reserve();
                return this;
            case "2": //예매확인
                checkReservation();
                return this;
            case "3": //예매취소
                cancelReservation();
                return this;
            case "4": //비밀번호
                if (!checkAdminPassWord()) {
                    System.out.println("비번오류");
                    return this;
                }
                AdminMenu adminMenu = AdminMenu.getInstance();
                adminMenu.setPrevMenu(this);
                return adminMenu;
            case "q":
                return prevMenu;
            default:
                return this;
        }
    }

    private boolean checkAdminPassWord() {
        System.out.println("관리자 비밀번호: ");
        return "12345".equals(scanner.nextLine());
    }

    private void checkReservation() {
        System.out.println("예매번호 입력");

        try {
            Reservation r = Reservation.findById(scanner.nextLine());
            if (r != null) {
                System.out.printf("> [확인완료] %s\n", r.toString());
            } else {
                System.out.println("> 내역 없음");
            }
        } catch (IOException e) {
            System.out.println("오류가 발생했습니다: ");
        }
    }


    private void cancelReservation() {
        System.out.println("예매번호를 입력하세요");
        try {
            Reservation canceled = Reservation.cancel(scanner.nextLine());
            if(canceled != null) {
                System.out.printf(">>[취소 완료] %s의 예매가 취소되었습니다.\n", canceled.toString());
            }else {
                System.out.println("예매내역 존재하지 않음");
            }
        } catch (IOException e) {
            System.out.println("파일 입출력에 문제가 발생했습니다: " );
        }
    }


    private void reserve(){
        try {
            //영화목록 출력
            ArrayList<Movie> movies = (ArrayList<Movie>) Movie.findAll();
            for(int i=0; i < movies.size(); i++) {
                System.out.printf("%s\n", movies.get(i).toString());
            }
            //예매영화선택
            System.out.print("예매할 영화를 선택하세요:");
            String movieIdStr = scanner.nextLine();
            Movie m = Movie.findByld(movieIdStr);
            //예매 영화의 좌석 현황 출력
            ArrayList<Reservation> reservations = (ArrayList<Reservation>) Reservation.findByMovieId(movieIdStr);
            Seats seats = new Seats(reservations);
            seats.show();
            //예매 좌석 선택
            System.out.print("좌석을 선택하세요.(예:E-9):");
            String seatName = scanner.nextLine();
            seats.mark(seatName);

            //예매 객체 저장
            Reservation r = new Reservation(
                    Long.parseLong(movieIdStr), //영화 대표값
                    m.getTitle(), //영화제목
                    seatName  //좌석명
            );
            r.save();
            System.out.println(">>예매가 완료되었습니다.");
            System.out.printf(">> 발급번호: %d\n", r.getId());
        }catch(IOException e) {
            System.out.println(">>파일 입출력에 문제가 생겼습니다.");
        }catch(Exception e) {
            System.out.printf(">>예매에 실패하였습니다: %s\n", e.getMessage());
        }
    }
}


