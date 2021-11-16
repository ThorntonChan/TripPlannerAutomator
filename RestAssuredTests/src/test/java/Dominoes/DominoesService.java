package Dominoes;

import com.automator.handler.RestHandler2;
import org.testng.annotations.Test;

public class DominoesService {
    private DominoesApiMethods dominoesApiMethods = new DominoesApiMethods();

    public void login(){
        System.out.println("Running Dominoes api login test");
        System.out.println(dominoesApiMethods.login(DominoesModel.email, DominoesModel.password));
    }
    public void loginAndGetQuizzes(){
        System.out.println("Running Dominoes api getquizzes test");
        String password = dominoesApiMethods.login(DominoesModel.email, DominoesModel.password);
        dominoesApiMethods.getAllQuizzes(password);
    }

}
