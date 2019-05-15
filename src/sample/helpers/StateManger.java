package sample.helpers;

import sample.controllers.LoginController;
import sample.controllers.MainController;
import sample.views.LoginView;
import sample.views.MainView;

public class StateManger {
    private static LoginController loginController;
    public final static MainController VIEW_SPEL_SCHERM = new MainController();
    public final static LoginController VIEW_LOGIN_SCHERM = new LoginController();

//    public static void initialize(LoginController loginController)
    {
       this.loginController = loginController;
    }

    public static void schakelScherm(String naam) {
    switch(naam) {
//        case VIEW_SPEL_SCHERM:
//            MainController mainController = new MainController();
//            MainView mainView = new MainView(mainController);

         //   mainController.sch
         //   break;

//            case VIEW_LOGIN_SCHERM:
//                LoginController loginController = new LoginController();
//                LoginView loginView = new LoginView(loginController);
//
//                loginController.schakelScherm(loginView.getRoot());
//        }
    }
}
}
