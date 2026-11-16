package com.printer.dao.impl;

import com.printer.dao.Paper;

public class TextPaper implements Paper {
    private int charPerLine=16;
    private int linePerPage=5;
    private String content="";
    private int posX=0;
    private int posY=0;
    private int posP=1;

    public void setCharPerLine(int charPerLine) {
        this.charPerLine = charPerLine;
    }

    public void setLinePerPage(int linePerPage) {
        this.linePerPage = linePerPage;
    }

    @Override
    public void putInChar(char c){
        content +=c;
        ++posX;
        //换行
        if(posX==charPerLine){
            content+=Paper.newLine;
            posX=0;
            ++posY;
        }
        //换页
        if(posY==linePerPage){
            content+="======"+posP+"页======";
            content+=Paper.newLine+Paper.newLine;
            posY=0;
            ++posP;
        }

    }

    @Override
    public String getContent(){
        String contents=this.content;
        if(posX!=0&&posY!=0){
            int count = linePerPage-posY;
            for(int i=0;i<count;i++){
                contents+=Paper.newLine;
            }
            content+="======"+posP+"页======";
        }
        return contents;
    }
}
