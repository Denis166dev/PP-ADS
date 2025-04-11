import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    private final TipoEvento tipo;
    private final LocalDate data;
    private static final DateTimeFormatter FORMATADOR_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public Evento(TipoEvento tipo, LocalDate data) {
        this.tipo = tipo;
        this.data = data;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public String getDataFormatada() {
        return data.format(FORMATADOR_DATA);
    }

    @Override
    public String toString() {
        return "Evento{" +
                "tipo=" + tipo +
                ", data=" + getDataFormatada() +
                '}';
    }
}