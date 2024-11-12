package movie2;


import java.io.*;
import java.time.Instant;
import java.util.ArrayList;

public class Movie {
    private static long id;
    private static String title;
    private static String genre;
    private static final File file = new File("movies.txt");

    // 생성자
    public Movie(long id, String title, String genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
    }


    // 모든 영화 정보 반환
    public static ArrayList<Movie> findAll() throws IOException {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        // 리소스 관리
        BufferedReader br = new BufferedReader(new FileReader(file));
        {
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                Movie m = new Movie(
                        Long.parseLong(temp[0]),
                        temp[1],
                        temp[2]
                );
                movies.add(m);
            }
        }
        br.close();
        return movies;
    }

    @Override
    public String toString() {
        return String.format("[%d] : %s(%s)",id,title,genre);

    }

    public Movie(String title, String genre) {
        this.id = Instant.now().getEpochSecond();
        this.title = title;
        this.genre = genre;
    }

    public void save() throws IOException {
        FileWriter fw = new FileWriter(file, true);
        fw.write(this.toFileString() + "\n");
        fw.close();
    }

    private String toFileString() {
        return String.format("%d,%s,%s", id, title, genre);
    }

    public static void delete(String moviedStr) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        //파일복사 빈 문자열
        String text = "";
        String line = null;

        //행 단위 읽기(반복구절)
        while ((line = br.readLine()) != null) {
            String[] temp = line.split(",");
            if (moviedStr.equals(temp[0])) {
                continue;
            }
            text += line + "\n";
        }
        br.close();

        FileWriter fw = new FileWriter(file);
        fw.write(text);
        fw.close();
    }

    public static Movie findByld(String moviedStr) throws IOException {
        Movie movie = null;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;

        while ((line=br.readLine())!=null){
            String[]temp = line.split(",");
            if (moviedStr.equals(temp[0])){
                movie = new Movie(Long.parseLong(temp[0]), temp[1], temp[2]);
                break;
            }
        }

        br.close();
        return movie;
    }
    public String getTitle(){
        return title;
    }
}