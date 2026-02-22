package danielcsciense.project.ItauJava10x.Docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name ="Estatisticas" ,
description = "Endpoint para vizualização de diferentes perspectivas de estatisticas")
public interface EstatisticaControllerDoc {
    @Operation(summary = "Calcula estatísticas",
            description = "Retorna o cálculo de sum, avg, max, min e count das transações dos últimos 60 segundos"
    )
    @ApiResponse(responseCode = "200", description = "Estatísticas calculadas com sucesso")
    ResponseEntity<Object> estatistica();

}
