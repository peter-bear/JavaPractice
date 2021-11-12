package CastleGame;
import java.util.*;
public class Game {
	private Room CurrentRoom;
	public Game() {
		createRoom();
	}
	private void createRoom() {
		//���췿��
		Room outside,lobby,pub,study,bedroom;
		outside = new Room("�Ǳ���");
		lobby = new Room("����");
		pub = new Room("�ư�");
		study =new Room("�鷿");
		bedroom =new Room("����");
		//����λ������
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
		System.out.println("��ӭ�����Ǳ�!");
		System.out.println("����һ���������ĵ���Ϸ��");
		System.out.println("�����Ҫ������������'help'");
		System.out.println();
		System.out.println("��������:" + CurrentRoom);
		System.out.println("��ӭ�����Ǳ�");
		System.out.println("�����У�");
		Place();
	}
	private void printHelp()
	{
		System.out.println("��·������������������У�go bye help");
		System.out.println("�磺\tgo east");
	}
	private void goRoom(String direction) {
		Room NextRoom =CurrentRoom.SetDirection(direction);
		if(NextRoom == null) {
			System.out.println("����û����");
		}
		else {
			CurrentRoom = NextRoom;
			System.out.println("����"+CurrentRoom);
			System.out.println("�����У� ");
			Place();
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Game game = new Game();
		game.Welcome();
		while(true) {
			System.out.print("�㣺");
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
		System.out.println("��л���Ĺ��١��ټ���");
		in.close();
	}
	
}
