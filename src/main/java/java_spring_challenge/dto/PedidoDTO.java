package java_spring_challenge.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PedidoDTO {
    private Long id;

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

    @NotNull(message = "Data é obrigatória")
    private LocalDate data;

    @NotNull(message = "ID do cliente é obrigatório")
    private Long clienteId;
}
