

package myapp.mapper;

import myapp.dto.response.VerificationResponseDTO;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper untuk mengonversi objek Verification dan VerificationCheck menjadi VerificationResponseDTO.
 */
@Mapper(componentModel = "spring")
public interface VerificationMapper {

    /**
     * Mengonversi objek Verification menjadi VerificationResponseDTO.
     *
     * @param verification Objek Verification dari Twilio.
     * @return VerificationResponseDTO untuk dikirimkan ke klien.
     */
    @Mapping(target = "status", source = "status")
    @Mapping(target = "message", expression = "java(\"Verification code sent successfully\")")
    VerificationResponseDTO toResponseDTO(Verification verification);

    /**
     * Mengonversi objek VerificationCheck menjadi VerificationResponseDTO.
     *
     * @param verificationCheck Objek VerificationCheck dari Twilio.
     * @return VerificationResponseDTO untuk dikirimkan ke klien.
     */
    @Mapping(target = "status", source = "status")
    @Mapping(target = "message", expression = "java(verificationCheck.getStatus().equals(\"approved\") ? \"Verification successful\" : \"Verification failed\")")
    VerificationResponseDTO toResponseDTO(VerificationCheck verificationCheck);
}
