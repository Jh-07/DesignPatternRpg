import SingletonParty.Party;

public class App {
    public static void main(String[] args) throws Exception {
        Party p = Party.getInstance();
        p.engage();
    }
}
