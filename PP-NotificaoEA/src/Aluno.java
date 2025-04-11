public class Aluno implements Observador {
    private final String nome;

    public Aluno(String nome) {
        this.nome = nome;
        System.out.println("Aluno " + nome + " criado.");
    }

    @Override
    public void atualizar(Evento evento) {
        System.out.println("--- Notificação para Aluno " + nome + " ---");
        System.out.println("Novo evento recebido: " + evento.getTipo().getDescricao() + " em " + evento.getDataFormatada());
        prepararParaEvento(evento);
        System.out.println("------------------------------------------");
    }

    public void prepararParaEvento(Evento evento) {
        String mensagem = String.format("Aluno %s: ESTOU PREPARADO PARA O/A %s DO DIA %s.",
                this.nome,
                evento.getTipo().toString().toUpperCase(), // PROVA, TRABALHO, SEMINARIO
                evento.getDataFormatada());
        System.out.println(mensagem);
    }

    public String getNome() {
        return nome;
    }
}