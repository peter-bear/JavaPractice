import java.util.Stack;

public class StackChainManager extends ChainManager{
	private Stack<Chain> chains;
	public StackChainManager() {
		// TODO Auto-generated constructor stub
		chains = new Stack<>();
		
	}
	
	@Override
	public void add(Chain chain) {
		// TODO Auto-generated method stub
		chains.push(chain);
		super.updateMax(chains.size());
	}

	@Override
	public Chain next() {
		// TODO Auto-generated method stub
		super.incrementNumNexts();
		
		return chains.pop();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return chains.isEmpty();
	}

}
