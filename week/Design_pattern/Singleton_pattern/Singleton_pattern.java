package week1;

public class Singleton_pattern{

    // Singleton Logger class
    static class Logger {
        // Private static instance of Logger
        private static Logger instance;

        // Private constructor
        private Logger() {
            System.out.println("Logger initialized.");
        }

        // Public method to provide access to the instance
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        // Logging method
        public void log(String message) {
            System.out.println("LOG: " + message);
        }
    }

    // Main method to test Singleton
    public static void main(String[] args) {
        // Get two instances of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Use the logger
        logger1.log("First message");
        logger2.log("Second message");

        // Test if both instances are the same
        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same (Singleton verified).");
        } else {
            System.out.println("Logger instances are different (Singleton failed).");
        }
    }
}

