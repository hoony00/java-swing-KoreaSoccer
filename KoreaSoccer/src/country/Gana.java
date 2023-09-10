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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Gana extends JFrame implements ActionListener, MouseListener {

	private ImageIcon icon;
	private Container c;
	private ImageIcon imgTest;
	private ImageIcon iconmana;
	private ImageIcon iconrank_urg;
	private JButton btn_manager;
	private JButton btn_mainplayer;
	private JButton btn_urghome;
	private JButton btn_urglank;
	private JButton b1;
	private ImageIcon iconiu;
	private ImageIcon icongana_mana;
	private ImageIcon iconhome_gana;

	public Gana() {
		setSize(500, 700);
		setTitle("가나 국가대표");
		setLocation(600, 100);
		setLayout(new BorderLayout());
		firstpanle();
		secpanle();
		setVisible(true);
	}

	ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // image Size Setting
		Image ximg = icon.getImage(); // ImageIcon을 Image로 변환.
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}

	private void firstpanle() {
		JPanel jp_fir = new JPanel();

		icon = new ImageIcon("images/gana.png");// ImageIcon 생성
		JLabel lbl_urg = new JLabel(icon);
		lbl_urg.addMouseListener(this);
		icon = imageSetSize(icon, 500, 300); // 사용자 정의 메소드
		lbl_urg.setIcon(icon);

		jp_fir.add(lbl_urg);
		add(jp_fir, BorderLayout.NORTH);
	}

	private void secpanle() {
		JPanel jp_sec = new JPanel();
		jp_sec.setLayout(new GridLayout(4, 2));

		Image image;

		icongana_mana = new ImageIcon("images/gana_mana.jpg");
		icongana_mana = imageSetSize(icongana_mana, 250, 90); // 사용자 정의 메소드
		JLabel lbl_manager = new JLabel(icongana_mana);
	
		 

		ImageIcon fol_icon = new ImageIcon("images/follow.png");
		fol_icon = imageSetSize(fol_icon, 80, 75); // 사용자 정의 메소드
		b1 = new JButton("  [오토 아도]       ", fol_icon);
		b1.addActionListener(this);   //오토 아도 버튼
		b1.setBackground(Color.LIGHT_GRAY);

		jp_sec.add(lbl_manager);
		jp_sec.add(b1);

		iconiu = new ImageIcon("images/gana_main.jpg");
		iconiu = imageSetSize(iconiu, 250, 90);

		JLabel lbl_mainplayer = new JLabel(iconiu);
		btn_mainplayer = new JButton("  [안드레 아이유]", fol_icon);
		btn_mainplayer.addActionListener(this);
		btn_mainplayer.setBackground(Color.LIGHT_GRAY);

		jp_sec.add(lbl_mainplayer);
		jp_sec.add(btn_mainplayer);

		iconhome_gana = new ImageIcon("images/gana_home.jpg");
		iconhome_gana = imageSetSize(iconhome_gana, 270, 90);
		JLabel lbl_urghome = new JLabel(iconhome_gana);
		btn_urghome = new JButton("[Unknown]");
		btn_urghome.addActionListener(this);
		btn_urghome.setBackground(Color.LIGHT_GRAY);

		iconrank_urg = new ImageIcon("images/wolrdcup.jpg");
		iconrank_urg = imageSetSize(iconrank_urg, 250, 90);
		JLabel lbl_urglank = new JLabel(iconrank_urg);
		btn_urglank = new JButton(" [FIFA :  61위] ", fol_icon);
		btn_urglank.addActionListener(this);
		btn_urglank.setBackground(Color.LIGHT_GRAY);

		jp_sec.add(lbl_urghome);
		jp_sec.add(btn_urghome);
		jp_sec.add(lbl_urglank);
		jp_sec.add(btn_urglank);
		add(jp_sec, BorderLayout.CENTER);

	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btn_mainplayer) {
			if (Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();
				try {
					URI uri = new URI(
							"https://namu.wiki/w/%EC%95%88%EB%93%9C%" + "EB%A0%88%20%EC%95%84%EC%9D%B4%EC%9C%A0");
					desktop.browse(uri);
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (URISyntaxException ex) {
					ex.printStackTrace();
				}
			}
		} else if (obj == b1) {
			if (Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();
				try {
					URI uri = new URI("https://namu.wiki/w/%EC%98%A4%ED%86%A0%20%EC%95%84%EB%8F%84");
					desktop.browse(uri);
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (URISyntaxException ex) {
					ex.printStackTrace();
				}
			}
		} else if (obj == btn_urghome) {
			JOptionPane.showMessageDialog(this, "알려진 정보가 없습니다", "Unknown", JOptionPane.WARNING_MESSAGE);
		} else if (obj == btn_urglank) {
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
