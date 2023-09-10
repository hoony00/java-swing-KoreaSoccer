package country;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DB.DB;
import injury.InjuryPlayerFrame;
import player.FormationFrame;
import player.MainPlayerFrame;
import player.SubPlayerFrame;
import schedule.ScheduleFrame;
import orders.OrderFrame;

public class PicplayerFrame extends JFrame implements MouseListener, ListSelectionListener, ActionListener {
   private Container c;
   private JPanel panel_background, panel, panel_1, panel_2, panel_3, panel_btn;
   private Vector<String> vecCombo;
   private Component combo;
   private DefaultListModel model_names;
   private JToolBar toolBar;
   private JTextField tf_toobar;
   private JLabel main_lbl;
   private ImageIcon back_ima, kfa_ima, sonima, qarta_ima, kimseungima, gaesungima, heechanima, uijoima, younggwonima,
         jinsuima, taehwonima, minjaeima, woyeongima, changhoonima, songbumgeunima, johyunwooima, songmingyuima,
         goseungbum, joyoungwookima, namtaehee, leejaecima, gwongyungwonima, parkjisooima, uenjonggyuima, bento,
         info_back;
   private JButton change_all_btn, change_pw_btn, change_cap_btn, change_df_btn, change_gk_btn, change_mf_btn,
         btn_manager;
   private JComboBox<String> combo1;
   private JScrollPane sp;
   private JList list;
   private JTextArea ta_p2;
   private int[] playerNumber = new int[50];
   private int[] player_age = new int[50];
   private int[] player_height = new int[50];
   private int[] player_weight = new int[50];
   private String[] player_name = new String[50];
   private String[] player_position = new String[50];
   private String sql_1, sql_2;
   private ResultSet rs, rs1;
   private int playerNumber_1, player_age_1, player_height_1, player_weight_1;
   private String player_name_1, player_position_1;
   private Object temp;
   private Object name;
   private JButton btn1, btn2, btn3, btn4, btn5;
   private ImageIcon siluat;
   private JButton btn6;
   private JButton btn7;
   private JButton btn8;
   private String name_subst;
private JButton addbtn;

