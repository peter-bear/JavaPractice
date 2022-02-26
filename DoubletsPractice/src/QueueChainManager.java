import java.util.LinkedList;

public class QueueChainManager extends ChainManager{
	private LinkedList<Chain> chains; 
	
	public QueueChainManager() {
		chains = new LinkedList<>();
	}
	
	
	@Override
	public void add(Chain chain) {
		// TODO Auto-generated method stub
		chains.offer(chain);
		updateMax(chains.size());
	}

	@Override
	public Chain next() {
		// TODO Auto-generated method stub
		super.incrementNumNexts();
		return chains.poll();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return chains.isEmpty();
	}

}
