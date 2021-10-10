
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;



/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox // what does extends VBox mean???
{

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	private Button button1;
	private Button button2;
	private Button button3; 
	private Button button4;
	private Button button5;
	private Label label;
	private TextField textf;
	
	//  declare two HBoxes
	private HBox hbox1;
	private HBox hbox2;
	//*** private Object root ; 
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager DM;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		button1 = new Button ("Hello");
		button2 = new Button ("Howdy");
		button3 = new Button ("Chinese");
		button4 = new Button ("Clear");
		button5 = new Button ("Exit");
		label = new Label ("Feedback:");
		textf = new TextField();
		hbox1 = new HBox() ;
		hbox2 = new HBox() ;
		
		//student Task #4:
		//  instantiate the DataManager instance
		DM = new DataManager();
		//  set margins and set alignment of the components
		HBox.setMargin(button1, getInsets());
		HBox.setMargin(button2, getInsets());
		HBox.setMargin(button3, getInsets());
		HBox.setMargin(button4, getInsets());
		HBox.setMargin(button5, getInsets());
		HBox.setMargin(label,getInsets());
		HBox.setMargin(textf, getInsets());
		hbox1.setAlignment (Pos.CENTER); 
		hbox2.setAlignment (Pos.CENTER);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hbox1.getChildren().addAll( label , textf );
		//  add the buttons to the other HBox
		hbox2.getChildren().addAll (button1, button2, button3, button4, button5);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll ( hbox1, hbox2); 
		
		button1.setOnAction(new ButtonHandler());
		button2.setOnAction(new ButtonHandler());
		button3.setOnAction(new ButtonHandler());
		button4.setOnAction(new ButtonHandler());
		button5.setOnAction(new ButtonHandler());
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class ButtonHandler implements EventHandler <ActionEvent>
	{
		@Override
		public void handle (ActionEvent event)
		{
			if (event.getTarget().equals(button1))
				textf.setText( DM.getHello());
			else if (event.getTarget().equals(button2))
				textf.setText( DM.getHowdy());
			else if (event.getTarget().equals(button3))
				textf.setText( DM.getChinese());
			
			if (event.getTarget().equals(button4))
				textf.setText("");
			
			if (event.getTarget().equals(button5)) {
				Platform.exit();
				System.exit(0);
				}
		}
	}
	
}
	