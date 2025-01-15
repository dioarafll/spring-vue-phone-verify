

package myapp.controller;

import myapp.dto.request.VerificationRequestDTO;
import myapp.dto.response.VerificationResponseDTO;
import myapp.service.VerificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/verification")
public class VerificationController {

    private final VerificationService verificationService;

    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @PostMapping("/send")
    public ResponseEntity<VerificationResponseDTO> sendVerification(@Valid @RequestBody VerificationRequestDTO requestDTO) {
        VerificationResponseDTO response = verificationService.sendVerificationCode(requestDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/verify")
    public ResponseEntity<VerificationResponseDTO> verifyCode(@RequestBody VerificationRequestDTO requestDTO) {
        VerificationResponseDTO response = verificationService.verifyCode(requestDTO);
        return ResponseEntity.ok(response);
    }
}
