package week1;

public class GrayscaleImageHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    
	static int[] histogram(short[][] image){
		int[] histograma = new int[256];
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[i].length; j++) {
				histograma[image[i][j]]++;
			}
		}
		return histograma;
	}
}
