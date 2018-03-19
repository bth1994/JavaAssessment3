package user_management;

import user_management.security.Password;
import user_management.security.UserAuthenticationFailedException;
import user_management.validation.EmailNotAvailableException;
import user_management.validation.InvalidEmailException;
import user_management.validation.PasswordTooSimpleException;

import java.util.ArrayList;
import java.util.Collections;
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
        for(User user : UserCollectionInitializer.generate()) {
            if(user.getEmail().equals(email)) {
                throw new EmailNotAvailableException();
            }
        }
        isValidEmail(email);
        isValidPassword(password);
        int id = getNextId();
        this.add(new User(email, id, name, password));
        return id;
    }

    public int getNextId() {
        Integer id = 1;
        ArrayList<Integer> ids = new ArrayList<>();
        for(User user : this) {
            ids.add((Integer)user.getId());
        }
        Collections.sort(ids);
        for(Integer key : ids) {
            if(id.equals(key)) {
                id++;
            }
        }
        return id;
    }

    public void isValidEmail(String email) throws InvalidEmailException {
        String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@+[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,6})$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        if(!emailPattern.matcher(email).matches()) {
            throw new InvalidEmailException();
        }
    }

    public void isValidPassword(String password) throws PasswordTooSimpleException {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}";
        Pattern passwordPattern = Pattern.compile(passwordRegex);
        if(!passwordPattern.matcher(password).matches()) {
            throw new PasswordTooSimpleException();
        }
    }

}
