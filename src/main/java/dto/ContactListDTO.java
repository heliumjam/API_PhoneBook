package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Setter
@Getter
@ToString
@Builder


public class ContactListDTO {
    /*
    Get all contacts response 200:

    {
  "contacts": [
    {
      "id": "string",
      "name": "string",
      "lastName": "string",
      "email": "string",
      "phone": "6353770506394",
      "address": "string",
      "description": "string"
    }
  ]
}
     */
    List<ReturnContactDTO> contacts;

}
