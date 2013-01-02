package model;
import java.net.*; 
import java.io.*; 

	
public class DHttp {

	public String getUrl(String urlAddress){
		
		try { 
			String page = new String();
			URL url = new URL(urlAddress); 
            BufferedReader in = new BufferedReader( 
                new InputStreamReader(url.openStream())); 
            String inputLine; 
    
            while ((inputLine = in.readLine()) != null) { 
            	page += inputLine;
            } 
            in.close(); 
            return page;
    
        } catch (MalformedURLException me) { 
            System.out.println(me); 
    
        } catch (IOException ioe) { 
            System.out.println(ioe); 
        }
		return null;
	}
	
	
};

