import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    // Instance variables for the labels, text field, and button press counter
    private Label label1 = new Label("Hello GUI World");
    private Label label2 = new Label("Press a button");
    private TextField textField = new TextField();
    private int buttonPressCount = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Hello GUI: Your Name");

        StackPane layout = new StackPane();

        AnchorPane anchorPane = new AnchorPane();

        AnchorPane.setTopAnchor(label1, 10.0);
        AnchorPane.setBottomAnchor(label2, 10.0);
        AnchorPane.setTopAnchor(textField, 50.0);
        AnchorPane.setLeftAnchor(textField, 50.0);

        Button button1 = new Button("Update Label");
        Button button2 = new Button("Button 2");

        AnchorPane.setLeftAnchor(button1, 10.0);
        AnchorPane.setRightAnchor(button2, 10.0);
        AnchorPane.setBottomAnchor(button1, 10.0);
        AnchorPane.setBottomAnchor(button2, 10.0);

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                label1.setText(textField.getText());
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                buttonPressCount++;
                label2.setText("Button 2 pressed " + buttonPressCount + " times");
            }
        });

        anchorPane.getChildren().addAll(label1, label2, textField, button1, button2);

        layout.getChildren().add(anchorPane);

        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}