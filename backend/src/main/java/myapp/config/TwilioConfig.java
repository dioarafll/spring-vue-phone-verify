

package myapp.config;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

/**
 * Konfigurasi untuk inisialisasi Twilio dengan kredensial dari application.properties.
 */
@Configuration
public class TwilioConfig {

    private final String accountSid;
    private final String authToken;

    public TwilioConfig(
            @Value("${twilio.account.sid}") String accountSid,
            @Value("${twilio.auth.token}") String authToken) {
        this.accountSid = accountSid;
        this.authToken = authToken;
    }

    /**
     * Inisialisasi Twilio setelah bean diinisialisasi.
     */
    @PostConstruct
    public void initTwilio() {
        Twilio.init(accountSid, authToken);
    }
}
