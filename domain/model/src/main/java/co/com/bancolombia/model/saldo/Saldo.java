package co.com.bancolombia.model.saldo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder(toBuilder = true)

public class Saldo implements Serializable {
    private double saldo;
    private String tipo;

}
