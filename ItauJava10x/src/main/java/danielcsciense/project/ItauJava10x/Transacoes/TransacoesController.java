package danielcsciense.project.ItauJava10x.Transacoes;

import danielcsciense.project.ItauJava10x.Docs.TransacaoControllerDoc;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/transacao")
public class TransacoesController implements TransacaoControllerDoc {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private TransacaoRepository transacaoRepository;


    @PostMapping
    public ResponseEntity adicionar(@RequestBody TransacaoDTO transacaoDTO){
        log.info("Enviando requisição de transação para o servidor: ");

        try {
            transacaoService.validarTransacao(transacaoDTO);;
            transacaoRepository.salvarDados(transacaoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        }catch (IllegalArgumentException exception){
            log.error("Erro em uma ou mais validações, tente novamente: ");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }catch (Exception e){
            log.error("Erro no servidor, tente novamente: ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }
    }

    @DeleteMapping
    public ResponseEntity deletar(){
        log.info("Lista de transações deletada: ");
        transacaoRepository.deletarDados();
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
