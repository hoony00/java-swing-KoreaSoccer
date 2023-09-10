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

public class Uruguay extends JFrame implements ActionListener, MouseListener {
	
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

	public Uruguay() {
		setSize(500,700);
		setTitle("우루과이 국가대표");
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
	
	icon = new ImageIcon("images/urgay_1.png");// ImageIcon 생성
	JLabel lbl_urg = new JLabel(icon); // 우루과이 사진
	lbl_urg.addMouseListener(this);
	icon = imageSetSize(icon,500,300); // 사용자 정의 메소드
	lbl_urg.setIcon(icon); 
	
//	jp_fir.setBounds(0, -10,500,300);
//	jp_fir.setBackground(Color.black);
	jp_fir.add(lbl_urg);
	add(jp_fir, BorderLayout.NORTH);
}
	
		private void secpanle() {
			ImageIcon fol_icon = new ImageIcon("images/follow.png");
			fol_icon = imageSetSize(fol_icon, 80, 75);
			
			JPanel jp_sec = new JPanel();
			jp_sec.setLayout(new GridLayout(4,2));
			
			
			
			iconmana = new ImageIcon("images/urg_mana.jpg");
			iconmana = imageSetSize(iconmana,250,90); // 사용자 정의 메소드
			JLabel lbl_manager = new JLabel(iconmana);
			 btn_manager = new JButton("[디에고 알론소]",fol_icon);
			 btn_manager.addActionListener(this);
			 btn_manager.setBackground(Color.LIGHT_GRAY);
			 
			icongodin = new ImageIcon("images/godin.jpg");
			icongodin = imageSetSize(icongodin,250,90);
			JLabel lbl_mainplayer = new JLabel(icongodin);
			 btn_mainplayer = new JButton("  [디에고 고딘] ",fol_icon);
			 btn_mainplayer.addActionListener(this);
			 btn_mainplayer.setBackground(Color.LIGHT_GRAY);
			
			iconhome_urg = new ImageIcon("images/home_urg.jpg");
			iconhome_urg = imageSetSize(iconhome_urg,250,90);
			JLabel lbl_urghome = new JLabel(iconhome_urg);
			 btn_urghome = new JButton("  [에스타디오] ",fol_icon);
			 btn_urghome.setBackground(Color.LIGHT_GRAY);
			 btn_urghome.addActionListener(this);
			
			iconrank_urg = new ImageIcon("images/wolrdcup.jpg");
			iconrank_urg = imageSetSize(iconrank_urg,250,90);
			JLabel lbl_urglank = new JLabel(iconrank_urg);
			 btn_urglank = new JButton("[FIFA :  16위]",fol_icon);
			 btn_urglank.setBackground(Color.LIGHT_GRAY);
			 btn_urglank.addActionListener(this);
			
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
		new Uruguay();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn_mainplayer) {
			 if (Desktop.isDesktopSupported()) {
		            Desktop desktop = Desktop.getDesktop();
		            try {
		                URI uri = new URI("https://namu.wiki/w/%EB%94%94%EC%97%90%EA%B3%A0%20%EA%B3%A0%EB%94%98");
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
		                URI uri = new URI("https://namu.wiki/w/%EB%94%94%EC%97%90%EA%B3%A0%20%EC%95%8C%EB%A1%A0%EC%86%8C");
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
		                URI uri = new URI("https://namu.wiki/w/%EC%97%90%EC%8A%A4%ED%83%80%EB%94%94%E"
		                		+ "C%98%A4%20%EC%84%BC%ED%85%8C%EB%82%98%EB%A6%AC%EC%98%A4");
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

