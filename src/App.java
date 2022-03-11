public class App {
    public static void main(String[] args) throws Exception {
        
        Carro carro = new Carro(0,50,100,5,2);
        carro.abastecer(1, 50);
        System.out.println(carro.getVolume_combustivel());
        carro.acelerar(2);
        System.out.printf("%.2f",carro.getVolume_combustivel());
        carro.frear(2);
        System.out.println(carro.getVAtual());
    } 
}
