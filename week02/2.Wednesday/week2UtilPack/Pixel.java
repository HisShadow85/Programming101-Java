package week2UtilPack;

public class Pixel {
        int R;
        int G;
        int B;
        public Pixel(){}
        
        public Pixel(int r,int g, int b){
        	this.R = r;
        	this.G = g;
        	this.B = b;
        }
        
        public void setRGB(int r,int g, int b){
        	this.R = r;
        	this.G = g;
        	this.B = b;
        }

		public int getR() {
			return R;
		}

		public void setR(int r) {
			R = r;
		}

		public int getG() {
			return G;
		}

		public void setG(int g) {
			G = g;
		}

		public int getB() {
			return B;
		}

		public void setB(int b) {
			B = b;
		}
		
		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append('['+R+','+G+','+B+']');
			return sb.toString();
		}
}
