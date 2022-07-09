package PlayerStrategy;

public class Killer implements Player {
    static private Killer killer;
    private Killer(){}   
    static public Killer getInstance(){
        if(killer==null){
            killer = new Killer();
           
        }
        return killer;
    }
    @Override
    public void action() {
        System.out.println("Attack!, Execute! ");
    }
    
}
