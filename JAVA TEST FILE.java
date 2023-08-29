package groupchat;

public class TestClass {
    public static void main(String[] args) {
        Network network = new Network();
        System.out.println("Local  IP : " + network.getLocalIP());
        System.out.println("Global IP : " + network.getGlobalIP());
    }
}
