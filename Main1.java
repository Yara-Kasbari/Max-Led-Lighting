package application;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Main1 extends Application {
	
	TextArea txt1;
	TextArea txt2;
	TextArea txt3;
	
	private int[] leds;
    private int[] ledSources;
   

	@Override
	public void start(Stage primaryStage) throws ParseException {
		try {
			
			// Scene 1 
			Image image1 = new Image ("C:\\Users\\user\\image2.jpg");
			ImageView imageView1 = new ImageView(image1); 			
		    imageView1.setFitHeight(450); 
		    imageView1.setFitWidth(500);   
		    Image image4 = new Image ("C:\\Users\\user\\image4.jpg");  // image for file 
			ImageView imageView4 = new ImageView(image4); 
			imageView4.setFitHeight(30); 
			imageView4.setFitWidth(30);  
			Image image5 = new Image ("C:\\Users\\user\\image3.jpg");  //  image for read data by file  
			ImageView imageView5 = new ImageView(image5); 
			imageView5.setFitHeight(30); 
			imageView5.setFitWidth(30);  
			Image image6 = new Image ("C:\\Users\\user\\image5.jpg");  //  image for user  
			ImageView imageView6 = new ImageView(image6); 
			imageView6.setFitHeight(30); 
			imageView6.setFitWidth(30);  
			
			
		    BorderPane pane = new BorderPane();
		    VBox vb1 = new VBox(); 
		    
		    Label lb1 = new Label ("Please Select A Button");
		    lb1.setFont(Font.font("Georgia",FontWeight.BOLD, 30));
		    lb1.setTextFill(Color.BLACK);
		  
		  
		   Button bt1 = new Button ("Load File",imageView4);
		    bt1.setFont(Font.font("Georgia", 26));
		    bt1.setMaxWidth(280);
		    bt1.setStyle("-fx-background-color: #00CCCC; ");
		      
		   
		    
		    
		    Button bt2 = new Button ("Enter Data By User",imageView6);
		    bt2.setFont(Font.font("Georgia", 26));
		    bt2.setStyle("-fx-background-color: #00CCCC; ");
		  /*  bt2.setStyle(
					"-fx-border-radius: 20;-fx-border-color: Blue;-fx-background-color: LightBlue;-fx-background-radius: 20;");*/
		    Button bt3 = new Button ("File Data",imageView5);
		    bt3.setFont(Font.font("Georgia", 26));
		    bt3.setMaxWidth(280);
		    bt3.setStyle("-fx-background-color: #00CCCC; ");
		 //   bt3.setStyle("-fx-border-color: black; -fx-border-width: 2px;");

		
		   
		    
		    vb1.getChildren().addAll(lb1,bt3,bt2);
			vb1.setSpacing(20);
			vb1.setAlignment(Pos.CENTER);
			pane.setCenter(vb1);

	        StackPane root = new StackPane();
	        root.setAlignment(Pos.CENTER);
	        root.getChildren().addAll(imageView1, pane);
	        
	        // Scene 2 
	        
	        BorderPane pane2 = new BorderPane();
	        pane2.setPadding(new Insets(15,15,15,15));
	       // pane2.setVgap(10);
	        Image image2 = new Image ("C:\\Users\\user\\image2.jpg");
			ImageView imageView2 = new ImageView(image2);    
		    imageView2.setFitHeight(600); 
		    imageView2.setFitWidth(600);  
		    
		    Image image7 = new Image ("C:\\Users\\user\\image6.jpg");
			ImageView imageView7 = new ImageView(image7);    
			imageView7.setFitHeight(30); 
			imageView7.setFitWidth(30); 
			
			 Image image8 = new Image ("C:\\Users\\user\\image7.jpg");
			 ImageView imageView8 = new ImageView(image8);    
			 imageView8.setFitHeight(30); 
			 imageView8.setFitWidth(30); 
				
			 Image image9 = new Image ("C:\\Users\\user\\image8.jpg");
			 ImageView imageView9 = new ImageView(image9);    
			 imageView9.setFitHeight(30); 
			 imageView9.setFitWidth(30); 
			
		    
		     VBox vb2 = new VBox();
		     HBox hb1 = new HBox();
		    
		    //pane2.setAlignment(Pos.CENTER);
		    
		    Button BackBt = new Button ("Back",imageView8);
		    BackBt.setFont(Font.font("Georgia", 26));
		    
		    Label lb2 = new Label ("The Expected Result is ");
		    lb2.setFont(Font.font("Georgia",FontWeight.BOLD, 20));
		    lb2.setTextFill(Color.BLACK);
		    TextArea txt1 = new TextArea ();
		    txt1.setPrefHeight(50);  
		    txt1.setPrefWidth(30);  
		    txt1.setStyle("-fx-border-color: black; -fx-border-width: 2px;");

		  
		    Label lb3 = new Label ("The Daynamic Programming table is: ");
		    lb3.setFont(Font.font("Georgia",FontWeight.BOLD, 20));
		    lb3.setTextFill(Color.BLACK);
		    TextArea txt2 = new TextArea ();
		    txt2.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
		    
		    Label lb4 = new Label ("The Leds That Will Give The Expected Result Are: ");
		    lb4.setFont(Font.font("Georgia",FontWeight.BOLD, 20));
		    lb4.setTextFill(Color.BLACK);
		    TextArea txt3 = new TextArea ();
		    txt3.setPrefHeight(50);  
		    txt3.setPrefWidth(30); 
		    txt3.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
		    
		    Button bt4 = new Button ("Calculate result",imageView7);
		    bt4.setFont(Font.font("Georgia", 26));
		    Button bt5 = new Button ("Next",imageView9);
		    bt5.setFont(Font.font("Georgia", 26));
		  //  Button bt6 = new Button ("MaxLed");
		  //  bt6.setFont(Font.font("Georgia", 26));
		    
            
		    bt4.setOnAction(e -> {
		        FileChooser fileChooser = new FileChooser();
		        // Set the initial directory for the file chooser
		        File initialDirectory = new File("C:\\Users\\user");
		        fileChooser.setInitialDirectory(initialDirectory);

		        // Set the file extension filters (optional)
		        FileChooser.ExtensionFilter textFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt");
		        fileChooser.getExtensionFilters().add(textFilter);

		        // Show the file chooser dialog
		        File selectedFile = fileChooser.showOpenDialog(primaryStage);

		        if (selectedFile != null) {
		            try {
		                // Read the LED data from the file and store it in the existing arrays
		                readLedData(selectedFile);
		                
		                int n = leds.length; // Get the length of the arrays

		                Font txtFont = Font.font("Times New Roman ", FontWeight.BOLD, 13);
		                Font txtFont2 = Font.font("Times New Roman ", FontWeight.BOLD, 15);

		                int[][] dp = new int[n + 1][n + 1];  //for numbers 
		                int[][] b = new int[n + 1][n + 1];  // for paths 
		                Led.fillDpTable(leds, ledSources, dp, b, n);
		                // Set the text in txt1
		                txt1.setText("The Number of Leds Are " + dp[n][n]);  // print the max number at this pos 
		                txt1.setFont(txtFont2);

		                // Display the results in the text areas
		                StringBuilder tableContent = new StringBuilder();
		                StringBuilder selectedLedsContent = new StringBuilder();

		                for (int i = 0; i <= n; i++) {
		                    for (int j = 0; j <= n; j++) {
		                        tableContent.append(dp[i][j]).append("   ");
		                    }
		                    tableContent.append("\n");
		                }

		                int i = n, j = n;
		                printSelectedLeds(b, leds, i, j, selectedLedsContent);

		                // Set the content of txt2 and txt3
		                txt2.setText(tableContent.toString());
		                txt2.setFont(txtFont);
		                txt3.setText(selectedLedsContent.toString());
		                txt3.setFont(txtFont);
		                
		                // Validate input
			            if (errorDialog(leds) || leds.length < n || leds.length > n) {
			                // Display an alert dialog for invalid input
			            	showErrorDialog("Invalid Input", "Please check your input. Ensure there are no duplicate LEDs and there are enough LEDs.");
			                return; // Exit the method if the input is invalid
			            }


		            } catch (FileNotFoundException ex) {
		                ex.printStackTrace();
		            }
		            
		            catch (Exception ex) {
		                ex.printStackTrace();
		                showErrorDialog("Invalid Input", "Please check your input. Ensure there are no duplicate LEDs and there are enough LEDs."+ ex.getMessage());
		                //showErrorDialog("Error", "An unexpected error occurred: " + ex.getMessage());
		            }
		        }
		    });
		   
		  /*  pane2.add(lb2, 0, 0);
		    pane2.add(txt1, 0, 1);
		    pane2.add(lb3, 0, 2);
		    pane2.add(txt2, 0, 3);
		    pane2.add(lb4, 0, 4);
		    pane2.add(txt3, 0, 5);
		    pane2.add(bt4, 2, 6);
		    pane2.add(bt5, 4, 7);
		    pane2.add(BackBt, 3, 7);
		    pane2.setAlignment(Pos.CENTER);*/
		    
            vb2.getChildren().addAll(lb2,txt1,lb3,txt2,lb4,txt3);
			vb2.setSpacing(10);
			vb2.setAlignment(Pos.TOP_CENTER);
			pane2.setLeft(vb2);
			
			hb1.getChildren().addAll(bt4,BackBt,bt5);
			hb1.setSpacing(20);
			hb1.setAlignment(Pos.BOTTOM_CENTER);
		    pane2.setBottom(hb1);
				
		    
		    StackPane root2 = new StackPane();
	        root2.setAlignment(Pos.CENTER);
	        root2.getChildren().addAll(imageView2,pane2);  
	        
	        // Scene 3
	        
	        GridPane pane3 = new GridPane();
	        pane3.setPadding(new Insets(15,15,15,15));
	        pane3.setVgap(10);
	        pane3.setHgap(5);
	        Image image3 = new Image ("C:\\Users\\user\\image2.jpg");
			ImageView imageView3 = new ImageView(image3);    
		    imageView3.setFitHeight(700); 
		    imageView3.setFitWidth(700);  
		    
		    Image image10 = new Image ("C:\\Users\\user\\image6.jpg");
			ImageView imageView10 = new ImageView(image10);    
			imageView10.setFitHeight(20); 
			imageView10.setFitWidth(20); 
		    
		   		    
		    Button BackBt2 = new Button ("Back");
		    BackBt2.setFont(Font.font("Georgia", 26));
		    
		    
		    Label lb5 = new Label("Enter Number Of Leds");
		    lb5.setFont(Font.font("Georgia",FontWeight.BOLD, 20));
		    lb5.setTextFill(Color.BLACK);
		    TextField txtf1 = new TextField ();
		    Label lb6 = new Label("Enter Permutation Of Leds");
		    lb6.setFont(Font.font("Georgia",FontWeight.BOLD, 20));
		    lb6.setTextFill(Color.BLACK);
		    TextField txtf2 = new TextField ();
		  /*  Label lb7 = new Label("Enter The Order Of Led Sources");
		    lb7.setFont(Font.font("Georgia",FontWeight.BOLD, 20));
		    lb7.setTextFill(Color.BLACK);*/
		  //  TextField txtf3 = new TextField ();
		    Label lb8 = new Label ("The Expected Result is ");
		    lb8.setFont(Font.font("Georgia",FontWeight.BOLD, 20));
		    lb8.setTextFill(Color.BLACK);
		    TextArea txt4 = new TextArea ();
		    txt4.setPrefHeight(50);  
		    txt4.setPrefWidth(30); 
		    txt4.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
		  
		    Label lb9 = new Label ("The Daynamic Programming table is: ");
		    lb9.setFont(Font.font("Georgia",FontWeight.BOLD, 20));
		    lb9.setTextFill(Color.BLACK);
		    TextArea txt5 = new TextArea ();
		    txt5.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
		    
		    Label lb10 = new Label ("The Leds That Will Give The Expected Result Are: ");
		    lb10.setFont(Font.font("Georgia",FontWeight.BOLD, 20));
		    lb10.setTextFill(Color.BLACK);
		    TextArea txt6 = new TextArea ();
		    txt6.setPrefHeight(50);  
		    txt6.setPrefWidth(30);
		    txt6.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
		    
		    Button calculateBt = new Button ("Calculate",imageView10);
		    calculateBt.setFont(Font.font("Georgia",FontWeight.BOLD, 18));
		    
		    calculateBt.setOnAction(e -> {
		        try {
		            // Read input values
		        	
		        	// Read input values
		            int n = Integer.parseInt(txtf1.getText());

		           
		           
		         /*   int[] leds = Arrays.stream(txtf2.getText().split(","))
		                                .mapToInt(Integer::parseInt)
		                                .toArray();*/
		            
		            String[] input = txtf2.getText().split(",");
		            int[] leds = new int[input.length];

		            for (int i = 0; i < input.length; i++) {
		                leds[i] = Integer.parseInt(input[i].trim());
		            }
		           
		       
		            int[] ledSources = new int [n];
		            for (int i = 0; i < n; i++) {
		                ledSources[i] = i+1 ; // Adding 1 to convert from 0-based to 1-based index
		            }
		            
		            

		            // Validate input
		            if (errorDialog(leds) || leds.length < n || leds.length>n) {
		                // Display an alert dialog for invalid input
		            	showErrorDialog("Invalid Input", "Please check your input. Ensure there are no duplicate LEDs and there are enough LEDs.");
		                return; // Exit the method if the input is invalid
		            }
		            
		           

		            // Call the method to perform dynamic programming
		            int[][] dp = new int[n + 1][n + 1];
		            int[][] b = new int[n + 1][n + 1];
		            Led.fillDpTable(leds, ledSources, dp, b, n);
		            
		            Font txtFont = Font.font("Times New Roman ",FontWeight.BOLD, 13);
		              Font txtFont2 = Font.font("Times New Roman ",FontWeight.BOLD, 15);
		    	
		            
		            
		            // Set the text in txt1
		            txt4.setText( "The Number of Leds Are " +dp[n][n]);
		            txt4.setFont(txtFont2);
		           
		              
		          

		          
		            // Display the results in the text areas
		            StringBuilder tableContent = new StringBuilder();
		            StringBuilder selectedLedsContent = new StringBuilder();

		            for (int i = 0; i <= n; i++) {
		                for (int j = 0; j <= n; j++) {
		                    tableContent.append(dp[i][j]).append("   ");
		                }
		                tableContent.append("\n");
		            }

		            int i = n, j = n;
		            printSelectedLeds(b, leds, i, j, selectedLedsContent);

		            // Set the content of txt2 and txt3
		            txt5.setText(tableContent.toString());
		            txt5.setFont(txtFont);
		            txt6.setText(selectedLedsContent.toString());
		            txt6.setFont(txtFont);

		         
		        } catch (NumberFormatException ex) {
		            // Handle invalid input
		            ex.printStackTrace();
		            showErrorDialog("Invalid Input", "Please check your input. Ensure there are no duplicate LEDs and there are enough LEDs." );
		        }
		        
		       
		    });
		    
		    pane3.add(lb5, 0, 0);
		    pane3.add(txtf1, 1, 0);
		    pane3.add(lb6, 0, 1);
		   pane3.add(txtf2, 1, 1);
		   // pane3.add(lb7, 0, 2);
		  //  pane3.add(txtf3, 1, 2);
		   pane3.add(calculateBt, 1, 5);
		    pane3.add(lb8, 0, 6);
		    pane3.add(txt4, 0, 7);
		    pane3.add(lb9, 0, 8);
		    pane3.add(txt5, 0, 9);
		    pane3.add(lb10, 0, 10);
		    pane3.add(txt6, 0, 11);
		  
		    pane3.setAlignment(Pos.BASELINE_LEFT);
		    
		  
		    StackPane root3 = new StackPane();
	        root3.setAlignment(Pos.CENTER);
	        root3.getChildren().addAll(imageView3,pane3);  
	        
	        // scene 4
	        
	        GridPane pane4 = new GridPane();
	        
	        Button bt7 = new Button ("MaxLed");
		    bt7.setFont(Font.font("Georgia", 26));
		    
		    pane4.add(bt7, 1,1);
		    pane4.setAlignment(Pos.TOP_LEFT);
	        
	        Image image11 = new Image ("C:\\Users\\user\\image12.jpg"); // background image
			ImageView imageView11 = new ImageView(image11);    
		    imageView11.setFitHeight(1000); 
		    imageView11.setFitWidth(1000);  
	        
	        StackPane root4 = new StackPane(imageView11,pane4);
	   
			
			Scene scene = new Scene(root,500,450);  // the main Scene
			Scene FileChooserScene = new Scene (root2,600,550);  // the second Scene
			Scene UserData = new Scene (root3,670,600); // third scene
			Scene imageScene = new Scene (root4,900,500); // fourth scene
			
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Max Led Light");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
	
			primaryStage.show();
			
			/*bt1.setOnAction(e -> {
				primaryStage.setScene(FileChooserScene);
			});*/
			
			bt3.setOnAction(e -> {
				primaryStage.setScene(FileChooserScene);
			});
			
			
			BackBt.setOnAction(e -> {
				primaryStage.setScene(scene); // back to main scene 
			});
			
			bt2.setOnAction(e -> {
				primaryStage.setScene(UserData); // back to main scene 
			});
			
			BackBt2.setOnAction(e -> {
				primaryStage.setScene(scene); // back to main scene 
			});
			
			bt5.setOnAction(e -> {
				primaryStage.setScene(UserData); 
			});
			
		/*	bt6.setOnAction(e -> {
				primaryStage.setScene(imageScene); 
			});*/
			

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	
	 private void printFileContents(File file) throws FileNotFoundException {
	        Scanner scanner = new Scanner(file);

	        // Print each line of the file to the console
	        while (scanner.hasNextLine()) {
	            System.out.println(scanner.nextLine());
	        }

	        scanner.close();
	    }
	 
	 public static void printSelectedLeds(int[][] c, int[] led, int i, int j, StringBuilder resultText) {
		    if (i == 0 || j == 0)
		        return;

		    if (c[i][j] == '\\') {
		        printSelectedLeds(c, led, i - 1, j - 1, resultText);
		        resultText.append(led[i - 1]).append("   ");
		    } else if (c[i][j] == '|') {
		        printSelectedLeds(c, led, i - 1, j, resultText);
		    } else {
		        printSelectedLeds(c, led, i, j - 1, resultText);
		    }
		}
	 
	 private void readLedData(File file) throws FileNotFoundException {
		    Scanner scan = new Scanner(file);

		    // Read the LED data from the file
		    int n = scan.nextInt();
		    leds = new int[n];
		    ledSources = new int[n];

		    for (int i = 0; i < n; i++) {
		        leds[i] = scan.nextInt();
		        
		        
		        for (int j = 0; j < i; j++) {
                    if (leds[i] == leds[j]) {
                        System.out.println("Error: Duplicate LED number found!");
                        System.exit(1);
                    }
                }
		    }

		  /*  for (int i = 0; i < n; i++) {
		        ledSources[i] = scan.nextInt();
		    }*/
		    
		    for (int i = 0; i < n; i++) {
                ledSources[i] = i + 1; // Adding 1 to convert from 0-based to 1-based index
            }

		    scan.close();                     
		}
	 
	 private boolean errorDialog(int[] leds) {
		    for (int i = 0; i < leds.length; i++) {
		        for (int j = i + 1; j < leds.length; j++) {
		            if (leds[i] == leds[j]) {
		                return true; // Duplicate LED found
		            }
		        }
		    }
		    return false; // No duplicate LEDs
		}
	 
	 public void showErrorDialog(String title, String content) {
		    Alert alert = new Alert(AlertType.ERROR); 
		    alert.setTitle("ERROR!!"); 
		    alert.setHeaderText(content); 
		    alert.setContentText(""); 
		    alert.showAndWait();
		}
	 
	 
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
