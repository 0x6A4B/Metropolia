package model;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

// real unique hardware identifier would be best get with OSHI library's functions
// one could also gather MAC addresses for all NIC's since the user might vary between WLAN and LAN
// but it's all unnecessary for this use and we wish to id the user also if multiple users on same machine
public class UniqueSystem {

    // simplest identifier imaginable, but it's acceptable for ID'ing the machine and user, at least for this case
    public UUID getId(){
        String username = System.getProperty("user.name");
        String hostname = "";
        try{
            hostname = InetAddress.getLocalHost().getHostName();
            // this is not acceptable but certain Java versions accept it...
            //return UUID.fromString(hostname + username);
            return UUID.nameUUIDFromBytes((hostname + username).getBytes()); // this is expected way
            //return UUID.fromString(InetAddress.getLocalHost().getHostName() + System.getProperty("user.name"));
        }catch(UnknownHostException e) {
            if (hostname == null || hostname.equals("")){
                String os = System.getProperty("os.name");
                if (os.toLowerCase().contains("win"))
                    hostname = System.getenv("COMPUTERNAME");
                else
                    hostname = System.getenv("HOSTNAME");  // WINNNN!!! ALL operating systems are POSIX!!!
                                                                // except for the weirdo outlier called windose
                                                                // how ya like dem apples william gates?!
                }
            }
            if (hostname != null && !hostname.equals(""))
                return UUID.nameUUIDFromBytes((hostname + username).getBytes());
            System.out.println("Couldn't get hostname! Using just user name for UUID");
            return UUID.nameUUIDFromBytes(username.getBytes());
        }
}
