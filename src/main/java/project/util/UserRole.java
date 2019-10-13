package project.util;

public enum UserRole {
    ADMIN, MANAGER, USER;

    @Override
    public String toString() {
        return "ROLE_" + name();
    }
}
