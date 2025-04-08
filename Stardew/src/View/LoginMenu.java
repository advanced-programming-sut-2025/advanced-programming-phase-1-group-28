package View;

import Controller.LoginController;
import Controller.SignUpController;
import Model.App;

public class LoginMenu {
    LoginController loginController = App.loginController;
    SignUpController signUpController = App.signUpController;
    public void Login(String UserName, String Password , boolean StayLoggedIn) {

    }
    public void  ForgotPassword(String UserName) {
        //IF OK output please enter newpassword
    }
}
