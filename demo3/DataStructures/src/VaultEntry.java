import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.*;
import java.util.Base64;

public class VaultEntry {
    public String site;
    public String userName;
    public String password;

    public VaultEntry(String site,String userName,String password) {
        this.site=site;
        this.userName=userName;
        this.password=password;
    }


    public static void main(String[] args) throws Exception {
        String filePath="";
        Vault vault=new Vault();

        vault.addEntry("Youtube.com", "LionelMessi","barca123");
        vault.addEntry("Facebook.com","Ronaldo","1234");
        vault.addEntry("Outlook.com","Muslera","1905");


        vault.saveFile(filePath);



    }


}

class Vault{
    HashMap<String,VaultEntry> entries=new HashMap<>();
    public void addEntry(String site,String username,String password) {
        entries.put(site,new VaultEntry(site, username, password));
    }

    public void removeEntry(String site) {
        entries.remove(site);
    }

    public VaultEntry getEntry(String site) {
        return entries.get(site);
    }

    public boolean containsSite(String site) {
        return entries.containsKey(site);
    }

    public static String encode(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes());
    }

    public static String decode(String encoded) {
        return new String(Base64.getDecoder().decode(encoded));
    }


    public void saveFile(String filename) throws Exception {
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(filename))){
            for(String site:entries.keySet()) {
                VaultEntry entry=entries.get(site);
                writer.write(site+"  "+entry.userName+"  "+encode(entry.password));
                writer.write("\n");
            }
            writer.close();

        }catch(Exception e) {
            System.out.println("Exception occured");
        }
    }
}
