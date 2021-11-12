package MultiThreadsStudy;

public class Tickets {
	private int tickets = 0;
	public void SellTicket() {
		setTickets(getTickets() + 1);
	}
	public int getTickets() {
		return tickets;
	}
	public void setTickets(int tickets) {
		this.tickets = tickets;
	}
}
