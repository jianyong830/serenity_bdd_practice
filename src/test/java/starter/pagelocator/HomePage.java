package starter.pagelocator;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    //sample code to find locator at console
    //$$("#id")

    @FindBy(name = "q")
    private WebElement search;

    public static final Target USER_NAME = Target.the("User Name").locatedBy("#user-name");

    public static final Target PASSWORD = Target.the("Password").locatedBy("#password");

    public static final Target LOGIN = Target.the("Login").locatedBy("#login-button");

    public static final Target LOGO = Target.the("Logo").locatedBy(".app_logo");

}
