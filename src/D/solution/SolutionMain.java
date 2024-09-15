package D.solution;


/**
 * Explanation:
 * Abstraction: The Database interface acts as an abstraction, allowing different database implementations.
 * Low-Level Modules: MySQLDatabase and PostgreSQLDatabase implement the Database interface.
 * High-Level Module: UserService depends on the Database abstraction rather than a specific database implementation. The dependency is injected through the constructor.
 * By following DIP, you achieve:
 * <p>
 * Decoupling: UserService is not tied to a specific database implementation.
 * Flexibility: You can easily switch to different database implementations without modifying the UserService class.
 */

// Abstraction (interface)
interface Database {
    void connect();
}

// Low-level module
class MySQLDatabase implements Database {
    @Override
    public void connect() {
        System.out.println("Connecting to MySQL database.");
    }
}

// Another low-level module
class PostgreSQLDatabase implements Database {
    @Override
    public void connect() {
        System.out.println("Connecting to PostgreSQL database.");
    }
}

// High-level module
class UserService {
    private Database database;

    // Dependency injection via constructor
    public UserService(Database database) {
        this.database = database;
    }

    public void performAction() {
        database.connect();
        System.out.println("Performing user service action.");
    }
}

public class SolutionMain {
    public static void main(String[] args) {
        Database mySQLDatabase = new MySQLDatabase();
        UserService userService = new UserService(mySQLDatabase);
        userService.performAction();

        // Switching to PostgreSQL
        Database postgreSQLDatabase = new PostgreSQLDatabase();
        UserService userService2 = new UserService(postgreSQLDatabase);
        userService2.performAction();
    }
}
