package main;
import DB.DB;
import player.SubPlayerFrame;

public class Main {

	public static void main(String[] args) {
		DB.init();	
		new SubPlayerFrame("구단 관리 프로그램");
	
	}

}
