package com.jogodavelha.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jogodavelha.model.JogoDaVelha;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TelaJogoController implements Initializable {

	@FXML
	private JFXButton btn1;

	@FXML
	private ImageView imgBotao2;
	
	@FXML
	private ImageView imgBotao1;

	@FXML
	private JFXButton btn2;

	@FXML
	private JFXButton btn3;

	@FXML
	private ImageView imgBotao3;

	@FXML
	private JFXButton btn4;

	@FXML
	private ImageView imgBotao4;

	@FXML
	private JFXButton btn5;

	@FXML
	private ImageView imgBotao5;

	@FXML
	private JFXButton btn6;

	@FXML
	private ImageView imgBotao6;

	@FXML
	private JFXButton btn7;

	@FXML
	private ImageView imgBotao7;

	@FXML
	private JFXButton btn8;

	@FXML
	private ImageView imgBotao8;

	@FXML
	private JFXButton btn9;

	@FXML
	private ImageView imgBotao9;

	private char[][] tabelaJogo = new char[3][3];

	private char opcaoEscolhida;

	private int resultado;

	private File urlO = new File("/com/jogodavelha/img/o.png");
	private File urlX = new File("/com/jogodavelha/img/x.png");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		zerarJogo();
		JogoDaVelha.setTabelaJogo(tabelaJogo);
	}
	public void zerarJogo(){
		
		for (int i = 0; i < tabelaJogo.length; ++i)
			for (int j = 0; j < tabelaJogo.length; ++j)
				tabelaJogo[i][j] = '1';
		
		imgBotao1.setImage(null);
		imgBotao2.setImage(null);
		imgBotao3.setImage(null);
		imgBotao4.setImage(null);
		imgBotao5.setImage(null);
		imgBotao6.setImage(null);
		imgBotao7.setImage(null);
		imgBotao8.setImage(null);
		imgBotao9.setImage(null);		
	}

	@FXML
	void btn1OnAction(ActionEvent event) {

		if(tabelaJogo[0][0] == '1'){
			// opção que o usuário escolheu
			opcaoEscolhida = JogoDaVelha.getOpcaoEscolhida();

			if(opcaoEscolhida != '1'){
				if (JogoDaVelha.getOpcaoEscolhida() == 'X')
					imgBotao1.setImage(new Image(urlX.toString()));
				else if(JogoDaVelha.getOpcaoEscolhida() == 'O')
					imgBotao1.setImage(new Image(urlO.toString()));

				// salva a opção escolhida na tabela
				tabelaJogo[0][0] = JogoDaVelha.getOpcaoEscolhida();
				// verifica se o usuario ganhou o jogo

				resultado = JogoDaVelha.validarJogo();

				if (resultado == 1) {
					JOptionPane.showMessageDialog(null, opcaoEscolhida+" Ganhoouu");
					zerarJogo();
				} else {
					// gera uma jogada automaticamente
					resultado = JogoDaVelha.counterStrikeComputador();
					if(resultado == 11){
						resultado = JogoDaVelha.gerarJogadaCumputador();
					}
					
					if (resultado == 1)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao1.setImage(new Image(urlO.toString()));
						else
							imgBotao1.setImage(new Image(urlX.toString()));
					if (resultado == 2)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao2.setImage(new Image(urlO.toString()));
						else
							imgBotao2.setImage(new Image(urlX.toString()));
					if (resultado == 3)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao3.setImage(new Image(urlO.toString()));
						else
							imgBotao3.setImage(new Image(urlX.toString()));
					if (resultado == 4)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao4.setImage(new Image(urlO.toString()));
						else
							imgBotao4.setImage(new Image(urlX.toString()));
					if (resultado == 5)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao5.setImage(new Image(urlO.toString()));
						else
							imgBotao5.setImage(new Image(urlX.toString()));
					if (resultado == 6)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao6.setImage(new Image(urlO.toString()));
						else
							imgBotao6.setImage(new Image(urlX.toString()));
					if (resultado == 7)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao7.setImage(new Image(urlO.toString()));
						else
							imgBotao7.setImage(new Image(urlX.toString()));
					if (resultado == 8)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao8.setImage(new Image(urlO.toString()));
						else
							imgBotao8.setImage(new Image(urlX.toString()));
					if (resultado == 9)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao9.setImage(new Image(urlO.toString()));
						else
							imgBotao9.setImage(new Image(urlX.toString()));
					else if (resultado == 10){
						JOptionPane.showMessageDialog(null, "Empateeee");
						zerarJogo();
					}	
					else {
						resultado = JogoDaVelha.validarJogo();
						if (resultado == 1) {
							if(opcaoEscolhida == 'X'){
								JOptionPane.showMessageDialog(null, " 'O' Ganhoouu");
							} else {
								JOptionPane.showMessageDialog(null, " 'X'Ganhoouu");
							}
							zerarJogo();
						}
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Escolha uma opção !!");
			}
		}

	}

	@FXML
	void btn2OnAction(ActionEvent event) {
		if(tabelaJogo[0][1] == '1'){
			// opção que o usuário escolheu
			opcaoEscolhida = JogoDaVelha.getOpcaoEscolhida();

			if(opcaoEscolhida != '1'){
				if (JogoDaVelha.getOpcaoEscolhida() == 'X')
					imgBotao2.setImage(new Image(urlX.toString()));
				else if(JogoDaVelha.getOpcaoEscolhida() == 'O')
					imgBotao2.setImage(new Image(urlO.toString()));

				// salva a opção escolhida na tabela
				tabelaJogo[0][1] = JogoDaVelha.getOpcaoEscolhida();
				// verifica se o usuario ganhou o jogo

				resultado = JogoDaVelha.validarJogo();

				if (resultado == 1) {
					JOptionPane.showMessageDialog(null, opcaoEscolhida+" Ganhoouu");
					zerarJogo();
				} else {
					// gera uma jogada automaticamente
					resultado = JogoDaVelha.counterStrikeComputador();
					if(resultado == 11){
						resultado = JogoDaVelha.gerarJogadaCumputador();
					}
					
					if (resultado == 1)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao1.setImage(new Image(urlO.toString()));
						else
							imgBotao1.setImage(new Image(urlX.toString()));
					if (resultado == 2)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao2.setImage(new Image(urlO.toString()));
						else
							imgBotao2.setImage(new Image(urlX.toString()));
					if (resultado == 3)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao3.setImage(new Image(urlO.toString()));
						else
							imgBotao3.setImage(new Image(urlX.toString()));
					if (resultado == 4)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao4.setImage(new Image(urlO.toString()));
						else
							imgBotao4.setImage(new Image(urlX.toString()));
					if (resultado == 5)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao5.setImage(new Image(urlO.toString()));
						else
							imgBotao5.setImage(new Image(urlX.toString()));
					if (resultado == 6)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao6.setImage(new Image(urlO.toString()));
						else
							imgBotao6.setImage(new Image(urlX.toString()));
					if (resultado == 7)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao7.setImage(new Image(urlO.toString()));
						else
							imgBotao7.setImage(new Image(urlX.toString()));
					if (resultado == 8)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao8.setImage(new Image(urlO.toString()));
						else
							imgBotao8.setImage(new Image(urlX.toString()));
					if (resultado == 9)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao9.setImage(new Image(urlO.toString()));
						else
							imgBotao9.setImage(new Image(urlX.toString()));
					else if (resultado == 10){
						JOptionPane.showMessageDialog(null, "Empateeee");
						zerarJogo();
					}
					else{
						resultado = JogoDaVelha.validarJogo();
						if (resultado == 1) {
							if(opcaoEscolhida == 'X'){
								JOptionPane.showMessageDialog(null, " 'O' Ganhoouu");
							} else {
								JOptionPane.showMessageDialog(null, " 'X'Ganhoouu");
							}
							zerarJogo();
						}
					}
				}

			}
			else {
				JOptionPane.showMessageDialog(null, "Escolha uma opção !!");
			}
		}
	}

	@FXML
	void btn3OnAction(ActionEvent event) {
		
		if(tabelaJogo[0][2] == '1'){
			// opção que o usuário escolheu
			opcaoEscolhida = JogoDaVelha.getOpcaoEscolhida();

			if(opcaoEscolhida != '1'){
				if (JogoDaVelha.getOpcaoEscolhida() == 'X')
					imgBotao3.setImage(new Image(urlX.toString()));
				else if(JogoDaVelha.getOpcaoEscolhida() == 'O')
					imgBotao3.setImage(new Image(urlO.toString()));

				// salva a opção escolhida na tabela
				tabelaJogo[0][2] = JogoDaVelha.getOpcaoEscolhida();
				// verifica se o usuario ganhou o jogo

				resultado = JogoDaVelha.validarJogo();

				if (resultado == 1) {
					JOptionPane.showMessageDialog(null, opcaoEscolhida+" Ganhoouu");
					zerarJogo();
				} else {
					// gera uma jogada automaticamente
					resultado = JogoDaVelha.counterStrikeComputador();
					if(resultado == 11){
						resultado = JogoDaVelha.gerarJogadaCumputador();
					}
					
					if (resultado == 1)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao1.setImage(new Image(urlO.toString()));
						else
							imgBotao1.setImage(new Image(urlX.toString()));
					if (resultado == 2)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao2.setImage(new Image(urlO.toString()));
						else
							imgBotao2.setImage(new Image(urlX.toString()));
					if (resultado == 3)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao3.setImage(new Image(urlO.toString()));
						else
							imgBotao3.setImage(new Image(urlX.toString()));
					if (resultado == 4)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao4.setImage(new Image(urlO.toString()));
						else
							imgBotao4.setImage(new Image(urlX.toString()));
					if (resultado == 5)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao5.setImage(new Image(urlO.toString()));
						else
							imgBotao5.setImage(new Image(urlX.toString()));
					if (resultado == 6)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao6.setImage(new Image(urlO.toString()));
						else
							imgBotao6.setImage(new Image(urlX.toString()));
					if (resultado == 7)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao7.setImage(new Image(urlO.toString()));
						else
							imgBotao7.setImage(new Image(urlX.toString()));
					if (resultado == 8)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao8.setImage(new Image(urlO.toString()));
						else
							imgBotao8.setImage(new Image(urlX.toString()));
					if (resultado == 9)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao9.setImage(new Image(urlO.toString()));
						else
							imgBotao9.setImage(new Image(urlX.toString()));
					else if (resultado == 10){
						JOptionPane.showMessageDialog(null, "Empateeee");
						zerarJogo();
					}
					else{
						resultado = JogoDaVelha.validarJogo();
						if (resultado == 1) {
							if(opcaoEscolhida == 'X'){
								JOptionPane.showMessageDialog(null, " 'O' Ganhoouu");
							} else {
								JOptionPane.showMessageDialog(null, " 'X'Ganhoouu");
							}
							zerarJogo();
						}
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Escolha uma opção !!");
			}

		}

		
	}

	@FXML
	void btn4OnAction(ActionEvent event) {

		if(tabelaJogo[1][0] == '1'){
			// opção que o usuário escolheu
			opcaoEscolhida = JogoDaVelha.getOpcaoEscolhida();
			
			if(opcaoEscolhida != '1'){
				

				if (JogoDaVelha.getOpcaoEscolhida() == 'X')
					imgBotao4.setImage(new Image(urlX.toString()));
				else if(JogoDaVelha.getOpcaoEscolhida() == 'O')
					imgBotao4.setImage(new Image(urlO.toString()));

				// salva a opção escolhida na tabela
				tabelaJogo[1][0] = JogoDaVelha.getOpcaoEscolhida();
				// verifica se o usuario ganhou o jogo

				resultado = JogoDaVelha.validarJogo();

				if (resultado == 1) {
					JOptionPane.showMessageDialog(null, opcaoEscolhida+" Ganhoouu");
					zerarJogo();
				} else {
					// gera uma jogada automaticamente
					resultado = JogoDaVelha.counterStrikeComputador();
					if(resultado == 11){
						resultado = JogoDaVelha.gerarJogadaCumputador();
					}
					
					if (resultado == 1)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao1.setImage(new Image(urlO.toString()));
						else
							imgBotao1.setImage(new Image(urlX.toString()));
					if (resultado == 2)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao2.setImage(new Image(urlO.toString()));
						else
							imgBotao2.setImage(new Image(urlX.toString()));
					if (resultado == 3)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao3.setImage(new Image(urlO.toString()));
						else
							imgBotao3.setImage(new Image(urlX.toString()));
					if (resultado == 4)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao4.setImage(new Image(urlO.toString()));
						else
							imgBotao4.setImage(new Image(urlX.toString()));
					if (resultado == 5)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao5.setImage(new Image(urlO.toString()));
						else
							imgBotao5.setImage(new Image(urlX.toString()));
					if (resultado == 6)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao6.setImage(new Image(urlO.toString()));
						else
							imgBotao6.setImage(new Image(urlX.toString()));
					if (resultado == 7)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao7.setImage(new Image(urlO.toString()));
						else
							imgBotao7.setImage(new Image(urlX.toString()));
					if (resultado == 8)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao8.setImage(new Image(urlO.toString()));
						else
							imgBotao8.setImage(new Image(urlX.toString()));
					if (resultado == 9)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao9.setImage(new Image(urlO.toString()));
						else
							imgBotao9.setImage(new Image(urlX.toString()));
					else if (resultado == 10){
						JOptionPane.showMessageDialog(null, "Empateeee");
						zerarJogo();
				}
					
					else{
						resultado = JogoDaVelha.validarJogo();
						if (resultado == 1) {
							if(opcaoEscolhida == 'X'){
								JOptionPane.showMessageDialog(null, " 'O' Ganhoouu");
							} else {
								JOptionPane.showMessageDialog(null, " 'X'Ganhoouu");
							}
							zerarJogo();
						}
					}
				}
				 
			} else {
				JOptionPane.showMessageDialog(null, "Escolha uma opção !!");
			}
		}
		
		

	}

	@FXML
	void btn5OnAction(ActionEvent event) {
		
		if(tabelaJogo[1][1] == '1'){

			// opção que o usuário escolheu
			opcaoEscolhida = JogoDaVelha.getOpcaoEscolhida();
			
			if(opcaoEscolhida != '1'){
				
				if (JogoDaVelha.getOpcaoEscolhida() == 'X')
					imgBotao5.setImage(new Image(urlX.toString()));
				else if(JogoDaVelha.getOpcaoEscolhida() == 'O')
					imgBotao5.setImage(new Image(urlO.toString()));

				// salva a opção escolhida na tabela
				tabelaJogo[1][1] = JogoDaVelha.getOpcaoEscolhida();
				// verifica se o usuario ganhou o jogo

				resultado = JogoDaVelha.validarJogo();

				if (resultado == 1) {
					JOptionPane.showMessageDialog(null, opcaoEscolhida+" Ganhoouu");
					zerarJogo();
				} else {
					// gera uma jogada automaticamente
					resultado = JogoDaVelha.counterStrikeComputador();
					if(resultado == 11){
						resultado = JogoDaVelha.gerarJogadaCumputador();
					}
					
					if (resultado == 1)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao1.setImage(new Image(urlO.toString()));
						else
							imgBotao1.setImage(new Image(urlX.toString()));
					if (resultado == 2)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao2.setImage(new Image(urlO.toString()));
						else
							imgBotao2.setImage(new Image(urlX.toString()));
					if (resultado == 3)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao3.setImage(new Image(urlO.toString()));
						else
							imgBotao3.setImage(new Image(urlX.toString()));
					if (resultado == 4)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao4.setImage(new Image(urlO.toString()));
						else
							imgBotao4.setImage(new Image(urlX.toString()));
					if (resultado == 5)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao5.setImage(new Image(urlO.toString()));
						else
							imgBotao5.setImage(new Image(urlX.toString()));
					if (resultado == 6)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao6.setImage(new Image(urlO.toString()));
						else
							imgBotao6.setImage(new Image(urlX.toString()));
					if (resultado == 7)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao7.setImage(new Image(urlO.toString()));
						else
							imgBotao7.setImage(new Image(urlX.toString()));
					if (resultado == 8)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao8.setImage(new Image(urlO.toString()));
						else
							imgBotao8.setImage(new Image(urlX.toString()));
					if (resultado == 9)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao9.setImage(new Image(urlO.toString()));
						else
							imgBotao9.setImage(new Image(urlX.toString()));
					else if (resultado == 10){
						JOptionPane.showMessageDialog(null, "Empateeee");
						zerarJogo();
					}
					else {
						resultado = JogoDaVelha.validarJogo();
						if (resultado == 1) {
							if(opcaoEscolhida == 'X'){
								JOptionPane.showMessageDialog(null, " 'O' Ganhoouu");
							} else {
								JOptionPane.showMessageDialog(null, " 'X'Ganhoouu");
							}
							zerarJogo();
						}
					}
				}
				 
			} else {
				JOptionPane.showMessageDialog(null, "Escolha uma opção !!");
			}

		}

		
	}

	@FXML
	void btn6OnAction(ActionEvent event) {
		
		if(tabelaJogo[1][2] == '1'){
			// opção que o usuário escolheu
			opcaoEscolhida = JogoDaVelha.getOpcaoEscolhida();
			
			if(opcaoEscolhida != '1'){
				
				if (JogoDaVelha.getOpcaoEscolhida() == 'X')
					imgBotao6.setImage(new Image(urlX.toString()));
				else if(JogoDaVelha.getOpcaoEscolhida() == 'O')
					imgBotao6.setImage(new Image(urlO.toString()));

				// salva a opção escolhida na tabela
				tabelaJogo[1][2] = JogoDaVelha.getOpcaoEscolhida();
				// verifica se o usuario ganhou o jogo

				resultado = JogoDaVelha.validarJogo();

				if (resultado == 1) {
					JOptionPane.showMessageDialog(null, opcaoEscolhida+" Ganhoouu");
					zerarJogo();
				} else {
					// gera uma jogada automaticamente
					resultado = JogoDaVelha.counterStrikeComputador();
					if(resultado == 11){
						resultado = JogoDaVelha.gerarJogadaCumputador();
					}
					
					if (resultado == 1)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao1.setImage(new Image(urlO.toString()));
						else
							imgBotao1.setImage(new Image(urlX.toString()));
					if (resultado == 2)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao2.setImage(new Image(urlO.toString()));
						else
							imgBotao2.setImage(new Image(urlX.toString()));
					if (resultado == 3)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao3.setImage(new Image(urlO.toString()));
						else
							imgBotao3.setImage(new Image(urlX.toString()));
					if (resultado == 4)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao4.setImage(new Image(urlO.toString()));
						else
							imgBotao4.setImage(new Image(urlX.toString()));
					if (resultado == 5)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao5.setImage(new Image(urlO.toString()));
						else
							imgBotao5.setImage(new Image(urlX.toString()));
					if (resultado == 6)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao6.setImage(new Image(urlO.toString()));
						else
							imgBotao6.setImage(new Image(urlX.toString()));
					if (resultado == 7)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao7.setImage(new Image(urlO.toString()));
						else
							imgBotao7.setImage(new Image(urlX.toString()));
					if (resultado == 8)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao8.setImage(new Image(urlO.toString()));
						else
							imgBotao8.setImage(new Image(urlX.toString()));
					if (resultado == 9)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao9.setImage(new Image(urlO.toString()));
						else
							imgBotao9.setImage(new Image(urlX.toString()));
					else if (resultado == 10){
						JOptionPane.showMessageDialog(null, "Empateeee");
						zerarJogo();
					}
					else {
						resultado = JogoDaVelha.validarJogo();
						if (resultado == 1) {
							if(opcaoEscolhida == 'X'){
								JOptionPane.showMessageDialog(null, " 'O' Ganhoouu");
							} else {
								JOptionPane.showMessageDialog(null, " 'X'Ganhoouu");
							}
							zerarJogo();
						}
					}
				}
				 
			} else {
				JOptionPane.showMessageDialog(null, "Escolha uma opção !!");
			}
		}
		
		
		

	}

	@FXML
	void btn7OnAction(ActionEvent event) {
		
		if(tabelaJogo[2][0] == '1'){
			
			// opção que o usuário escolheu
			opcaoEscolhida = JogoDaVelha.getOpcaoEscolhida();
			
			if(opcaoEscolhida != '1'){
				
				if (JogoDaVelha.getOpcaoEscolhida() == 'X')
					imgBotao7.setImage(new Image(urlX.toString()));
				else if(JogoDaVelha.getOpcaoEscolhida() == 'O')
					imgBotao7.setImage(new Image(urlO.toString()));

				// salva a opção escolhida na tabela
				tabelaJogo[2][0] = JogoDaVelha.getOpcaoEscolhida();
				// verifica se o usuario ganhou o jogo

				resultado = JogoDaVelha.validarJogo();

				if (resultado == 1) {
					JOptionPane.showMessageDialog(null, opcaoEscolhida+" Ganhoouu");
					zerarJogo();
				} else {
					// gera uma jogada automaticamente
					resultado = JogoDaVelha.counterStrikeComputador();
					if(resultado == 11){
						resultado = JogoDaVelha.gerarJogadaCumputador();
					}
					
					if (resultado == 1)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao1.setImage(new Image(urlO.toString()));
						else
							imgBotao1.setImage(new Image(urlX.toString()));
					if (resultado == 2)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao2.setImage(new Image(urlO.toString()));
						else
							imgBotao2.setImage(new Image(urlX.toString()));
					if (resultado == 3)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao3.setImage(new Image(urlO.toString()));
						else
							imgBotao3.setImage(new Image(urlX.toString()));
					if (resultado == 4)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao4.setImage(new Image(urlO.toString()));
						else
							imgBotao4.setImage(new Image(urlX.toString()));
					if (resultado == 5)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao5.setImage(new Image(urlO.toString()));
						else
							imgBotao5.setImage(new Image(urlX.toString()));
					if (resultado == 6)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao6.setImage(new Image(urlO.toString()));
						else
							imgBotao6.setImage(new Image(urlX.toString()));
					if (resultado == 7)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao7.setImage(new Image(urlO.toString()));
						else
							imgBotao7.setImage(new Image(urlX.toString()));
					if (resultado == 8)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao8.setImage(new Image(urlO.toString()));
						else
							imgBotao8.setImage(new Image(urlX.toString()));
					if (resultado == 9)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao9.setImage(new Image(urlO.toString()));
						else
							imgBotao9.setImage(new Image(urlX.toString()));
					else if (resultado == 10){
						JOptionPane.showMessageDialog(null, "Empateeee");
						zerarJogo();
					}
					else {
						resultado = JogoDaVelha.validarJogo();
						if (resultado == 1) {
							if(opcaoEscolhida == 'X'){
								JOptionPane.showMessageDialog(null, " 'O' Ganhoouu");
							} else {
								JOptionPane.showMessageDialog(null, " 'X'Ganhoouu");
							}
							zerarJogo();
						}
					}
				}
				 
			} else {
				JOptionPane.showMessageDialog(null, "Escolha uma opção !!");
			}
		}
	

		

	}

	@FXML
	void btn8OnAction(ActionEvent event) {
		
		if(tabelaJogo[2][1] == '1'){
			
			// opção que o usuário escolheu
			opcaoEscolhida = JogoDaVelha.getOpcaoEscolhida();
			
			if(opcaoEscolhida != '1'){
				
				if (JogoDaVelha.getOpcaoEscolhida() == 'X')
					imgBotao8.setImage(new Image(urlX.toString()));
				else if(JogoDaVelha.getOpcaoEscolhida() == 'O')
					imgBotao8.setImage(new Image(urlO.toString()));

				// salva a opção escolhida na tabela
				tabelaJogo[2][1] = JogoDaVelha.getOpcaoEscolhida();
				// verifica se o usuario ganhou o jogo

				resultado = JogoDaVelha.validarJogo();

				if (resultado == 1) {
					JOptionPane.showMessageDialog(null, opcaoEscolhida+" Ganhoouu");
					zerarJogo();
				} else {
					// gera uma jogada automaticamente
					resultado = JogoDaVelha.counterStrikeComputador();
					if(resultado == 11){
						resultado = JogoDaVelha.gerarJogadaCumputador();
					}
					
					if (resultado == 1)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao1.setImage(new Image(urlO.toString()));
						else
							imgBotao1.setImage(new Image(urlX.toString()));
					if (resultado == 2)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao2.setImage(new Image(urlO.toString()));
						else
							imgBotao2.setImage(new Image(urlX.toString()));
					if (resultado == 3)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao3.setImage(new Image(urlO.toString()));
						else
							imgBotao3.setImage(new Image(urlX.toString()));
					if (resultado == 4)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao4.setImage(new Image(urlO.toString()));
						else
							imgBotao4.setImage(new Image(urlX.toString()));
					if (resultado == 5)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao5.setImage(new Image(urlO.toString()));
						else
							imgBotao5.setImage(new Image(urlX.toString()));
					if (resultado == 6)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao6.setImage(new Image(urlO.toString()));
						else
							imgBotao6.setImage(new Image(urlX.toString()));
					if (resultado == 7)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao7.setImage(new Image(urlO.toString()));
						else
							imgBotao7.setImage(new Image(urlX.toString()));
					if (resultado == 8)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao8.setImage(new Image(urlO.toString()));
						else
							imgBotao8.setImage(new Image(urlX.toString()));
					if (resultado == 9)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao9.setImage(new Image(urlO.toString()));
						else
							imgBotao9.setImage(new Image(urlX.toString()));
					else if (resultado == 10){
						JOptionPane.showMessageDialog(null, "Empateeee");
						zerarJogo();
					}
					else{
						resultado = JogoDaVelha.validarJogo();
						if (resultado == 1) {
							if(opcaoEscolhida == 'X'){
								JOptionPane.showMessageDialog(null, " 'O' Ganhoouu");
							} else {
								JOptionPane.showMessageDialog(null, " 'X'Ganhoouu");
							}
							zerarJogo();
						}
					}
				}
				 
			} else {
				JOptionPane.showMessageDialog(null, "Escolha uma opção !!");
			}
			
		}

		
		

	}

	@FXML
	void btn9OnAction(ActionEvent event) {
		
		if(tabelaJogo[2][2] == '1'){
			// opção que o usuário escolheu
			opcaoEscolhida = JogoDaVelha.getOpcaoEscolhida();
			
			if(opcaoEscolhida != '1'){
				
				if (JogoDaVelha.getOpcaoEscolhida() == 'X')
					imgBotao9.setImage(new Image(urlX.toString()));
				else if(JogoDaVelha.getOpcaoEscolhida() == 'O')
					imgBotao9.setImage(new Image(urlO.toString()));

				// salva a opção escolhida na tabela
				tabelaJogo[2][2] = JogoDaVelha.getOpcaoEscolhida();
				// verifica se o usuario ganhou o jogo

				resultado = JogoDaVelha.validarJogo();

				if (resultado == 1) {
					JOptionPane.showMessageDialog(null, opcaoEscolhida+" Ganhoouu");
					zerarJogo();
				} else {
					// gera uma jogada automaticamente
					resultado = JogoDaVelha.counterStrikeComputador();
					if(resultado == 11){
						resultado = JogoDaVelha.gerarJogadaCumputador();
					}
					
					if (resultado == 1)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao1.setImage(new Image(urlO.toString()));
						else
							imgBotao1.setImage(new Image(urlX.toString()));
					if (resultado == 2)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao2.setImage(new Image(urlO.toString()));
						else
							imgBotao2.setImage(new Image(urlX.toString()));
					if (resultado == 3)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao3.setImage(new Image(urlO.toString()));
						else
							imgBotao3.setImage(new Image(urlX.toString()));
					if (resultado == 4)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao4.setImage(new Image(urlO.toString()));
						else
							imgBotao4.setImage(new Image(urlX.toString()));
					if (resultado == 5)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao5.setImage(new Image(urlO.toString()));
						else
							imgBotao5.setImage(new Image(urlX.toString()));
					if (resultado == 6)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao6.setImage(new Image(urlO.toString()));
						else
							imgBotao6.setImage(new Image(urlX.toString()));
					if (resultado == 7)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao7.setImage(new Image(urlO.toString()));
						else
							imgBotao7.setImage(new Image(urlX.toString()));
					if (resultado == 8)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao8.setImage(new Image(urlO.toString()));
						else
							imgBotao8.setImage(new Image(urlX.toString()));
					if (resultado == 9)
						if (JogoDaVelha.getOpcaoEscolhida() == 'X')
							imgBotao9.setImage(new Image(urlO.toString()));
						else
							imgBotao9.setImage(new Image(urlX.toString()));
					else if (resultado == 10){
						JOptionPane.showMessageDialog(null, "Empateeee");
						zerarJogo();
					}
					else{
						resultado = JogoDaVelha.validarJogo();
						if (resultado == 1) {
							if(opcaoEscolhida == 'X'){
								JOptionPane.showMessageDialog(null, " 'O' Ganhoouu");
							} else {
								JOptionPane.showMessageDialog(null, " 'X'Ganhoouu");
							}
							zerarJogo();
						}
					}
				}
				 
			} else {
				JOptionPane.showMessageDialog(null, "Escolha uma opção !!");
			}

		}
		
		
		

	}

	@FXML
	void btnOonAction(ActionEvent event) {
		JogoDaVelha.setOpcaoEscolhida('O');
	}

	@FXML
	void btnXonAction(ActionEvent event) {
		JogoDaVelha.setOpcaoEscolhida('X');
	}

}
