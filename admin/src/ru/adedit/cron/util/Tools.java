/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.adedit.cron.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tools
{
    private static String i;
    /** Creates a new instance of Main */
    private int test;
    private String s="true";
    private String host="";
    private String ip="";
    private String storeName="";

    public String getHost(String ip) throws IOException {
 
            InetAddress addr = null;
        try {
            if (addr.isReachable(11)){
             addr = InetAddress.getByName(ip);
            if ( addr.isReachable(11))
                host=addr.getCanonicalHostName();//.getHostName();
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return host;
    }


    public String getIp() {
        return ip;
    }


    public Tools()
    {
        System.out.println("=="+Math.round(Math.floor(1.0)));
    }

    
    public boolean getParity(int test){
        setTest(test);

        int t=test/2;
//            System.out.println("----------->>>"+t);
        if ((t*2)<test)    {
            setS("false");
            return false;
        }
            setS("true");
            return true;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
;

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    public String tostring(){

        return s;
    };

    public String getStoreName(byte[] store){
        //byte b;
        char c;
        String sss="";
        for(byte b : store){
                c=(char)b;
                sss=(c=='/')?sss+"/":sss+c;
        }
        return sss;
    };

    public static void main(String[] args)
    {
        String host="";
        Boolean yes=null;

        Tools tools = new Tools();
        for(int i=0;i<1;i++){
            tools.getParity(i);
                InetAddress addr = null;
            try {
                addr = InetAddress.getByName("192.168.77.136");
                    yes = addr.isSiteLocalAddress();;
            } catch (UnknownHostException ex) {
                Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
            }
//                    yes=addr.isReachable(1);
//                    yes=addr.isReachable(111);
//                    yes = addr.isAnyLocalAddress();
                    //host=addr.getCanonicalHostName();

                System.out.println(addr.getHostName()+" "+i + " - " + tools.tostring() +"==="+ host+"==="+yes+(byte)'/');
            }

        }
}