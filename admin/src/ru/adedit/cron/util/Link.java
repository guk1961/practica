package ru.adedit.cron.util;


public class Link {
    private String text;
    private String href;
    private int num=0;
    
    public Link(String text, String href) {
        if(text==null) text = "";
        if(href==null) href = "";
        this.text = text;
        this.href = href;
        
        if (text!="...")
            {this.num=Integer.parseInt(text);}
//        else{this.num=Integer.parseInt(text);}
    }
    public int getNum(){
        return this.num;
    }

    public String toString() {
        return "<a href=\""+href+"\">"+text+"</a>";
    }
}
