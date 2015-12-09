package week2;

import week2UtilPack.Pixel;
import week2UtilPack.Matrix;
import week2UtilPack.MatrixOperation;


public class TheOne {

	public static void main(String[] args) {
		//grayscale
		MatrixOperation grayscale = (int x, int y, Pixel[][] matrix) ->{
			int grayscal = (int) (0.21*matrix[x][y].getR() + 0.72*matrix[x][y].getG() + 0.07*matrix[x][y].getB());
			return new Pixel(grayscal,grayscal,grayscal);
		};
		
		MatrixOperation brightnessReduce = (int x, int y, Pixel[][] matrix) ->{
			int reduce = 10; 
			int R,G,B;
			if(matrix[x][y].getR() >=reduce){
				R = matrix[x][y].getR()-reduce;
				
			}
			else{
				R = 0;
			}
			if(matrix[x][y].getG() >=reduce){
				G = matrix[x][y].getG()-reduce;
				
			}
			else{
				G = 0;
			}
			if(matrix[x][y].getB() >=reduce){
				B = matrix[x][y].getB()-reduce;
				
			}
			else{
				B = 0;
			}
			matrix[x][y].setR(R);
			matrix[x][y].setG(G);
			matrix[x][y].setB(B);
			return new Pixel(R,G,B);
		};
		
		Matrix matrix = new Matrix();
		
		matrix.operate(grayscale);
		matrix.operate(brightnessReduce);
	}

}
