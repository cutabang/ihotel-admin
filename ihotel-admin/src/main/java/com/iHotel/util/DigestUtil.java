package com.iHotel.util;

import java.security.MessageDigest;

//import org.apache.commons.codec.digest.DigestUtils;

public class DigestUtil {
	
	public static void main(String [] arg) throws Exception {
        System.out.println(digest("ihotel**"));
        //System.out.println(DigestUtils.shaHex("HENRYL2508"));
		
	}
	
	 public static String digest(String plain) throws Exception {
         if (plain == null) return null;
         
         try {
        	 plain = plain.trim();

        	 MessageDigest sha = MessageDigest.getInstance("SHA-1");
        	 sha.update(plain.getBytes("UTF-16"));
        	 byte bs[] = sha.digest();
        	 StringBuffer res = new StringBuffer();
        	 for (int ix=0; ix<bs.length; ix++) {
        		 int i;
        		 byte b = bs[ix];
        		 if (b > 0) i = b; else i = 256 + b;
        		 int d = i / 16;
        		 if (d > 9) res.append((char) ('A' + d - 10)); else
        			 res.append((char) ('0' + d));
        		 d = i % 16;
        		 if (d > 9) res.append((char) ('A' + d - 10)); else
        			 res.append((char) ('0' + d));
        	 }
        	 return res.toString();
         } catch (Exception ex) {
        	 throw new Exception("Digest Exception",ex);
         }
 }
}