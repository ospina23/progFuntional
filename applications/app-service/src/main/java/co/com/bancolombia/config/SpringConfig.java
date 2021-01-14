package co.com.bancolombia.config;
import co.com.bancolombia.usecase.calculorendimiento.CalculoRendimientoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public CalculoRendimientoUseCase calculoRendimientoUseCase() {
        return new CalculoRendimientoUseCase();
    }
}
