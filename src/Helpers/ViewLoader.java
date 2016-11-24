package Helpers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * Created by sk4yb3n on 23/11/2016.
 */
public class ViewLoader {

    private String viewName;

    public ViewLoader(String viewName) {
        this.setViewName(viewName);
    }

    public Parent load() throws Exception {
        return FXMLLoader.load(getClass().getResource("../Views/" + this.getViewName() + ".fxml"));
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return this.viewName;
    }

}
