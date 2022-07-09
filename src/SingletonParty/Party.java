package SingletonParty;

import PlayerStrategy.Healer;
import PlayerStrategy.Killer;
import PlayerStrategy.Player;
import PlayerStrategy.Tank;

public class Party {
    private static Party party;

    private Party(){
        super();
    }
    
    Killer k = Killer.getInstance();
    Healer h = Healer.getInstance();
    Tank t = Tank.getInstance();
    Player[] arr = {k,h,t};

    public static Party getInstance(){
        if(party == null){
            party = new Party();
        }
        return party;
    }

    public void engage(){
        for (Player player : arr) {
            player.action();
        }
    }

}
