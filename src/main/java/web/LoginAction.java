package web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import domain.User;
import lombok.Setter;
import service.Impl.LoginServiceImpl;

@Setter
public class LoginAction extends ActionSupport implements ModelDriven<User> {
    private User user;
    //注入service
    private LoginServiceImpl loginService;

    //登陆
    public String login() {
        System.out.println("来到登陆页面" + user);
        //登陆业务逻辑
        User resUser = loginService.loginService(this.user);
        if (resUser == null) {
            //错误信息回显
            this.addActionError("用户名或者密码错误");
            //结果页跳转
            return LOGIN;
        } else {
            //保存用户信息
            ActionContext.getContext().getSession().put("resUser", resUser);
            return SUCCESS;
        }

    }

    //退出登录
    public String loginout() {
        System.out.println("来到了退出");
        /*清空session*/
        ActionContext.getContext().getSession().remove("resUser");
        return "login_out";
    }
    @Override
    public User getModel() {
        return user;
    }
}
