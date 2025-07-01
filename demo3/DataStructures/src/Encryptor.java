import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Scanner;
import java.util.Base64;
public class Encryptor {
    private static final String ALGORITHM="AES";
    private static final String SECRET_KEY="1234567890123456";

    public static void encryptFile(String fileInput,String fileOutput) throws Exception{
      processFile(Cipher.ENCRYPT_MODE,fileInput,fileOutput);
    }


    public static void decryptFile(String inputPath, String outputPath) throws Exception {
        processFile(Cipher.DECRYPT_MODE, inputPath, outputPath);
    }




    private static void processFile(int cipherMode,String fileInput,String fileOutput) throws Exception{
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(),ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(cipherMode,key);

        FileInputStream fis = new FileInputStream(fileInput);
        byte[] inputByte = fis.readAllBytes();
        fis.close();
        byte[] outputByte = cipher.doFinal(inputByte);

        FileOutputStream fos = new FileOutputStream(fileOutput);
        fos.write(outputByte);
        fos.close();

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Dosya Şifreleyici");
        System.out.print("İşlem seçin (1: Şifrele, 2: Çöz): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // newline

        System.out.print("Dosya yolu: ");
        String inputPath = scanner.nextLine();

        System.out.print("Çıkış dosya adı: ");
        String outputPath = scanner.nextLine();

        try {
            if (choice == 1) {
                Encryptor.encryptFile(inputPath, outputPath);
                System.out.println("Şifreleme tamamlandı.");
            } else if (choice == 2) {
                Encryptor.decryptFile(inputPath, outputPath);
                System.out.println("Çözme tamamlandı.");
            } else {
                System.out.println("Geçersiz seçim.");
            }
        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }

        scanner.close();
    }


}

