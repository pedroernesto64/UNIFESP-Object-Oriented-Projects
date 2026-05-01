package relatorio;

import visitor.RelatorioVisitor;

public class RelatorioArtigo implements Relatorio {

    private final String titulo;
    private final String autor;
    private final String corpo;
    private final String urlImagem;
    private final String legenda;

    public RelatorioArtigo(String titulo, String autor,
                           String corpo, String urlImagem, String legenda) {
        this.titulo = titulo;
        this.autor = autor;
        this.corpo = corpo;
        this.urlImagem = urlImagem;
        this.legenda = legenda;
    }

    @Override
    public String accept(RelatorioVisitor visitor) {
        return visitor.visit(this);
    }

    @Override public String getTitulo()   { return titulo; }
    public String getAutor()              { return autor; }
    public String getCorpo()              { return corpo; }
    public String getUrlImagem()          { return urlImagem; }
    public String getLegenda()            { return legenda; }
}
