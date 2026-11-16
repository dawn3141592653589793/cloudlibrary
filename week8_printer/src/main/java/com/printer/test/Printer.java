package com.printer.test;

import com.printer.dao.Ink;
import com.printer.dao.Paper;

public class Printer {
    public Ink ink;
    public Paper paper;

    public void setInk(Ink ink) {
        this.ink = ink;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }
    public void print(String str){
        System.out.println("使用"+ink.getColor(255,0,0)+"颜色打印纸张。\r\t");
        for(int i=0;i<str.length();i++){
            paper.putInChar(str.charAt(i));
        }
        System.out.println(paper.getContent());
    }
}
