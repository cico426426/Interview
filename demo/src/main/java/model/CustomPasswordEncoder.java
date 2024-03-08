package model;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        try {
            String salt = getSalt();
            String hashedPassword = getSHA256SecurePassword(rawPassword.toString(), salt);
            return hashedPassword + ":" + salt;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error during password encoding", e);
        }
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        try {
            String[] parts = encodedPassword.split(":");
            if (parts.length != 2) {
                return false;
            }
            String salt = parts[1];
            String hashedPassword = getSHA256SecurePassword(rawPassword.toString(), salt);
            return encodedPassword.equals(hashedPassword + ":" + salt);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error during password matching", e);
        }
    }
    private String getSHA256SecurePassword(String passwordToHash, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt.getBytes());
        byte[] bytes = md.digest(passwordToHash.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    private String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
}
