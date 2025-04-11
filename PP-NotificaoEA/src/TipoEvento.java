public enum TipoEvento {
    PROVA("Prova"),
    TRABALHO("Trabalho"),
    SEMINARIO("Seminário");

    private final String descricao;

    TipoEvento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}