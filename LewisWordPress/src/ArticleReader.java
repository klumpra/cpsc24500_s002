import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ArticleReader {
	public ArrayList<Article> readFromJSON(String fname) {
		try {
			ArrayList<Article> articles = new ArrayList<Article>();
			FileReader reader = new FileReader(new File(fname));
			JSONParser parser = new JSONParser();
			JSONObject all = (JSONObject)parser.parse(reader);
			JSONArray arr = (JSONArray)all.get("articles");
			Iterator itr = arr.iterator();  // help me step through every entry
			JSONObject articleObject;
			String title, author, text;
			while (itr.hasNext()) {
				articleObject = (JSONObject)itr.next();
				title = articleObject.get("title").toString();
				author = articleObject.get("author").toString();
				text = articleObject.get("text").toString();
				articles.add(new Article(title,author,text));
			}
			reader.close();
			return articles;
		} catch (Exception ex) {
			return null;
		}
	}
}
