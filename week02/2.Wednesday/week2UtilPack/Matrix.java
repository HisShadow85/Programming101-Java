package week2UtilPack;


public class Matrix{
	Pixel[][] matrix;
	
	public Matrix(int n, int m){
		matrix = new Pixel[n][m];
	}
	
	public Matrix(Pixel[][] matrix){
		this.matrix = matrix.clone();
	}
	
	public Matrix() {
		// TODO Auto-generated constructor stub
	}

	public void operate(MatrixOperation op){
		
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				sb.append(matrix[i][j].toString());
			}
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}
}
