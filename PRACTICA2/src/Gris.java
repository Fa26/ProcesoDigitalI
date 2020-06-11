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


}





}//fin de la clase Gris