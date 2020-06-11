
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

public class Gris3 extends JFrame{
	
	BufferedImage image= null;
	int width;
	int height;

	public Gris3(){
		super("Gris3");
		Gray3();
		setSize(900,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}//fin del constructor Gris3

	public void Gray3(){
		try{
			File input = new File("Imagen15.jpg");
			image=ImageIO.read(input);
			width=image.getWidth();
			height=image.getHeight();

			Random rnd = new Random();
			for(int i=0;i<height;i++){
				for(int j=0;j<width; j++){
					Color c = new Color(image.getRGB(j,i));
					int green=(int)(c.getGreen());
					Color newColor = new Color(green,green,green);
					image.setRGB(j,i,newColor.getRGB());

				}
			}
			File up = new File("Gris3.jpg");
			ImageIO.write(image,"jpg",up);
		}catch(Exception e){}

	}//fin del metodo Gray3

	public void paint(Graphics g){
		 	ImageIcon imen = new ImageIcon(getClass().getResource("Gris3.jpg"));
		g.drawImage(image,10,10,getWidth()-10,getHeight()-10,null);


	}

	public void ventanaG3(){
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
		Gris3 obj = new Gris3();
	}

}//fin de la clase Gris3