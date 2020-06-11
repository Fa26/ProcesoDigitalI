

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


public class GrisU extends JFrame{
	
	BufferedImage image= null;
	int width;
	int height;

	public GrisU(){
		super("Tono de Gris");
		griss();
		setSize(900,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}//fin del constructor GrisU

	public void griss(){
		try{
			File input = new File("Imagen6.jpg");
			image=ImageIO.read(input);
			width=image.getWidth();
			height=image.getHeight();

			
			for(int i=0;i<height;i++){
				for(int j=0;j<width; j++){
					Color c = new Color(image.getRGB(j,i));
					int blue = (int)(c.getBlue());
					int green = (int)(c.getGreen());
					int red =(int)(c.getRed());
					int gray=(int)((blue+green+red)/3);
					Color newColor = new Color(gray,gray,gray);
					image.setRGB(j,i,newColor.getRGB());

				}
			}
			File up = new File("GrisU.jpg");
			ImageIO.write(image,"jpg",up);
		}catch(Exception e){}

	}//fin del metodo  griss

	public void paint(Graphics g){
		 	ImageIcon imen = new ImageIcon(getClass().getResource("GrisU.jpg"));
		g.drawImage(image,10,10,getWidth()-10,getHeight()-10,null);


	}

	public void ventanaG(){
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
		GrisU obj = new GrisU();
	}

}//fin de la clase GrisU