package danielcsciense.project.ItauJava10x.Transacoes;

import danielcsciense.project.ItauJava10x.Estatisticas.EstatisticaDTO;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    List<TransacaoDTO> listaDeTransacoes = new ArrayList<>();

    //salvar dados em uma lista
    public void salvarDados(TransacaoDTO transacaoDTO){
        listaDeTransacoes.add(transacaoDTO);

    }

    //apagar essa lista depois de 60 segundos
    public void limparDados(TransacaoDTO transacaoDTO){

    }

    //apagar todas as transações da lista
    public void deletarDados() {
        listaDeTransacoes.clear();

    }

    //Gerar estatisticas
    public EstatisticaDTO estatistica(OffsetDateTime horaInicial){

        if (listaDeTransacoes.isEmpty()){
            return new EstatisticaDTO(0.0,0,0.0,0.0,0.0);
        }

        //transforma a lista de transações em numeros  para fazer  uma operação
        final var summary = listaDeTransacoes.stream()
                .filter(t ->
                        t.getDataHora().isAfter(horaInicial) || t.getDataHora().isEqual(horaInicial)
                ).mapToDouble(t-> t.getValor().doubleValue())
                .summaryStatistics();

        return new EstatisticaDTO(summary.getAverage(), // 1º double avg
                summary.getCount(),   // 2º long count
                summary.getMax(),     // 3º double max
                summary.getMin(),     // 4º double min
                summary.getSum());
    }
}
