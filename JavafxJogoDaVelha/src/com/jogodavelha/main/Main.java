package com.jogodavelha.main;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application{
	
	private static Stage stage;
	private static Pane root;
	private static Font font;
	private MenuPersonalizado menu;
	private Scene scene;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args); 
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		stage = primaryStage;
		carregarTelaMenu();
		panePersonalizado();

	}
	public void carregarTelaMenu(){
		
		try {
			root = FXMLLoader.load(getClass().getResource("/com/jogodavelha/view/TelaMenu.fxml"));
			scene = new Scene(root);
			stage.setScene(scene); 
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	public void carregarTelaJogo(){
		try {
			root = FXMLLoader.load(getClass().getResource("/com/jogodavelha/view/TelaJogo.fxml"));
			
			FadeTransition fade = new FadeTransition(Duration.seconds(2), root);
			fade.setFromValue(0.0);
			fade.setToValue(1.0);
			fade.play();
			
			
			
			
			scene = new Scene(root);
			stage.setScene(scene); 
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	private void panePersonalizado() { 

        try (
                InputStream fontStream = Files.newInputStream(Paths.get("res/cod_font.ttf"))
             ) {
            font = Font.loadFont(fontStream, 30);   
        }
        catch (IOException e) {
            System.out.println("erro ao carregar font");
        }

        MenuItemPersonalizado itemQuit = new MenuItemPersonalizado("QUIT");
        itemQuit.setOnMouseClicked(event -> System.exit(0));
        MenuItemPersonalizado umJogador = new MenuItemPersonalizado("UM JOGADOR");
        umJogador.setOnMouseClicked(event -> {
    
        	carregarTelaJogo();
        	
        }); 
        MenuItemPersonalizado doisJogadores = new MenuItemPersonalizado("DOIS JOGADORES");
        doisJogadores.setOnMouseClicked(event -> JOptionPane.showMessageDialog(null, "Em Breve !!") ); 
        
        MenuItemPersonalizado opcao = new MenuItemPersonalizado("OPÇÃO");
        opcao.setOnMouseClicked(event -> JOptionPane.showMessageDialog(null, "Em Breve !!") ); 
        
        MenuItemPersonalizado creditos = new MenuItemPersonalizado("CRÉDITOS");
        creditos.setOnMouseClicked(event -> JOptionPane.showMessageDialog(null, "Em Breve !!") ); 
        
        menu = new MenuPersonalizado("MENU",
                umJogador,
                doisJogadores,
                opcao,
                creditos,
                itemQuit);

        root.getChildren().add(menu);
    }
	
	 private static class MenuPersonalizado extends StackPane { 
	        public MenuPersonalizado(String title, MenuItemPersonalizado... items) {
	            Rectangle bg = new Rectangle(300, 600);
	            bg.setOpacity(0.2);

	            DropShadow shadow = new DropShadow(7, 5, 0, Color.BLACK);
	            shadow.setSpread(0.8);

	            bg.setEffect(shadow);

	            Text text = new Text(title + "   ");
	            text.setFont(font);
	            text.setFill(Color.WHITE);

	            Line hSep = new Line();
	            hSep.setEndX(250);
	            hSep.setStroke(Color.DARKGREEN);
	            hSep.setOpacity(0.4);

	            Line vSep = new Line();
	            vSep.setStartX(300);
	            vSep.setEndX(300);
	            vSep.setEndY(600);
	            vSep.setStroke(Color.DARKGREEN);
	            vSep.setOpacity(0.4);

	            VBox vbox = new VBox();
	            vbox.setAlignment(Pos.TOP_RIGHT);
	            vbox.setPadding(new Insets(60, 0, 0, 0));
	            vbox.getChildren().addAll(text, hSep);
	            vbox.getChildren().addAll(items);

	            setAlignment(Pos.TOP_RIGHT);
	            getChildren().addAll(bg, vSep, vbox);
	        }

	        public void show() {
	            setVisible(true);
	            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.5), this);
	            tt.setToX(0);
	            tt.play();
	        }

	        public void hide() {
	            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.5), this);
	            tt.setToX(-300);
	            tt.setOnFinished(event -> setVisible(false));
	            tt.play();
	        }
	    }

	    private static class MenuItemPersonalizado extends StackPane { 
	        public MenuItemPersonalizado(String name) {
	            Rectangle bg = new Rectangle(300, 24);

	            LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop[] {
	                    new Stop(0, Color.BLACK),
	                    new Stop(0.2, Color.DARKGREY)
	            });

	            bg.setFill(gradient);
	            bg.setVisible(false);
	            bg.setEffect(new DropShadow(5, 0, 5, Color.BLACK));

	            Text text = new Text(name + "      ");
	            text.setFill(Color.LIGHTGREY);
	            text.setFont(Font.font(20));

	            setAlignment(Pos.CENTER_RIGHT);
	            getChildren().addAll(bg, text);

	            setOnMouseEntered(event -> {
	                bg.setVisible(true);
	                text.setFill(Color.WHITE);
	            });

	            setOnMouseExited(event -> {
	                bg.setVisible(false);
	                text.setFill(Color.LIGHTGREY);
	            });

	            setOnMousePressed(event -> {
	                bg.setFill(Color.WHITE);
	                text.setFill(Color.BLACK);
	            });

	            setOnMouseReleased(event -> {
	                bg.setFill(gradient);
	                text.setFill(Color.WHITE);
	            });
	        }
	    }

}
