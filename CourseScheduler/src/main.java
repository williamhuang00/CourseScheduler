import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class main {

	public static void main(String[] args) {
		String url = "https://online.seas.upenn.edu/course-catalog/mse-ds-online/";
		
		try {
			Document document = Jsoup.connect(url).get();
			
//			System.out.println(document);
			
			Elements courses = document.select(".overlayBtn");
			
			System.out.println(parseCourseTitles(courses));
			
		} catch (IOException e){
			System.out.println("An Exception Has Occurred!");
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> parseCourseTitles(Elements elems) {
		ArrayList<String> listOfCourses = new ArrayList<String>();
		for (Element elem : elems) {
			listOfCourses.add(elem.ownText());
		}
		return listOfCourses;
	}

}
