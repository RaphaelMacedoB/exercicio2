public class Carro {
    private double quilometragem;
    private double volume_combustivel;
    private double capacidade_tanque;
    private double velMaxima;
    private double velAtual = 0;
    private double aceleracaoMedia;
    private double consumoMedio;

    Carro(double quilometragem, double capacidade_tanque, double velMaxima, double aceleracaoMedia, double consumoMedio){
        this.quilometragem = quilometragem;
        this.capacidade_tanque = capacidade_tanque;
        setVmax(velMaxima);
        setAceleracaoMedia(aceleracaoMedia);
        this.consumoMedio = consumoMedio;
    }
    
    public double getQuilometragem(){
        return this.quilometragem;
    }
    public void setQuilometragem( double quilometragem){
        this.quilometragem = quilometragem;
    }

    public double getVolume_combustivel(){
        return this.volume_combustivel;
    }

    public double getCapacidadeTanque(){
        return this.capacidade_tanque;
    }

    public void setCapacidadeTanque(double capacidade_tanque){
        this.capacidade_tanque = capacidade_tanque;
    }

    public double getVmax(){
        return this.velMaxima;
    }

    public void setVmax(double velMaxima){
        if(velMaxima < 0){
            System.out.println("Velocidade não pode ser negativa!");
        }else{
            this.velMaxima = velMaxima;
        }
    }

    public double getVAtual(){
        return this.velAtual;
    }

    public double getAceleracaoMedia(){
        return this.aceleracaoMedia;
    }

    public void setAceleracaoMedia(double aceleracaoMedia){
        if(aceleracaoMedia < 0){
            System.out.println("Aceleração média não pode ser negativa");
        }else{
            this.aceleracaoMedia = aceleracaoMedia;
        }
    }

    public double getConsumoMedio(){
        return this.consumoMedio;
    }

    public void setConsumoMedio(double consumoMedio){
        this.consumoMedio = consumoMedio;
    }

    public void abastecer(double custo_litro, double valor_pago_frentista) {
        double litros = valor_pago_frentista / custo_litro;
        double l = 1;
        if (litros > 0) { 
            do {
                if (litros < 1) {
                    l = litros;
                    litros = 0;
                } else
                    litros--;
                if (this.capacidade_tanque < (this.volume_combustivel + l)){
                    System.out.println("Capacidade máxima do tanque do veículo atingida.");
                    return;
                }
                    
                this.volume_combustivel += l;
            } while (litros != 0);
        }
    }

    public void acelerar(double tempo){
        double t = tempo;
        if(volume_combustivel <= 0){
            System.out.println("Veículo sem combustível!");
        }else{
            do{
                if(tempo < 0){
                    t = tempo;
                    tempo = 0;
                }
                velAtual += aceleracaoMedia;
                double distancia = velAtual*t;
                volume_combustivel -= ((consumoMedio / 3.6) * distancia);
                tempo --;
            }while(tempo > 0);
        }
    }

    public void frear(double tempo){
        double t = tempo;
            do{
                if(tempo < 0){
                    t = tempo;
                    tempo = 0;
                }
                velAtual -= aceleracaoMedia;
                double distancia = velAtual*t;
                volume_combustivel -= ((consumoMedio / 3.6) * distancia);
                tempo --;
            }while(tempo > 0);
        
    }
}


