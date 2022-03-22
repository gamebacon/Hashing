import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashMaster {


    public HashMaster() {


    }

    public String hash(String data) {
        try {

            MessageDigest messageDigest = MessageDigest.getInstance("SHA");

            messageDigest.update(data.getBytes());

            byte[] hash = messageDigest.digest();

            return new String(hash);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

}
