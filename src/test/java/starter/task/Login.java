package starter.task;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import starter.pagelocator.HomePage;

public class Login {
    public static Task login(String username, String password){
        return Task.where(
                "{0} log in as " + username,
                Open.url("https://www.saucedemo.com/"),
                Enter.theValue(username).into(HomePage.USER_NAME),
                Enter.theValue(password).into(HomePage.PASSWORD),
                Click.on(HomePage.LOGIN)
        );
    }
}
