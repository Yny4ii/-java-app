package sample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;


public class Controller {
    public TextField hours_field;
    public TextField minutes_field;
    int hours, minutes;


    public void button(javafx.event.ActionEvent actionEvent) throws SQLException {
        Db db = new Db();
        Connection connection = db.getConnection();
        String sql = "INSERT time (minutes) VALUES('" + minutes_field.getText() + "')";
        String sql2 = "INSERT time (hours) VALUES('" + hours_field.getText() + "')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql2);
        statement.executeUpdate(sql);
        String query = "select * from javatime.time";
        ResultSet resSet = statement.executeQuery(query);
        loadinfo();
    }

    public void loadinfo() throws SQLException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Db db1 = new Db();
        String query = "select * from javatime.time";
        Connection connection = db1.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resSet = statement.executeQuery(query);
        while (resSet.next()) {
            hours += resSet.getInt(2);
            minutes += resSet.getInt(3);

        }
        if(minutes > 60){
            hours = hours + (minutes / 60);
            minutes = (minutes % 60);
        }
        alert.setContentText(String.valueOf(hours) + " hours and " + String.valueOf(minutes) + " minutes");

        alert.showAndWait();

    }
}
