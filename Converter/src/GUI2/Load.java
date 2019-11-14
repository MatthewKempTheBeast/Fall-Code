package GUI2;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Load {
	public static BufferedImage[] getNewButton(int size) {
		if(size == 1) {
			try {
				BufferedImage[] temp = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/arrows/uparrow.PNG")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/arrows/rightarrow.PNG")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/arrows/downarrow.PNG")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/arrows/leftarrow.PNG")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/arrows/rotateR.PNG")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/arrows/rotateL.PNG"))};
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
				BufferedImage[] temp = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/gui/g/execute.png")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/gui/g/reset.PNG"))};
				return temp;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(size == 6) {
			try {
				BufferedImage[] temp = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/red/g/redb.png")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/green/g/greenb.png")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/white/g/whiteb.png")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/blue/g/blueb.png")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/yellow/g/yellowb.png")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/orange/g/orangeb.png"))};
				return temp;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(size == 7) {
			try {
				BufferedImage[] temp = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/medium/g/mbutton.png")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/medium/g/mbuttonr.png"))};
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
				BufferedImage[] temp2 = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/arrows/uparrow.PNG")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/arrows/rightarrow.PNG")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/arrows/downarrow.PNG")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/arrows/leftarrow.PNG")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/arrows/rotateR.PNG")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/arrows/rotateL.PNG"))};
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
				BufferedImage[] temp = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/gui/gc/executec.PNG")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/gui/gc/resetc.PNG"))};
				return temp;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(size == 6) {
			try {
				BufferedImage[] temp = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/red/gc/redbc.png")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/green/gc/greenbc.png")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/white/gc/whitebc.png")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/blue/gc/bluebc.png")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/yellow/gc/yellowbc.png")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/orange/gc/orangebc.png"))};
				return temp;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(size == 7) {
			try {
				BufferedImage[] temp = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/medium/gc/mbuttonc.png")),
						ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/button/medium/gc/mbuttonrc.png"))};
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
				BufferedImage[] temp2 = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/List/back.PNG"))};
				return temp2[spot];
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(size == 2) {
			try {
				BufferedImage[] temp2 = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/lists/list.PNG"))};
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
				BufferedImage[] temp = {ImageIO.read(new File(System.getProperty("user.dir")+"/bin/GUI2/Pics/image/cubefaces.png"))};
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
