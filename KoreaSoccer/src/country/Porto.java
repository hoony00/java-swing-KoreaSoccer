package country;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Porto extends JFrame implements ActionListener, MouseListener {
	
	private ImageIcon icon;
	private Container c;
	private ImageIcon imgTest;
	private ImageIcon iconmana;
	private ImageIcon icongodin;
	private ImageIcon iconhome_urg;
	private ImageIcon iconrank_urg;
	private JButton btn_manager;
	private JButton btn_mainplayer;
	private JButton btn_urghome;
	private JButton btn_urglank;

	public Porto() {
		setSize(500,700);
		setTitle("포루투갈 국가대표");
		setLocation(600, 100);
		setLayout(new BorderLayout());
		
		firstpanle();
		secpanle();
		
		setVisible(true);
	}
	
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // image Size Setting
		Image ximg = icon.getImage();  //ImageIcon을 Image로 변환.
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg); 
		return xyimg;
	

	
}
private void firstpanle() {
	JPanel jp_fir = new JPanel();
	
	icon = new ImageIcon("images/porto.png");// ImageIcon 생성
	JLabel lbl_urg = new JLabel(icon); // 우루과이 사진
	lbl_urg.addMouseListener(this);
	icon = imageSetSize(icon,500,300); // 사용자 정의 메소드
	lbl_urg.setIcon(icon); 
	
	jp_fir.add(lbl_urg);
	add(jp_fir, BorderLayout.NORTH);
}
	
		private void secpanle() {
			JPanel jp_sec = new JPanel();
			jp_sec.setLayout(new GridLayout(4,2));
			
			ImageIcon fol_icon = new ImageIcon("images/follow.png");
			fol_icon = imageSetSize(fol_icon, 80, 75);
			
			ImageIcon icon_porto_mana = new ImageIcon("images/porto_mana.jpg");
			icon_porto_mana = imageSetSize(icon_porto_mana,250,90); // 사용자 정의 메소드
			JLabel lbl_manager = new JLabel(icon_porto_mana);
			 btn_manager = new JButton("  [페르난두 산투스]      ",fol_icon);
			 btn_manager.addActionListener(this);
			 btn_manager.setBackground(Color.LIGHT_GRAY);
			
			 ImageIcon iconhonaldo = new ImageIcon("images/portomain.jpg");
			iconhonaldo = imageSetSize(iconhonaldo,250,90);
			JLabel lbl_mainplayer = new JLabel(iconhonaldo);
			 btn_mainplayer = new JButton("[크리스티아누 호날두]",fol_icon);
			 btn_mainplayer.addActionListener(this);
			 btn_mainplayer.setBackground(Color.LIGHT_GRAY);
			
			 ImageIcon iconhome_por = new ImageIcon("images/porto_stad.jpg");
			 iconhome_por = imageSetSize(iconhome_por,250,90);
			JLabel lbl_urghome = new JLabel(iconhome_por);
			 btn_urghome = new JButton(" [이스타디우 다 루스] ",fol_icon);
			 btn_urghome.addActionListener(this);
			 btn_urghome.setBackground(Color.LIGHT_GRAY);
			
			iconrank_urg = new ImageIcon("images/wolrdcup.jpg");
			iconrank_urg = imageSetSize(iconrank_urg,250,90);
			JLabel lbl_urglank = new JLabel(iconrank_urg);
			 btn_urglank = new JButton("   [피파랭킹 :  8위]    ",fol_icon);
			 btn_urglank.addActionListener(this);
			 btn_urglank.setBackground(Color.LIGHT_GRAY);
			
			jp_sec.add(lbl_manager);
			jp_sec.add(btn_manager);
			
			jp_sec.add(lbl_mainplayer);
			jp_sec.add(btn_mainplayer);
			
			jp_sec.add(lbl_urghome);
			jp_sec.add(btn_urghome);
			
			jp_sec.add(lbl_urglank);
			jp_sec.add(btn_urglank);
			
//			jp_sec.setBounds(0, -10, 500, 600);
//			jp_sec.setBackground(Color.GRAY);
			add(jp_sec,BorderLayout.CENTER);
			
			
		
	}

	
	
	public static void main(String[] args) {
		new Porto();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn_mainplayer) {
			 if (Desktop.isDesktopSupported()) {
		            Desktop desktop = Desktop.getDesktop();
		            try {
		                URI uri = new URI("https://namu.wiki/w/%ED%81%AC%EB%A6%AC%EC%8A%A4%ED%8B%B0%E"
		                		+ "C%95%84%EB%88%84%20%ED%98%B8%EB%82%A0%EB%91%90");
		                desktop.browse(uri);
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            } catch (URISyntaxException ex) {
		                ex.printStackTrace();
		            }
		    }
		}else if(obj == btn_manager) {
			 if (Desktop.isDesktopSupported()) {
		            Desktop desktop = Desktop.getDesktop();
		            try {
		                URI uri = new URI("https://namu.wiki/w/%ED%8E%98%EB%A5%B4%EB"
		                		+ "%82%9C%EB%91%90%20%EC%82%B0%ED%88%AC%EC%8A%A4");
		                desktop.browse(uri);
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            } catch (URISyntaxException ex) {
		                ex.printStackTrace();
		            }
		    }
		}else if(obj==btn_urghome) {
			 if (Desktop.isDesktopSupported()) {
		            Desktop desktop = Desktop.getDesktop();
		            try {
		                URI uri = new URI("https://namu.wiki/w/%EC%9D%B4%EC%8A%A4%ED%83%80"
		                		+ "%EB%94%94%EC%9A%B0%20%EB%8B%A4%20%EB%A3%A8%EC%8A%A4");
		                desktop.browse(uri);
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            } catch (URISyntaxException ex) {
		                ex.printStackTrace();
		            }
		    }
		}else if(obj == btn_urglank) {
			 if (Desktop.isDesktopSupported()) {
		            Desktop desktop = Desktop.getDesktop();
		            try {
		                URI uri = new URI("https://www.fifa.com/fifa-world-ranking4");
		                desktop.browse(uri);
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            } catch (URISyntaxException ex) {
		                ex.printStackTrace();
		            }
		    }
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		 if (Desktop.isDesktopSupported()) {
	            Desktop desktop = Desktop.getDesktop();
	            try {
	                URI uri = new URI("https://namu.wiki/w/%EC%9A%B0%EB%A3%A8%EA%B3"
	                		+ "%BC%EC%9D%B4%20%EC%B6%95%EA%B5%AC%20%EA%B5%AD%EA%B0%8"
	                		+ "0%EB%8C%80%ED%91%9C%ED%8C%80/FIFA%20%EC%9B%94%EB%93%9C%EC%BB%B5");
	                desktop.browse(uri);
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            } catch (URISyntaxException ex) {
	                ex.printStackTrace();
	            }
	    }
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	}

