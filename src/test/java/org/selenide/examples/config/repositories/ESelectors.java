package org.selenide.examples.config.repositories;

public enum ESelectors {
    SELECTOR_NAME_Q("q");


    private final String selectorText;

    public String getSelectorText() {
        return selectorText;
    }

    @Override
    public String toString() {
        return getSelectorText();
    }

    ESelectors(String selectorText) {
        this.selectorText = selectorText;
    }
}
