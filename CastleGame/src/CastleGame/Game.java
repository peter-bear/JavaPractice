package CastleGame;
import java.util.*;
public class Game {
	private Room CurrentRoom;
	public Game() {
		createRoom();
	}
	private void createRoom() {
		//制造房间
		Room outside,lobby,pub,study,bedroom;
		outside = new Room("城堡外");
		lobby = new Room("大堂");
		pub = new Room("酒吧");
		study =new Room("书房");
		bedroom =new Room("卧室");
		//房间位置设置
		outside.SetExit("south",lobby);
		lobby.SetExit("north",outside);
		lobby.SetExit("south",pub);
		lobby.SetExit("east",study);
		lobby.SetExit("west",bedroom);
		pub.SetExit("north",lobby);
		bedroom.SetExit("east", lobby);
		study.SetExit( "west",lobby);
		CurrentRoom =outside;
	}
	private void Place() {
		for(String i: CurrentRoom.GetExitDes()) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}
	private void Welcome() {
		System.out.println();
		System.out.println("欢迎来到城堡!");
		System.out.println("这是一个超级无聊的游戏。");
		System.out.println("如果需要帮助，请输入'help'");
		System.out.println();
		System.out.println("现在你在:" + CurrentRoom);
		System.out.println("欢迎来到城堡");
		System.out.println("出口有：");
		Place();
	}
	private void printHelp()
	{
		System.out.println("迷路了吗？你可以做的命令有：go bye help");
		System.out.println("如：\tgo east");
	}
	private void goRoom(String direction) {
		Room NextRoom =CurrentRoom.SetDirection(direction);
		if(NextRoom == null) {
			System.out.println("那里没有门");
		}
		else {
			CurrentRoom = NextRoom;
			System.out.println("你在"+CurrentRoom);
			System.out.println("出口有： ");
			Place();
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Game game = new Game();
		game.Welcome();
		while(true) {
			System.out.print("你：");
			String line = in.nextLine();
			String[] words =line.split(" ");
			if(words[0].equals("go")) {
				game.goRoom(words[1]);
			}
			else if(words[0].equals("bye")) {
				break;
			}
			else if(words[0].equals("help")){
				game.printHelp();
			}
			else{
				game.printHelp();
			}
			
		}
		System.out.println("感谢您的光临。再见！");
		in.close();
	}
	
}
