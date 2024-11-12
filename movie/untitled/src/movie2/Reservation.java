package movie2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Reservation {

    private long id;  //예약번호
    private long movieId; // 영화가격
    private String movieTitle; // 제목
    private String seatName; // 좌석지정
    private static final File file = new File("reservations.txt");//파일객체


    public Reservation(long id,
                       long movieId,
                       String movieTitle,
                       String seatName) {
        this.id = id;
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.seatName = seatName;
    }



    public static Reservation findById(String resercvationId) throws IOException {
        Reservation r =null;
        BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;

            while((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                if(resercvationId.equals(temp[0])) {
                    r = new Reservation
                            (Long.parseLong(temp[0]),
                             Long.parseLong(temp[1]),
                            temp[2], temp[3]
              );
                    break;
                }
            }
            br.close();
            return r;
        }

    @Override
    public String toString() {
        return String.format
                ("영화 : %s, 좌석 : %s\n", movieTitle,seatName);
    }

    public static Reservation cancel(String reservationId) throws IOException {
        Reservation canceled = null;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        String text = "";

        while((line = br.readLine()) != null){
            String[] temp = line.split(",");

            if(reservationId.equals(temp[0])) {
                canceled = new Reservation
                        (Long.parseLong(temp[0]),
                                Long.parseLong(temp[0]),
                                temp[2], temp[3]
                        );
                continue;
            }
            text += line + "\n";
        }
        br.close();

        FileWriter fw = new FileWriter(file);
        fw.write(text);
        fw.close();
        return canceled;
    }



    public static List<Reservation> findByMovieId(String movieIdStr) throws IOException {

        ArrayList<Reservation> reservations = new ArrayList<Reservation>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;

        while((line =br.readLine()) != null) {
            String[] temp = line.split(",");
            if(movieIdStr.equals(temp[1])) {
                long id = Long.parseLong(temp[0]);
                long movieId = Long.parseLong(temp[1]);
                String movieTitle = temp[2];
                String seatName = temp[3];
                Reservation r = new Reservation(id, movieId, movieTitle, seatName);
                reservations.add(r);
            }
        }
        br.close();
        return reservations;
    }

    public Reservation(long movieId, String movieTitle,String seatName) {
        this.id=Instant.now().toEpochMilli();
        this.movieId=movieId;
        this.movieTitle=movieTitle;
        this.seatName=seatName;
    }

    public String getSeatName(){
        return seatName;
    }

    public void save() throws IOException {
        FileWriter fw = new FileWriter(file, true); //이어쓰기,모드설정
        fw.write(this.toFileString() + "\n");
        fw.close();
    }

    private String toFileString() {
        return String.format("%d,%d,%s,%s",
                id,movieId,movieTitle, seatName);
    }

    public long getId() {
        return id;
    }
}
















