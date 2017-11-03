package play.model;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

//Found https://stackoverflow.com/questions/1248510/convert-string-to-keyevents

public class Altbot extends Robot{

    public Altbot()throws AWTException{}

    
    
    public void type(CharSequence cs){
        for(int i=0;i<cs.length();i++){
            type(cs.charAt(i));
        }
    }

    public void type(char c){
        keyPress(KeyEvent.VK_ALT);
        keyPress(KeyEvent.VK_NUMPAD0);
        keyRelease(KeyEvent.VK_NUMPAD0);
        String altCode=Integer.toString(c);
        for(int i=0;i<altCode.length();i++){
            c=(char)(altCode.charAt(i)+'0');
            //delay(20);//may be needed for certain applications
            keyPress(c);
            //delay(20);//uncomment if necessary
            keyRelease(c);
        }
        keyRelease(KeyEvent.VK_ALT);
    }
}