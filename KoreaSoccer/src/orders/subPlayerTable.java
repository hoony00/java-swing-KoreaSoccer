package orders;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import DB.SubPlayerList;

public class subPlayerTable extends JFrame implements KeyListener {

	private JPanel tablepanel;
	private JTextField search;
	private JTable table;

	public subPlayerTable(String title, int width, int height) {
		setTitle(title);
		setSize(863, 574);
//			setLocation(300, 300);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 레이아웃
		getContentPane().setLayout(null);

		setBackground(new Color(194, 210, 233));
		tablepanel = new JPanel();
		tablepanel.setBackground(new Color(194, 210, 233));
		tablepanel.setBounds(0, 0, 854, 544);
		String[][] data = SubPlayerList.getPlayers2();
		String[] headers = new String[] { "pn", "name", "age", "height", "weight", "position" };
		tablepanel.setLayout(null);
		table = new JTable(data, headers);
		table.setRowHeight(30);
		table.setFont(new Font("Sanserif", Font.BOLD, 15));
		table.setAlignmentX(0);
		table.setSize(800, 400);
		table.setPreferredScrollableViewportSize(new Dimension(800, 600));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(26, 59, 802, 574);
		tablepanel.add(scrollPane);
		getContentPane().add(tablepanel);

		search = new JTextField();
		search.setFont(new Font("굴림", Font.PLAIN, 17));
		search.setBounds(155, 23, 673, 26);
		tablepanel.add(search);
		search.setColumns(10);

		JLabel searchLabel = new JLabel("선수 이름 : ");
		searchLabel.setFont(new Font("굴림", Font.BOLD, 17));
		searchLabel.setBounds(53, 23, 117, 26);
		tablepanel.add(searchLabel);
		search.addKeyListener(this);

		setVisible(true);
	}

	public static void main(String[] args) {
		new subPlayerTable("선발선수", 855, 400);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		String val = search.getText();
		// 현재 행이 데이터를 갖고 있지 않으면 정리가 되도록함
		TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());
		table.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(val));
	}
}
