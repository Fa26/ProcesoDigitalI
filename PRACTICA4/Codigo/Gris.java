/**
 * @author Venegas Guerreo Fatima Alejandra
 * num cuenta: 310318738
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.util.Random;
import java.util.Arrays;
import java.awt.image.ConvolveOp;
import java.awt.image.BufferedImageOp;
import java.awt.image.Kernel;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.BadLocationException;
import java.awt.AlphaComposite;



public class Gris{

//Algortimo_1 de gris 
public  BufferedImage Gray1(BufferedImage bi){
		
			Random rnd = new Random();
			for(int i=0;i<bi.getHeight();i++){
				for(int j=0;j<bi.getWidth(); j++){
					Color c = new Color(bi.getRGB(j,i));
					int blue=(int)(c.getBlue());
					Color newColor = new Color(blue,blue,blue);
					bi.setRGB(j,i,newColor.getRGB());

				}
			}
            
            
            return bi;
			
		

	}//fin del metodo Gray1

//Algortimo_2 de gris 
public BufferedImage Gray2 (BufferedImage bi){

    	Random rnd = new Random();
			for(int i=0;i<bi.getHeight();i++){
				for(int j=0;j<bi.getWidth(); j++){
					Color c = new Color(bi.getRGB(j,i));
					int red=(int)(c.getRed());
					Color newColor = new Color(red,red,red);
					bi.setRGB(j,i,newColor.getRGB());

				}
			}return bi;

}

//Algoritmo_3 de gris
public BufferedImage Gray3 (BufferedImage bi){

			Random rnd = new Random();
			for(int i=0;i<bi.getHeight();i++){
				for(int j=0;j<bi.getWidth(); j++){
					Color c = new Color(bi.getRGB(j,i));
					int green=(int)(c.getGreen());
					Color newColor = new Color(green,green,green);
					bi.setRGB(j,i,newColor.getRGB());

				}
			}return bi;

}

//Algortimo_4 de gris
public BufferedImage Gray4 (BufferedImage bi){

    Color newColor;
    	for(int i=0;i<bi.getHeight();i++){
				for(int j=0;j<bi.getWidth(); j++){
					Color c = new Color(bi.getRGB(j,i));
					int blue = (int)(c.getBlue()*0.114);
					int green = (int)(c.getGreen()*0.587);
					int red =(int)(c.getRed()*0.299);
					int gray=blue+green+red;

					newColor = new Color(gray,gray,gray);
					bi.setRGB(j,i,newColor.getRGB());
					
				}
			}return bi;

}

//Algoritmo de AltoC
public BufferedImage AltoC(BufferedImage bi){

    Color newColor;
    	Random rnd = new Random();
			for(int i=0;i<bi.getHeight();i++){
				for(int j=0;j<bi.getWidth(); j++){
					Color c = new Color(bi.getRGB(j,i));
					int blue = (int)(c.getBlue());
					int green = (int)(c.getGreen());
					int red =(int)(c.getRed());
					int gray=(int)((blue+green+red)/3);

					if(gray>=127){
					 newColor = new Color(255,255,255);
					 bi.setRGB(j,i,newColor.getRGB());
					}if(gray<127){
					newColor = new Color(0,0,0);
					bi.setRGB(j,i,newColor.getRGB());
					}
				}
            }return bi;
    }

//Funcion auxiliar para Brillo
	public int entero(){
		JFrame frame = new JFrame("Introduce numero: ");
		String name=JOptionPane.showInputDialog(frame,
			"Ingresa un numero de Brillo: ");
		int e=Integer.parseInt(name);
		return e;

	}




//Algoritmo de Brillo
public BufferedImage Brillo(BufferedImage bi){

    	Color newColor;
		int n = entero();
			for(int i=0;i<bi.getHeight();i++){
				for(int j=0;j<bi.getWidth(); j++){
					Color c = new Color(bi.getRGB(j,i));
					int blue = (int)(c.getBlue() + n);
					int green = (int)(c.getGreen() + n);
					int red =(int)(c.getRed()+ n);
					int suma=(int)(blue+green+red);

					if(suma>255){
					 newColor = new Color(255,255,255);
					 bi.setRGB(j,i,newColor.getRGB());
					}if(suma<0){
					newColor = new Color(0,0,0);
					bi.setRGB(j,i,newColor.getRGB());
					}
				}
			}return bi;
}

//Algortimo del verde
public BufferedImage Verde(BufferedImage bi){

		for(int i=0;i<bi.getHeight();i++){
				for(int j=0;j<bi.getWidth(); j++){
					Color c = new Color(bi.getRGB(j,i));
					int green = (int)(c.getGreen());
					Color newColor = new Color(0,green,0);
					bi.setRGB(j,i,newColor.getRGB());

				}
			}
			return bi;

}

//Algortimo del Azul
public BufferedImage Azul(BufferedImage bi){

		for(int i=0;i<bi.getHeight();i++){
				for(int j=0;j<bi.getWidth(); j++){
					Color c = new Color(bi.getRGB(j,i));
					int blue = (int)(c.getBlue());
					Color newColor = new Color(0,0,blue);
					bi.setRGB(j,i,newColor.getRGB());

				}
			}
			return bi;

}

//Algortimo del Rojo
public BufferedImage Rojo(BufferedImage bi){
		for(int i=0;i<bi.getHeight();i++){
				for(int j=0;j<bi.getWidth(); j++){
					Color c = new Color(bi.getRGB(j,i));
					int red = (int)(c.getRed());
					Color newColor = new Color(red,0,0);
					bi.setRGB(j,i,newColor.getRGB());

				}
			}
			return bi;

}

//Algortimo del Rosa
public BufferedImage Rosa(BufferedImage bi){
			for(int i=0;i<bi.getHeight();i++){
				for(int j=0;j<bi.getWidth(); j++){
					Color c = new Color(bi.getRGB(j,i));
					int blue = (int)(c.getBlue());
					int green = (int)(c.getGreen());
					int red =(int)(c.getRed());
					Color newColor = new Color(red,0,blue);
					
					bi.setRGB(j,i,newColor.getRGB());

				}
			}
			return bi;

}

//Algortimo del Amarillo
public BufferedImage Amarillo(BufferedImage bi){
			for(int i=0;i<bi.getHeight();i++){
				for(int j=0;j<bi.getWidth(); j++){
					Color c = new Color(bi.getRGB(j,i));
					int blue = (int)(c.getBlue());
					int green = (int)(c.getGreen());
					int red =(int)(c.getRed());
					Color newColor = new Color(red,green,0);
					bi.setRGB(j,i,newColor.getRGB());

				}
			}
			return bi;

}

//Algortimo del AzulClaro
public BufferedImage AzulClaro(BufferedImage bi){
			
			
			for(int i=0;i<bi.getHeight();i++){
				for(int j=0;j<bi.getWidth(); j++){
					Color c = new Color(bi.getRGB(j,i));
					int blue = (int)(c.getBlue());
					int green = (int)(c.getGreen());
					int red =(int)(c.getRed());
					Color newColor = new Color(0,green,blue);
					bi.setRGB(j,i,newColor.getRGB());

				}
			}
			return bi;

}

//Algortimo de inverso
public BufferedImage Inverso(BufferedImage bi){

		Color newColor;
				Random rnd = new Random();
			for(int i=0;i<bi.getHeight();i++){
				for(int j=0;j<bi.getWidth(); j++){
					Color c = new Color(bi.getRGB(j,i));
					int blue = (int)(c.getBlue());
					int green = (int)(c.getGreen());
					int red =(int)(c.getRed());
					int gray=(int)((blue+green+red)/3);

					if(gray>=127){
					 newColor = new Color(0,0,0);
					 bi.setRGB(j,i,newColor.getRGB());
					}if(gray<127){
					newColor = new Color(255,255,255);
					bi.setRGB(j,i,newColor.getRGB());
					}
				}
			}
		
			return bi;

}

//Algoritmo de Mediano
public BufferedImage Mediano(BufferedImage bi){
	 Color[] pixel=new Color[9];
        int[] R=new int[9];
        int[] B=new int[9];
        int[] G=new int[9];
		 for(int i=1;i<bi.getWidth()-1;i++)
            for(int j=1;j<bi.getHeight()-1;j++)
            {
               pixel[0]=new Color(bi.getRGB(i-1,j-1));
               pixel[1]=new Color(bi.getRGB(i-1,j));
               pixel[2]=new Color(bi.getRGB(i-1,j+1));
               pixel[3]=new Color(bi.getRGB(i,j+1));
               pixel[4]=new Color(bi.getRGB(i+1,j+1));
               pixel[5]=new Color(bi.getRGB(i+1,j));
               pixel[6]=new Color(bi.getRGB(i+1,j-1));
               pixel[7]=new Color(bi.getRGB(i,j-1));
               pixel[8]=new Color(bi.getRGB(i,j));
               for(int k=0;k<9;k++){
                   R[k]=pixel[k].getRed();
                   B[k]=pixel[k].getBlue();
                   G[k]=pixel[k].getGreen();
               }
			     Arrays.sort(R);
               Arrays.sort(G);
               Arrays.sort(B);
               bi.setRGB(i,j,new Color(R[4],B[4],G[4]).getRGB());
            }
			return bi;
}

//Algortimo de Emboss
public BufferedImage Emboss(BufferedImage miImage){
		BufferedImage filter = new BufferedImage(miImage.getWidth(null),
				miImage.getHeight(null),BufferedImage.TYPE_BYTE_GRAY);
			Graphics g1 = filter.getGraphics();
			g1.drawImage(miImage,10,10,null);

			float [] sKernel={
                  -1, -1, -1, -1,  0,
				  -1, -1, -1,  0,  1,
				  -1, -1,  0,  1,  1,
				  -1,  0,  1,  1,  1,
				   0,  1,  1,  1,  1
				 
			};

			BufferedImageOp sha = new ConvolveOp(new Kernel(5,5,sKernel));
			miImage=sha.filter(miImage,null);
			g1.dispose();
			return miImage;
}

//Algortimo de Emboss1
public BufferedImage Emboss1(BufferedImage miImage){
	BufferedImage filter = new BufferedImage(miImage.getWidth(null),
	miImage.getHeight(null),BufferedImage.TYPE_BYTE_GRAY);
Graphics g1 = filter.getGraphics();
g1.drawImage(miImage,10,10,null);

float [] sKernel={
	  -1, -1,  0,
	  -1,  0,  1,
	   0,  1,  1
	 
};

BufferedImageOp sha = new ConvolveOp(new Kernel(3,3,sKernel));
miImage=sha.filter(miImage,null);
g1.dispose();
	
			return miImage;


}

//Algoritmo de encontrar bordes
public BufferedImage Edege(BufferedImage miImage){
		BufferedImage filteredI = new BufferedImage(miImage.getWidth(null),miImage.getHeight(null),BufferedImage.TYPE_BYTE_GRAY);

			Graphics g1 = filteredI.getGraphics();
			g1.drawImage(miImage, 10, 10, null);

			 float[] edgeKernel = {
   				 0.0f, -1.0f, 0.0f,
   				-1.0f, 4.0f, -1.0f,
    			0.0f, -1.0f, 0.0f
				 };
 			BufferedImageOp edge = new ConvolveOp(new Kernel(3, 3, edgeKernel));
 			miImage=edge.filter(miImage,null);
 			g1.dispose();
			 return miImage;


}

//Algoritmo de Mean
public BufferedImage mean(BufferedImage miImage){

	BufferedImage filter = new BufferedImage(miImage.getWidth(null),
	miImage.getHeight(null),BufferedImage.TYPE_BYTE_GRAY);
  Graphics g1 = filter.getGraphics();
  g1.drawImage(miImage,10,10,null);
  float n = 1.0f/9.0f;

  float [] sKernel={
				n,n,n,
				n,n,n,
				n,n,n
	 
  };

  BufferedImageOp sha = new ConvolveOp(new Kernel(3,3,sKernel));
  miImage=sha.filter(miImage,null);
  g1.dispose();

  return miImage;

}

//Algoritmo de MotionBlur
public BufferedImage MBlur(BufferedImage miImage){

		BufferedImage filteredI = new BufferedImage(miImage.getWidth(null),miImage.getHeight(null),BufferedImage.TYPE_BYTE_GRAY);

			Graphics g1 = filteredI.getGraphics();
			g1.drawImage(miImage,10,10,null);
			float f=1.0f/17.0f;

			float[] motionKernel  = {

		 f,0,0,0,0,0,0,0,0,0,0,0,0,0,			
		 0,f,0,0,0,0,0,0,0,0,0,0,0,0,	
		 0, 0,f,0,0,0,0,0,0,0,0,0,0,0,	
		 0, 0,0,f,0,0,0,0,0,0,0,0,0,0,
		 0, 0,0,0,f,0,0,0,0,0,0,0,0,0,
		 0, 0,0,0,0,f,0,0,0,0,0,0,0,0,
 		 0, 0,0,0,0,0,f,0,0,0,0,0,0,0,
 		 0, 0,0,0,0,0,0,f,0,0,0,0,0,0,
		 0, 0,0,0,0,0,0,0,f,0,0,0,0,0,
		 0, 0,0,0,0,0,0,0,0,f,0,0,0,0,
		 0, 0,0,0,0,0,0,0,0,0,f,0,0,0,
		 0, 0,0,0,0,0,0,0,0,0,0,f,0,0,
		 0, 0,0,0,0,0,0,0,0,0,0,0,f,0,
		 0, 0,0,0,0,0,0,0,0,0,0,0,0,f,	

			};
			BufferedImageOp blur = new ConvolveOp(new Kernel(14,14,motionKernel));
			miImage=blur.filter(miImage,null);
			g1.dispose();
			return miImage;

}

//Algoritmo del Sharpen
public BufferedImage Sharpen(BufferedImage miImage){

	BufferedImage filter = new BufferedImage(miImage.getWidth(null),
				miImage.getHeight(null),BufferedImage.TYPE_BYTE_GRAY);
			Graphics g1 = filter.getGraphics();
			g1.drawImage(miImage,10,10,null);

	float [] sKernel={

		-1, -1, -1,
		 -1,  9, -1,
		 -1, -1, -1
   };

   BufferedImageOp sha = new ConvolveOp(new Kernel(3,3,sKernel));
			miImage=sha.filter(miImage,null);
			g1.dispose();
	return miImage;

}

//Algortimo de Blur
public BufferedImage Blur(BufferedImage myImage ){

	BufferedImage filteredImage = new BufferedImage(myImage.getWidth(null), myImage
	.getHeight(null), BufferedImage.TYPE_BYTE_GRAY);


	Graphics g1 = filteredImage.getGraphics();
	g1.drawImage(myImage, 10, 10, null);

	float n =1.0f /400.0f;

	float[] blurKernel= new float[400];
	for(int i=0;i<400;i++){
	blurKernel[i]=1.0f/400.0f;
}
BufferedImageOp blur = new ConvolveOp(new Kernel(20, 20, blurKernel),ConvolveOp.EDGE_NO_OP,null);
myImage = blur.filter(myImage, null);
g1.dispose();
return myImage;	

}
//Algortimo de Edge2
public BufferedImage edge2(BufferedImage miImage){

	BufferedImage filteredI = new BufferedImage(miImage.getWidth(null),miImage.getHeight(null),BufferedImage.TYPE_BYTE_GRAY);

	Graphics g1 = filteredI.getGraphics();
	g1.drawImage(miImage, 10, 10, null);

	float [] eKernel={

		   0,  0, -1,  0,  0,
		   0,  0, -1,  0,  0,
		   0,  0, -1,  0,  0,
		   0,  0,  4,  0,  0,
		   0,  0, -1,  0,  0,
		   0,  0, -1,  0,  0,

	};

	BufferedImageOp edge = new ConvolveOp(new Kernel(5, 5, eKernel));
	 miImage=edge.filter(miImage,null);
	 g1.dispose();

	 return miImage;

}

//Algoritmo bordes3
public BufferedImage edge3(BufferedImage miImage){


	BufferedImage filteredI = new BufferedImage(miImage.getWidth(null),miImage.getHeight(null),BufferedImage.TYPE_BYTE_GRAY);

	Graphics g1 = filteredI.getGraphics();
	g1.drawImage(miImage, 10, 10, null);

	float [] eKernel={

		  -1,  0,  0,  0,  0,
		   0, -2,  0,  0,  0,
		   0,  0,  6,  0,  0,
		   0,  0,  0, -2,  0,
		   0,  0,  0,  0, -1,

	};

	BufferedImageOp edge = new ConvolveOp(new Kernel(5, 5, eKernel));
	 miImage=edge.filter(miImage,null);
	 g1.dispose();
	 return  miImage;

}

//Algoritmo edge4
public BufferedImage edge4(BufferedImage miImage){

	BufferedImage filteredI = new BufferedImage(miImage.getWidth(null),miImage.getHeight(null),BufferedImage.TYPE_BYTE_GRAY);

	Graphics g1 = filteredI.getGraphics();
	g1.drawImage(miImage, 10, 10, null);

	float [] eKernel={

	 -1, -1, -1,
	  -1,  8, -1,
	  -1, -1, -1
	};

	BufferedImageOp edge = new ConvolveOp(new Kernel(3, 3, eKernel));
	 miImage=edge.filter(miImage,null);
	 g1.dispose();
	 return miImage;

}

//Algortimo Sharpen2
public BufferedImage Sharpen2(BufferedImage miImage){
	BufferedImage filter = new BufferedImage(miImage.getWidth(null),
				miImage.getHeight(null),BufferedImage.TYPE_BYTE_GRAY);
			Graphics g1 = filter.getGraphics();
			g1.drawImage(miImage,10,10,null);

			float [] sKernel={
				   1,  1,  1,
				   1, -7,  1,
				   1,  1,  1
				 
			};

			BufferedImageOp sha = new ConvolveOp(new Kernel(3,3,sKernel));
			miImage=sha.filter(miImage,null);
			g1.dispose();
		return miImage;


}

//Metodo que ayuda a sacar color promedio

public Color PromedioRegion(int inicioa, int fina,int iniciol, int finl, BufferedImage img, Boolean f){
    int rp =0;
    int gp =0;
    int bp =0;
    int h=img.getHeight();
    int w=img.getWidth();
    int cantidad = (img.getHeight() / 90)*(img.getWidth() /90);
       for(int a = inicioa ; a < fina;a++){
        for(int b= iniciol;b< finl;b++){
         if(a<img.getWidth()){
           if(b<img.getHeight()){
              Color c1=new Color(img.getRGB(a, b));
              rp+= c1.getRed();
              gp+= c1.getGreen();
              bp+= c1.getBlue();
           }
         }
        }
    }
    rp = (int)(rp/cantidad);
    gp = (int)(gp/cantidad);
    bp = (int)(bp/cantidad);
    return new Color(rp,gp,bp);
}//fin del metodo

//Algortimo de ayuda
public Color PromedioRegio(int inicioa, int fina,int iniciol, int finl, BufferedImage img, Boolean f){
	int rp =0;
	int gp =0;
	int bp =0;
	int h=img.getHeight();
	int w=img.getWidth();
	int cantidad = (img.getHeight() / 50)*(img.getWidth() /50);
	   for(int a = inicioa ; a < fina;a++){
		for(int b= iniciol;b< finl;b++){
		 if(a<img.getWidth()){
		   if(b<img.getHeight()){
			  Color c1=new Color(img.getRGB(a, b));
			  rp+= c1.getRed();
			  gp+= c1.getGreen();
			  bp+= c1.getBlue();
		   }
		 }
		}
	}
	rp = (int)(rp/cantidad);
	gp = (int)(gp/cantidad);
	bp = (int)(bp/cantidad);
	return new Color(rp,gp,bp);
}//fin del metodo

//metodo de promeiode GrisM
public Color PromedioRegioM(int inicioa, int fina,int iniciol, int finl, BufferedImage img, Boolean f){
	int rp =0;
	int gp =0;
	int bp =0;
	int h=img.getHeight();
	int w=img.getWidth();
	int cantidad = (img.getHeight() / 90)*(img.getWidth() /90);
	   for(int a = inicioa ; a < fina;a++){
		for(int b= iniciol;b< finl;b++){
		 if(a<img.getWidth()){
		   if(b<img.getHeight()){
			  Color c1=new Color(img.getRGB(a, b));
			  rp+= c1.getRed();
			  gp+= c1.getGreen();
			  bp+= c1.getBlue();
		   }
		 }
		}
	}
	rp = (int)(rp/cantidad);
	gp = (int)(gp/cantidad);
	bp = (int)(bp/cantidad);
	return new Color(rp,gp,bp);
}//fin del metodo

public BufferedImage UnaLetra(BufferedImage  miImage) throws BadLocationException{
   
  
    int a =  miImage.getHeight() / 90;
    int l = miImage.getWidth() / 90;
    String s = "";
    if(miImage != null){
        for (int y = 0; y < 90; y++){
           if(y > 0) s += "\n";
            
            for (int x = 0 ; x < 90; x++){
                s += "M";
              

            }
        }
    }

    StyleContext sc = new StyleContext();
    DefaultStyledDocument doc = new DefaultStyledDocument(sc);
    JTextPane pane = new JTextPane(doc);

    JFrame f = new JFrame("M,Color");
    doc.insertString(0, s, null);

    Color c = new Color(0,0,0);
    int contador = 0;
    for (int h = 0; h < 90; h++){
            if(h > 0) contador++ ;
            for (int k = 0 ; k < 90; k++){
                Style estilo = sc.addStyle("ConstantWidth", null);
                c = PromedioRegioM(k*l,(k*l)+l,h*a,(h*a)+a,miImage,false);
                StyleConstants.setForeground(estilo, c);
                doc.setCharacterAttributes(contador++, 1, estilo, false);
            }
        }
    f.getContentPane().add(new JScrollPane(pane));
    f.setSize(1100, 700);
    f.setVisible(true);
   return miImage;
 }

//letra M
public BufferedImage UnaLetraBN(BufferedImage  miImage) throws BadLocationException{
	


 int a =  miImage.getHeight() / 50;
 int l = miImage.getWidth() / 50;
 String s = "";
 if(miImage != null){
	 for (int y = 0; y < 50; y++){
		if(y > 0) s += "\n";
		 for (int x = 0 ; x < 50; x++){
			 s += "M";

		 }
	 }
 }

 StyleContext sc = new StyleContext();
 DefaultStyledDocument doc = new DefaultStyledDocument(sc);
 JTextPane pane = new JTextPane(doc);

 JFrame f = new JFrame("M Blanco Y Negro");
 doc.insertString(0, s, null);

 Color c = new Color(0,0,0);
 int contador = 0;
 int gray=0;
 for (int h = 0; h < 50; h++){
		 if(h > 0) contador++ ;
		 for (int k = 0 ; k < 50; k++){
			 Style estilo = sc.addStyle("ConstantWidth", null);
			 c = PromedioRegio(k*l,(k*l)+l,h*a,(h*a)+a,miImage,false);
			 gray=(c.getRed()+c.getGreen()+c.getBlue())/3;
			 StyleConstants.setForeground(estilo, new Color(gray,gray,gray));
			 doc.setCharacterAttributes(contador++, 1, estilo, false);
		 }
	 }
 f.getContentPane().add(new JScrollPane(pane));
 f.setSize(600, 1300);
 f.setVisible(true);
 return miImage;
 
}

//Algoritmo para dibujarunaLetra@
public BufferedImage FiltroUnaLetra(BufferedImage  miImage) throws BadLocationException{

int a =  miImage.getHeight() / 90;
int l = miImage.getWidth() / 90;

String s = "";
if(miImage != null){
    for (int y = 0; y < 90; y++){
       if(y > 0) s += "\n";
        for (int x = 0 ; x < 90; x++){
            s += "@";

        }
    }
}

StyleContext sc = new StyleContext();
DefaultStyledDocument doc = new DefaultStyledDocument(sc);
 JTextPane pane = new JTextPane(doc);
   JFrame f = new JFrame("@,Color");
doc.insertString(0, s, null);


Color c = new Color(0,0,0);
int contador = 0;
for (int h = 0; h < 90; h++){
        if(h > 0) contador++ ;
        for (int k = 0 ; k < 90; k++){
            Style estilo = sc.addStyle("ConstantWidth", null);
            c = PromedioRegion(k*l,(k*l)+l,h*a,(h*a)+a,miImage,false);
            miImage.getRGB(k,h);
            StyleConstants.setForeground(estilo, c);
            doc.setCharacterAttributes(contador++, 1, estilo, false);
        }
    }
    f.getContentPane().add(new JScrollPane(pane));
    f.setSize(1100 ,700);
    f.setVisible(true);
return miImage;

}

//Algoritmo de marca de Agua
public BufferedImage marcaAgua(BufferedImage  image){
	int auxx = 0;
	for(int i = 0; i < image.getHeight(); i++){
		for(int j = 0; j < image.getWidth(); j++){
			Color aux = new Color(image.getRGB(j, i));
			int red = aux.getRed();
			int green = aux.getGreen();
			int blue = aux.getBlue();
		   
		
			 if(((red - green) > 10) || ((red - blue) > 10)){
				auxx++;
			}else if(auxx != 0){
				Color color_nuevo = new Color(red, green, blue);
				if(auxx < 13){
				//cleSystem.out.println(auxx);
				
				for(int k = j - auxx; k < j; k++){
					image.setRGB(k, i, color_nuevo.getRGB());
				}
				}
				auxx = 0;
				image.setRGB(j, i, color_nuevo.getRGB());
			}else{
				Color color_nuevoo = new Color(red, green, blue);
				image.setRGB(j, i, color_nuevoo.getRGB());
			}
							
		}
	}
	return image;
}

//Marca de agua2
public BufferedImage marcaAgua1(BufferedImage  imagen){
	int auxx = 0;
	for(int i = 0; i < imagen.getWidth(); i++){
		for(int j = 0; j < imagen.getHeight(); j++){
			Color aux = new Color(imagen.getRGB(i, j));
			int red = aux.getRed();
			int green = aux.getGreen();
			int blue = aux.getBlue();
		
			
			 if(((red - green) > 10) || ((red - blue) > 10)){
				auxx++;
			}else if(auxx != 0){
				//System.out.println(auxx);
				Color color_nuevo = new Color(red, green, blue);
				for(int k = j - auxx; k < j; k++){
					imagen.setRGB(i, k, color_nuevo.getRGB());
				}
				auxx = 0;
				imagen.setRGB(i, j, color_nuevo.getRGB());
			}else{
				Color color_nuevoo = new Color(red, green, blue);
				imagen.setRGB(i, j, color_nuevoo.getRGB());
			}
							
		}
	}
	return imagen;
}



//Algortimo del mosaico
public BufferedImage Mosaico(BufferedImage bi){

    int b=entero();
    int h=b;
    
           final int X = bi.getWidth();
           final int Y = bi.getHeight();

                BufferedImage nueva_Imagen = new BufferedImage(X, Y, BufferedImage.TYPE_INT_RGB);

                int t=(X / b) + ((X % b == 0) ? 0 : 1);
                int r=(Y / h) + ((Y % h == 0) ? 0 : 1);

                int area=b * h;
                int area_YReducida=b * (Y % h);
                int area_XReducida=h * (X % b);
                int area_XYReducida=(X % b) * (Y % h);

                int [][] rojos=new int[t][r];
                int [][] verdes=new int[t][r];
                int [][] azules=new int[t][r];

                int rgb_Pixel;

                for(int i=0, o=0; i<X; i++) {
                        if(i % b == 0 && i>0) { o++; }

                        for(int j=0, p=0; j<Y; j++) {

                                if (j % h == 0 && j>0) { p++; }
                                rgb_Pixel = bi.getRGB(i, j);

                                rojos[o][p] = rojos[o][p] + ((rgb_Pixel >> 16) & 0xFF);
                                verdes[o][p] = verdes[o][p] + ((rgb_Pixel >> 8) & 0xFF);
                                azules[o][p] = azules[o][p] + (rgb_Pixel & 0xFF);

                                if (i % b == b-1 && j % h == h-1) {
                                        rojos[o][p] = rojos[o][p] / area;
                                        verdes[o][p] = verdes[o][p] / area;
                                        azules[o][p] = azules[o][p] / area;
                                } else if (i % b == b-1 && j == Y-1) {
                                        rojos[o][p] = rojos[o][p] / area_YReducida;
                                        verdes[o][p] = verdes[o][p] / area_YReducida;
                                        azules[o][p] = azules[o][p] / area_YReducida;
                                } else if (j % h == h-1 && i == X-1) {
                                        rojos[o][p] = rojos[o][p] / area_XReducida;
                                        verdes[o][p] = verdes[o][p] / area_XReducida;
                                        azules[o][p] = azules[o][p] / area_XReducida;
                                } else if (i == X-1 && j == Y-1) {
                                        rojos[o][p] = rojos[o][p] / area_XYReducida;
                                        verdes[o][p] = verdes[o][p] / area_XYReducida;
                                        azules[o][p] = azules[o][p] / area_XYReducida;
                                }
                        }
                }

                for(int i=0, o=0; i < X; i++){
                        if (i % b == 0 && i>0) o++;
                        for(int j=0, p=0; j<Y; j++) {
                                if(j % h == 0 && j>0) p++;
                                nueva_Imagen.setRGB(i, j, (rojos[o][p] << 16) | (verdes[o][p] << 8) | azules[o][p]);
                        }
                }
                return nueva_Imagen;


}//fin del algortimo








}//fin de la clase Gris