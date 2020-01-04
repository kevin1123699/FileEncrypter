import java.nio.file.Paths;
import javax.crypto.Cipher;

/**
 * Encrypt and decrypt files recursively from the specified directory
 * 
 * @author Kevin Barbón
 */
public class Main {
	public static void main(String[] args) {

		FileEncrypter encrypter = new FileEncrypter();
		encrypter.setDesCipher(Cipher.ENCRYPT_MODE); // Cipher.DECRYPT_MODE
		encrypter.getFiles(Paths.get(System.getProperty("user.home") + "/Desktop/").toString());

	}
}
