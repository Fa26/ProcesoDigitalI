


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
import java.util.Random;

public class Gris1 extends JFrame{
	
	BufferedImage image= null;
	int width;
	int height;

	public Gris1(){
		super("Gris1");
		Gray1();
		setSize(900,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}//fin del constructor Gris1

	public void Gray1(){
		try{
			File input = new File("Imagen3.jpg");
			image=ImageIO.read(input);
			width=image.getWidth();
			height=image.getHeight();

			Random rnd = new Random();
			for(int i=0;i<height;i++){
				for(int j=0;j<width; j++){
					Color c = new Color(image.getRGB(j,i));
					int blue=(int)(c.getBlue());
					Color newColor = new Color(blue,blue,blue);
					image.setRGB(j,i,newColor.getRGB());

				}
			}
			File up = new File("Gris1.jpg");
			ImageIO.write(image,"jpg",up);
		}catch(Exception e){}

	}//fin del metodo Gray1

	public void paint(Graphics g){
		 	ImageIcon imen = new ImageIcon(getClass().getResource("Gris1.jpg"));
		g.drawImage(image,10,10,getWidth()-10,getHeight()-10,null);


	}

	public void ventanaG1(){
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
		Gris1 obj = new Gris1();
	}

}//fin de la clase Gris1