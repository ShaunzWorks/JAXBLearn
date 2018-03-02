package log;

public class Logger {
	private static Logger logger = new Logger();
	private Logger(){}
	public static Logger getLogger(Class<?> clazz){
		return logger;
	}
	public void error(String msg){
		System.out.println(msg);
	}
	
	public void info(String msg){
		System.out.println(msg);
	}
}
