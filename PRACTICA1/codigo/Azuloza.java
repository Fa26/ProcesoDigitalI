
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

public class Azuloza extends JFrame{
	
	BufferedImage image= null;
	int width;
	int height;

	public Azuloza(){
		super("Azuloza");
		Azul();
		setSize(900,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}//fin del constructor Azuloza

	public void Azul(){
		try{
			File input = new File("Imagen2.jpg");
			image=ImageIO.read(input);
			width=image.getWidth();
			height=image.getHeight();

			for(int i=0;i<height;i++){
				for(int j=0;j<width; j++){
					Color c = new Color(image.getRGB(j,i));
					int blue = (int)(c.getBlue());
					Color newColor = new Color(0,0,blue);
					image.setRGB(j,i,newColor.getRGB());

				}
			}
			File up = new File("Azuloza.jpg");
			ImageIO.write(image,"jpg",up);
		}catch(Exception e){}

	}//fin del metodo Azuloza

	public void paint(Graphics g){
		 	ImageIcon imen = new ImageIcon(getClass().getResource("Azuloza.jpg"));
		g.drawImage(image,10,10,getWidth()-10,getHeight()-10,null);


	}

	public void ventanaAz(){
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
		Azuloza obj = new Azuloza();
	}



}//fin de la clase Azuloza