package danielcsciense.project.ItauJava10x.Docs;

import danielcsciense.project.ItauJava10x.Transacoes.TransacaoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Transações",
        description = "Endpoints de criação de transações")

public interface TransacaoControllerDoc {

    @Operation(summary = "Cria transação ",
            description = "Recebe uma tranção valida e adiciona em uma lista")

    @ApiResponse(responseCode = "201",
            description = "Transação criada com sucesso")

    @ApiResponse(responseCode = "422",
            description = "Erro de validação capturado")

    @ApiResponse(responseCode = "400",
            description = "Erro ineperado no servidor")
    ResponseEntity<Void> adicionar(@RequestBody TransacaoDTO transacaoDTO);

    @Operation(summary = "Deleta a transação",
            description = "Remove todas as transações adicionadas a lista")
    @ApiResponse(responseCode = "200",
            description = "Transações deletadas com sucesso")

    ResponseEntity<Void> deletar();

}
