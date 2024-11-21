# Internationalization (i18n) in JavaFX

This project illustrates how to internationalize a JavaFX applicaton through a `ResourceBundle`.

the project contains an example that shows how to use direct references to internationalized strings via `%key` references,
but also how to use a `StringProperty` that is exposed in the controller. The latter allows to dynamically
propagate `Locale` changes in the UI without reloading a `Scene`.

*Please note:* The source code of `Main` and `Controller` and the corresponding `i18n.fxml` file are all
extensively commented to explain the implementation.    
 
Assuming that you have [Maven](https://maven.apache.org/install.html) installed, you can run the project out-of-the-box from your terminal via

    mvn clean javafx:run

Running it within your IDE (Eclipse/IntelliJ) requires setting up OpenJFX.

First download (and unzip!) an [OpenJFX SDK](https://openjfx.io).
Make sure that the download *matches your Java JDK version*.
You might also need to adapt the version property in the `pom.xml` file.

Then create a *run configuration* and add the following *VM* commands:

	--module-path="/path/to/javafx-sdk/lib"
	--add-modules=javafx.controls,javafx.fxml

Adjust the module path to your local download and make sure you adapt the path
to the `lib`(!) directory (not just the directory that you unzipped)...

*Tip:* Windows uses `\` to separate path elements.

*Tip:* Make sure not to forget the `/lib` at the end of the path

*Tip:* Double-check that the path is correct. If you receive abstract error messages, like `Module javafx.fxml not found`
or a segmentation fault, you are likely not pointing to the right folder
