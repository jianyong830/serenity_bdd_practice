package starter.questions;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;


public class verifyHomePage {
    public static Question<Boolean> isDisplayed(Target locator) {
        return actor -> locator.resolveFor(actor).isDisplayed();
    }

}
