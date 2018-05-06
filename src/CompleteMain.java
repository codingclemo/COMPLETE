import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class CompleteMain extends Application implements EventHandler<KeyEvent> {


	private Button loginButton;
	private Button registerButton;
	
	private Button createTextButton(String id, String caption) {
		Button button = new Button(caption);
		button.setId(id);
		button.setPadding(new Insets(5));
		button.setPrefSize(100, 30);
		return button;
	}
	
	
	private Pane createWelcomePane() {
		GridPane contentPane = new GridPane();  // probably there is a nicer solution to this
		contentPane.setId("content-pane");
		
		Text t = new Text();
		t.setText("Welcome to COMPLETE");
		contentPane.add(t, 0, 2);
		
		VBox welcomePane = new VBox();
		welcomePane.setId("welcome-pane");
		welcomePane.getChildren().addAll(contentPane);
		welcomePane.setAlignment(Pos.CENTER);
		welcomePane.setBackground(new Background ( new BackgroundFill(Color.AQUA, null, null)));
		
		return welcomePane;
	}
	
	
	private Pane createCredentialsPane() {
		loginButton = createTextButton("button-login", "Login");
		registerButton = createTextButton("button-register", "Register");
		registerButton.setOnAction(e -> window.setScene(registrationScene));
		
		VBox buttonPane = new VBox();
		buttonPane.getChildren().add(loginButton);
		buttonPane.getChildren().add(registerButton);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setSpacing(10);
		buttonPane.setBackground(new Background ( new BackgroundFill(Color.BURLYWOOD, null, null)));
		
		Label usernameLabel = new Label("Username");
		usernameLabel.setAlignment(Pos.CENTER_LEFT);
		TextField usernameTextField = new TextField ();
		usernameTextField.setPromptText("enter e-mail adress");
		VBox usernameInput = new VBox();
		usernameInput.getChildren().addAll(usernameLabel, usernameTextField);
		usernameInput.setPadding(new Insets(5, 0, 10, 0));
		
		Label passwordLabel = new Label("Password");
		passwordLabel.setAlignment(Pos.CENTER_LEFT);
		PasswordField passwordTextField = new PasswordField();
		passwordTextField.setPromptText("enter password");
//		TextField passwordTextField = new TextField ();
		VBox pwInput = new VBox();
		pwInput.getChildren().addAll(passwordLabel, passwordTextField);
		pwInput.setPadding(new Insets(5, 0, 10, 0));
		
		VBox credentialsPane = new VBox();
		credentialsPane.setId("credentials-pane");
		
		credentialsPane.getChildren().add(usernameInput);
		credentialsPane.getChildren().add(pwInput);
		credentialsPane.getChildren().add(buttonPane);
		
		credentialsPane.setBackground( new Background( new BackgroundFill(Color.CORNSILK, null, null)));
		credentialsPane.setAlignment(Pos.CENTER);

		return credentialsPane;
	}
	
	
	
	Button nextButton;
	Button backButton;
	
	private Pane createRegistrationPane() {
		
		VBox registrationPane = new VBox();
		
		GridPane headerPane = new GridPane();  // probably there is a nicer solution to this
		headerPane.setId("header-pane");
		headerPane.setAlignment(Pos.CENTER);
		headerPane.setBackground(new Background ( new BackgroundFill(Color.AQUA, null, null)));
		
		Text t = new Text();
		t.setText("Registration - Onboard the Panini exchange train");
		headerPane.add(t, 0, 2);
		headerPane.setMinHeight(100);
		
		GridPane registrationForm = new GridPane();
		registrationForm.setId("registration-form");
		registrationForm.setMinHeight(50);
		registrationForm.setBackground(new Background ( new BackgroundFill(Color.BEIGE, null, null)));
	
		Label fnLabel = new Label("First name");
		TextField fnTextField = new TextField ();
		
		Label lnLabel = new Label("Last name");
		TextField lnTextField = new TextField ();
		
		Label usernameLabel = new Label("E-Mail");
		TextField usernameTextField = new TextField ();
		
		Label passwordLabel = new Label("Password");
//		passwordLabel.setAlignment(Pos.CENTER_LEFT);
		PasswordField passwordTextField = new PasswordField();
//		passwordTextField.setPromptText("enter password");
		
		Label adressLabel = new Label("Adress");
		TextField adressTextField = new TextField ();
		
		Label cityLabel = new Label("City");
		TextField cityTextField = new TextField ();	
		
		Label regionLabel = new Label("Region");
		TextField regionTextField = new TextField ();	
		
		Label countryLabel = new Label("Country");
		TextField countryTextField = new TextField ();	


		registrationForm.add(fnLabel, 			0, 0);
		registrationForm.add(fnTextField, 		1, 0);
		registrationForm.add(lnLabel, 			0, 1);
		registrationForm.add(lnTextField, 		1, 1);
		registrationForm.add(usernameLabel, 	0, 2);
		registrationForm.add(usernameTextField, 1, 2);
		
		registrationForm.add(adressLabel, 		0, 3);
		registrationForm.add(adressTextField, 	1, 3);
		registrationForm.add(cityLabel, 		0, 4);
		registrationForm.add(cityTextField, 	1, 4);
		registrationForm.add(regionLabel, 		0, 5);
		registrationForm.add(regionTextField, 	1, 5);
		registrationForm.add(countryLabel, 		0, 6);
		registrationForm.add(countryTextField, 	1, 6);
		registrationForm.add(passwordLabel, 	0, 8);
		registrationForm.add(passwordTextField, 	1, 8);
		
		registrationForm.setVgap(5);
		registrationForm.setHgap(20);		
//		registrationForm.setGridLinesVisible(true);
		registrationForm.setHalignment(fnLabel, HPos.RIGHT);
		registrationForm.setHalignment(lnLabel, HPos.RIGHT);
		registrationForm.setHalignment(usernameLabel, HPos.RIGHT);
		registrationForm.setHalignment(adressLabel, HPos.RIGHT);
		registrationForm.setHalignment(cityLabel, HPos.RIGHT);
		registrationForm.setHalignment(regionLabel, HPos.RIGHT);
		registrationForm.setHalignment(countryLabel, HPos.RIGHT);

		registrationForm.setAlignment(Pos.CENTER);
		registrationForm.setMaxWidth(400);
		
		nextButton = createTextButton("button-next", "Next");
		backButton = createTextButton("button-back", "Back");
		backButton.setOnAction(e -> window.setScene(loginScene));
		
		HBox buttonsPane = new HBox();
		buttonsPane.getChildren().add(backButton);
		buttonsPane.getChildren().add(nextButton);
		buttonsPane.setSpacing(50);
		buttonsPane.setPrefSize(400, 70);
		buttonsPane.setAlignment(Pos.BOTTOM_CENTER);
		buttonsPane.setBackground(new Background ( new BackgroundFill(Color.BLUEVIOLET, null, null)));
		
		registrationPane.setId("registration-pane");
		registrationPane.getChildren().addAll(headerPane);
		registrationPane.getChildren().addAll(registrationForm);
		registrationPane.getChildren().addAll(buttonsPane);
		registrationPane.setAlignment(Pos.TOP_CENTER);
		
		return registrationPane;
		
	}
	
	Stage window;
	Scene loginScene;
	Scene registrationScene;
	
	@Override
	public void start(Stage primaryStage) throws Exception { // changed to priStage from primaryStage
		
		window = primaryStage;
		
		Pane welcomePane = createWelcomePane();
		welcomePane.setMinHeight(50);
		welcomePane.setMaxWidth(100);
		
		Pane credentialsPane = createCredentialsPane();
		credentialsPane.setMaxWidth(200);
		
		VBox rootPane = new VBox(welcomePane, credentialsPane);
		rootPane.setAlignment(Pos.CENTER);
		

		Pane registrationPane = createRegistrationPane();
		
		//TODO: Add eventhandler so that the registrationPane is loaded when register Button is pressed
		
//		Scene scene = new Scene(registrationPane, 500, 500);		
//		Scene scene = new Scene(rootPane, 500, 500);
		loginScene = new Scene(rootPane, 500, 500);

		registrationScene = new Scene(registrationPane, 500, 500);
		
		window.setScene(loginScene);
		window.setMinWidth(400);
		window.setMinHeight(400);
		
		window.setTitle("Complete");
		window.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	

}
