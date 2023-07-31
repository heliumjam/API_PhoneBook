package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class ErrorDTO {
    /*

Any format error

    {
  "timestamp": "2023-07-25T16:08:10.797Z",
  "status": 0,
  "error": "string",
  "message": {},
  "path": "string"
}
     */
    String timestamp;
    int status;
    String error;
    Object message;
    String path;


}
