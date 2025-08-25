package design_patterns.creational.singleton;

class AppSettings1 {
	// STEP - 1 : Private static instance of class
	private static AppSettings1 instance;

	private String databaseUrl;
	private String apiKey;

	// STEP - 2 : Private constructor
	private AppSettings1() {
		// Read settings from a config file
		databaseUrl = "jdbc:mysql://localhost:3306/mydatabase";
		apiKey = "12345-ABCDE";
	}

	public String getDatabaseUrl() {
		return databaseUrl;
	}

	public String getApiKey() {
		return apiKey;
	}
	
	// STEP - 3 : Public static method getInstance()
	public static AppSettings1 getInstance() {
		if (instance == null) {
			instance = new AppSettings1();
		}

		return instance;
	}
}

public class WithSingletonPattern {
	public static void main(String[] args) {
		AppSettings1 appSettings = AppSettings1.getInstance();
		AppSettings1 appSettingsCopy = AppSettings1.getInstance();

		System.out.println(appSettingsCopy.getApiKey());
		System.out.println(appSettings.getApiKey());

		// More memory -> both objects are same
		System.out.println(appSettings == appSettingsCopy);

	}
}
