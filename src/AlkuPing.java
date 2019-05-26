import java.io.IOException;
import java.net.InetAddress;
import java.util.GregorianCalendar;

public class AlkuPing {

    public static void sendPingRequest(String ipAddress)
            throws IOException
    {
        InetAddress pingService = null;
        try{
             pingService = InetAddress.getByName(ipAddress);
        }catch (Exception ex){
            System.out.println("Boyle bir host yok!");
            return;
        }
        System.out.println("Ping istegi gonderiliyor =>  " + ipAddress);
        long bitis = 0;
        long baslangic = new GregorianCalendar().getTimeInMillis();

        if (pingService.isReachable(5000)) {
            bitis = new GregorianCalendar().getTimeInMillis();

            System.out.println("Hosta erisilebilir.");
            System.out.println("Ping RTT: " + (bitis - baslangic) + " ms.");
        }
        else
            System.out.println("Uzgunum, bu hosta erisilemedi.");
    }



    public static void main(String[] args) throws IOException {
        String ipAddress = "google.com";
        sendPingRequest(args[0]);
    }
}
+