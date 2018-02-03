package com.tassta.test.chat.view;

import com.tassta.test.chat.model.UserController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

import java.util.Random;

/**
 * Created by nimtego_loc on 24.08.2017.
 */
public class MainWindowController {

    public Button confirmButton;
    public Label labelMain;
    public Button exitButton;
    public AnchorPane rightBarSheetAmount;
    public TextArea chatTextArea;
    public Label messageLabel;
    public Label chatLabel;
    public TextField nameTextField;
    public AnchorPane leftBar;
    public TextArea messageTextArea;
    public Button sendButton;
    public Button clearButton;
    public Label currentName;
    public Button reloginButton;
    private UserController userController;
    private ChatApplication application;
    private Color color = Color.SKYBLUE;

    @FXML
    private void initialize() {
        nameTextField.setStyle("-fx-control-inner-background: #3D4956");
        messageTextArea.setStyle("-fx-control-inner-background: #3D4956");
        chatTextArea.setStyle("-fx-control-inner-background: #3D4956");
        userController = new UserController();
        currentName.setVisible(false);
        reloginButton.setVisible(false);

    }

    public void setApplication(ChatApplication application) {
        this.application = application;
    }

    public void action() {
        if (exitButton.isArmed()) {
            application.getPrimaryStage().close();
        }
        if (confirmButton.isArmed()) {
            String name = nameTextField.getText();
            if (name.isEmpty()) {
                alert("Enter name");
                return;
            }
            if (userController.setUser(name)) {
                currentName.setText(userController.getCurrentUser().getName());
                currentName.setVisible(true);
                nameTextField.setVisible(false);
                confirmButton.setVisible(false);
                reloginButton.setVisible(true);
            }
            else {
                alert("The name already exists");
            }

        }
        if (sendButton.isArmed()) {
            StringBuilder sb = new StringBuilder();
            sb.append(currentName.getText())
                    .append(": ")
                    .append(messageTextArea.getText());
            messageTextArea.clear();
            updateChat(String.valueOf(sb));
        }
        if (clearButton.isArmed())
            messageTextArea.clear();
        if (reloginButton.isArmed()) {
            reloginButton.setVisible(false);
            confirmButton.setVisible(true);
            currentName.setVisible(false);
            nameTextField.setVisible(true);
            userController.clear();
        }
    }
    private void updateChat(final String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(chatTextArea.getText()).append("\n").append(message);
        chatTextArea.clear();
        chatTextArea.setText(String.valueOf(sb));
    }

    private void alert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.TRANSPARENT);
        alert.setTitle("Attention");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void mouseMoved(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof Button)
            ((Button) mouseEvent.getSource()).setTextFill(Color.SKYBLUE);
        if (mouseEvent.getSource() instanceof Label)
            ((Label) mouseEvent.getSource()).setTextFill(Color.SKYBLUE);
    }

    public void mouseReMoved(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof Button)
            ((Button) mouseEvent.getSource()).setTextFill(Color.BLACK);
        if (mouseEvent.getSource() instanceof Label)
            ((Label) mouseEvent.getSource()).setTextFill(color);
        if (mouseEvent.getSource() instanceof TextField)
            ((TextField) mouseEvent.getSource()).setText("GGGGG");
    }

    public void actionLabel(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof Label) {
            Parent parent = ((Label) mouseEvent.getSource()).getParent();
            Random random = new Random();
            int r, g, b;
            r = random.nextInt(255);
            g = random.nextInt(255);
            b = random.nextInt(255);
            if (parent.getId().equals("leftBar")) {
                System.out.println(parent.getId().equals("leftBar"));
                parent.getScene().setFill(Color.rgb(r, g, b));
            }
            color = Color.rgb(r, g, b);
        }
    }
}