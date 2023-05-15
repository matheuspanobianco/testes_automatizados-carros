package service;

import model.Carro;

public class CarroServiceImpl implements CarroService {

    @Override
    public void acelerar(Carro carro, int velocidadeAMais) {
        if (carro.isLigado()) {
            if (carro.getVelocidadeAtual() == carro.getVelocidadeMaxima()) {
                System.out.printf("Não é possivel acelerar mais que a velocidade maxima (%skm/h).\n", carro.getVelocidadeMaxima());
            } else {
                System.out.printf("Acelerando carro em %skm/h...\n", velocidadeAMais);
                int velocidadeAtual = carro.getVelocidadeAtual() + velocidadeAMais;
                carro.setVelocidadeAtual(velocidadeAtual);
                System.out.println(estadoAtual(carro));
            }
        } else {
            System.out.println("Carro desligado. Ligue primeiro.\n");
        }
        System.out.println();
    }

    @Override
    public void frear(Carro carro, int velocidadeAMenos) {
        if (carro.isLigado()) {
            if (carro.getVelocidadeAtual() > 0) {
                System.out.printf("Freando o carro em %skm/h...\n", velocidadeAMenos);
                int velocidadeAtual = carro.getVelocidadeAtual() - velocidadeAMenos;
                carro.setVelocidadeAtual(velocidadeAtual);
                System.out.println(estadoAtual(carro));
            }
            if (carro.getVelocidadeAtual() == 0) {
                System.out.printf("O carro esta parado. Não tem como diminuir a velocidade.\n");
            }
        } else {
            System.out.println("Carro desligado. Ligue primeiro para poder frear.\n");
        }
        System.out.println();
    }

    @Override
    public void ligar(Carro carro) {
        carro.setLigado(true);
        System.out.println("Carro ligado.\n");
    }

    @Override
    public void desligar(Carro carro) {
        if (!carro.isLigado()) {
            System.out.println("Carro desligado. Liguei o carro para depois desligar...\n");
        }
        if (carro.getVelocidadeAtual() != 0) {
            System.out.printf("Carro está a %s, desacelere até 0km/h para desligar...\n");
        } else {
            carro.setLigado(false);
            System.out.println("Carro desligado.");
        }
    }

    @Override
    public String estadoAtual(Carro carro) {
        String estadoAtual;
        if(carro.isLigado()){
            estadoAtual = "O carro está ligado e a " + carro.getVelocidadeAtual() + "km/h";
        } else {
            estadoAtual = "O carro está desligado...";
        }
        return estadoAtual;
    }
}
