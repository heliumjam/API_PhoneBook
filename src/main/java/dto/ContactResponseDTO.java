package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class ContactResponseDTO {
/*
add new contact response 200
update contact response 200

Return ResponseMessageDto:
 */

    String message;

}
