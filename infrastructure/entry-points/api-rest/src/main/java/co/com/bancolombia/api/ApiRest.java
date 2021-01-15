package co.com.bancolombia.api;

import co.com.bancolombia.model.saldo.Saldo;
import co.com.bancolombia.usecase.calculorendimiento.CalculoRendimientoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final CalculoRendimientoUseCase  useCase;

    @PostMapping(path ="/balance")
    public ResponseEntity<String> calcularBalance(@RequestBody List<Saldo> saldos){

        saldos.stream().forEach(System.out::println);
        Boolean esRentable = useCase.esRestableSaldoMes(saldos);
        if (esRentable) {
            return ResponseEntity.ok("Es rentable");
        }
        return ResponseEntity.ok("No es rentable");
    }

}
