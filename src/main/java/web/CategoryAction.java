package web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import domain.Category;
import lombok.Setter;
import service.Interface.ICategoryService;

public class CategoryAction extends ActionSupport implements ModelDriven {
    private Category category = new Category();
    //注入service
    @Setter
    private ICategoryService categoryService;
    @Override
    public Object getModel() {
        return category;
    }

    public String add() {
        System.out.println(category);
        //调用service
        categoryService.save(category);
        return null;
    }
}
