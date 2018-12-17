package service.Impl;

import dao.Impl.UserDaoImpl;
import domain.User;
import lombok.Setter;
import service.Interface.ILoginService;

@Setter
public class LoginServiceImpl implements ILoginService {
    //注入dao
    private UserDaoImpl userDao;
    @Override
    public User loginService(User user) {
        System.out.println("来到service中"+user.getUsername()+user.getPassword());
        User resUsre = userDao.getUsre(user.getUsername(), user.getPassword());
        return resUsre;
    }
}
