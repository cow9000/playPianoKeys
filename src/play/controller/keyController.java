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
			Robot robot = new Robot();
		}
		catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		start();
	}
	
	public void start() {
		
		String pianoTextFile = "9 ip ip 0 u oa | q ps ps 0 u oa " + 
				"9 ip ip 0 u oa | q ps ps 0 u oa " + 
				"9d g ipz ip | 9d g oaz " + 
				"qxcxcxl aoj " + 
				"j ipd g h jq ip " + 
				"j ipd g h ef up " + 
				"9 ip ip 0 u oa | q ps ps 0 u oa " + 
				"9 ip ip 0 u oa | q ps ps 0 u oa " + 
				"9d g ipz ip | 9d g oaz " + 
				"qxcxcxl aoj " + 
				"j ipd g h jq ip " + 
				"j ipd g h jq dz " + 
				"9 ip ip 0 u oa | q ps ps 0 u oa " + 
				"9 ip ip 0 u oa | q ps ps 0 u oa ";
		
		String[] pianoFileArray = pianoTextFile.split(" ");
		for(int i = 0; i < pianoFileArray.length; i++) {
			String play = pianoFileArray[i]; 
			System.out.println(play);
			
			writeString(play);
		}
		
	}
	
	private void writeString(String s) {
	    for (int i = 0; i < s.length(); i++) {
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
