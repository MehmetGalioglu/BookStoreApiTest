package bookstore.models;

import lombok.Data;

@Data
public class TokenResponse {

    String token;

    String expires;

    String status;

    String result;

}
