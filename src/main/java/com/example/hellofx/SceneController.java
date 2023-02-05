package com.example.hellofx;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ReadJson;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchTomainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchTohelloView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("helloView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSectorView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SectorView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSearch(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("search.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//   ArrayList<String> words = new ArrayList<>(
//            Arrays.asList("test", "dog","Human", "Days of our life", "The best day",
//                   "Friends", "Animal", "Human", "Humans", "Bear", "Life",
//                    "This is some text", "Words", "222", "Bird", "Dog", "A few words",
//                 "Subscribe!", "SoftwareEngineeringStudent", "You got this!!",
//                   "Super Human", "Super", "Like")
//   );

    String arr[]= ReadJson.getJson().toArray(new String[0]);
    ArrayList<String> words = new ArrayList<>(
           Arrays.asList(arr));
    @FXML
    private TextField searchBar;

    @FXML
    private ListView<String> listView;

    @FXML
    void search(ActionEvent event) {
        listView.getItems().clear();
        listView.getItems().addAll(searchList(searchBar.getText(),words));
    }
    private List<String> searchList(String searchWords, List<String> listOfStrings) {

        List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));

        return listOfStrings.stream().filter(input -> {
            return searchWordsArray.stream().allMatch(word ->
                    input.toLowerCase().contains(word.toLowerCase()));
        }).collect(Collectors.toList());
    }

}
