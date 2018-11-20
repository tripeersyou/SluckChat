public class Program {
	
	public static void main(String[] args) throws Exception {
		int portNumber = 8000;
		String restClassPackage = "app.rest";
		String applicationContext = "applicationContext-jpa.xml";
		System.out.println("Listening on http://localhost:8000");
		new JerseyStarter().start(portNumber, restClassPackage, applicationContext);
	}
}

