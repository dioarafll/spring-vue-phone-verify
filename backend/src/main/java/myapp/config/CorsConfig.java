


package myapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * Konfigurasi CORS untuk mengatur izin origin, metode, header, dan pengaturan terkait.
 */
@Configuration
public class CorsConfig {

    @Value("${cors.allowed-origins}")
    private String allowedOrigins;

    @Value("${cors.allowed-methods}")
    private String allowedMethods;

    @Value("${cors.allowed-headers}")
    private String allowedHeaders;

    @Value("${cors.exposed-headers}")
    private String exposedHeaders;

    @Value("${cors.allow-credentials}")
    private boolean allowCredentials;

    @Value("${cors.max-age}")
    private long maxAge;

    /**
     * Mengonfigurasi filter CORS.
     * 
     * @return Filter CORS yang diterapkan pada semua endpoint.
     */
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList(allowedOrigins.split(",")));  // Tentukan origins yang diizinkan
        config.setAllowedMethods(Arrays.asList(allowedMethods.split(",")));  // Tentukan metode HTTP yang diizinkan
        config.setAllowedHeaders(Arrays.asList(allowedHeaders.split(",")));  // Tentukan headers yang diizinkan
        config.setExposedHeaders(Arrays.asList(exposedHeaders.split(",")));  // Tentukan headers yang boleh diakses dari frontend
        config.setAllowCredentials(allowCredentials);  // Tentukan apakah cookie diizinkan
        config.setMaxAge(maxAge);  // Tentukan durasi cache untuk preflight request

        // Tentukan URL yang diizinkan untuk CORS
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);  // Aplikasikan ke semua endpoint

        return new CorsFilter(source);  // Mengembalikan filter CORS
    }
}
