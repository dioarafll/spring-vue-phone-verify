

package myapp.dto.response;

/**
 * DTO untuk respon hasil verifikasi.
 */
public class VerificationResponseDTO {
    private String status;
    private String message;

    // Getters dan Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
