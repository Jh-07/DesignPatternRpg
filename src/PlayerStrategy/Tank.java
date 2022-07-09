package PlayerStrategy;

public class Tank implements Player {
    static private Tank tank;
    private Tank(){}   
    static public Tank getInstance(){
        if(tank==null){
            tank = new Tank();
           
        }
        return tank;
    }
    @Override
    public void action() {
        System.out.println("Defensive Stance!, Taunt!");
    }
    
}
