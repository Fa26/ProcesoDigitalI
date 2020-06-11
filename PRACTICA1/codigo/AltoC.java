

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

public class AltoC extends JFrame{
	
	BufferedImage image= null;
	int width;
	int height;

	public AltoC(){
		super("Alto Constranste");
		Alcon();
		setSize(900,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}//fin del constructor AltoC

	public void Alcon(){
		try{
			File input = new File("Imagen14.jpg");
			image=ImageIO.read(input);
			width=image.getWidth();
			height=image.getHeight();
			Color newColor;

			Random rnd = new Random();
			for(int i=0;i<height;i++){
				for(int j=0;j<width; j++){
					Color c = new Color(image.getRGB(j,i));
					int blue = (int)(c.getBlue());
					int green = (int)(c.getGreen());
					int red =(int)(c.getRed());
					int gray=(int)((blue+green+red)/3);

					if(gray>=127){
					 newColor = new Color(255,255,255);
					 image.setRGB(j,i,newColor.getRGB());
					}if(gray<127){
					newColor = new Color(0,0,0);
					image.setRGB(j,i,newColor.getRGB());
					}
				}
			}
			File up = new File("altoConstraste.jpg");
			ImageIO.write(image,"jpg",up);
		}catch(Exception e){}

	}//fin del metodo Alcon

	public void paint(Graphics g){
		 	ImageIcon imen = new ImageIcon(getClass().getResource("altoConstraste.jpg"));
		g.drawImage(image,10,10,getWidth()-10,getHeight()-10,null);


	}

	public void ventanaCon(){
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
		AltoC obj = new AltoC();
	}

}//fin de la clase AltoC