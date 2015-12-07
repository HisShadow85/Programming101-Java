package week1;

import java.util.ArrayList;

public class ReduceFilePath {

	public static void main(String[] args) {
		System.out.println(reduce_file_path("/"));
		System.out.println(reduce_file_path("/srv/../"));
		System.out.println(reduce_file_path("/srv/www/htdocs/wtf/"));
		System.out.println(reduce_file_path("/srv/www/htdocs/wtf"));
		System.out.println(reduce_file_path("/srv/./././././"));
		System.out.println(reduce_file_path("/etc//wtf/"));
		System.out.println(reduce_file_path("/etc/../etc/../etc/../"));
		System.out.println(reduce_file_path("//////////////"));
		System.out.println(reduce_file_path("/../"));

	}

	public static String reduce_file_path(String path) {
		path = path.trim();
		if (path.indexOf(" ") < 0) {
			
			ArrayList<String> list = new ArrayList<String>();
			String[] dirs = path.split("/");
			
			for (int i = 0; i < dirs.length; i++) {
				switch (dirs[i]) {
				case "":
				case ".":
					break;
				case "..":
					if (list.size() > 0 ){
						list.remove(list.size() - 1);
					}
					break;
				default : list.add(dirs[i]);
				}				
			}
			
		
		     
			return   "/" + String.join("/", list);
			
		} else {
			return "invalid path";
		}
	}

}
