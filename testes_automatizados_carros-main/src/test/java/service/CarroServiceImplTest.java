package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Test;

public class CarroServiceImplTest {

    private CarroService carroService = new CarroServiceImpl();
    ;
    private Carro carroTeste = new Carro("Cinza", "Fiat", "Fastback", 2023, 200);
    ;

    @Test
    public void deveAcelerarCorretamente() {
        // Given
        carroService.ligar(carroTeste);

        // When
        carroService.acelerar(carroTeste, 10);

        // Then
        // Assertivas
        // O Junit busca por Asserts no método para validar que o teste passou
        Assert.assertTrue(carroTeste.getVelocidadeAtual() == 10);
    }

    @Test
    public void deveLigarCorretamente() {
        // Quando
        carroService.ligar(carroTeste);

        // Então
        Assert.assertTrue(carroTeste.isLigado());
    }

    @Test
    public void velocidadeNaoDeveSerMenorQueZero() {
        // Dado
        carroService.ligar(carroTeste); // velocidade zero

        // Quando:
        carroService.frear(carroTeste, 10);

        // Então:
        Assert.assertTrue(carroTeste.isLigado());
        Assert.assertEquals(0, carroTeste.getVelocidadeAtual());
    }
    @Test
    public void velocidadeNaoDeveSerMaiorQueAMaxima() {
        carroService.ligar(carroTeste);
        carroService.acelerar(carroTeste, 200);
        carroService.acelerar(carroTeste,10);

        Assert.assertTrue(carroTeste.isLigado());
        Assert.assertEquals(200, carroTeste.getVelocidadeAtual());
    }

    @Test
    public void deveLigarCorretamenteEAcelerarCorretamente() {
        // Quando:
        carroService.ligar(carroTeste);
        carroService.acelerar(carroTeste, 10);

        // Então:
        Assert.assertTrue(carroTeste.isLigado());
        Assert.assertEquals(10, carroTeste.getVelocidadeAtual());
    }

    @Test
    public void deveFrearCorretamente() {
        carroService.ligar(carroTeste);
        carroService.acelerar(carroTeste, 20);
        carroService.frear(carroTeste, 10);
        Assert.assertTrue(carroTeste.isLigado());
        Assert.assertEquals(10, carroTeste.getVelocidadeAtual());

    }

    @Test
    public void deveDesligarCorretamente() {
        carroService.ligar(carroTeste);
        carroService.acelerar(carroTeste, 10);
        carroService.frear(carroTeste, 10);
        carroService.desligar(carroTeste);
        Assert.assertFalse(carroTeste.isLigado());
        Assert.assertEquals(0, carroTeste.getVelocidadeAtual());
    }

    @Test
    public void deveMostrarOEstadoAtualCorretamente() {
        carroService.ligar(carroTeste);
        carroService.acelerar(carroTeste,25);
        System.out.println(carroService.estadoAtual(carroTeste));
        carroService.frear(carroTeste, 25);
        carroService.desligar(carroTeste);
        System.out.println(carroService.estadoAtual(carroTeste));
        Assert.assertFalse(carroTeste.isLigado());
    }
}
