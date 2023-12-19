package jogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	public Principal() {
    	
        setTitle("JoKenPô");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setResizable(false);
        setLocationRelativeTo(null);

        painel = new JPanel();
        painel.setPreferredSize(new Dimension(300, 400));
        painel.setLayout(new BorderLayout());
        
        imagemPedra = new ImageIcon(getClass().getResource("/imagens/pedra.png"));
        imagemPapel = new ImageIcon(getClass().getResource("/imagens/papel.png"));
        imagemTesoura = new ImageIcon(getClass().getResource("/imagens/tesoura.png"));
        
        
        JLabel labelNome = new JLabel("Jo Ken Pô");
        labelNome.setFont(new Font("Showcard Gothic", Font.PLAIN, 35));
        labelNome.setForeground(new Color (113, 168, 241));
        
        JPanel painelNome = new JPanel(new FlowLayout(FlowLayout.CENTER, 1, 10));
        painelNome.setPreferredSize(new Dimension(300, 60));
        painelNome.add(labelNome);
        
        
		labelMensagem = new JLabel(mensagem);
		labelMensagem.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        
        painelMensagem = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 10));
        painelMensagem.setPreferredSize(new Dimension(300, 50));
        painelMensagem.add(labelMensagem);
        
        
        JPanel inicio = new JPanel(new FlowLayout(FlowLayout.CENTER, 1, 10));
        inicio.setPreferredSize(new Dimension(300, 100));
        inicio.add(painelNome, BorderLayout.NORTH);
        inicio.add(labelMensagem, BorderLayout.SOUTH);

        painel.add(inicio, BorderLayout.NORTH);
        
        label_imgJogador = new JLabel(imagemJogador);
        label_imgJogador.setPreferredSize(new Dimension(80, 80));
     
        label_imgComputador = new JLabel(imagemComputador);
        label_imgComputador.setPreferredSize(new Dimension(80, 80));
        
        JPanel painel_imgJogador = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        painel_imgJogador.add(label_imgJogador);
        painel_imgJogador.setVisible(false);
        
        painel_imgComputador = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        painel_imgComputador.add(label_imgComputador);
        painel_imgComputador.setVisible(false);

        JPanel painelImagens = new JPanel(new GridLayout(1, 0, 0, 0));
        painelImagens.add(painel_imgJogador);
        painelImagens.add(painel_imgComputador);
        painelImagens.setVisible(true);

        painel.add(painelImagens, BorderLayout.CENTER);
        
        botaoPedra = new JButton();
        botaoPedra.setPreferredSize(new Dimension(64, 64));
        botaoPedra.setIcon(new ImageIcon(getClass().getResource("/imagens/imgpedra.png")));
        botaoPedra.setBorderPainted(false);
        botaoPedra.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				painel_imgJogador.setVisible(true);
				label_imgJogador.setIcon(imagemPedra);
				jogador = 0;
				computador = numAleatorio(0, 2);
				jogo();			
			}
        });
        
        botaoPapel = new JButton();
        botaoPapel.setPreferredSize(new Dimension(64, 64));
        botaoPapel.setIcon(new ImageIcon(getClass().getResource("/imagens/imgpapel.png")));
        botaoPapel.setBorderPainted(false);
        botaoPapel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				painel_imgJogador.setVisible(true);
				label_imgJogador.setIcon(imagemPapel);
				jogador = 1;
				computador = numAleatorio(0, 2);
				jogo();
			}
        
        });
        
        botaoTesoura = new JButton();
        botaoTesoura.setPreferredSize(new Dimension(64, 64));
        botaoTesoura.setIcon(new ImageIcon(getClass().getResource("/imagens/imgtesoura.png")));
        botaoTesoura.setBorderPainted(false);
        botaoTesoura.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				painel_imgJogador.setVisible(true);
				label_imgJogador.setIcon(imagemTesoura);
				jogador = 2;
				computador = numAleatorio(0, 2);
				jogo();
			}
        });

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        painelBotoes.add(botaoPedra);
        painelBotoes.add(botaoPapel);
        painelBotoes.add(botaoTesoura);
        painelBotoes.setBackground(new Color (113, 168,	241));
        
        label_vitJogador = new JLabel("Jogador");
        label_vitJogador.setFont(new Font("Showcard Gothic", Font.PLAIN, 14));
        label_vitJogador.setForeground(new Color (242, 242, 242));
        label_vitComputador = new JLabel("Computador");
        label_vitComputador.setFont(new Font("Showcard Gothic", Font.PLAIN, 14));
        label_vitComputador.setForeground(new Color (242, 242, 242));

        painelPlacar = new JPanel(new FlowLayout(FlowLayout.CENTER, 45, 8));
        painelPlacar.setPreferredSize(new Dimension(300, 30));
        painelPlacar.add(label_vitJogador);
        painelPlacar.add(label_vitComputador);
        painelPlacar.setBackground(new Color (113, 168, 241));
        painelPlacar.setVisible(true);
        
        JPanel base = new JPanel(new FlowLayout(FlowLayout.CENTER, 1, 10));
        base.setPreferredSize(new Dimension(300, 134));
        base.add(painelPlacar, BorderLayout.NORTH);
        base.add(painelBotoes, BorderLayout.SOUTH);
        
        painel.add(base, BorderLayout.SOUTH);
        getContentPane().add(painel);
        setVisible(true);
      
    }
    
    private void jogo(){
    	
    	switch (computador){
        case 0:
            imagemComputador = imagemPedra;
            break;
        case 1:
            imagemComputador = imagemPapel;
            break;
        case 2:
            imagemComputador = imagemTesoura;
            break;
    	}
    	
	    label_imgComputador.setIcon(imagemComputador);
	    painel_imgComputador.setVisible(true);
    	
    	
    	if (jogador == computador)
		{
    		mensagem =("EMPATE!");
    		labelMensagem.setForeground(new Color (235, 217, 35));
    		labelMensagem.setText(mensagem);

		} 
		else
		{
			if ((jogador == 0 && computador == 2) || (jogador == 1 && computador == 0)
					|| (jogador == 2 && computador == 1)){
				mensagem =("JOGADOR VENCEU!");
				vitJogador++;
				labelMensagem.setForeground(new Color (70, 222, 24));
				label_vitJogador.setText("Jogador: " + vitJogador);
				labelMensagem.setText(mensagem);

			}else{
				mensagem = ("COMPUTADOR VENCEU!");
				vitComputador++;
				labelMensagem.setForeground(new Color (255, 0, 0));
				label_vitComputador.setText("Computador: " + vitComputador);
				labelMensagem.setText(mensagem);
			}
		}
    	
		
	}

    public static void main(String[] args) {
        new Principal();
        
    }
    
    private static int numAleatorio(int min, int max) {
		java.util.Random rand = new java.util.Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
    
    private JPanel painel, painel_imgComputador, painelPlacar, painelMensagem;
    private JLabel labelMensagem, label_imgJogador, label_imgComputador, label_vitJogador, label_vitComputador;
    private ImageIcon imagemPedra, imagemPapel, imagemTesoura, imagemJogador, imagemComputador;
    private int jogador;
    private int computador;
    private String mensagem;
    private JButton botaoPedra, botaoPapel, botaoTesoura;
    private int vitJogador = 0, vitComputador = 0;
}
