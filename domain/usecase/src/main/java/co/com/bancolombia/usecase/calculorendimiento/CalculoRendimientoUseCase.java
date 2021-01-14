package co.com.bancolombia.usecase.calculorendimiento;

import co.com.bancolombia.model.saldo.Saldo;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CalculoRendimientoUseCase {

    private static double INTERES = 1.10;

    private static double SATISFACTORIO = 1000000;



    public boolean esRestableSaldoMes(List<Saldo> saldo){
        long valor =  saldo.stream()
                .map(element -> element.getSaldo()*INTERES)
                .filter(element -> element > SATISFACTORIO)
                .count();
        if(valor ==3){
            return true;
        }else{
            return false;
        }
    }

}