   public PicplayerFrame(String title) {
      setSize(1000, 600);
      setLocation(570, 240);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      setLayout(null);
      c = getContentPane();
      c.setBackground(Color.LIGHT_GRAY);

      plyerlist();

      setVisible(true);

   }

   ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // 이미지 메소드 
      Image ximg = icon.getImage(); // ImageIcon을 Image로 변환.
      Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
      ImageIcon xyimg = new ImageIcon(yimg);
      return xyimg;

   }

   private void plyerlist() {

      // 맨위 버튼 ---------------------------------------------------------
      btn1 = new JButton("후보 선수 관리");
      btn1.setBounds(10, 10, 120, 30);
      btn1.setBackground(new Color(0xCECECE));
      btn1.addActionListener(this);
      btn1.setBorderPainted(false); 

      btn2 = new JButton("선발 선수 관리");
      btn2.setBounds(140, 10, 120, 30);
      btn2.setBackground(new Color(0xCECECE));
      btn2.setBorderPainted(false);
      btn2.addActionListener(this);

      btn3 = new JButton("포메이션");
      btn3.setBounds(270, 10, 120, 30);
      btn3.setBackground(new Color(0xCECECE));
      btn3.setBorderPainted(false); 
      btn3.addActionListener(this);

      btn4 = new JButton("부상자 관리");
      btn4.setBounds(400, 10, 120, 30);
      btn4.setBackground(new Color(0xCECECE));
      btn4.setBorderPainted(false); 
      btn4.addActionListener(this);

      btn5 = new JButton("선수 사진");
      btn5.setBounds(530, 10, 120, 30);
      btn5.setBackground(new Color(0xEDEDED));
      btn5.setBorderPainted(false);
      btn5.addActionListener(this);

      btn6 = new JButton("경기장");
      btn6.setBounds(660, 10, 120, 30);
      btn6.setBackground(new Color(0xCECECE));
      btn6.setBorderPainted(false); 
      btn6.addActionListener(this);

      btn7 = new JButton("식단");
      btn7.setBounds(790, 10, 80, 30);
      btn7.setBackground(new Color(0xCECECE));
      btn7.setBorderPainted(false); 
      btn7.addActionListener(this);

      btn8 = new JButton("일정");
      btn8.setBounds(880, 10, 80, 30);
      btn8.setBackground(new Color(0xCECECE));
      btn8.setBorderPainted(false); 
      btn8.addActionListener(this);

      add(btn1);
      add(btn2);
      add(btn3);
      add(btn4);
      add(btn5);
      add(btn6);
      add(btn7);
      add(btn8);
      // 맨위 버튼 ---------------------------------------------------------

      // -------------------- 툴바 --------------------------------------//
      toolBar = new JToolBar("내 툴바");
      toolBar.add(new JLabel(" 선수 검색 : "));
      tf_toobar = new JTextField();
      tf_toobar.addActionListener(this);
      toolBar.add(tf_toobar);
      toolBar.add(new JLabel("  검색 기록 보기 "));

      vecCombo = new Vector<String>();
      vecCombo.add("검색 기록을 보여줍니다.");
      vecCombo.add("기성용");
      vecCombo.add("박지성");

      combo1 = new JComboBox<String>(vecCombo);
      combo1.addMouseListener(this);
      combo = new JComboBox<>(vecCombo);
      combo.addMouseListener(this);
      toolBar.add(combo1);
      toolBar.setBounds(20, 50, 925, 30);
//      -9, 16, 1010, 609

      add(toolBar);

      // ------------------- 메인 배경 패널 -------------------------------//
      panel_background = new JPanel(); // 배경
      panel_background.setBounds(-9, 40, 1010, 609);
      panel_background.setLayout(null);

      panel_background.setBackground(new Color(0xEDEDED));
      back_ima = new ImageIcon("images/background.jpg");
      JLabel back_lbl = new JLabel(back_ima); //
      back_ima = imageSetSize(back_ima, 800, 500); // 사용자 정의 메소드
      back_lbl.setIcon(back_ima);
      back_lbl.setBounds(0, 0, 800, 500);

      // ------------------- 우측 버튼 패널 -------------------------------//
      panel_btn = new JPanel();
      panel_btn.setBounds(850, 50, 100, 430);
      panel_btn.setLayout(new GridLayout(0, 1, 10, 10));
      panel_btn.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3), "Filtering"));

      ImageIcon ima_all = new ImageIcon("images/ALL.jpg");
      ima_all = imageSetSize(ima_all, 100, 60);

      ImageIcon ima_cap = new ImageIcon("images/captinjpg.jpg");
      ima_cap = imageSetSize(ima_cap, 100, 60);

      ImageIcon ima_pw = new ImageIcon("images/PO.jpg");
      ima_pw = imageSetSize(ima_pw, 100, 60);
      ImageIcon ima_mf = new ImageIcon("images/MF.jpg");
      ima_mf = imageSetSize(ima_mf, 100, 140);
      ImageIcon ima_dp = new ImageIcon("images/DP.jpg");
      ima_dp = imageSetSize(ima_dp, 100, 140);
      ImageIcon ima_gk = new ImageIcon("images/GK.jpg");
      ima_gk = imageSetSize(ima_gk, 100, 70);

      change_pw_btn = new JButton(ima_pw);
      change_pw_btn.addActionListener(this);
      change_mf_btn = new JButton(ima_mf);
      change_mf_btn.addActionListener(this);
      change_df_btn = new JButton(ima_dp);
      change_df_btn.addActionListener(this);
      change_gk_btn = new JButton(ima_gk);
      change_gk_btn.addActionListener(this);
      change_all_btn = new JButton(ima_all);
      change_all_btn.addActionListener(this);
      change_cap_btn = new JButton(ima_cap);
      change_cap_btn.addActionListener(this);

      panel_btn.add(change_all_btn);
      panel_btn.add(change_cap_btn);
      panel_btn.add(change_pw_btn);
      panel_btn.add(change_mf_btn);
      panel_btn.add(change_df_btn);
      panel_btn.add(change_gk_btn);

      panel_background.add(panel_btn);
      // --------------------------선수 사진 ----------------------------//

      panel = new JPanel();
