package ohtu.services;

import ohtu.domain.User;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password
        return !(passCheck(password) && userNameCheck(username));
    }

    private boolean passCheck(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean number = false, special = false;
        for (char a : password.toCharArray()) {
            if (Character.isDigit(a)) {
                number = true;
            } else if (!Character.isAlphabetic(a)) {
                special = true;
            }
        }
        return number || special;
    }

    private boolean userNameCheck(String username) {
        if (username.length() < 3) {
            return false;
        }
        for (char a : username.toCharArray()) {
            if (!(Character.isAlphabetic(a) && Character.isLowerCase(a))) {
                return false;
            }
        }
        return true;
    }

}
