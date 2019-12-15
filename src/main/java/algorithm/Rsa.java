package algorithm;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.Cipher;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.X509EncodedKeySpec;

public class Rsa {
  private static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";​
  private static final String KEY_FACTORY_ALGORITHM = "RSA";

  private static final Charset ENCODING = StandardCharsets.UTF_8;

  public static String encrypt(final String publicKey, final String decryptedData) throws Exception {
    try {
      final X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode(publicKey));
      final Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
      cipher.init(Cipher.ENCRYPT_MODE, KeyFactory.getInstance(KEY_FACTORY_ALGORITHM)
              .generatePublic(x509EncodedKeySpec));
      return Base64.encode(cipher.doFinal(decryptedData.getBytes()));
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalStateException(e);
    } catch (Exception e) {
      throw new Exception("Error while decrypting data", e);
    }
  }

  public static void main(String[] args) {
    try {
      encrypt("ee", "4000");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
