package dao.Impl;

import dao.Interface.ICategoryDao;
import domain.Category;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CategoryDaoImpl extends HibernateDaoSupport implements ICategoryDao {
    @Override
    public void save(Category category) {
        System.out.println(category+"categoryDao");
       this.getHibernateTemplate().save(category);
    }
}
