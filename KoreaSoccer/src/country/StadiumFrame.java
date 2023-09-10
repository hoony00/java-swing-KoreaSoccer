package country;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import injury.InjuryPlayerFrame;
import player.FormationFrame;
import player.MainPlayerFrame;
import player.SubPlayerFrame;
import schedule.ScheduleFrame;
import orders.OrderFrame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class StadiumFrame extends JFrame implements ActionListener, MouseListener {

	private JPanel panCenter;
	private JButton btn1;
	private JPanel Infopanel;
	private JPanel Infoaddpanel;
	private JTextField numtf;
	private JTextField nametf;
	private JTextField agetf;
	private JTextField heighttf;
	private JTextField weighttf;
	private JTextField searchnametf;
	private JButton searchnamebtn;
	private JButton searchallbtn;
	private JComboBox combo;
	private JButton addbtn;
	private String inputnum;
	private String inputname;
	private String inputage;
	private String inputheight;
	private Object inputweight;
	private String inputposition;
	private String pn;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private ImageIcon[] imgsta = { new ImageIcon("images/sangaum.jpg"), new ImageIcon("images/suwon_sta.jpg"),
			new ImageIcon("images/incheon_sta.jpg"), new ImageIcon("images/gwangju_sta.jpg"),
			new ImageIcon("images/juenju_sta.jpg") };
	private JButton btn_nextsta;
	private int i;
	private JLabel sta_lbl;
	private JButton btn_Previoussta;
	private JPanel panel_3;
	private JLabel sang;
	private JLabel suwon;
	private JLabel incheon;
	private JLabel jeonju;
	private JLabel gwangju;
	private JTextArea sangadress;
	private JTextArea suwonadress;
	private JTextArea incheonadress;
	private JTextArea gwangjuadress;
	private JTextArea jeonjuadress;
	private JTextArea ta_next;
	private JTextArea ta_info;
	private String seoul_lbl;
	private String suwon_lbl;
	private String incheon_lbl;
	private String gwongju_lbl;
	private String jeonju_lbl;
	private JLabel url_Seo;
	private JButton btn7;
	private JButton btn8;

	public StadiumFrame(String title) {

		setTitle(title);
		setSize(1000, 600);
		setLocation(570, 240);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);

		Container c = getContentPane();
		c.setBackground(Color.LIGHT_GRAY);

		panCenter = new JPanel();
		panCenter.setBackground(new Color(0xEDEDED));
		panCenter.setBounds(0, 40, 1000, 600);

//맨위 버튼 ---------------------------------------------------------		
		btn1 = new JButton("후보 선수 관리");
		btn1.setBounds(10, 10, 120, 30);
		btn1.setBackground(new Color(0xCECECE));
		btn1.setBorderPainted(false); // 버튼 테두리 없애기
		btn1.addActionListener(this);

		btn2 = new JButton("선발 선수 관리");
		btn2.setBounds(140, 10, 120, 30);
		btn2.setBackground(new Color(0xCECECE));
		btn2.setBorderPainted(false); // 버튼 테두리 없애기
		btn2.addActionListener(this);

		btn3 = new JButton("포메이션");
		btn3.setBounds(270, 10, 120, 30);
		btn3.setBackground(new Color(0xCECECE));
		btn3.setBorderPainted(false); // 버튼 테두리 없애기
		btn3.addActionListener(this);

		btn4 = new JButton("부상자 관리");
		btn4.setBounds(400, 10, 120, 30);
		btn4.setBackground(new Color(0xCECECE));
		btn4.setBorderPainted(false); // 버튼 테두리 없애기
		btn4.addActionListener(this);

		btn5 = new JButton("선수 사진");
		btn5.setBounds(530, 10, 120, 30);
		btn5.setBackground(new Color(0xCECECE));
		btn5.setBorderPainted(false); // 버튼 테두리 없애기
		btn5.addActionListener(this);
		
		btn6 = new JButton("경기장");
		btn6.setBounds(660, 10, 120, 30);
		btn6.setBackground(new Color(0xEDEDED));
		btn6.setBorderPainted(false); // 버튼 테두리 없애기
		btn6.addActionListener(this);
		
		btn7 = new JButton("식단"); 
		btn7.setBounds(790, 10, 80, 30);
		btn7.setBackground(new Color(0xCECECE));
		btn7.setBorderPainted(false); // 버튼 테두리 없애기
		btn7.addActionListener(this);
		
		btn8 = new JButton("일정");
		btn8.setBounds(880, 10, 80, 30);
		btn8.setBackground(new Color(0xCECECE)); 
		btn8.setBorderPainted(false); // 버튼 테두리 없애기
		btn8.addActionListener(this);

		getContentPane().add(btn1);
		getContentPane().add(btn2);
		getContentPane().add(btn3);
		getContentPane().add(btn4);
		getContentPane().add(btn5);
		getContentPane().add(btn6);
		getContentPane().add(btn7);
		getContentPane().add(btn8);
//맨위 버튼 ---------------------------------------------------------		

		// 아래부터 메인 패널 3개 -----------------------------------------------

//		ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // 이미지 메소드 건들
//			Image ximg = icon.getImage(); // ImageIcon을 Image로 변환.
//			Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
//			ImageIcon xyimg = new ImageIcon(yimg);
//			return xyimg;
//		}

		// 아래부터 사진 패널 -----------------------------------
		JPanel panel = new JPanel(); // 사진 패널
		panel.setBounds(30, 66, 650, 300);
		panel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3)));
		c.add(panel);
		panel.setLayout(new BorderLayout());
		i = 0;
		sta_lbl = new JLabel(imgsta[i]);
		panel.add(sta_lbl);
		// 위까지 사진 패널 -----------------------------------

		// 아래부터 경기장 리스트 패널 -----------------------------------
		JPanel panel_1 = new JPanel(); // 리스트 패널
		panel_1.setLayout(null);
		panel_1.setBounds(700, 66, 230, 420);
		panel_1.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3)));

		JPanel p1_sang = new JPanel();
		p1_sang.setBounds(12, 10, 100, 70);
		p1_sang.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2)));
		p1_sang.setLayout(new BorderLayout());
		ImageIcon sta_icon = new ImageIcon("images/sta_icon.png");
		sang = new JLabel(sta_icon);
		sang.addMouseListener(this);
		p1_sang.add(sang);
		panel_1.add(p1_sang);

		JPanel p1_sang_1 = new JPanel();
		p1_sang_1.setBounds(112, 10, 100, 70);
		p1_sang_1.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2)));
		panel_1.add(p1_sang_1);
		p1_sang_1.setLayout(new BorderLayout(0, 0));

		sangadress = new JTextArea("서울 경기장\n" + "\n주소 :\n서울특별시" + " 마포구 \n월드컵로 240 ");
		Font font_adress = new Font("궁서", Font.TYPE1_FONT, 10);
		sangadress.setFont(font_adress);
		sangadress.setBackground(new Color(0xEDEDED));
		sangadress.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1)));
		sangadress.setEditable(false);
		p1_sang_1.add(sangadress, BorderLayout.CENTER);
		sangadress.addMouseListener(this);

		JPanel p1_suwon = new JPanel();
		p1_suwon.setBounds(12, 90, 100, 70);
		p1_suwon.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3)));
		p1_suwon.setLayout(new BorderLayout());
		suwon = new JLabel(sta_icon);
		suwon.addMouseListener(this);
		p1_suwon.add(suwon);

		JPanel p1_suwon_1 = new JPanel();
		p1_suwon_1.setBounds(112, 90, 100, 70);
		p1_suwon_1.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2)));
		panel_1.add(p1_suwon_1);
		p1_suwon_1.setLayout(new BorderLayout(0, 0));

		suwonadress = new JTextArea("수원 경기장\n" + "\n주소 :\n" + "경기 수원시 팔달구\n우만동 207-2 ");
		suwonadress.setFont(font_adress);
		suwonadress.setBackground(new Color(0xEDEDED));
		suwonadress.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1)));
		suwonadress.setEditable(false);
		p1_suwon_1.add(suwonadress, BorderLayout.CENTER);
		suwonadress.addMouseListener(this);

		JPanel p1_incheon = new JPanel();
		p1_incheon.setBounds(12, 170, 100, 70);
		p1_incheon.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3)));
		p1_incheon.setLayout(new BorderLayout());
		incheon = new JLabel(sta_icon);
		incheon.addMouseListener(this);
		p1_incheon.add(incheon);

		JPanel p1_incheon_1 = new JPanel();
		p1_incheon_1.setBounds(112, 170, 100, 70);
		p1_incheon_1.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2)));
		panel_1.add(p1_incheon_1);
		p1_incheon_1.setLayout(new BorderLayout(0, 0));

		incheonadress = new JTextArea("인천 경기장\n" + "\n주소 :\n인천광역시 " + "\n남구 매소홀로 618");
		incheonadress.setFont(font_adress);
		incheonadress.setBackground(new Color(0xEDEDED));
		incheonadress.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1)));
		incheonadress.setEditable(false);
		p1_incheon_1.add(incheonadress, BorderLayout.CENTER);
		incheonadress.addMouseListener(this);

		JPanel p1_gwangju = new JPanel();
		p1_gwangju.setBounds(12, 250, 100, 70);
		p1_gwangju.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3)));
		p1_gwangju.setLayout(new BorderLayout());
		gwangju = new JLabel(sta_icon);
		gwangju.addMouseListener(this);
		p1_gwangju.add(gwangju);

		JPanel p1_gwangju_1 = new JPanel();
		p1_gwangju_1.setBounds(112, 250, 100, 70);
		p1_gwangju_1.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2)));
		panel_1.add(p1_gwangju_1);
		p1_gwangju_1.setLayout(new BorderLayout(0, 0));

		gwangjuadress = new JTextArea("광주 경기장\n" + "\n주소 :\n광주광역시 " + "\n서구 금화로 240");
		gwangjuadress.setFont(font_adress);
		gwangjuadress.setBackground(new Color(0xEDEDED));
		gwangjuadress.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1)));
		gwangjuadress.setEditable(false);
		p1_gwangju_1.add(gwangjuadress, BorderLayout.CENTER);
		gwangjuadress.addMouseListener(this);

		JPanel p1_jeonju = new JPanel();
		p1_jeonju.setBounds(12, 330, 100, 70);
		p1_jeonju.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3)));
		p1_jeonju.setLayout(new BorderLayout());
		jeonju = new JLabel(sta_icon);
		jeonju.addMouseListener(this);
		p1_jeonju.add(jeonju);

		JPanel p1_jeonju_1 = new JPanel();
		p1_jeonju_1.setBounds(112, 330, 100, 70);
		p1_jeonju_1.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2)));
		panel_1.add(p1_jeonju_1);
		p1_jeonju_1.setLayout(new BorderLayout(0, 0));

		jeonjuadress = new JTextArea("전주 경기장\n" + "\n주소 :\n전북 전주시 덕진구" + "\n기린대로 1055");
		jeonjuadress.setFont(font_adress);
		jeonjuadress.setBackground(new Color(0xEDEDED));
		jeonjuadress.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1)));
		jeonjuadress.setEditable(false);
		p1_jeonju_1.add(jeonjuadress, BorderLayout.CENTER);
		jeonjuadress.addMouseListener(this);

		panel_1.add(p1_suwon);
		panel_1.add(p1_incheon);
		panel_1.add(p1_gwangju);
		panel_1.add(p1_jeonju);
		c.add(panel_1);

		// 위까지 경기장 리스트 패널 -----------------------------------
		JPanel panel_2 = new JPanel(); // 정보 패널
		panel_2.setBounds(30, 370, 650, 115);
		panel_2.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3)));
		btn_Previoussta = new JButton("이전");
		btn_Previoussta.setBounds(400, 8, 70, 23);
		btn_Previoussta.addActionListener(this);

		btn_nextsta = new JButton("다음");
		btn_nextsta.setBounds(485, 8, 70, 23);
		btn_nextsta.addActionListener(this);

		btn_Previoussta.setBackground(Color.LIGHT_GRAY);
		btn_nextsta.setBackground(Color.LIGHT_GRAY);
		panel_2.setLayout(null);
		panel_2.add(btn_Previoussta);
		panel_2.add(btn_nextsta);
		c.add(panel_2);

		Font font_name = new Font("궁서", Font.BOLD, 23);
		Font font_info = new Font("맑은고딕", Font.PLAIN, 15);

		ta_next = new JTextArea();
		ta_next.setEditable(false);
		ta_next.setFont(font_name);
		ta_next.setBounds(12, 10, 390, 25);
		ta_next.setText("        [서울 월드컵 경기장] ");
		panel_2.add(ta_next);

		ta_next.setBackground(new Color(0xEDEDED));

		ta_info = new JTextArea();
		ta_info.setEditable(false);
		ta_info.setBounds(0, 40, 650, 75);
		ta_info.setFont(font_info);
		seoul_lbl = "  [주소] : 서울특별시 마포구 월드컵로 240\n" + "  [최대 관중 인원] : 66704석\n  [완공] : 2001년 11월 10일";
		suwon_lbl = "  [주소] : 경기도 수원시 팔달구 우만동 207-2\n" + "  [최대 관중 인원] : 44,031석\n  [완공] : 2001년 05월 13일";
		incheon_lbl = "  [주소] : 인천광역시 남구 매소홀로 618\n" + "  [최대 관중 인원] : 49,084석\n  [완공] : 2002년 02월 25일";
		gwongju_lbl = "  [주소] : 광주광역시 서구 금화로 240\n" + "  [최대 관중 인원] : 44,118석\n  [완공] : 2001년 09월 00일";
		jeonju_lbl = "  [주소] : 전라북도 전주시 덕진구 기린대로 1055\n" + "  [최대 관중 인원] : 42,477석\n  [완공] : 2001년 11월 08일";

		ta_info.setText(seoul_lbl);
		url_Seo = new JLabel("사이트 바로가기");
		url_Seo.addMouseListener(this);
		url_Seo.setBounds(530, 45, 100, 20);
		ta_info.add(url_Seo);
		ta_info.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3)));
		panel_2.add(ta_info);

		ta_info.setBackground(new Color(0xEDEDED));

		// 위까지 메인 패널 3개 -----------------------------------------------
		getContentPane().add(panCenter);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == btn1) {
			new SubPlayerFrame("구단 관리 프로그램");
			dispose();
		} else if (obj == btn2) {
			new MainPlayerFrame("구단 관리 프로그램");
			dispose();
		} else if (obj == btn3) {
			new FormationFrame("구단 관리 프로그램");
			dispose();
		} else if (obj == btn4) {
			new InjuryPlayerFrame("구단 관리 프로그램");
			dispose();
		} else if (obj == btn5) {
			new PicplayerFrame("구단 관리 프로그램");
			dispose(); 
		} else if (obj == btn7) {
			new OrderFrame("구단 관리 프로그램");
			dispose();
		} else if (obj == btn8) {
			new ScheduleFrame("구단 관리 프로그램");
			dispose();
		} 
				
		else if (obj == btn_Previoussta) {
			if (i == 0) {
				JOptionPane.showMessageDialog(this, "다음 버튼을 눌러주십시오", "[알림]", JOptionPane.WARNING_MESSAGE);
			} else
				i--;
			if_method();

		} else if (obj == btn_nextsta) {
			if (i != 4) {
				i++;
				if_method();
			}

			else {
				JOptionPane.showMessageDialog(this, "이전 버튼을 눌러주십시오", "[알림]", JOptionPane.WARNING_MESSAGE);
			}

		}
	}

	private void if_method() {
		if (i == 0) {

			ta_next.setText("        [서울 상암 월드컵 경기장] ");
			ta_info.setText(seoul_lbl);
		} else if (i == 1) {
			ta_next.setText("        [수원 월드컵 경기장]  ");
			ta_info.setText(suwon_lbl);
		} else if (i == 2) {
			ta_next.setText("        [인천 문학 경기장]  ");
			ta_info.setText(incheon_lbl);
		} else if (i == 3) {
			ta_next.setText("        [광주 월드컵 경기장]  ");
			ta_info.setText(gwongju_lbl);
		} else if (i == 4) {
			ta_next.setText("        [전주 월드컵 경기장]  ");
			ta_info.setText(jeonju_lbl);
		}
		sta_lbl.setIcon(imgsta[i]);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Component component = e.getComponent();
		if (component == sangadress || component == sang) {
			i = 0;
			sta_lbl.setIcon(imgsta[0]);

			ta_next.setText("        [서울 상암 월드컵 경기장] ");
			ta_info.setText(seoul_lbl);
		} else if (component == suwonadress || component == suwon) {
			sta_lbl.setIcon(imgsta[1]);
			i = 1;
			ta_next.setText("        [수원 월드컵 경기장]  ");
			ta_info.setText(suwon_lbl);
		} else if (component == incheonadress || component == incheon) {
			sta_lbl.setIcon(imgsta[2]);
			i = 2;
			ta_next.setText("        [인천 문학 경기장]  ");
			ta_info.setText(incheon_lbl);
		} else if (component == gwangjuadress || component == gwangju) {
			i = 3;
			sta_lbl.setIcon(imgsta[3]);
			ta_next.setText("        [광주 월드컵 경기장]  ");
			ta_info.setText(gwongju_lbl);
		} else if (component == jeonjuadress || component == jeonju) {
			sta_lbl.setIcon(imgsta[4]);
			i = 4;
			ta_next.setText("        [전주 월드컵 경기장]  ");
			ta_info.setText(jeonju_lbl);
		} else if (component == url_Seo) {
			if (Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();
				try {
					if (i == 0) {
						URI uri = new URI(
								"https://namu.wiki/w/%EC%84%9C%EC%9A%B8%EC%9B%94%EB%93%9C%EC%BB%B5%EA%B2%BD%EA%B8%B0%EC%9E%A5");
						url_Seo.setForeground(Color.BLUE);
						desktop.browse(uri);
					} else if (i == 1) {
						URI uri = new URI(
								"https://namu.wiki/w/%EC%88%98%EC%9B%90%EC%9B%94%EB%93%9C%EC%BB%B5%EA%B2%BD%EA%B8%B0%EC%9E%A5");
						url_Seo.setForeground(Color.BLUE);
						desktop.browse(uri);
					} else if (i == 2) {
						URI uri = new URI(
								"https://namu.wiki/w/%EC%9D%B8%EC%B2%9C%EB%AC%B8%ED%95%99%EA%B2%BD%EA%B8%B0%EC%9E%A5");
						url_Seo.setForeground(Color.BLUE);
						desktop.browse(uri);
					} else if (i == 3) {
						URI uri = new URI(
								"https://namu.wiki/w/%EA%B4%91%EC%A3%BC%EC%9B%94%EB%93%9C%EC%BB%B5%EA%B2%BD%EA%B8%B0%EC%9E%A5");
						url_Seo.setForeground(Color.BLUE);
						desktop.browse(uri);
					} else if (i == 4) {
						URI uri = new URI(
								"https://namu.wiki/w/%EC%A0%84%EC%A3%BC%EC%9B%94%EB%93%9C%EC%BB%B5%EA%B2%BD%EA%B8%B0%EC%9E%A5");
						url_Seo.setForeground(Color.BLUE);
						desktop.browse(uri);
					}

				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (URISyntaxException ex) {
					ex.printStackTrace();
				}
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
