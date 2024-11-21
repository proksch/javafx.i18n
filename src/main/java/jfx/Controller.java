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

import static jfx.Main.BUNDLE_NAME;
import static jfx.Main.DEFAULT_LOCALE;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

	// A UI element can refer to a *StringProperty* instead of a hard-coded
	// *String*, which makes it possible to dynamically change the labels
	// (the FXML file contains an exemplary *Label*)
	private final StringProperty propertyFarewell = new SimpleStringProperty();

	@FXML
	private Label labelFarewell;

	// The *initialize* function can serve as a trigger for when JFX is done
	// injecting the fields (before that, the *Label* would be null).
	@FXML
	private void initialize() {
		// *Label* and *Property* need to be "bound" to enable
		// instant propagation of property updates to the UI
		labelFarewell.textProperty().bind(propertyFarewell);

		// set a default locale
		setLocale(DEFAULT_LOCALE);
	}

	private void setLocale(Locale l) {
		// Find the right bundle in the resource folder ...
		var rb = ResourceBundle.getBundle(BUNDLE_NAME, l);
		// Read the text for a given key ... 
		var text = rb.getString("msg.farewell");
		// Set the property to this text
		propertyFarewell.set(text);
		// The example only has a single property, but one could set more than
		// one property in one go to prevent loading the bundle multiple times
	}

	// the various JFX buttons are bound to the following methods
	public void setEN() {
		setLocale(Locale.ENGLISH);
	}

	public void setDE() {
		setLocale(Locale.GERMAN);
	}

	public void setNL() {
		setLocale(Locale.forLanguageTag("nl-NL"));
	}

}