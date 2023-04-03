package utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Users {
    ADMINISTRATOR("admin"),
    DEFAULT("default");

    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
