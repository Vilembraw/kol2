public class WhisperParser {
    public static void main(String[] args) {
        String input = "/w user1 testmessage";

        // Check if the input string starts with "/w "
        if (input.startsWith("/w ")) {
            // Remove the "/w " part
            String withoutCommand = input.substring(3);

            // Split the remaining part by the first space to separate login and message
            String[] parts = withoutCommand.split(" ", 2);

            if (parts.length == 2) {
                String login = parts[0];
                String message = parts[1];

                // Output the login and message
                System.out.println("Login: " + login);
                System.out.println("Message: " + message);
            } else {
                System.out.println("Invalid format. Message part is missing.");
            }
        } else {
            System.out.println("Invalid whisper command.");
        }
    }
}