//      panel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,10)));
      panel.setBounds(200, 55, 505, 290);
      qarta_ima = new ImageIcon("images/2022_qatar.jpg");
      main_lbl = new JLabel(qarta_ima); //
      qarta_ima = imageSetSize(qarta_ima, 500, 280); // 500, 287
      main_lbl.setIcon(qarta_ima);
      panel.add(main_lbl);
      panel_background.add(panel);

      // ------------------- 우측 선수 리스트 -------------------------------//
      Image P1_back = new ImageIcon("images/2_uenjonggyu.png").getImage(); // 이미지 선언
      panel_1 = new JPanel();

        

      panel_1.setBounds(730, 50, 105, 430);
      panel_1.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2)));
      panel_background.add(panel_1);
      panel_1.setLayout(new GridLayout(1, 1));
      panel_1_mainmethod(); // 선수추가 메소드

      // ------------------- 하단 선수 정보 -------------------------------//
      panel_2 = new JPanel(); // 선수 정보
      panel_2.setBounds(205, 350, 495, 130);
      panel_2.setLayout(new BorderLayout());
      panel_2.setBackground(new Color(0xEDEDED));
      Image info_back = new ImageIcon("images/lasttae.png").getImage(); 
      ta_p2 = new JTextArea();
      Font font1 = new Font("serif", Font.BOLD, 15);
      ta_p2.setFont(font1);
      ta_p2.setBackground(new Color(0xEDEDED));
      ta_p2.setEditable(false);
      ta_p2.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 5), "Info"));
      ta_p2.setText("선수 검색 or 클릭 하십시오");

      panel_2.add(ta_p2);
      
  	addbtn = new JButton("이미지 불러오기");
	addbtn.addActionListener(this);
	addbtn.setBounds(520, 520, 150, 30);
	addbtn.setVisible(false);
	addbtn.setBackground(Color.LIGHT_GRAY);
	c.add(addbtn);
	panel_2.add(ta_p2);

      // ------------------- 좌측 국대 마크, 감독 -------------------------------//

      panel_3 = new JPanel(); // 국대 마크
      panel_3.setBounds(30, 190, 150, 290);
      panel_3.setLayout(new BorderLayout());
      panel_3.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 5)));

      kfa_ima = new ImageIcon("images/horanglee.png");// ImageIcon 생성
      JLabel kfa_lbl = new JLabel(kfa_ima); //
      kfa_ima = imageSetSize(kfa_ima, 150, 290); // 사용자 정의 메소드
      kfa_lbl.setIcon(kfa_ima);
      panel_3.add(kfa_lbl);

      ImageIcon ima_ma = new ImageIcon("images/CO.jpg");
      ima_ma = imageSetSize(ima_ma, 140, 340);
      btn_manager = new JButton(ima_ma);
      btn_manager.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3)));
      btn_manager.setBounds(30, 55, 150, 130);
      btn_manager.addActionListener(this);
      btn_manager.setLayout(new BorderLayout());

      panel_background.add(btn_manager);

      // ------------------- 패널 추가 순서 ----------------------//
      panel_background.add(panel_2);
      panel_background.add(panel_3);
      c.add(panel_background);
