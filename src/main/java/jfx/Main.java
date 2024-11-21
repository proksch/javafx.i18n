/*
 * Copyright 2021 Delft University of Technology
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jfx;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static final String BUNDLE_NAME = "messages";
	public static final Locale DEFAULT_LOCALE = Locale.ENGLISH;

	public static void main(String[] args) throws URISyntaxException, IOException {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// The right bundle file is picked from the resource folder
		var bundle = ResourceBundle.getBundle(BUNDLE_NAME, DEFAULT_LOCALE);

		var loader = new FXMLLoader(getLocation("jfx", "i18n.fxml"));
		// a resource bundle can be provided to the loader, which allows to
		// use "%..." entries in FXML files. This makes it very easy to get
		// started, but the label does NOT dynamically change in the UI. It is
		// required to reload the scene with a different resource bundle.
		loader.setResources(bundle);

		var scene = new Scene(loader.load());

		primaryStage.setTitle("i18n Example");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private static URL getLocation(String... parts) {
		var path = Path.of("", parts).toString();
		return Main.class.getClassLoader().getResource(path);
	}
}