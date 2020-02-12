package org.selenide.examples.config.pages.app;

import com.codeborne.selenide.ElementsCollection;
import org.selenide.examples.config.pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$$;

public class GoogleResultsPage extends BasePage {
    public GoogleResultsPage() {
        super("/results");
    }

    public ElementsCollection getResults() {
        return $$("#ires li.g");
    }
}
