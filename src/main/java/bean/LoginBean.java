package bean;

import java.io.Serializable;
import java.util.Optional;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import lombok.Data;
import model.Role;
import model.User;
import org.apache.commons.lang.StringUtils;
import service.LoginService;
import util.SessionUtils;

@ManagedBean(name = "login")
@SessionScoped
@Data
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;
    @Inject
    private LoginService loginService;

    private String pwd;
    private String user;

    //validate login
    public String validateUsernamePassword() {
        Optional<User> loggedInUserOpt = loginService.isValid(user, pwd);
        if (loggedInUserOpt.isPresent()) {
            User loggedInUser = loggedInUserOpt.get();
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("user", loggedInUser);
            if(loggedInUser.getRole() == Role.TEACHER){
                return "teacherPage";
            }
            return "studentPage";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Incorrect Username or Password",
                            "Please enter correct username and Password"));
            return StringUtils.EMPTY;
        }
    }

    public String toLogin(){
        return "loginPage";
    }


    //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return this.toLogin();
    }
}
