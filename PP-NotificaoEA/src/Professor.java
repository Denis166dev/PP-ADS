import java.time.LocalDate;

public class Professor {
    private final String nome;
    private final GestorDeNotificacoes gestorNotificacoes;

    public Professor(String nome) {
        this.nome = nome;
        // Obtém a instância única do gestor
        this.gestorNotificacoes = GestorDeNotificacoes.getInstancia();
        System.out.println("Professor " + nome + " criado.");
    }

    public void criarEventoAcademico(TipoEvento tipo, LocalDate data) {
        System.out.println("\nProfessor " + nome + " está criando um evento: " + tipo);
        Evento novoEvento = new Evento(tipo, data);
        // Usa o gestor para criar e notificar sobre o evento
        gestorNotificacoes.criarNovoEvento(novoEvento);
    }

    public String getNome() {
        return nome;
    }
}