package danielcsciense.project.ItauJava10x.Transacoes;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    public void validarTransacao(TransacaoDTO transacaoDTO){

        //VALOR MAIOR OU IGUAL A 0
        if (transacaoDTO.getValor().compareTo(BigDecimal.ZERO) < 0){
            //TRANSACAO NAO É VALIDA VALOR MENOR OU IGUAL A 0
            throw new IllegalArgumentException("Erro: Isso não é uma transação válida, transações devem ter valor maior do que zero");
        }
        //DATA MENOR OU IGUAL A DATA HOJE
        if (transacaoDTO.getDataHora().isAfter(OffsetDateTime.now())){
            throw new IllegalArgumentException("Erro: na data da transação");
        }
        //DATA E HORA PRESENTES(BODY NAO PODE SER VAZIO)
        if (transacaoDTO.getDataHora()==null){
            throw new IllegalArgumentException("Erro: Data e Hora não podem ser vazios");
        }

        if (transacaoDTO.getValor() == null){
            throw new IllegalArgumentException("Erro: Valor não pode ser vazio");
        }
    }
}