//      panel_background.add(back_lbl);

   }

   // -----------------------선수 리스트 메소드 ----------------------------------//
   private void panel_1_mainmethod() {
      panel_1.setLayout(new GridLayout(0, 1));
      model_names = new DefaultListModel<>();
      DB.init();
      sql_1 = "select * from MAINPLAYER";
      sql_2 = "select * from SUBPLAYER";

      rs = DB.getResult(sql_1); // 선발 선수
      rs1 = DB.getResult(sql_2); // 후보 선수

      int i = 0;
      try {
         model_names.addElement(" [  선발 선수  ] ");
         model_names.addElement("----------------------");

         while (rs.next()) // 정보작업
         {
            playerNumber[i] = rs.getInt("PN");
            player_name[i] = rs.getString("NAME");
            player_age[i] = rs.getInt("AGE");
            player_height[i] = rs.getInt("HEIGHT");
            player_weight[i] = rs.getInt("WEIGHT");
            player_position[i] = rs.getString("POSITION");

            model_names.addElement("No." + Integer.toString(rs.getInt("PN")) + " " + rs.getString("NAME"));
            model_names.addElement("----------------------");

            i++;
         }

         model_names.addElement(" [  후보 선수  ] ");
         model_names.addElement("----------------------");
         while (rs1.next()) {

            playerNumber[i] = rs1.getInt("PN");
            player_name[i] = rs1.getString("NAME");
            player_age[i] = rs1.getInt("AGE");
            player_height[i] = rs1.getInt("HEIGHT");
            player_weight[i] = rs1.getInt("WEIGHT");
            player_position[i] = rs1.getString("POSITION");

            model_names.addElement("No." + Integer.toString(rs1.getInt("PN")) + " " + rs1.getString("NAME"));
            model_names.addElement("----------------------");
            i++;
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }
      try {
         rs.close();
         rs1.close();
      } catch (SQLException e1) {
         // TODO Auto-generated catch block
         e1.printStackTrace();
      }

      list = new JList<>(model_names);
      list.addListSelectionListener(this);
      list.addMouseListener(this);
      sp = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      sp.getViewport().setBackground(Color.BLACK);
      panel_1.add(sp);
   }

   @Override
   public void actionPerformed(ActionEvent e) { // ----------메소드 -----------------//
      Object obj = e.getSource();
      main_lbl.setIcon(qarta_ima);
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
      } else if (obj == btn6) {
         new StadiumFrame("구단 관리 프로그램");
         dispose();
      } else if (obj == btn7) {
         new OrderFrame("구단 관리 프로그램");
         dispose();
      } else if (obj == btn8) {
         new ScheduleFrame("구단 관리 프로그램");
         dispose();
      } else if (obj == change_gk_btn) {
         ta_p2.setText("선수 검색 or 클릭 하십시오");
         ResultSet rs = DB.getResult(sql_1);
         ResultSet rs1 = DB.getResult(sql_2);
         model_names.removeAllElements();
         try {
            model_names.addElement("== GK 선발 ==");
            model_names.addElement("----------------------");
            while (rs.next()) {
               temp = rs.getString("POSITION");
               if (temp.equals("GK")) {
                  model_names.addElement("No." + Integer.toString(rs.getInt("PN")) + " " + rs.getString("NAME"));
                  model_names.addElement("----------------------");
               }
            }
            model_names.addElement("== GK 후보 ==");
            model_names.addElement("----------------------");
            while (rs1.next()) {
               temp = rs1.getString("POSITION");
               if (temp.equals("GK")) {
                  model_names
                        .addElement("No." + Integer.toString(rs1.getInt("PN")) + " " + rs1.getString("NAME"));
                  model_names.addElement("----------------------");
               }
            }

         } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         try {
            rs.close();
            rs1.close();
         } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         panel_1.add(sp);

      } else if (obj == change_all_btn) {
         ta_p2.setText("선수 검색 or 클릭 하십시오");
         ResultSet rs = DB.getResult(sql_1);
         ResultSet rs1 = DB.getResult(sql_2);
         model_names.removeAllElements();
         try {
            model_names.addElement(" [  선발 선수  ] ");
            model_names.addElement("----------------------");
            while (rs.next()) {
               model_names.addElement("No." + Integer.toString(rs.getInt("PN")) + " " + rs.getString("NAME"));
               model_names.addElement("----------------------");
            }
            model_names.addElement(" [  후보 선수  ] ");
            model_names.addElement("----------------------");
            while (rs1.next()) {
               model_names.addElement("No." + Integer.toString(rs1.getInt("PN")) + " " + rs1.getString("NAME"));
               model_names.addElement("----------------------");
            }
         } catch (SQLException e1) {
            e1.printStackTrace();
         }
         try {
            rs.close();
            rs1.close();
         } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }

         panel_1.add(sp);
      } else if (obj == change_df_btn) {
         ta_p2.setText("선수 검색 or 클릭 하십시오");

         ResultSet rs = DB.getResult(sql_1);
         ResultSet rs1 = DB.getResult(sql_2);
         model_names.removeAllElements();
         try {
            model_names.addElement("== DF 선발 ==");
            model_names.addElement("----------------------");
            while (rs.next()) {
               temp = rs.getString("POSITION");
               if (temp.equals("DF")) {
                  model_names.addElement("No." + Integer.toString(rs.getInt("PN")) + " " + rs.getString("NAME"));
                  model_names.addElement("----------------------");
               }
            }
            model_names.addElement("== DF 후보 ==");
            model_names.addElement("----------------------");
            while (rs1.next()) {
               temp = rs1.getString("POSITION");
               if (temp.equals("DF")) {
                  model_names
                        .addElement("No." + Integer.toString(rs1.getInt("PN")) + " " + rs1.getString("NAME"));
                  model_names.addElement("----------------------");
               }
            }

         } catch (SQLException e1) {
            // TODO Auto-generated catch block
            System.out.println("파라미터 초과 다시 실행하십시오");
            e1.printStackTrace();
         }
         try {
            rs.close();
            rs1.close();
         } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         panel_1.add(sp);

      } else if (obj == change_mf_btn) {
         ta_p2.setText("선수 검색 or 클릭 하십시오");
         ResultSet rs = DB.getResult(sql_1);
         ResultSet rs1 = DB.getResult(sql_2);
         model_names.removeAllElements();
         try {
            model_names.addElement("== MF 선발 ==");
            model_names.addElement("----------------------");
            while (rs.next()) {
               temp = rs.getString("POSITION");
               if (temp.equals("MF")) {
                  model_names.addElement("No." + Integer.toString(rs.getInt("PN")) + " " + rs.getString("NAME"));
                  model_names.addElement("----------------------");
               }
            }
            model_names.addElement("== MF 후보 =");
            model_names.addElement("----------------------");
            while (rs1.next()) {
               temp = rs1.getString("POSITION");
               if (temp.equals("MF")) {
                  model_names
                        .addElement("No." + Integer.toString(rs1.getInt("PN")) + " " + rs1.getString("NAME"));
                  model_names.addElement("----------------------");
               }
            }

         } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         try {
            rs.close();
            rs1.close();
         } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         panel_1.add(sp);
      } else if (obj == change_pw_btn) {
         ta_p2.setText("선수 검색 or 클릭 하십시오");
         ResultSet rs = DB.getResult(sql_1);
         ResultSet rs1 = DB.getResult(sql_2);
         model_names.removeAllElements();
         try {
            model_names.addElement("== FW 선발 ==");
            model_names.addElement("----------------------");
            while (rs.next()) {
               temp = rs.getString("POSITION");
               if (temp.equals("FW")) {
                  model_names.addElement("No." + Integer.toString(rs.getInt("PN")) + " " + rs.getString("NAME"));
                  model_names.addElement("----------------------");
               }
            }
            model_names.addElement("== FW 후보 ==");
            model_names.addElement("----------------------");
            while (rs1.next()) {
               temp = rs1.getString("POSITION");
               if (temp.equals("FW")) {
                  model_names
                        .addElement("No." + Integer.toString(rs1.getInt("PN")) + " " + rs1.getString("NAME"));
                  model_names.addElement("----------------------");

               }
            }

         } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         try {
            rs.close();
            rs1.close();
         } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         panel_1.add(sp);
      } else if (obj == change_cap_btn) { // 우측 주장 버튼
         model_names.removeAllElements();
         model_names.addElement("  ----- 주장 -----");
         model_names.addElement("No.7 손흥민");
         model_names.addElement("----------------------");
         String captinson = "손흥민";
         ResultSet rs_son = DB.getResult("select * from MAINPLAYER where name = '" + captinson + "' ");
         try {
            while (rs_son.next()) {
               String son_name = rs_son.getString("NAME");
               int son_number = rs_son.getInt("PN");
               int son_Age = rs_son.getInt("AGE");
               int son_height = rs_son.getInt("HEIGHT");
               int son_weight = rs_son.getInt("WEIGHT");
               String son_position = rs_son.getString("POSITION");
               ta_p2.setText(" \n  [이름] :" + son_name + "\t\t[등번호] : " + son_number + " \n  [나이] :" + son_Age
                     + "\t\t\t[키] : " + son_height + " \n  [몸무게] :" + son_weight + "\t\t\t[포지션] : "
                     + son_position);
            }
         } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         try {
            rs.close();
            rs1.close();
         } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }

         sonima = new ImageIcon("images/7_son_min.png");
         sonima = imageSetSize(sonima, 500, 287);
         main_lbl.setIcon(sonima);

      } else if (obj == btn_manager) { // 좌측 상단 감독 패널
         bento = new ImageIcon("images/bento.png");
         bento = imageSetSize(bento, 500, 287);
         ta_p2.setText(" \n  [이름] :" + "파울루 벤투" + "\t                       [국적] : " + "포르투갈" + " \n  [나이] :" + "52세"
               + "\t\t             [전 소속팀] : " + "포르투갈" + " \n  [키] :" + "174" + "\t\t                  [포지션] : "
               + "DF, MF");
         main_lbl.setIcon(bento);
      }
      if (obj == tf_toobar) { // ----------툴바 검색 기능-------------------//
         vecCombo.add(tf_toobar.getText());
         String get_toolbar_text = tf_toobar.getText();
         ResultSet rs = DB.getResult(sql_1);
         ResultSet rs1 = DB.getResult(sql_2);

         try {
            while (rs.next()) {
               temp = rs.getString("NAME");
               ResultSet rs_name = DB.getResult("select * from MAINPLAYER where name = '" + temp + "' ");
               if (temp.equals(get_toolbar_text)) {
                  while (rs_name.next()) {
                     rs_next(rs_name); // DB값 저장
                  }
                  SetText_info();// DB에서 불러온 값 출력
                  rs_name.close();
               }
            }
            while (rs1.next()) {
               temp = rs1.getString("NAME");
               ResultSet rs_namesub = DB.getResult("select * from SUBPLAYER where name = '" + temp + "' ");
               if (temp.equals(get_toolbar_text)) {
                  while (rs_namesub.next()) {
                     rs_next(rs_namesub);
                  }
                  SetText_info();
               }
               rs_namesub.close();
            }
         } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         try {
            rs.close();
            rs1.close();
         } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         toobar_equals(); // 툴바 문자열 비교 사진 출력
         
      }else if (obj == addbtn) { // 파일에서 이미지 불러서 출력하기
			selectFile();
			ImageIcon fima = new ImageIcon(selectFile());
			main_lbl.setIcon(fima);
		}
      
      

      tf_toobar.setText("");
   }
   
   public String selectFile() {    // 파일에서 이미지 불러오는 메소드
		FileDialog fd = new FileDialog(this, "file select", FileDialog.LOAD);
		fd.setVisible(true);
		StringBuilder sb = new StringBuilder();
		sb.append(fd.getDirectory());
		sb.append(fd.getFile());
		return sb.toString();
	}

   private void SetText_info() {
      ta_p2.setText(" \n  [이름] :" + player_name_1 + "\t\t[등번호] : " + playerNumber_1 + " \n  [나이] :" + player_age_1
            + "\t\t\t[키] : " + player_height_1 + " \n  [몸무게] :" + player_weight_1 + "\t\t\t[포지션] : "
            + player_position_1);
   }

   private void rs_next(ResultSet rs_name) throws SQLException {
      playerNumber_1 = rs_name.getInt("PN");
      player_name_1 = rs_name.getString("NAME");
      player_age_1 = rs_name.getInt("AGE");
      player_height_1 = rs_name.getInt("HEIGHT");
      player_weight_1 = rs_name.getInt("WEIGHT");
      player_position_1 = rs_name.getString("POSITION");
   }

   private void toobar_equals() {
      if (tf_toobar.getText().equals("손흥민")) {
         sonima = new ImageIcon("images/7_son_min.png");
         sonima = imageSetSize(sonima, 500, 287);
         main_lbl.setIcon(sonima);
      } else if (tf_toobar.getText().equals("김승규")) {
         kimseungima = new ImageIcon("images/1_KimSeunggyu.png");
         main_lbl.setIcon(kimseungima);
      } else if (tf_toobar.getText().equals("이재성")) {
         gaesungima = new ImageIcon("images/10__leejaesung.png");
         main_lbl.setIcon(gaesungima);
      } else if (tf_toobar.getText().equals("황희찬")) {
         heechanima = new ImageIcon("images/11_hwongheechan.png");
         main_lbl.setIcon(heechanima);
      } else if (tf_toobar.getText().equals("황의조")) {
         uijoima = new ImageIcon("images/16_hwong_ui_jo.jpg");
         uijoima = imageSetSize(uijoima, 500, 287);
         main_lbl.setIcon(uijoima);
      } else if (tf_toobar.getText().equals("김영권")) {
         younggwonima = new ImageIcon("images/19_kimyounggwon.jpg");
         younggwonima = imageSetSize(younggwonima, 500, 287);
         main_lbl.setIcon(younggwonima);
      } else if (tf_toobar.getText().equals("김태환")) {
         taehwonima = new ImageIcon("images/23_kimtaehwon.jpg");
         taehwonima = imageSetSize(taehwonima, 500, 287);
         main_lbl.setIcon(taehwonima);
      } else if (tf_toobar.getText().equals("김진수")) {
         jinsuima = new ImageIcon("images/3_kimjinsu.png");
         main_lbl.setIcon(jinsuima);
      } else if (tf_toobar.getText().equals("김민재")) {
         minjaeima = new ImageIcon("images/4_kimminjae.png");
         main_lbl.setIcon(minjaeima);
      } else if (tf_toobar.getText().equals("정우영")) {
         woyeongima = new ImageIcon("images/5_ jungwoyeong.png");
         main_lbl.setIcon(woyeongima);
      } else if (tf_toobar.getText().equals("권창훈")) {
         changhoonima = new ImageIcon("images/22_gwonchanghoon.jpg");
         changhoonima = imageSetSize(changhoonima, 500, 287);
         main_lbl.setIcon(changhoonima);
      } else if (tf_toobar.getText().equals("송범근")) {
         songbumgeunima = new ImageIcon("images/12_songbumgeun.png");
         main_lbl.setIcon(songbumgeunima);
      } else if (tf_toobar.getText().equals("조현우")) {
         johyunwooima = new ImageIcon("images/21_johyunwoo.png");
         main_lbl.setIcon(johyunwooima);
      } else if (tf_toobar.getText().equals("윤종규")) {
         uenjonggyuima = new ImageIcon("images/2_uenjonggyu.png");
         uenjonggyuima = imageSetSize(uenjonggyuima, 500, 287);
         main_lbl.setIcon(uenjonggyuima);
      } else if (tf_toobar.getText().equals("박지수")) {
         parkjisooima = new ImageIcon("images/15_parkjisoo.png");
         main_lbl.setIcon(parkjisooima);
      } else if (tf_toobar.getText().equals("권경원")) {
         gwongyungwonima = new ImageIcon("images/20_gwongyungwon.png");
         main_lbl.setIcon(gwongyungwonima);
      } else if (tf_toobar.getText().equals("이재익")) {
         leejaecima = new ImageIcon("images/18_leejaec.png");
         main_lbl.setIcon(leejaecima);
      } else if (tf_toobar.getText().equals("남태희")) {
         namtaehee = new ImageIcon("images/8_namtaehee.png");
         main_lbl.setIcon(namtaehee);
      } else if (tf_toobar.getText().equals("송민규")) {
         songmingyuima = new ImageIcon("images/13_songminkyu.png");
         songmingyuima = imageSetSize(songmingyuima, 500, 287);
         main_lbl.setIcon(songmingyuima);
      } else if (tf_toobar.getText().equals("고승범")) {
         goseungbum = imageSetSize(goseungbum, 500, 287);
         goseungbum = new ImageIcon("images/6_goseungbeom.png");
         main_lbl.setIcon(goseungbum);
      } else if (tf_toobar.getText().equals("조영욱")) {

         joyoungwookima = new ImageIcon("images/17_joyoungwook.png");
         main_lbl.setIcon(joyoungwookima);
      } else if (tf_toobar.getText().length() >= 2 && tf_toobar.getText().length() <= 4) {
         siluat = new ImageIcon("images/siluat.jpg");
         siluat = imageSetSize(siluat, 500, 600);
         main_lbl.setIcon(siluat);

      } else {
         JOptionPane.showMessageDialog(this, "2 ~ 4길이의 " + "선수만 검색할 수 있습니다.", "[검색 실패 알림]",
               JOptionPane.WARNING_MESSAGE);
         main_lbl.setIcon(qarta_ima);
      }
   }

   @Override
   public void mouseClicked(MouseEvent e) {
		addbtn.setVisible(false);
      if (e.getClickCount() == 1) {
         if ("----------------------".equals((String) list.getSelectedValue())) {
            ta_p2.setText("선수 검색 or 클릭 하십시오");
         } else {
            String getvalue = (String) list.getSelectedValue();
            try {   // null 값 예외 대비
            	String show_text = getvalue.substring(getvalue.length() - 3); 
               tf_toobar.setText(show_text);
            } catch (NullPointerException e2) {
               tf_toobar.setText(" ");
            }
         }
      }
      if (e.getClickCount() == 2) { 
         Object selectedValue = list.getSelectedValue();

         try {  // null 값 예외 대비
            String strselec = (String) selectedValue;
             name_subst = strselec.substring(strselec.length() - 3);
         } catch (NullPointerException e2) {
            tf_toobar.setText(" ");
         }
      

         ResultSet rs = DB.getResult(sql_1);
         ResultSet rs1 = DB.getResult(sql_2);
         try {
            while (rs.next()) {
               temp = rs.getString("NAME");
               ResultSet rs_name = DB.getResult("select * from MAINPLAYER where name = '" + temp + "' ");
               if (temp.equals(name_subst)) {
                  while (rs_name.next()) {
                     rs_next(rs_name);
                  }
                  SetText_info();
                  rs_name.close();
               }
            }
            while (rs1.next()) {
               temp = rs1.getString("NAME");
               ResultSet rs_namesub = DB.getResult("select * from SUBPLAYER where name = '" + temp + "' ");
               if (temp.equals(name_subst)) {
                  while (rs_namesub.next()) {
                     rs_next(rs_namesub);
                  }
                  SetText_info();
               }
               rs_namesub.close();
            }
         } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         try {
            rs.close();
            rs1.close();
         } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }

         list_equals(); // 리스트 글자 비교 후 사진 출력

      }

   }

   private void list_equals() {
      String lenth_gsv = (String) list.getSelectedValue();
      if (list.getSelectedValue().equals("No.7 손흥민")) {
         sonima = new ImageIcon("images/7_son_min.png");
         sonima = imageSetSize(sonima, 500, 287);
         main_lbl.setIcon(sonima);
      } else if (list.getSelectedValue().equals("No.1 김승규")) {
         kimseungima = new ImageIcon("images/1_KimSeunggyu.png");
         main_lbl.setIcon(kimseungima);

      } else if (list.getSelectedValue().equals("No.10 이재성")) {
         gaesungima = new ImageIcon("images/10__leejaesung.png");
         main_lbl.setIcon(gaesungima);
      } else if (list.getSelectedValue().equals("No.11 황희찬")) {
         heechanima = new ImageIcon("images/11_hwongheechan.png");
         main_lbl.setIcon(heechanima);
      } else if (list.getSelectedValue().equals("No.16 황의조")) {
         uijoima = new ImageIcon("images/16_hwong_ui_jo.jpg");
         uijoima = imageSetSize(uijoima, 500, 287);
         main_lbl.setIcon(uijoima);
      } else if (list.getSelectedValue().equals("No.19 김영권")) {
         younggwonima = new ImageIcon("images/19_kimyounggwon.jpg");
         younggwonima = imageSetSize(younggwonima, 500, 287);
         main_lbl.setIcon(younggwonima);
      } else if (list.getSelectedValue().equals("No.23 김태환")) {
         taehwonima = new ImageIcon("images/23_kimtaehwon.jpg");
         taehwonima = imageSetSize(taehwonima, 500, 287);
         main_lbl.setIcon(taehwonima);
      } else if (list.getSelectedValue().equals("No.3 김진수")) {
         jinsuima = new ImageIcon("images/3_kimjinsu.png");
         main_lbl.setIcon(jinsuima);
      } else if (list.getSelectedValue().equals("No.4 김민재")) {
         minjaeima = new ImageIcon("images/4_kimminjae.png");
         main_lbl.setIcon(minjaeima);
      } else if (list.getSelectedValue().equals("No.5 정우영")) {
         woyeongima = new ImageIcon("images/5_ jungwoyeong.png");
         main_lbl.setIcon(woyeongima);
      } else if (list.getSelectedValue().equals("No.22 권창훈")) {
         changhoonima = new ImageIcon("images/22_gwonchanghoon.jpg");
         changhoonima = imageSetSize(changhoonima, 500, 287);
         main_lbl.setIcon(changhoonima);
      } else if ("No.12 송범근".equals(list.getSelectedValue())) {
         songbumgeunima = new ImageIcon("images/12_songbumgeun.png");
         main_lbl.setIcon(songbumgeunima);
      } else if ("No.21 조현우".equals(list.getSelectedValue())) {
         johyunwooima = new ImageIcon("images/21_johyunwoo.png");
         main_lbl.setIcon(johyunwooima);
      } else if ("No.2 윤종규".equals(list.getSelectedValue())) {
         uenjonggyuima = new ImageIcon("images/2_uenjonggyu.png");
         uenjonggyuima = imageSetSize(uenjonggyuima, 500, 287);
         main_lbl.setIcon(uenjonggyuima);
      } else if ("No.15 박지수".equals(list.getSelectedValue())) {
         parkjisooima = new ImageIcon("images/15_parkjisoo.png");
         main_lbl.setIcon(parkjisooima);
      } else if ("No.20 권경원".equals(list.getSelectedValue())) {
         gwongyungwonima = new ImageIcon("images/20_gwongyungwon.png");
         main_lbl.setIcon(gwongyungwonima);
      } else if ("No.18 이재익".equals(list.getSelectedValue())) {
         leejaecima = new ImageIcon("images/18_leejaec.png");
         main_lbl.setIcon(leejaecima);
      } else if ("No.8 남태희".equals(list.getSelectedValue())) {
         namtaehee = new ImageIcon("images/8_namtaehee.png");
         main_lbl.setIcon(namtaehee);
      } else if ("No.13 송민규".equals(list.getSelectedValue())) {
         songmingyuima = new ImageIcon("images/13_songminkyu.png");
         songmingyuima = imageSetSize(songmingyuima, 500, 287);
         main_lbl.setIcon(songmingyuima);
      } else if ("No.6 고승범".equals(list.getSelectedValue())) {
         goseungbum = new ImageIcon("images/6_goseungbeom.png");
         goseungbum = imageSetSize(goseungbum, 500, 287);
         main_lbl.setIcon(goseungbum);
      } else if ("No.17 조영욱".equals(list.getSelectedValue())) {
         joyoungwookima = new ImageIcon("images/17_joyoungwook.png");
         main_lbl.setIcon(joyoungwookima);
      } else if ("----------------------".equals(list.getSelectedValue())) {
         ta_p2.setText("선수 검색 or 클릭 하십시오");
         main_lbl.setIcon(qarta_ima);
      } else if (lenth_gsv.length() >= 8 && lenth_gsv.length() <= 11) {
         siluat = new ImageIcon("images/siluat.jpg");
         main_lbl.setIcon(siluat);
     	addbtn.setVisible(true);
      } else {
         main_lbl.setIcon(qarta_ima);
      }
   }

   @Override
   public void valueChanged(ListSelectionEvent e) {
      // TODO Auto-generated method stub

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