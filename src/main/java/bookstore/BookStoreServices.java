package bookstore;

import bookstore.models.*;
import retrofit2.Call;
import retrofit2.http.*;

public interface BookStoreServices {

    String BASE_URL = BookStoreApi.BASE_URL;

    interface Account {

        @SuppressWarnings("unused")
        String BASE_URL = BookStoreServices.BASE_URL + BookStoreApi.ACCOUNT_SUFFIX + BookStoreApi.V1_SUFFIX;

        @POST("User")
        Call<User> postUser(@Body LoginView loginView);

        @POST("GenerateToken")
        Call<TokenResponse> generateToken(@Body LoginView loginView);

        @GET("User/{UUID}")
        Call<User> getUserById(@Path("UUID") String userId);
    }

    interface BookStore{

        @SuppressWarnings("unused")
        String BASE_URL = BookStoreServices.BASE_URL + BookStoreApi.BOOK_STORE_SUFFIX + BookStoreApi.V1_SUFFIX;

        @GET("Books")
        Call<BookResponse> getBooks();

        @POST("Books")
        Call<BookResponse> postBooks(@Header("Authorization") String userToken, @Body AddListOfBooks books);

    }




}
