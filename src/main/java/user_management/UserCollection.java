package user_management;

import user_management.security.Password;
import user_management.security.UserAuthenticationFailedException;
import user_management.validation.EmailNotAvailableException;
import user_management.validation.InvalidEmailException;
import user_management.validation.PasswordTooSimpleException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserCollection extends ArrayList<User> {

    public User findById(int id) {
        for(User user : UserCollectionInitializer.generate()) {
            if(user.getId() == (Integer) id) {
                return user;
            }
        }
        return null;
    }

    public User findByEmail(String email) {
        for(User user : UserCollectionInitializer.generate()) {
            if(user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public User attemptLogin(String email, String password) throws UserAuthenticationFailedException {
        for(User user : UserCollectionInitializer.generate()) {
            if(user.getEmail().equals(email)) {
                if(user.getPassword().matches(password)) {
                    return user;
                } else {
                    throw new UserAuthenticationFailedException();
                }
            }
        }
        return null;
    }

    public int createUser(String name, String email, String password) throws EmailNotAvailableException, InvalidEmailException, PasswordTooSimpleException {
        UserCollection userCollection = UserCollectionInitializer.generate();


        for(User user : UserCollectionInitializer.generate()) {
            if(user.getEmail().equals(email)) {
                throw new EmailNotAvailableException();
            }
        }

        if(!isValidPassword(password)) {
            throw new PasswordTooSimpleException();
        }
        if(!isValidEmail(email)) {
            throw new InvalidEmailException();
        }
        return userCollection.size() + 1;
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "\\b[A-Z._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}\\b";
        Pattern emailPattern = Pattern.compile(emailRegex);
        return emailPattern.matcher(email).matches();
    }

    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}";
        Pattern passwordPattern = Pattern.compile(passwordRegex);
        return passwordPattern.matcher(password).matches();
    }

}
