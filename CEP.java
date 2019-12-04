import java.util.Random;

public class CEP {
    public int seuCep;
    public Arvore a = new Arvore();

    public int geraRandom(){
        int min = 10000000;
        int max = 99999999;
        return (int) ((Math.random() * (max - min)) + min);
        
    }

    public void printaCEP(){
        a.print();
    }

    public void addCEP(Integer cep){
        if(cep < 10000000 || cep > 999999999){
            a.add(geraRandom());
        }
        else{
            a.add(cep);
        }
    }

    public void addCEP(){
        a.add(geraRandom());
    }

    public boolean cepIsEmpty(){
        return a.isEmpty();
    }

    public Integer getParentCep(Integer e){
        return a.getParent(e);
        
    }

    public Integer getCep(int e){
        return a.get(e);
    }

    public int cepHeight(){
        return a.height();
    }

    public int cepSize(){
        return a.size();
    }

    public LinkedListOfInteger positionsPreCep(){
        return a.positionsPre();
    }

    public LinkedListOfInteger positionsPosCep(){
        return a.positionsPos();
    }

    public LinkedListOfInteger positionsCentralCep(){
        return a.positionsCentral();
    }

    public LinkedListOfInteger positionsWidthCep(){
        return a.positionsWidth();
    }

    public Arvore clone(){
        return a.clone();
    }
    
}