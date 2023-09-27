public class Main {
    public static void main(String[] args) {
        Busca busca = new Busca();
        busca.inserir(5);
        busca.inserir(3);
        busca.inserir(7);
        busca.inserir(1);
        busca.inserir(10);

        busca.imprimir();

        System.out.println(busca.buscar(7)); // imprime true

        busca.remover(7);

        busca.imprimir();
    }
}
