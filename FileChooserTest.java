import java.io.File;
import java.util.Optional;
import javafx.application.Application;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import static javafx.stage.FileChooser.ExtensionFilter;

public class FileChooserTest extends Application{
    @Override
    public void start(final Stage stage){
	stage.show();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
	fileChooser.getExtensionFilters()
	           .addAll(
			      new ExtensionFilter("All Files",   "*.*"),
			      new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
			      new ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png", "*.gif"),
			      new ExtensionFilter("Java Files", "*.java"),
			      new ExtensionFilter("Pdf Files",  "*.pdf"),
			      new ExtensionFilter("Text Files", "*.txt"),
			      new ExtensionFilter("XML Files", "*.xml")
		          );
        final File selectedFile = fileChooser.showOpenDialog(stage);
	Optional.ofNullable(selectedFile).ifPresent(System.out::println);
	stage.close();
    }

    public static void main(final String ... args){
        launch(args);
    }
}
