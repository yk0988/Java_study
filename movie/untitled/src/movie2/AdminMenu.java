package movie2;

import java.util.ArrayList;

public class AdminMenu extends AbstractMenu {

    private static final AdminMenu instance = new AdminMenu("Admin Menu", null);  // 기본값 추가

    private static final String ADMIN_MENU_TEXT =
                                    "1.영화 등록하기\n" +
                                    "2.영화 목록 보기\n" +
                                    "3.영화 삭제\n" +
                                    "b.메인 메뉴로 이동\n" +
                                    "메뉴를 선택하세요:";

    // 부모 생성자 호출
    private AdminMenu(String adminMenu, Menu prevMenu) {
        super(ADMIN_MENU_TEXT, prevMenu);
    }

    // 메뉴객체 반환
    public static AdminMenu getInstance() {
        return instance;
    }

    @Override
    public Menu next() {
        switch (scanner.nextLine().trim()) {  // 입력값에서 공백을 제거하여 비교
            case "1":
                createMovie();
                return this;

            case "2":
                printAllMovie();
                return this;

            case "3":
                deleteMovie();
                return this;

            case "b":
                return prevMenu;

            default:
                return this;
        }
    }

    private void printAllMovie() {
        try {
            ArrayList <Movie> movies = Movie.findAll();
            System.out.println();
            for (int i = 0; i < movies.size(); i++) {
                System.out.printf("%s\n", movies.get(i).toString()); }
        } catch (Exception e) {
            System.out.println("데이터 접근 실패");
        }
    }

    private void createMovie() {
        System.out.println("제목: ");
        String title = scanner.nextLine();

        System.out.println("장르: ");
        String genre = scanner.nextLine();
        Movie movie = new Movie(title, genre);


        try {
            movie.save();
            System.out.println(">>등록");
        } catch (Exception e) {
            System.out.println(">>등록 실패");
        }
    }



    private void deleteMovie() {
        System.out.println("영화리스트:");
        printAllMovie();
        System.out.println("삭제할 영화의 ID 또는 제목을 입력하세요:");

        try {
            Movie.delete(scanner.nextLine());  // 영화 삭제 (제목 또는 ID를 기준으로 삭제)
            System.out.println(">>삭제 완료");
        } catch (Exception e) {
            System.out.println(">>삭제 실패");
        }
    }
}
