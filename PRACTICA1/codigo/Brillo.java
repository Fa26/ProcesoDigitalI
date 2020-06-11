

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

public class Brillo extends JFrame{
	
	BufferedImage image= null;
	int width;
	int height;

	public Brillo(){
		super("Brillo");
		Bri();
		setSize(900,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}//fin del constructor Brillo

	public int entero(){
		JFrame frame = new JFrame("Introduce numero para el brillo");
		String name=JOptionPane.showInputDialog(frame,
			"Ingresa un numero de Brillo: ");
		int e=Integer.parseInt(name);
		return e;

	}

	public void Bri(){
		try{
			int n = entero();
			File input = new File("p.jpg");
			image=ImageIO.read(input);
			width=image.getWidth();
			height=image.getHeight();
			Color newColor;
		
			for(int i=0;i<height;i++){
				for(int j=0;j<width; j++){
					Color c = new Color(image.getRGB(j,i));
					int blue = (int)(c.getBlue() + n);
					int green = (int)(c.getGreen() + n);
					int red =(int)(c.getRed()+ n);
					int suma=(int)(blue+green+red);

					if(suma>255){
					 newColor = new Color(255,255,255);
					 image.setRGB(j,i,newColor.getRGB());
					}if(suma<0){
					newColor = new Color(0,0,0);
					image.setRGB(j,i,newColor.getRGB());
					}
				}
			}
			File up = new File("Brillo.jpg");
			ImageIO.write(image,"jpg",up);
		}catch(Exception e){}

	}//fin del metodo Bri

	public void paint(Graphics g){
		 	ImageIcon imen = new ImageIcon(getClass().getResource("Brillo.jpg"));
		g.drawImage(image,10,10,getWidth()-10,getHeight()-10,null);


	}
	public void ventanaBri(){
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
	Brillo obj = new Brillo();
	}

}//fin de la clase Brillo