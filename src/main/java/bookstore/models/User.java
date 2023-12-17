package bookstore.models;

import lombok.Data;
import java.util.List;

@Data
public class User {

    String userID;

    String username;

    List<Book> books;

}
