package D.violation;

/**
 * In this example, UserService directly depends on MySQLDatabase.
 * This tight coupling makes it difficult to switch to another database type without modifying UserService.
 */

// Low-level module
class MySQLDatabase {
    public void connect() {
        System.out.println("Connecting to MySQL database.");
    }
}

// High-level module
class UserService {
    private MySQLDatabase database;

    public UserService() {
        this.database = new MySQLDatabase();
    }

    public void performAction() {
        database.connect();
        System.out.println("Performing user service action.");
    }
}

public class ViolationMain {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.performAction();
    }
}