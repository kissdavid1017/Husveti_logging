import org.apache.logging.log4j.*;
import java.util.Scanner;
public class Main {

    public static final Logger logger=LogManager.getLogger();
    public static  final Marker KIJELENTES_MARKER=MarkerManager.getMarker("Kijelentes");
    public static  final Marker FELTETELEZES_MARKER=MarkerManager.getMarker("Feltetelezes");
    public static  final Marker KERDES_MARKER=MarkerManager.getMarker("Kerdes");
    public static void main(String[] args) throws InterruptedException {//a thread.sleep miatt raktam be az interrupted Exceptiont
        Scanner myInput = new Scanner( System.in );
        System.out.print( "Ird be az iteráció számát" );
        var iteracioSzam=myInput.nextInt();


        for (int i=1;i<=iteracioSzam;i++)
        {
            ThreadContext.put("iteráció:", String.valueOf(i));
            logger.info(KIJELENTES_MARKER,"Van nekem egy kis locsolóm");
            logger.error("Kölni nincsen benne");
            logger.debug(FELTETELEZES_MARKER,"Ha én azt most elővenném");
            logger.fatal(KIJELENTES_MARKER,"Nagy röhögés lenne");
            logger.info(KERDES_MARKER,"Szabad-e locsolni?");

            ThreadContext.clearAll();
            Thread.sleep(3000);
        }

    }
}
