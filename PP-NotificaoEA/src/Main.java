import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- Iniciando Simulação do Sistema de Notificações Acadêmicas ---");

        // 1. Obter a instância única do Gestor (Singleton)
        // A primeira chamada a getInstancia() cria o objeto.
        GestorDeNotificacoes gestor = GestorDeNotificacoes.getInstancia();

        // Tentar criar outra instância (não deve funcionar devido ao Singleton)
        // GestorDeNotificacoes gestor2 = new GestorDeNotificacoes(); // Erro de compilação (construtor privado)
        GestorDeNotificacoes gestor2 = GestorDeNotificacoes.getInstancia();
        System.out.println("Gestor 1 é o mesmo que Gestor 2? " + (gestor == gestor2)); // Deve imprimir true

        // 2. Criar Alunos (Observadores)
        Aluno aluno1 = new Aluno("João Silva");
        Aluno aluno2 = new Aluno("Maria Oliveira");
        Aluno aluno3 = new Aluno("Carlos Pereira");

        // 3. Inscrever Alunos no Gestor de Notificações
        gestor.adicionarObservador(aluno1);
        gestor.adicionarObservador(aluno2);
        gestor.adicionarObservador(aluno3);

        // 4. Criar Professores
        Professor profMarcos = new Professor("Marcos Rocha");
        Professor profAna = new Professor("Ana Souza");

        // 5. Professores criam eventos (o Gestor notificará os Alunos)
        System.out.println("\n--- Criação de Eventos ---");

        profMarcos.criarEventoAcademico(TipoEvento.PROVA, LocalDate.of(2025, Month.APRIL, 11));
        profAna.criarEventoAcademico(TipoEvento.TRABALHO, LocalDate.of(2025, Month.MAY, 5));

        // 6. Remover um aluno e criar outro evento
        System.out.println("\n--- Removendo um Observador ---");
        gestor.removerObservador(aluno2); // Maria não receberá a próxima notificação

        profMarcos.criarEventoAcademico(TipoEvento.SEMINARIO, LocalDate.of(2025, Month.JUNE, 15));

        // 7. Adicionar o aluno novamente e criar mais um evento
        System.out.println("\n--- Readicionando um Observador ---");
        gestor.adicionarObservador(aluno2); // Maria voltará a receber notificações

        profAna.criarEventoAcademico(TipoEvento.PROVA, LocalDate.of(2025, Month.JULY, 1));


        System.out.println("\n--- Simulação Concluída ---");
    }
}