package elasticsearch;

import java.util.Timer;
import java.util.TimerTask;


public class TimeTask {
	public static void main(String[] args) {  
        TimerTask task = new TimerTask() {  
            @Override  
            public void run() {  
                // task to run goes here
            	
            	String path = PropertiesUtil.getProperty("path");
            	String usaged = DevUsage.getDevUsage(path);
            	System.out.println(usaged);
            	String usage = PropertiesUtil.getProperty("Usage");
            	int time = 60;
            	while(Float.parseFloat(usaged) >= Float.parseFloat(usage)){
            		time = time/2;
            		Delete.delete(time);
            		usaged = DevUsage.getDevUsage(path);
            		System.out.println(usaged);
            	}
//                System.out.println("Hello !!!");  
            }  
        };  
        Timer timer = new Timer();  
        long delay = 2000;
        int t = Integer.parseInt(PropertiesUtil.getProperty("timer"));
        long intevalPeriod = t * 60 * 1000;  
        // schedules the task to be run in an interval  
        timer.scheduleAtFixedRate(task, delay, intevalPeriod);  
    }

}
