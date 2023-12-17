package bookstore.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class AddListOfBooks {

    String userId;

    List<Isbn> collectionOfIsbns;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Isbn {

        String isbn;

    }

}
