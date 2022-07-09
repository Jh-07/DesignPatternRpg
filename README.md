# Projeto usando Design Patterns Singleton, Facade e Strategy

## Visão geral

Este é um projeto simples  na qual temos um grupo de RPG que consiste de 3 jogadores: um Tank, um healer e um dps. Cada um deles tem uma ação diferente em combate

### Interface Player

Todo jogador tem uma ação em combate

~~~~java
package PlayerStrategy;

public interface Player {
    void action();    
    
}
~~~~

### Classes diferentes

Todas as classes são **Singleton** , isto é cada classe possuirá uma única instancia .

#### Healer

~~~~java
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
~~~~

#### Tank

~~~~java
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

~~~~

#### DPS

~~~~~java
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

~~~~~

### Strategy

Com as classes e a interface implementada, temos um método em comum entre todas as classes

### Grupo/Facade

O grupo é composto por um jogador de cada classe e ele possui um método que coloca todos em combate (  _engage()_ )

~~~~java
package SingletonParty;

import PlayerStrategy.Healer;
import PlayerStrategy.Killer;
import PlayerStrategy.Tank;
import PlayerStrategy.Player;


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
~~~~

Com isso temos um App de execução bem simples:

~~~~java
import SingletonParty.Party;

public class App {
    public static void main(String[] args) throws Exception {
        Party p = Party.getInstance();
        p.engage();
    }
}
//Coloca todo o grupo em combate
~~~~

