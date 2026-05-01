package relatorio;

import visitor.RelatorioVisitor;

public interface Relatorio {
    String accept(RelatorioVisitor visitor);
    String getTitulo();
}
