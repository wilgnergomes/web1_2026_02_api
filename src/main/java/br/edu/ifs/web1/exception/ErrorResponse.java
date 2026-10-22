package br.edu.ifs.web1.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Estrutura padrão de resposta de erro da API")
public class ErrorResponse {

    @Schema(description = "Data e hora em que o erro ocorreu", example = "2026-10-22T15:30:00")
    private LocalDateTime timestamp;

    @Schema(description = "Código de status HTTP", example = "400")
    private Integer status;

    @Schema(description = "Nome do erro HTTP", example = "Bad Request")
    private String error;

    @Schema(description = "Mensagem explicativa do erro", example = "Requisição inválida ou dados incorretos")
    private String message;

    @Schema(description = "Caminho da URI que gerou o erro", example = "/usuario/10")
    private String path;

    @Schema(description = "Erros de validação específicos por campo (quando aplicável)")
    private Map<String, String> fields;
}
