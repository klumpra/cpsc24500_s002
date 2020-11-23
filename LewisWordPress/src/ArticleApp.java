import java.util.ArrayList;
import java.util.Scanner;

public class ArticleApp {

	public static int showMenuAndGetChoice(Scanner sc) {
		System.out.println("Here are your choices: ");
		System.out.println("1. Add an article.");
		System.out.println("2. Print articles.");
		System.out.println("3. Save articles.");
		System.out.println("4. Delete articles.");
		System.out.println("5. Load articles.");
		System.out.println("6. Exit");
		System.out.print("Enter your choice: ");
		int result = sc.nextInt();
		sc.nextLine(); // clear the end-of-line marker
		return result;
	}
	
	public static void printArticles(ArrayList<Article> articles) {
		for (Article article : articles) {
			System.out.println(article);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		/* 
		 * this will present a menu of options to the user.
		 * the user will be able to create articles, print them,
		 * delete them, and save to a json file.
		 */
		int choice;
		String title, author, text;
		Scanner sc = new Scanner(System.in);
		Article article;
		ArrayList<Article> articles = new ArrayList<Article>();
		int toRemove;
		String path; // where the json to write is located
		ArticleWriter aw = new ArticleWriter();   // controller class
		ArticleReader ar = new ArticleReader();
		do {
			choice = showMenuAndGetChoice(sc);
			if (choice == 1) { //add an article
				System.out.print("Enter title: ");
				title = sc.nextLine();
				System.out.print("Enter author: ");
				author = sc.nextLine();
				System.out.print("Enter text: ");
				text = sc.nextLine();
				article = new Article(title,author,text);
				articles.add(article);
			} else if (choice == 2) {
				printArticles(articles);
			} else if (choice == 3) {
				System.out.print("Enter path to json file: ");
				path = sc.nextLine();
				if (aw.writeToJSON(path,articles)) {
					System.out.println("Saved articles successfully.");
				} else {
					System.out.println("Couldn't save articles.");
				}
			} else if (choice == 4) {
				System.out.print("Enter number of article to remove: ");
				toRemove = sc.nextInt();
				articles.remove(toRemove);
			} else if (choice == 5) {
				System.out.print("Enter name of file: ");
				path = sc.nextLine();
				articles = ar.readFromJSON(path);
				if (articles == null) {
					System.out.println("Fail!");
				} else {
					System.out.println("Success!");
				}
			}
		} while (choice != 6);
		System.out.println("Support Freedom of the Press!");
	}
}

/*
 * By the way, here is the code for the website:
 * 
<html>
<head></head>
<body>
<div id="id01"></div>
<script>
var xmlhttp = new XMLHttpRequest();
var url = "articles.json";
xmlhttp.onreadystatechange = function() {
	if (this.readyState == 4 && this.status == 200) {
		var resp = JSON.parse(this.responseText);
		myFunction(resp);
	}
}
xmlhttp.open("GET",url,true);
xmlhttp.send();
function myFunction(resp) {
	var out = "";
	var i;
	for (i = 0; i < resp.articles.length; i++) {
		out += "<h1>" + resp.articles[i].title + "</h1><h3>" + 
			resp.articles[i].author + "</h3><p>" + 
			resp.articles[i].text + "</p><br/><hr/>";
	}
	document.getElementById("id01").innerHTML = out;
}
</script>
</body>
</html>

*/
