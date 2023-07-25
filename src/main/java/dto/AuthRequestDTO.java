package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder


public class AuthRequestDTO {
    /*
    {
  "username": "string",
  "password": "C6c$B#k7s$g8&-VUqw(c@WB/!Y!OUQ/yP{|[w-^pwQkACZ^uW+Y8>'dkY(zX63cSu5:N'y&sF"
}
     */

    String username;
    String password;


}
