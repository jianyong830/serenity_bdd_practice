package starter.wikipedia;

import net.serenitybdd.annotations.ClearCookiesPolicy;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.WebDriver;
import starter.pagelocator.HomePage;
import starter.questions.verifyHomePage;
import starter.task.Login;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

@ExtendWith(SerenityJUnit5Extension.class)
class TC1_VerifyAbleToLoginSuccessfulTest {

    private final Logger logger = LoggerFactory.getLogger(TC1_VerifyAbleToLoginSuccessfulTest.class);

    @Managed(uniqueSession = false, clearCookies = ClearCookiesPolicy.BeforeEachTest)
    public WebDriver hisBrowser;

    private Actor actor;

    @BeforeEach
    public void preRequisite(){
        actor = Actor.named("Tester user 1");
        actor.can(BrowseTheWeb.with(hisBrowser));
    }

    @Test
    public void TC1_VerifyAbleToLoginSuccessfulTest() {
       when(actor).attemptsTo(
               Login.login("standard_user","secret_sauce"),
               WaitUntil.the(HomePage.LOGO, isVisible()).forNoMoreThan(60).seconds()
       );

       then(actor).should(
               seeThat("Successful login and Logo is displayed", verifyHomePage.isDisplayed(HomePage.LOGO), Matchers.is(true))
       );

    }
}
