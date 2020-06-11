

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.*;

public class Filtro3{
	
	 ImageIcon Seleccion;
    BufferedImage imagen;
     
 
    public Color PromedioRegion(int inicioa, int fina,int iniciol, int finl, BufferedImage img, Boolean f){
        int rp =0;
        int gp =0;
        int bp =0;
        int h=img.getHeight();
        int w=img.getWidth();
        int cantidad = (img.getHeight() / 80)*(img.getWidth() /80);
           for(int a = inicioa ; a < fina;a++){
            for(int b= iniciol;b< finl;b++){
             if(a<img.getWidth()){
               if(b<img.getHeight()){
                  Color c1=new Color(img.getRGB(a, b));
                  rp+= c1.getRed();
                  gp+= c1.getGreen();
                  bp+= c1.getBlue();
               }
             }
            }
        }
        rp = (int)(rp/cantidad);
        gp = (int)(gp/cantidad);
        bp = (int)(bp/cantidad);
        return new Color(rp,gp,bp);
    }//fin del metodo


     public int PromedioRegion(int inicioa, int fina,int iniciol, int finl, BufferedImage img){
        int rp =0;
        int gp =0;
        int bp =0;
        int cantidad = (img.getHeight() / 80)*(img.getWidth() /80) ;
        for(int a = inicioa ; a < fina;a++){
            for(int b= iniciol;b< finl;b++){
             if(a<img.getWidth()){
               if(b<img.getHeight()){
                  Color c1=new Color(img.getRGB(a, b));
                  rp+= c1.getRed();
                  gp+= c1.getGreen();
                  bp+= c1.getBlue();
               }
             }
            }
        }
        rp = (int)(rp/cantidad);
        gp = (int)(gp/cantidad);
        bp = (int)(bp/cantidad);
        int promedio = (int)((rp + gp + bp)/3);
        return promedio;
    }


    public  BufferedImage  Cadena3(BufferedImage bi){
   


    int a =  bi.getHeight() / 80;
    int l = bi.getWidth() / 80;
    int med=0;
    String s = "";
    if(bi != null){
        for (int y = 0; y < 80; y++){
            if(y > 0) s += "\n";
            for (int x = 0 ; x < 80; x++){
                 med= PromedioRegion(x*l,(x*l)+l,y*a,(y*a)+a,bi);
                if (med >= 0 && med < 16){
                    s += "M";
                } else if(med >= 16 && med < 32){
                    s += "N";
                }else if(med >= 32 && med < 48){
                    s += "H";
                }else if(med >= 48 && med < 64){
                    s += "#";
                }else if(med >= 64 && med < 80){
                    s += "Q";
                }else if(med >= 80 && med < 96){
                    s += "U";
                }else if(med >= 96 && med < 112){
                    s += "A";
                }else if(med >= 112 && med < 128){
                    s += "D";
                }else if(med >= 128 && med < 144){
                    s += "O";
                }else if(med >= 144 && med < 160){
                    s += "Y";
                }else if(med >= 160 && med < 176){
                    s += "2";
                }else if(med >= 176 && med < 192){
                    s += "$";
                }else if(med >= 192 && med < 208){
                    s += "%";
                }else if(med >= 208 && med < 224){
                    s += "+";
                }else if(med >= 224 && med < 240){
                    s += "_";
                }else if(med >= 240 && med < 256){
                    s += " ";
                }

            }
        }
    }
    
try{
     StyleContext sc = new StyleContext();
    DefaultStyledDocument doc = new DefaultStyledDocument(sc);
    JTextPane pane = new JTextPane(doc);

    JFrame f = new JFrame("Cadena,Color");
   doc.insertString(0, s, null);

    Color c = new Color(0,0,0);
    int contador=0;
    for(int h=0;h<80;h++){
    	if(h<0)contador++;
    	for (int k=0;k<80 ;k++ ) {
    		Style estilo = sc.addStyle("ConstantWidth", null);
    		c=PromedioRegion(k*l,(k*l)+l,h*a,(h*a)+a,bi,false);
    		       StyleConstants.setForeground(estilo, c);
                doc.setCharacterAttributes(contador++, 1, estilo, false);
    		
    	}
    }
     f.getContentPane().add(new JScrollPane(pane));
    f.setSize(1000, 900);
    f.setVisible(true);
}catch(Exception e){}
    return bi;

 }//fin del metodo
}