package project.util;

public enum Currency {
    UAH, USD, EUR;

    @Override
    public String toString() {
        return name();
    }
}
