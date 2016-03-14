package galaxy.rapid.command;

import java.util.ArrayList;
import java.util.List;

public class ExecCommandsProccesor {
	private String command;
	private List<String> args = new ArrayList<String>();
	
	public ExecCommandsProccesor(String command) {
		this(command, new String[0]);
	}
	
	public ExecCommandsProccesor(String command, String[] args) {
		this.command = command;
		for(String arg : args){
			this.args.add(arg);
		}
	}
	
	
	
	public int addArgument(String arg){
		args.add(arg);
		return args.size();
	}
}
