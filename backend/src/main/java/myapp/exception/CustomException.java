
package myapp.exception;

/**
 * Custom exception untuk menangani error terkait verifikasi.
 */
public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
