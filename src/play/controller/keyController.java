package play.controller;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

public class keyController
{
	Robot robot;
	
	public keyController(){
		try
		{
			robot = new Robot();
		}
		catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		start();
	}
	
	public void start() {
		
		String pianoTextFile = "6 0 e r T r e 0 9 Q T u T e\n" + 
				"6 0 e r T r e 0 9 Q T u T e\n" + 
				"O 0 e r T r [pe] 0 I Q T u T e\n" + 
				"u I O 0 e r T r [ea] S 9 [QI] T u T e\n" + 
				"S f [h5] 7 9 [GQ] [ed] Q [9p] [7a] 5 7 9 Q e\n" + 
				"[h5] 7 G Q [ed] Q [9p] [7a] 5 7 9 Q e\n" + 
				"p [6u] 0 e r T r e 0 6 0 e r T\n" + 
				"u p S | [7yd] 9 Q S p [uf] [IG] 7 [9yd] Q e T\n" + 
				"p S [5d] 7 S d e G S | r e\n" + 
				"[3r] % 7 0 W 0 7 %\n" + 
				"3 % 7 0 W 0 6 5 7 9 Q e Q 9 7 6 ( 0 e T r e 0\n" + 
				"3 % 7 0 W 3 % 7 0 W";
		
		pianoTextFile = pianoTextFile.replace("\n", " _");
		
		String[] pianoFileArray = pianoTextFile.split(" ");
		
		for(int i = 0; i < pianoFileArray.length; i++) {
			String play = pianoFileArray[i]; 
			System.out.println(play);
			
			if(play.contains("_")) {
				try
				{
					Thread.sleep(50);
				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				try
				{
					Thread.sleep(400);
				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(!play.equalsIgnoreCase("|")) {
					writeString(play);
				}else {
					try
					{
						Thread.sleep(200);
					}
					catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			
		}
		
	}
	
	private void writeString(String s) {
		
	    for (int i = 0; i < s.length(); i++) {
	        
	    		if(!s.contains("[") || !s.contains("]")) {
	    			if(s.length() > 1) {
		    			try
						{
							Thread.sleep(150);
						}
						catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	    			}
	    		}
	    	
	    		char c = s.charAt(i);
	        if (Character.isUpperCase(c)) {
	            robot.keyPress(KeyEvent.VK_SHIFT);
	        }
	        
	        
	        System.out.println(c);
	        robot.keyPress(Character.toUpperCase(c));
	        robot.keyRelease(Character.toUpperCase(c));

	        if (Character.isUpperCase(c)) {
	            robot.keyRelease(KeyEvent.VK_SHIFT);
	        }
	    }
	    
	    robot.delay(10);
	}
	
}
