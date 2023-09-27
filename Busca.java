public class Busca {
    private No raiz;

    public Busca() {
        raiz = null;
    }

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor); // RAIZ
    }

    private No inserirRecursivo(No no, int valor) {
        if (no == null) {
            return new No(valor);
        }

        if (valor < no.getValor()) {
            no.setEsquerda(inserirRecursivo(no.getEsquerda(), valor));
        } else if (valor > no.getValor()) {
            no.setDireita(inserirRecursivo(no.getDireita(), valor));
        }

        return no;
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(No no, int valor) {
        if (no == null) {
            return false;
        }

        if (valor == no.getValor()) {
            return true;
        }

        return valor < no.getValor()
                ? buscarRecursivo(no.getEsquerda(), valor)
                : buscarRecursivo(no.getDireita(), valor);
    }

    public void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    private No removerRecursivo(No no, int valor) {
        if (no == null) {
            return null;
        }

        if (valor == no.getValor()) {
            if (no.getEsquerda() == null && no.getDireita() == null) {
                return null;
            }

            if (no.getDireita() == null) {
                return no.getEsquerda();
            }

            if (no.getEsquerda() == null) {
                return no.getDireita();
            }

            int menorValor = encontrarMenorValor(no.getDireita());
            no.setValor(menorValor);
            no.setDireita(removerRecursivo(no.getDireita(), menorValor));
            return no;
        }

        if (valor < no.getValor()) {
            no.setEsquerda(removerRecursivo(no.getEsquerda(), valor));
            return no;
        }

        no.setDireita(removerRecursivo(no.getDireita(), valor));
        return no;
    }

    private int encontrarMenorValor(No no) {
        return no.getEsquerda() == null ? no.getValor() : encontrarMenorValor(no.getEsquerda());
    }

    public void imprimir() {
        imprimirRecursivo(raiz, 0);
    }

    private void imprimirRecursivo(No no, int profundidade) {
        if (no == null) {
            return;
        }

        imprimirRecursivo(no.getDireita(), profundidade + 1);

        for (int i = 0; i < profundidade; i++) {
            System.out.print("    ");
        }

        System.out.println(no.getValor());

        imprimirRecursivo(no.getEsquerda(), profundidade + 1);
    }
}
