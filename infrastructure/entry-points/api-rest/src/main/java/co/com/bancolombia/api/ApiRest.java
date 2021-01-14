package co.com.bancolombia.api;

import co.com.bancolombia.model.saldo.Saldo;
import co.com.bancolombia.usecase.calculorendimiento.CalculoRendimientoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final CalculoRendimientoUseCase  useCase;

    @GetMapping(path = "/hello")
    public String health() {
        return "HelloWorld";
    }

    @PostMapping(path ="/balance")
    public ResponseEntity<String> calcularBalance(@RequestBody List<Saldo> saldos){
        //List<Saldo> saldos = new ArrayList<>();
        //saldos.add(Saldo.builder().saldo(1000000).tipo("depositos").build());
        //saldos.add(Saldo.builder().saldo(1000000).tipo("fidu").build());
        //saldos.add(Saldo.builder().saldo(1000000).tipo("tarjetas").build());

        saldos.stream().forEach(System.out::println);
        Boolean esRentable = useCase.esRestableSaldoMes(saldos);
        if (esRentable) {
            return ResponseEntity.ok("Es rentable");
        }
        return ResponseEntity.ok("No es rentable");
    }

    @GetMapping(path ="/balance")
    public ResponseEntity<List<Saldo>> calcularBalance(){
        List<Saldo> saldos = new ArrayList<>();
        saldos.add(Saldo.builder().saldo(1000000).tipo("depositos").build());
        saldos.add(Saldo.builder().saldo(1000000).tipo("fidu").build());
        saldos.add(Saldo.builder().saldo(1000000).tipo("tarjetas").build());

        return ResponseEntity.ok(saldos);
    }

    @PostMapping(path ="/balanceSolo")
    public ResponseEntity<Saldo> calcularBalance(@RequestBody Saldo saldo){
        //List<Saldo> saldos = new ArrayList<>();
        //saldos.add(Saldo.builder().saldo(1000000).tipo("depositos").build());
        //saldos.add(Saldo.builder().saldo(1000000).tipo("fidu").build());
        //saldos.add(Saldo.builder().saldo(1000000).tipo("tarjetas").build());

        return ResponseEntity.ok(saldo);
    }

}
