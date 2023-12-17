package bookstore.models;

import lombok.Data;
import java.util.List;

@Data
public class BookResponse {

    List<Book> books;

}
