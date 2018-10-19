package br.edu.ifsc.ads.steam.properties;

import javafx.scene.image.Image;

public class Images {
	private static Image icon;
	
	public static Image getIcon() {
		if (icon == null)
			icon = new Image("/br/edu/ifsc/ads/steam/ux/images/icon.png");
		return icon;
	}
}
