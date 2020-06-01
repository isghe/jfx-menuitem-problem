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
import java.util.List;
import java.util.Arrays;

public class MenuBar_1 extends Application { 

	// launch the application 
	public void start(Stage s) 
	{ 
		// set title for the stage 
		s.setTitle("creating MenuBar"); 

		List <String> properties = Arrays.asList (
			"os.name", "os.arch", "os.version",
			"java.vendor", "java.version", "javafx.version"
		);

		ListIterator <String> listIterator = properties.listIterator ();

		while (listIterator.hasNext ()){
			String property = listIterator.next ();
			listIterator.set (property + ": " + System.getProperty(property));
		}

		Label labelVersion = new Label (String.join (";\n", properties) + ".");

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

		Label labelSelected = new Label("\nItem selected: none");
		// create events for menu items
		// action event
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e)
			{
				labelSelected.setText("\nItem selected: " +((MenuItem)e.getSource()).getText());
			}
		};

		for (MenuItem menuItem: menuItems){
			m.getItems().add(menuItem);
			menuItem.setOnAction (event);
		}

		m.getItems().forEach (menuItem ->{
			System.out.println (menuItem.getText());
		});

		// create a menubar 
		MenuBar mb = new MenuBar();

		// add menu to menubar
		mb.getMenus().add(m);

		// create a VBox 
		VBox vb = new VBox(mb, labelVersion, labelSelected);
		vb.setAlignment(javafx.geometry.Pos.TOP_CENTER);

		// create a scene 
		Scene sc = new Scene(vb, 512, 342);

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

