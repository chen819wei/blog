package dao.Impl;

import dao.Interface.IUserDao;
import domain.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class UserDaoImpl extends HibernateDaoSupport implements IUserDao {
    @Override
    public User getUsre(String username, String password) {
        System.out.println("UserDao----" + username + "::" + password);
        //到数据库中查询
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
        detachedCriteria.add(Restrictions.eq("username", username));
        detachedCriteria.add(Restrictions.eq("password", password));
        //使用QBC查询
        List<User> userList = (List<User>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        System.out.println(userList);
        if (userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }
}
