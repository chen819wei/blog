package dao.Interface;

import domain.User;

public interface IUserDao {
    User getUsre(String username, String password);
}
