package pages.app;

import com.codeborne.selenide.ElementsCollection;
import pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$$;

public class GoogleResultsPage extends BasePage {
    public GoogleResultsPage() {
        setURL("/results");
    }

    public ElementsCollection getResults() {
        return $$("#ires li.g");
    }
}
