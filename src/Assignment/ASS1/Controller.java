package Assignment.ASS1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    public Text validate;

    @FXML
    private TableView<Students> table;

    @FXML
    private TableColumn<Students, String> nameColumn;

    @FXML
    private TableColumn<Students, Integer> ageColumn;

    @FXML
    private TableColumn<Students, Double> markColumn;

    private ObservableList<Students> studentList;

    @FXML
    private TextField nameText;

    @FXML
    private TextField ageText;

    @FXML
    private TextField markText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentList = FXCollections.observableArrayList(
                new Students("Truong Quang Huy", 18, 10),
                new Students("Dao Minh Giang", 17, 4),
                new Students("Hoang Van Son", 15, 5)
        );
        nameColumn.setCellValueFactory(new PropertyValueFactory<Students, String>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Students, Integer>("age"));
        markColumn.setCellValueFactory(new PropertyValueFactory<Students, Double>("mark"));
        table.setItems(studentList);
    }

    public void add (ActionEvent e){
        String n = nameText.getText();
        String a = ageText.getText();
        String m = markText.getText();
        if(!n.isEmpty() && !a.isEmpty()) {
            Students newStudent = new Students();
            newStudent.setName(nameText.getText());
            newStudent.setAge(Integer.parseInt(ageText.getText()));
            newStudent.setMark(Integer.parseInt(markText.getText()));
            studentList.add(newStudent);
        }else {
            validate.setText("Vui lòng nhập ttin");
            validate.setDisable(false);
        }
    }

    public void delete (ActionEvent e){
        Students selected = table.getSelectionModel().getSelectedItem();
        studentList.remove(selected);
    }
    private boolean change = false;
    public void sort(){
        if (change){
            Collections.reverse(studentList);
            change = false;
        }else {
            Collections.sort(studentList);
            change = true;
        }
    }

}