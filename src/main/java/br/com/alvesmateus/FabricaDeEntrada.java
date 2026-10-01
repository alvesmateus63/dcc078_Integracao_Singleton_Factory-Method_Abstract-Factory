package br.com.alvesmateus;

public class FabricaDeEntrada implements FabricaDeEletronicos {
    @Override
    public Processador fabricarProcessador() {
        return new ProcessadorQuadCore();
    }

    @Override
    public Tela fabricarTela() {
        return new TelaLcd();
    }
}
