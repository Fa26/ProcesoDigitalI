
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

public class Rojiza extends JFrame{
	
	BufferedImage image= null;
	int width;
	int height;

	public Rojiza(){
		super("Rojiza");
		Rojo();
		setSize(900,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}//fin del constructor Rojiza

	public void Rojo(){
		try{
			File input = new File("Imagen10.jpg");
			image=ImageIO.read(input);
			width=image.getWidth();
			height=image.getHeight();

			for(int i=0;i<height;i++){
				for(int j=0;j<width; j++){
					Color c = new Color(image.getRGB(j,i));
					int red = (int)(c.getRed());
					Color newColor = new Color(red,0,0);
					image.setRGB(j,i,newColor.getRGB());

				}
			}
			File up = new File("Rojiza.jpg");
			ImageIO.write(image,"jpg",up);
		}catch(Exception e){}

	}//fin del metodo Rojo

	public void paint(Graphics g){
		 	ImageIcon imen = new ImageIcon(getClass().getResource("Rojiza.jpg"));
		g.drawImage(image,10,10,getWidth()-10,getHeight()-10,null);


	}

	public void ventanaRo(){
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
		Rojiza obj = new Rojiza();
	}

}//fin de la clase Rojiza