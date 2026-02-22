package danielcsciense.project.ItauJava10x.Estatisticas;

import lombok.Getter;

@Getter
public class EstatisticaDTO {

    private final long count;
    private final double avg;
    private final double max;
    private final double min;
    private final double sum;


    public EstatisticaDTO(double avg, long count, double max, double min, double sum) {
        this.avg = avg;
        this.count = count;
        this.max = max;
        this.min = min;
        this.sum = sum;
    }
}
