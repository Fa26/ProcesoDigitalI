

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
import java.awt.*;

public class Texto{

	
 


     public String text(){
        JFrame frame = new JFrame("Introduce el texto");
        String name=JOptionPane.showInputDialog(frame,
        "Ingresa un texto a poner: ");
        String e=name;
        return e;

        }

     public Color PromedioRegion(int inicioa, int fina,int iniciol, int finl, BufferedImage img, Boolean f){
        int rp =0;
        int gp =0;
        int bp =0;
        int cantidad = (img.getHeight() / 40)*(img.getWidth() /40) ;
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
    }


 public BufferedImage FiltroTexto(BufferedImage bi) throws BadLocationException{
  

    String texto=text();
    int a =  bi.getHeight() / 40;
    int l = bi.getWidth() / 40;
    int aux = 0;
    String s = "";
    if(bi != null){
        for (int y = 0; y < 40; y++){
            if(y > 0) s += "\n";
            for (int x = 0 ; x < 40; x++){
                if(aux == texto.length()){
                    s += " ";
                    aux = 0;
                } else{
                    s += texto.substring(aux, aux+1);
                    aux++;
                }
            }
        }
    }

    StyleContext sc = new StyleContext();
    DefaultStyledDocument doc = new DefaultStyledDocument(sc);
    JTextPane pane = new JTextPane(doc);

    JFrame f = new JFrame("Filtro Texto con Color");
    doc.insertString(0, s, null);

   
    Color c = new Color(0,0,0);
    int contador = 0;
    for (int h = 0; h < 40; h++){
            if(h > 0) contador++ ;
            for (int k = 0 ; k < 40; k++){
                Style estilo = sc.addStyle("ConstantWidth", null);
                c = PromedioRegion(k*l,(k*l)+l,h*a,(h*a)+a,bi,false);
                StyleConstants.setForeground(estilo, c);
                doc.setCharacterAttributes(contador++, 1, estilo, false);
            }
        }
    pane.setFont(new Font("Courier New", Font.PLAIN, 15));
    f.getContentPane().add(new JScrollPane(pane));
    f.setSize(600, 1000);
    f.setVisible(true);
    return bi;
 }
 
}