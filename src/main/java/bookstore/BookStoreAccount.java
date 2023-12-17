package bookstore;

import api_assured.ApiUtilities;
import api_assured.ServiceGenerator;
import bookstore.models.LoginView;
import bookstore.models.TokenResponse;
import bookstore.models.User;
import retrofit2.Call;


public class BookStoreAccount extends ApiUtilities {

    BookStoreServices.Account accountServices = new ServiceGenerator().generate(BookStoreServices.Account.class);

    public User postUser(LoginView loginView){
        log.info("Posting the user whose username is: " + loginView.getUserName());
        Call<User> userCall = accountServices.postUser(loginView);
        return perform(userCall, false, true);
    }

    public TokenResponse generateToken(LoginView loginView){
        log.info("Generating token for the user with username: " +loginView.getUserName());
        Call<TokenResponse> tokenResponseCall = accountServices.generateToken(loginView);
        return perform(tokenResponseCall, false, true);
    }

    public User getUserById(String userId){
        log.info("Getting user with id: " + userId);
        Call<User> userCall = accountServices.getUserById(userId);
        return perform(userCall, false, true);
    }


}
