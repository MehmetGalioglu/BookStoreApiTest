package bookstore.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    String isbn;

    String title;

    String author;

    String publish_date;

    String publisher;

    int pages;

    String description;

    String website;

}
