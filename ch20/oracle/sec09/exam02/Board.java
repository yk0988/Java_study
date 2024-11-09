package ch20.oracle.sec09.exam02;
import lombok.Data;
import java.sql.Blob;
import java.sql.Date;

@Data // Lombok을 사용하여 getter, setter 등을 자동으로 생성
public class Board {
    private int bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private Date bdate;
    private String bfilename;
    private Blob bfiledata;


}