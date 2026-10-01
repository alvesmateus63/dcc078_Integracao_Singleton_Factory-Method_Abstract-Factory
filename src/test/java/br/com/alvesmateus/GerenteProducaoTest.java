package br.com.alvesmateus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GerenteProducaoTest {
    @Test
    void testeSingleton_deveRetornarMesmaInstancia() {
        GerenteProducao gerente1 = GerenteProducao.getInstancia();
        GerenteProducao gerente2 = GerenteProducao.getInstancia();

        assertSame(gerente1, gerente2, "As instâncias do GerenteProducao devem ser exatamente as mesmas na memória.");
    }

    @Test
    void testeFactoryMethod_deveCriarFabricaDeEntrada() {
        GerenteProducao gerente = GerenteProducao.getInstancia();
        FabricaDeEletronicos fabrica = gerente.escolherFabrica("entrada");

        assertNotNull(fabrica, "A fábrica não deveria ser nula.");
        assertInstanceOf(FabricaDeEntrada.class, fabrica, "A fábrica criada deve ser do tipo FabricaDeEntrada.");
    }

    @Test
    void testeFactoryMethod_deveCriarFabricaPremium() {
        GerenteProducao gerente = GerenteProducao.getInstancia();
        FabricaDeEletronicos fabrica = gerente.escolherFabrica("premium");

        assertNotNull(fabrica, "A fábrica não deveria ser nula.");
        assertInstanceOf(FabricaPremium.class, fabrica, "A fábrica criada deve ser do tipo FabricaPremium.");
    }

    @Test
    void testeFactoryMethod_deveRetornarNuloParaTipoInvalido() {
        GerenteProducao gerente = GerenteProducao.getInstancia();
        FabricaDeEletronicos fabrica = gerente.escolherFabrica("invalido");

        assertNull(fabrica, "A fábrica deve ser nula para um tipo desconhecido.");
    }

    @Test
    void testeAbstractFactory_linhaEntrada_deveCriarProdutosCorretos() {
        FabricaDeEletronicos fabrica = new FabricaDeEntrada();

        Processador processador = fabrica.fabricarProcessador();
        Tela tela = fabrica.fabricarTela();

        assertInstanceOf(ProcessadorQuadCore.class, processador);
        assertEquals("Processamento em 4 núcleos", processador.processarDados());

        assertInstanceOf(TelaLcd.class, tela);
        assertEquals("Exibição LCD", tela.exibirImagem());
    }

    @Test
    void testeAbstractFactory_linhaPremium_deveCriarProdutosCorretos() {
        FabricaDeEletronicos fabrica = new FabricaPremium();

        Processador processador = fabrica.fabricarProcessador();
        Tela tela = fabrica.fabricarTela();

        assertInstanceOf(ProcessadorOctaCore.class, processador);
        assertEquals("Processamento em 8 núcleos", processador.processarDados());

        assertInstanceOf(TelaOled.class, tela);
        assertEquals("Exibição OLED", tela.exibirImagem());
    }
}
