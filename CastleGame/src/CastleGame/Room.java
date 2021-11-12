package CastleGame;
import java.util.HashMap;
import java.util.Set;
public class Room {
	private String description;

	public Room(String description) {
		this.description =description;
	}
	//通过搜索key（方向）来确立房间
	public Room SetDirection(String dir) {
		Room rst =null;
		for(String j:map.keySet()) {
			if (j.equals(dir)){
				rst = map.get(j);
			}
		}
		return rst;
	}
	//返回所在房间的接口方向
	public Set<String> GetExitDes() { 
		Set<String> exit =map.keySet();
		return exit;
	}
	//建立一个哈希容器，储存各个房间对应current room方向
	private HashMap<String ,Room> map = new HashMap<String, Room>();
	public void SetExit(String direction,Room room) {
		map.put(direction, room);
	}
	

	@Override
	public String toString() {
		return description;
	}
	
}


//private Room NorthExit, SouthExit,WestExit,EastExit;	
//public String GetExitDes() {
//	StringBuffer ret =new StringBuffer();
//	if(NorthExit !=null)
//		ret.append("north ");
//	if(EastExit !=null)
//		ret.append("east ");
//	if(SouthExit !=null)
//		ret.append("south ");
//	if(WestExit !=null)
//		ret.append("west ");
//	return ret.toString();
//}

//public Room SetDirection(String direction) {
//	Room rst =null;
//	if(direction.equals("north")) {
//		rst = NorthExit;
//	}
//	if(direction.equals("south")) {
//		rst = SouthExit;
//	}
//	if(direction.equals("east")) {
//		rst = EastExit;
//	}
//	if(direction.equals("west")) {
//		rst = WestExit;
//	}
//	return rst;
//}

//public void SetExit(Room north,Room south,Room west,Room east) {
//if(north!=null) {
//	NorthExit = north;
//}
//if(south!=null) {
//	SouthExit = south;
//}
//if(west!=null) {
//	WestExit = west;
//}
//if(east!=null) {
//	EastExit = east;
//}
//}