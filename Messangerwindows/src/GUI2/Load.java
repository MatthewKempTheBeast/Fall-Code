package GUI2;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Load {
	public static BufferedImage[] getNewButton(int size) {
		if(size == 1) {
			try {
				BufferedImage[] temp = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Button/small/smallBanana.PNG"))};
				return temp;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(size == 2) {
			try {
				BufferedImage[] temp = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Button/medium/mediumBanana.PNG"))};
				return temp;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(size == 3) {
			try {
				BufferedImage[] temp = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Button/xsmall/search.PNG")),ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Button/xsmall/plus.PNG")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Button/xsmall/minus.PNG"))};
				return temp;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(size == 4) {
			try {
				BufferedImage[] temp = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Button/addgui/guibutton.PNG"))};
				return temp;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(size == 5) {
			try {
				BufferedImage[] temp = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Button/send/send.PNG"))};
				return temp;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static BufferedImage[] getNewButtonc(int size) {
		if(size == 1) {
			try {
				BufferedImage[] temp2 = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Button/small/smallBananac.PNG"))};
				return temp2;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(size == 2) {
			try {
				BufferedImage[] temp2 = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Button/medium/mediumBananac.PNG"))};
				return temp2;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(size == 3) {
			try {
				BufferedImage[] temp = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Button/xsmall/searchc.PNG")),ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Button/xsmall/plusc.PNG")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Button/xsmall/minusc.PNG"))};
				return temp;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(size == 4) {
			try {
				BufferedImage[] temp = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Button/addgui/guibuttonc.PNG"))};
				return temp;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(size == 5) {
			try {
				BufferedImage[] temp = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Button/send/sendc.PNG"))};
				return temp;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static BufferedImage getNewList(int size, int spot) {
		if(size == 1) {
			try {
				BufferedImage[] temp2 = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/List/small/smallBananaList.PNG"))};
				return temp2[spot];
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static BufferedImage getNewDisplay(int size, int spot) {
		if(size == 1) {
			try {
				BufferedImage[] temp2 = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Display/small/smallBananaDisplay.PNG"))};
				return temp2[spot];
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(size == 2) {
			try {
				BufferedImage[] temp2 = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Display/125/sky.PNG"))};
				return temp2[spot];
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(size == 3) {
			try {
				BufferedImage[] temp2 = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Display/addgui/addguidisplay.PNG"))};
				return temp2[spot];
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(size == 4) {
			try {
				BufferedImage[] temp2 = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Display/message/messagedisplay.PNG"))};
				return temp2[spot];
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static BufferedImage getImage(int folder, int spot) {
		if(folder == 0) {
			try {
				BufferedImage[] temp = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Images/Test/ball.jpeg"))};
				return temp[spot];
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static BufferedImage getScroll(int size, int spot) {
		if(size == 1) {
			try {
				BufferedImage[] temp = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Scroll/small/scroll.PNG"))
						,ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Scroll/small/longScroll.PNG")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Scroll/large/scrollbarBlue.PNG"))};
				return temp[spot];
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static BufferedImage getScrollBar(int size,int spot) {
		if(size == 1) {
			try {
				BufferedImage[] temp = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/Scroll/small/scrollBar.PNG"))};
				return temp[spot];
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
