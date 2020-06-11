




/**
*@author Venegas Guerrero Fatima Alejandra
*@version 1.0
*/

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.*;


public class Gris4 extends JFrame{
	
	BufferedImage image= null;
	int width;
	int height;

	public Gris4(){
		super("Gris4");
		Gray4();
		setSize(900,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}//fin del constructor Gris4

	public void Gray4(){
		try{
			File input = new File("Imagen5.jpg");
			image=ImageIO.read(input);
			width=image.getWidth();
			height=image.getHeight();
			Color newColor;

			for(int i=0;i<height;i++){
				for(int j=0;j<width; j++){
					Color c = new Color(image.getRGB(j,i));
					int blue = (int)(c.getBlue()*0.114);
					int green = (int)(c.getGreen()*0.587);
					int red =(int)(c.getRed()*0.299);
					int gray=blue+green+red;

					newColor = new Color(gray,gray,gray);
					image.setRGB(j,i,newColor.getRGB());
					
				}
			}
			File up = new File("Gris4.jpg");
			ImageIO.write(image,"jpg",up);
		}catch(Exception e){}

	}//fin del metodo Inver

	public void paint(Graphics g){
		 	ImageIcon imen = new ImageIcon(getClass().getResource("Gris4.jpg"));
		g.drawImage(image,10,10,getWidth()-10,getHeight()-10,null);


	}

	public void ventanaG4(){
		    int res = JOptionPane.showConfirmDialog(null,"Quieres probar otro Filtro?","Filtro",
         JOptionPane.INFORMATION_MESSAGE);
            if(res==JOptionPane.YES_OPTION){
               Filtros fe = new Filtros();
               fe.menu();
               
            }else{
               JOptionPane.showMessageDialog(null,"HASTA LUEGO!!! ");
               System.exit(0);

            }
	}
	
	static public void main(String args[])throws Exception{
		Gris4 obj = new Gris4();
	}

}//fin de la clase Gris4