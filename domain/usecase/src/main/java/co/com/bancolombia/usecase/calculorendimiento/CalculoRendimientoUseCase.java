package co.com.bancolombia.usecase.calculorendimiento;

import co.com.bancolombia.model.saldo.Saldo;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CalculoRendimientoUseCase {

    private static final double INTERES = 1.10;

    private static final  double SATISFACTORIO = 1000000;


    public boolean esRestableSaldoMes(List<Saldo> saldo){
        boolean valor = saldo.stream()
                .map(element -> element.getSaldo() * INTERES)
                .allMatch(element -> element > SATISFACTORIO);

        System.out.println(valor);
        return  valor;
    }

    private boolean validarRentabilidad(long valor) {
        if(valor ==3){
            return true;
        }else{
            return false;
        }
    }

}
