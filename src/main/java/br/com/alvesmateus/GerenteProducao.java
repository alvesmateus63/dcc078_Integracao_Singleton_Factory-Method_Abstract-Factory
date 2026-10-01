package br.com.alvesmateus;

public class GerenteProducao {
    private static GerenteProducao instancia;

    private GerenteProducao() {}

    public static GerenteProducao getInstancia() {
        if (instancia == null) instancia = new GerenteProducao();
        return instancia;
    }

    public FabricaDeEletronicos escolherFabrica(String tipo) {
        if (tipo.equals("entrada")) return new FabricaDeEntrada();
        if (tipo.equals("premium")) return new FabricaPremium();
        return null;
    }
}
