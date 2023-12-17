package bookstore;

import bookstore.models.*;
import org.junit.Test;
import utils.ArrayUtilities;
import utils.ReflectionUtilities;
import utils.StringUtilities;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    StringUtilities strUtilities = new StringUtilities();
    BookStoreAccount bookStoreAccount = new BookStoreAccount();

    /**
     * Rigorous Test :-)
     */
    @Test
    public void postUserTest(){

        String userName = strUtilities.generateRandomString("fuzzy", 5, false, true);

        LoginView loginView = new LoginView(userName, "Password123!");

        User user = bookStoreAccount.postUser(loginView);

    }

    @Test
    public void userAuthorization(){

        String userName = strUtilities.generateRandomString("fuzzy", 5, false, true);

        LoginView loginView = new LoginView(userName, "Password123!");

        User user = bookStoreAccount.postUser(loginView);
        String userID = user.getUserID();

        TokenResponse tokenResponse = bookStoreAccount.generateToken(loginView);
        String userToken = tokenResponse.getToken();

        BookStore bookStore = new BookStore(userToken);

        List<Book> books =  bookStore.getBooks().getBooks();
        Book randomBook = ArrayUtilities.getRandomItemFrom(books);
        ReflectionUtilities.printObjectFields(randomBook);

        AddListOfBooks addListOfBooks = new AddListOfBooks(userID, List.of(new AddListOfBooks.Isbn(randomBook.getIsbn())));
        bookStore.postBooks(userToken, addListOfBooks);

    }
}
