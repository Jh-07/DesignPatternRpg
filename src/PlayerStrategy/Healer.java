package PlayerStrategy;

public class Healer implements Player {
    static private Healer healer;
    private Healer(){}   
    static public Healer getInstance(){
        if(healer==null){
            healer = new Healer();
           
        }
        return healer;
    }
    @Override
    public void action() {
        System.out.println("Heal!, Buffs!");
    }
}
