package br.com.alvesmateus;

public class FabricaPremium implements FabricaDeEletronicos{
    @Override
    public Processador fabricarProcessador() {
        return new ProcessadorOctaCore();
    }

    @Override
    public Tela fabricarTela() {
        return new TelaOled();
    }
}
