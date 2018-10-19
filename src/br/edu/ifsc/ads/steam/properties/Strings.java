package br.edu.ifsc.ads.steam.properties;

import java.util.Locale;
import java.util.ResourceBundle;

public class Strings {
	private static ResourceBundle strings;
	private static String locale;

	public static String get(String key) {
		try {
			return getBundle().getString(key);
		} catch (java.util.MissingResourceException ex) {
			return "????";
		}
	}
	
	public static String getLocale() {
		return locale;
	}

	public static void setUS() {
		strings = ResourceBundle.getBundle("br.edu.ifsc.ads.steam.properties.Strings", new Locale("en", "US"));
		locale = "en-US";
	}

	public static void setBR() {
		strings = ResourceBundle.getBundle("br.edu.ifsc.ads.steam.properties.Strings", new Locale("pt", "BR"));
		locale = "pt-BR";
	}
	
	public static ResourceBundle getBundle() {
		if (strings == null)
			setBR();
		return strings;
	}
}