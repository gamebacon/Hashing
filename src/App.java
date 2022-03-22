import javax.imageio.plugins.tiff.GeoTIFFTagSet;
import java.util.Scanner;

public class App {

    private final Scanner scanner = new Scanner(System.in);
    IOManager io = new IOManager();
    HashMaster hashMaster = new HashMaster();

    public App() {
        start();
    }

    public void start() {
        System.out.println("(1)Register (2)Login");

        String input = scanner.nextLine();

        switch (input) {
            case "1": register(); break;
            case "2": login(); break;
            default: break;
        }

    }

    private void login() {
        String[] input = getInput();

        String hashedPassword = hashMaster.hash(input[1]);

        if(isUser(input[0], hashedPassword)) {
            System.out.println("Welcome!");
        } else {
            System.out.println("Invalid login!");
        }
    }


    private void register() {
        String[] input = getInput();

        String hashedPassword = hashMaster.hash(input[1]);
        io.addUser(input[0], hashedPassword);
    }


    private boolean isUser(String username, String password) {
        String[] lines = io.readUsers();

        for(String line : lines) {
            System.out.println(line);

            String[] data = line.split(",");

            String name = data[0];
            String pw = data[1];

           if(username.equals(name) && password.equals(pw))
               return true;
        }

        return false;
    }

    private String[] getInput() {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String passport = scanner.nextLine();
        return new String[]{username, passport};
    }










}

