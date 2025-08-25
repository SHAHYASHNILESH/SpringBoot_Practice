package design_patterns.creational.singleton;

class AppSettings {
	private String databaseUrl;
	private String apiKey;

	public AppSettings() {
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
}

public class WithoutSingletonPattern {
	public static void main(String[] args) {
		AppSettings appSettings = new AppSettings();
		AppSettings appSettingsCopy = new AppSettings();

		System.out.println(appSettingsCopy.getApiKey());
		System.out.println(appSettings.getApiKey());

		// More memory -> both objects are not same
		System.out.println(appSettings == appSettingsCopy);

	}
}
