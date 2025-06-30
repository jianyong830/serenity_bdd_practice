package starter.task;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.InstrumentedTask;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import starter.pagelocator.HomePage;

public class SearchForKeywords implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue("test").into(HomePage.USER_NAME).thenHit(Keys.ENTER)
        );
    }

    private String keyword;

    public SearchForKeywords(String keyword){
        this.keyword = keyword;
    }

    public static Task of(String keyword){
        return Instrumented.instanceOf(SearchForKeywords.class).withProperties(keyword);
    }
}
