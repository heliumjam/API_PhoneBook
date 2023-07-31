package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder

public class ReturnContactDTO {

    // Get all contacts
    //Return Contacts Dto

    /*
    {
  "id": "string",
  "name": "string",
  "lastName": "string",
  "email": "string",
  "phone": "449048985962329",
  "address": "string",
  "description": "string"
}
     */

    String id;
    String name;
    String lastName;
    String email;
    String phone;
    String address;
    String description;
}
