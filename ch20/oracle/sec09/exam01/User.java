package ch20.oracle.sec09.exam01;

import lombok.Data;

@Data//getter, setter, toString, equals, hashCode
public class User {

    private String userId;
    private String userName;
    private String userPassword;
    private int userAge;
    private String userEmail;

}
