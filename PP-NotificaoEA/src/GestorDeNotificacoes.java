import java.util.ArrayList;
import java.util.List;

public class GestorDeNotificacoes implements Observavel {

    // --- Implementação do Singleton ---
    private static volatile GestorDeNotificacoes instancia; // volatile para thread-safety

    private GestorDeNotificacoes() {
        // Construtor privado para impedir instanciação externa
        if (instancia != null) {
            // Previne criação via reflection API
            throw new IllegalStateException("Use GestorDeNotificacoes.getInstancia()");
        }
        System.out.println("Instância única do GestorDeNotificacoes criada.");
    }

    public static GestorDeNotificacoes getInstancia() {
        // Double-Checked Locking para performance e thread-safety
        if (instancia == null) {
            synchronized (GestorDeNotificacoes.class) {
                if (instancia == null) {
                    instancia = new GestorDeNotificacoes();
                }
            }
        }
        return instancia;
    }
    // --- Fim do Singleton ---

    // --- Implementação do Observer ---
    private final List<Observador> observadores = new ArrayList<>();

    @Override
    public void adicionarObservador(Observador observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
            System.out.println("Observador " + ((Aluno)observador).getNome() + " adicionado."); // Assumindo que Observador é Aluno
        }
    }

    @Override
    public void removerObservador(Observador observador) {
        observadores.remove(observador);
        System.out.println("Observador " + ((Aluno)observador).getNome() + " removido."); // Assumindo que Observador é Aluno
    }

    @Override
    public void notificarObservadores(Evento evento) {
        System.out.println("\nNotificando " + observadores.size() + " observadores sobre o evento: " + evento.getTipo());
        // Criar cópia para evitar ConcurrentModificationException se remover/adicionar durante notificação
        List<Observador> observadoresCopia = new ArrayList<>(observadores);
        for (Observador obs : observadoresCopia) {
            obs.atualizar(evento);
        }
    }
    // --- Fim do Observer ---

    // --- Lógica de Negócio ---
    public void criarNovoEvento(Evento evento) {
        System.out.println("\n*** Gestor: Novo evento criado - " + evento.getTipo() + " em " + evento.getDataFormatada() + " ***");
        // Ao criar o evento, notifica todos os observadores inscritos
        this.notificarObservadores(evento);
    }
}