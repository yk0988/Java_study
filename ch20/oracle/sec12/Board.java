package ch20.oracle.sec12;

import lombok.Data;

import java.util.Date;
@Data
public class Board {
    private int bno;
    private String bitile;
    private String bcontent;
    private String bwriter;
    private Date bdate;
}
