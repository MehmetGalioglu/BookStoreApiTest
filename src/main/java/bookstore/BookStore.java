package bookstore;

import api_assured.ApiUtilities;
import api_assured.ServiceGenerator;
import bookstore.models.AddListOfBooks;
import bookstore.models.BookResponse;
import okhttp3.Headers;
import retrofit2.Call;

public class BookStore extends ApiUtilities {

    BookStoreServices.BookStore bookStore;


    public BookStore(String userToken){
        bookStore = new ServiceGenerator(
                new Headers.Builder().add("Authorization", "Bearer " + userToken).build()
        ).generate(BookStoreServices.BookStore.class);
    }

    public BookResponse getBooks(){
        log.info("Getting books");
        Call<BookResponse> bookResponseCall = bookStore.getBooks();
        return perform(bookResponseCall, false, false);
    }

    public BookResponse postBooks(String userToken, AddListOfBooks books){
        log.info("Posting books");
        Call<BookResponse> postBooksCall = bookStore.postBooks("Bearer " + userToken, books);
        return perform(postBooksCall, false, true);
    }

}
