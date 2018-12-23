package service.Impl;

import dao.Interface.ICategoryDao;
import domain.Category;
import lombok.Setter;
import service.Interface.ICategoryService;

public class ICategoryServiceImpl implements ICategoryService {
    @Setter
    private ICategoryDao categoryDao;
    @Override
    public void save(Category category) {
        System.out.println("来到service====");
        categoryDao.save(category);
    }
}
