/**
 * @author Venegas Guerreo Fatima Alejandra
 * num cuenta: 310318738
 */


import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.JSplitPane;
import javax.swing.text.BadLocationException;


public class PaintImage extends JPanel implements ActionListener 
{
  public static BufferedImage image;
  public static BufferedImage image2;
  public static BufferedImage image3;
  public static BufferedImage image4; 
  public static BufferedImage image5; 
  public static BufferedImage image6; 
  public static BufferedImage image7;
  public static BufferedImage image8;
  public static BufferedImage image9;


  Gris g = new Gris();
  Filtros2 f = new Filtros2();
  Filtro3 f3 = new Filtro3();
  Texto t = new Texto();
//ImageRGB i;
  JButton boton1,boton2;
  //Esteganografia e = new Esteganografia();

  private   JMenuBar menubar;
  private  static JMenu m1;
  private  static  JMenu m2 ;

  public PaintImage() {
        setLayout(null);
        boton1=new JButton("Filtros");
        boton1.setBounds(0,0,70,70);
        add(boton1);
        boton1.addActionListener(this);

        boton2=new JButton("Salir");
        boton2.setBounds(70,0,70,70);
        boton2.addActionListener(this);
        add(boton2);
    }
  
   public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton1) {
            window();
        }if(e.getSource()==boton2){
          System.exit(0);
        }
    }
 

  public void dibuja(String opcion){
    
    try{               
    image = ImageIO.read(new File("piano.jpg"));
    image3= ImageIO.read(new File("n.png"));
    image4= ImageIO.read(new File("einvigi_10_halldor_1.jpg"));
    image5= ImageIO.read(new File("einvigi_10_halldor_3.jpg"));
    image6= ImageIO.read(new File("einvigi_10_halldor_6.jpg"));
    image7 = ImageIO.read(new File("einvigi_10_halldor_8.jpg"));
    //i= new ImageRGB("f.bmp");
    image9 = ImageIO.read(new File("img2.jpg"));
    if(opcion.equals("Gris3")){
        image2= g.Gray3(image);
    }  if(opcion.equals("AltoC")){
      image2=g.AltoC(image);
    }if(opcion.equals("Gris1")){
        image2= g.Gray1(image);
    }if(opcion.equals("Gris2")){
        image2= g.Gray2(image);
    }if(opcion.equals("Gris4")){
        image2= g.Gray4(image);
    }if(opcion.equals("Brillo")){
        image2= g.Brillo(image);
    }if(opcion.equals("Mosaico")){
        image2= g.Mosaico(image);
    }if(opcion.equals("Verde")){
        image2= g.Verde(image);
    }if(opcion.equals("Azul")){
        image2= g.Azul(image);
    }if(opcion.equals("Rojo")){
        image2= g.Rojo(image);
    }if(opcion.equals("Rosa")){
        image2= g.Rosa(image);
    }if(opcion.equals("Amarillo")){
        image2= g.Amarillo(image);
    }if(opcion.equals("AzulClaro")){
        image2= g.AzulClaro(image);
    }if(opcion.equals("Inverso")){
        image2= g.Inverso(image);
    }if(opcion.equals("Mediano")){
        image2= g.Mediano(image3);
    }if(opcion.equals("Emboss")){
        image2= g.Emboss(image);
    }if(opcion.equals("Bordes")){
        image2= g.Edege(image);
    }if(opcion.equals("MotionBlur")){
        image2= g.MBlur(image);
    }if(opcion.equals("Sharpen")){
        image2= g.Sharpen(image);
    }if(opcion.equals("Blur")){
        image2= g.Blur(image);
    }if(opcion.equals("Bordes2")){
        image2= g.edge2(image);
    }if(opcion.equals("Bordes3")){
        image2= g.edge3(image);
    }if(opcion.equals("Bordes4")){
        image2= g.edge4(image);
    }if(opcion.equals("Sharpen2")){
        image2= g.Sharpen2(image);
    }if(opcion.equals("Emboss1")){
        image2= g.Emboss1(image);
    }if(opcion.equals("mean")){
        image2= g.mean(image);
    }if(opcion.equals("@_Color")){
        try{
        image2= g.FiltroUnaLetra(image);
        }catch(Exception e){}
    }if(opcion.equals("M_B/N")){
        try{
        image2= g.UnaLetraBN(image);
        }catch(Exception e){}
    }if(opcion.equals("M_Color")){
        try{
        image2= g.UnaLetra(image);
        }catch(Exception e){}
    }if(opcion.equals("MNH#AD")){
        try{
        image2= f.Cadena(image);
        }catch(Exception e){}
    }if(opcion.equals("MNH#AD_Color")){
        try{
        image2= f3.Cadena3(image);
        }catch(Exception e){}
    }if(opcion.equals("Texto")){
        try{
        image2= t.FiltroTexto(image);
        }catch(Exception e){}
    }/*if(opcion.equals("MarcaAgua")){
        image2=g.marcaAgua(i,"holaSugaamormio");
    }*/if(opcion.equals("MarcaAgua3")){
        image2=g.marcaAgua1(image5);

    }if(opcion.equals("MarcaAgua6")){
        image2=g.marcaAgua1(image6);

    }if(opcion.equals("MarcaAgua8")){
        image2=g.marcaAgua1(image7);

    }/*if(opcion.equals("Estenografia")){
        image2=e.escondeTexto(i,"hola suga");

    }*/if(opcion.equals("Sepia")){
        image2=g.Sepia(image9);

    }

    }catch (IOException ef){}

  }

  	public void ventanaG1(){
		    int res = JOptionPane.showConfirmDialog(null,"Quieres probar otro Filtro?","Filtro",
         JOptionPane.INFORMATION_MESSAGE);
            if(res==JOptionPane.YES_OPTION){
              window();
               
            }else{
               JOptionPane.showMessageDialog(null,"HASTA LUEGO!!! ");
               System.exit(0);

            }
	}
	

  public void paintComponent(Graphics g)
  {
    g.drawImage(image2, 0, 0, null);
    repaint();
  }

  public void window(){
    	String[] pintar={"Azul","Verde",
						"Rojo","Gris3",
						"Amarillo","Rosa",
						"AzulClaro","Gris1",
						"Gris2","Gris4",
						"AltoConstraste","Inverso",
						"Brillo","Mosaico","Mediano","Emboss",
            "Bordes","MotionBlur","Sharpen","Blur","Bordes_2",
             "Bordes_3","Bordes_4","Sharpen_2","Emboss_1",
            "Mean","@_Color","M_B/N","M_Color","MNH#AD",
            "MNH#AD_Color","Texto","MarcaAgua3",
            "MarcaAgua6","MarcaAgua8","Esteganografia",
        "Sepia"};
		JFrame frame = new JFrame("R,G,B");
		String colores=(String)JOptionPane.showInputDialog(frame,
			"Elige una opcion",
			"Filtros",
			JOptionPane.QUESTION_MESSAGE,
			null,
			pintar,
			pintar[0]);
		if(colores.equals("Gris3")){
      dibuja("Gris3");
		}if(colores.equals("AltoConstraste")){
      dibuja("AltoC");
    }if(colores.equals("Gris1")){
      dibuja("Gris1");
		}if(colores.equals("Gris2")){
      dibuja("Gris2");
		}if(colores.equals("Gris4")){
      dibuja("Gris4");
		}if(colores.equals("Brillo")){
      dibuja("Brillo");
		}if(colores.equals("Mosaico")){
      dibuja("Mosaico");
		}if(colores.equals("Verde")){
      dibuja("Verde");
		}if(colores.equals("Azul")){
      dibuja("Azul");
		}if(colores.equals("Rojo")){
      dibuja("Rojo");
		}if(colores.equals("Rosa")){
      dibuja("Rosa");
		}if(colores.equals("Amarillo")){
      dibuja("Amarillo");
		}if(colores.equals("AzulClaro")){
      dibuja("AzulClaro");
		}if(colores.equals("Inverso")){
      dibuja("Inverso");
		}if(colores.equals("Mediano")){
      dibuja("Mediano");
		}if(colores.equals("Emboss")){
      dibuja("Emboss");
		}if(colores.equals("Bordes")){
      dibuja("Bordes");
		}if(colores.equals("MotionBlur")){
      dibuja("MotionBlur");
		}if(colores.equals("Sharpen")){
      dibuja("Sharpen");
        }if(colores.equals("Blur")){
      dibuja("Blur");
        }if(colores.equals("Bordes_2")){
      dibuja("Bordes2");
        }if(colores.equals("Bordes_3")){
      dibuja("Bordes3");
        }if(colores.equals("Bordes_4")){
      dibuja("Bordes4");
        }if(colores.equals("Sharpen_2")){
      dibuja("Sharpen2");
        }if(colores.equals("Emboss_1")){
      dibuja("Emboss1");
        }if(colores.equals("Mean")){
      dibuja("mean");
        }if(colores.equals("@_Color")){
      dibuja("@_Color");
        }if(colores.equals("M_B/N")){
            dibuja("M_B/N");
        }if(colores.equals("M_Color")){
            dibuja("M_Color");
        }if(colores.equals("MNH#AD")){
            dibuja("MNH#AD");
        }if(colores.equals("MNH#AD_Color")){
            dibuja("MNH#AD_Color");
        }if(colores.equals("Texto")){
            dibuja("Texto");
        }/*if(colores.equals("MarcaAgua")){
            dibuja("MarcaAgua");
        }*/if(colores.equals("MarcaAgua3")){
            dibuja("MarcaAgua3");
        }if(colores.equals("MarcaAgua6")){
            dibuja("MarcaAgua6");
        }if(colores.equals("MarcaAgua8")){
            dibuja("MarcaAgua8");
        }if(colores.equals("Esteganografia")){
            dibuja("Esteganografia");
        }if(colores.equals("Sepia")){
            dibuja("Sepia");
        }


  }

 
  


  public static void main(String [] args)
  {

   JFrame f = new JFrame("PhotoFa");
   PaintImage p = new PaintImage();

   
   p.window();
    
   f.setBounds(0,0,450,350);
   f.setVisible(true);

    f.add(new PaintImage());
    f.setSize(image2.getWidth(), image2.getHeight() + 30);
    f.setVisible(true);
   
    
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
   
   
  }
}