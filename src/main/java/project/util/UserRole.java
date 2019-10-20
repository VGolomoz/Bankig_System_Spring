package project.util;

public enum UserRole {
    ADMIN, MANAGER, CLIENT;

    @Override
    public String toString() {
        return "ROLE_" + name();
    }
}
