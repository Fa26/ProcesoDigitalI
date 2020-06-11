

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



public class AzulClaro extends JFrame{
	
	BufferedImage image= null;
	int width;
	int height;

	public AzulClaro(){
		super("Azul Claro");
		Azull();
		setSize(900,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}//fin del constructor Azar

	public void Azull(){
		try{
			File input = new File("Imagen1.jpg");
			image=ImageIO.read(input);
			width=image.getWidth();
			height=image.getHeight();

			
			for(int i=0;i<height;i++){
				for(int j=0;j<width; j++){
					Color c = new Color(image.getRGB(j,i));
					int blue = (int)(c.getBlue());
					int green = (int)(c.getGreen());
					int red =(int)(c.getRed());
					Color newColor = new Color(0,green,blue);
					image.setRGB(j,i,newColor.getRGB());

				}
			}
			File up = new File("AzulClaro.jpg");
			ImageIO.write(image,"jpg",up);
		}catch(Exception e){}

	}//fin del metodo Azull

	public void paint(Graphics g){
		 	ImageIcon imen = new ImageIcon(getClass().getResource("AzulClaro.jpg"));
		g.drawImage(image,10,10,getWidth()-10,getHeight()-10,null);


	}

	public void ventanaLight(){
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
		AzulClaro obj = new AzulClaro();
	}

}//fin de la clase AzulClaro