import java.io.*;

public class IOManager {

    public void addUser(String name, String hashedPassword) {
        appendLine(String.format("\n%s,%s", name, hashedPassword));
    }

    public String[] readUsers() {
        return readLines().split("\n");
    }

    private String getFilePath() {
        return getClass().getResource("saves.txt").getPath();
    }

    private void appendLine(String data) {
        try {
            File file = new File(getFilePath());
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readLines() {
        String lines = "";
        try {
            File file = new File(getFilePath());
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = "";
            while((line = reader.readLine()) != null) {
                lines += line + "\n";
            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }


}
