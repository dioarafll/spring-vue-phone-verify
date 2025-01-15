

package myapp.service;

import myapp.dto.request.VerificationRequestDTO;
import myapp.dto.response.VerificationResponseDTO;
import myapp.exception.CustomException;
import myapp.mapper.VerificationMapper;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Service untuk menangani pengiriman dan verifikasi kode.
 */
@Service
public class VerificationService {

    @Value("${twilio.verify.service.sid}")
    private String verifyServiceSid;

    private final VerificationMapper verificationMapper;

    public VerificationService(VerificationMapper verificationMapper) {
        this.verificationMapper = verificationMapper;
    }

    /**
     * Mengirimkan kode verifikasi ke nomor telepon yang diberikan melalui channel yang dipilih.
     *
     * @param requestDTO DTO yang berisi informasi nomor telepon dan channel.
     * @return DTO yang berisi status dan pesan dari hasil pengiriman.
     */
    public VerificationResponseDTO sendVerificationCode(VerificationRequestDTO requestDTO) {
        try {
            Verification verification = Verification.creator(
                    verifyServiceSid,
                    requestDTO.getPhoneNumber(),
                    requestDTO.getChannel()
            ).create();

            return verificationMapper.toResponseDTO(verification);
        } catch (Exception e) {
            throw new CustomException("Failed to send verification code: " + e.getMessage());
        }
    }

    /**
     * Memverifikasi kode yang dikirimkan ke nomor telepon.
     *
     * @param requestDTO DTO yang berisi nomor telepon dan kode verifikasi.
     * @return DTO yang berisi status dan pesan dari hasil verifikasi.
     */
    public VerificationResponseDTO verifyCode(VerificationRequestDTO requestDTO) {
        if (requestDTO.getCode() == null || requestDTO.getCode().isEmpty()) {
            throw new CustomException("Code cannot be blank");
        }
        try {
            VerificationCheck verificationCheck = VerificationCheck.creator(verifyServiceSid)
                    .setTo(requestDTO.getPhoneNumber())
                    .setCode(requestDTO.getCode())
                    .create();

            return verificationMapper.toResponseDTO(verificationCheck);
        } catch (Exception e) {
            throw new CustomException("Verification failed: " + e.getMessage());
        }
    }
}
