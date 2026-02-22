package danielcsciense.project.ItauJava10x.Estatisticas;

import danielcsciense.project.ItauJava10x.Transacoes.TransacaoDTO;
import danielcsciense.project.ItauJava10x.Transacoes.TransacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@Slf4j
@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    @Autowired
    private EstatisticaProperties estatisticaProperties;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping
    public ResponseEntity estatistica(){
        //Log de requisição criado via lombock
        log.info("Calculando estisticas de transações");

        //calcular quantas transações acontecem em N segundos
        final var horaInicial = OffsetDateTime
                .now()
                .minusSeconds(estatisticaProperties.segundos());

        return ResponseEntity.ok(transacaoRepository.estatistica(horaInicial));
    }


}
