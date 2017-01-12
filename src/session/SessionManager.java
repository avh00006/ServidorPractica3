package session;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Juan Carlos
 */
public class SessionManager {
    
    public static final long SESSION_DURATION = 15000;//ms = 1 minute 
    
    /**
     * Devuelve un nuevo valor de una sesi�n v�lida desde el instante de la petici�n
     * @return el instante de validez final de la sesi�n
     */
    public static String newSession(){
        String expires=null;
        
        Date f= new Date();
        TimeZone tz = TimeZone.getDefault();
        long offset = tz.getOffset(f.getTime());
        Date fecha = new Date(System.currentTimeMillis()-3600000 + offset+SESSION_DURATION);
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd-H-m-s");
        expires = dt1.format(fecha);
    
        return expires;
    }
}