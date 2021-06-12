package com.online.videostreaming.classrooms.onlineclassrooms.utils;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;


public class CommonUtils {

    private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);

    public static int genRandomInt(int bound) {
        return ThreadLocalRandom.current().nextInt(bound);
    }

    public static int genRandomInt(int lowerBound, int upperBound) {
        if (lowerBound > upperBound) {
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        return lowerBound + ThreadLocalRandom.current().nextInt(upperBound - lowerBound);
    }

    public static long genRandomLong() {
        return ThreadLocalRandom.current().nextLong();
    }

    public static String loadFile(String filename) {
        try {
            URL url = CommonUtils.class.getClassLoader().getResource(filename);
            if (url == null) {
                logger.warn("file not exists: " + filename);
                return null;
            }
            Path path = Paths.get(url.toURI());
            return new String(Files.readAllBytes(path));
        } catch (Exception e) {
            logger.error("loadFile failed: " + filename);
        }
        return null;
    }
    
    public static String maskString(String strText, int start, int end, char maskChar) 
            throws Exception{
            
            if(strText == null || strText.equals(""))
                return "";
            
            if(start < 0)
                start = 0;
            
            if( end > strText.length() )
                end = strText.length();
                
            if(start > end)
                throw new Exception("End index cannot be greater than start index");
            
            int maskLength = end - start;
            
            if(maskLength == 0)
                return strText;
            
            StringBuilder sbMaskString = new StringBuilder(maskLength);
            
            for(int i = 0; i < maskLength; i++){
                sbMaskString.append(maskChar);
            }
            
            return strText.substring(0, start) 
                + sbMaskString.toString() 
                + strText.substring(start + maskLength);
        }
     
    public static void main(String[] args) throws Exception {
		
    	
    	System.out.println(maskString("9319540045",0,6,'*'));
	}
}

