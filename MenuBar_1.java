// Java program to create a menu bar and add 
// menu to it and also add menuitems to menu 
import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.*; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.scene.control.*; 
import javafx.stage.Stage; 
import javafx.scene.control.Alert.AlertType; 
import java.time.LocalDate;
import java.util.ListIterator;
public class MenuBar_1 extends Application { 

	// launch the application 
	public void start(Stage s) 
	{ 
		// set title for the stage 
		s.setTitle("creating MenuBar"); 

		// create a menu 
		Menu m = new Menu("Menu");

		MenuItem [] menuItems = {
			new MenuItem("menu_item_1"),
			new MenuItem("menu-item 2"),
			new MenuItem("menu-item_3"),
			new SeparatorMenuItem(),
			new MenuItem("_"),
			new MenuItem("__"),
			new MenuItem("_menu item 7"),
			new MenuItem("__menu item 8"),
			new MenuItem("_id_menu item 9")
		};

		Label label = new Label("no menu item selected");
		// create events for menu items
		// action event
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e)
			{
				label.setText(((MenuItem)e.getSource()).getText() + " selected");
			}
		};

		for (MenuItem menuItem: menuItems){
			m.getItems().add(menuItem);
		}

		m.getItems().forEach (menuItem ->{
			System.out.println (menuItem.getText());
			menuItem.setOnAction (event);
		});

		// create a menubar 
		MenuBar mb = new MenuBar();

		// add menu to menubar
		mb.getMenus().add(m);

		// create a VBox 
		VBox vb = new VBox(mb, label);
		vb.setAlignment(javafx.geometry.Pos.TOP_CENTER);

		// create a scene 
		Scene sc = new Scene(vb, 500, 300);

		// set the scene 
		s.setScene(sc); 

		s.show(); 
	} 

	public static void main(String args[]) 
	{ 
		// launch the application 
		launch(args); 
	} 
} 

