

package myapp.dto.request;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO untuk permintaan verifikasi.
 */
public class VerificationRequestDTO {

    @NotBlank(message = "Phone number cannot be blank")
    private String phoneNumber;

    private String channel;

    // `code` tidak divalidasi dengan anotasi khusus untuk menghindari kesalahan
    private String code;

    // Getters dan Setters
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
