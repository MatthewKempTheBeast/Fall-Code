package GUI2;

import java.awt.event.KeyEvent;
//detects what key was pressed and returns the corresponding string for lists and displays
public class KeyText {
	//returns all characters
	public static String whatKeyAll(int e) {
		if(e == KeyEvent.VK_Q) {
			return "q";
		}
		else if(e == KeyEvent.VK_W) {
			return "w";
		}
		else if(e == KeyEvent.VK_E) {
			return "e";
		}
		else if(e == KeyEvent.VK_R) {
			return "r";
		}
		else if(e == KeyEvent.VK_T) {
			return "t";
		}
		else if(e == KeyEvent.VK_Y) {
			return "y";
		}
		else if(e == KeyEvent.VK_U) {
			return "u";
		}
		else if(e == KeyEvent.VK_I) {
			return "i";
		}
		else if(e == KeyEvent.VK_O) {
			return "o";
		}
		else if(e == KeyEvent.VK_P) {
			return "p";
		}
		else if(e == KeyEvent.VK_OPEN_BRACKET) {
			return "[";
		}
		else if(e == KeyEvent.VK_CLOSE_BRACKET) {
			return "]";
		}
		else if(e == KeyEvent.VK_BACK_SLASH) {
			return "\"";
		}
		else if(e == KeyEvent.VK_1) {
			return "1";
		}
		else if(e == KeyEvent.VK_2) {
			return "2";
		}
		else if(e == KeyEvent.VK_3) {
			return "3";
		}
		else if(e == KeyEvent.VK_4) {
			return "4";
		}
		else if(e == KeyEvent.VK_5) {
			return "5";
		}
		else if(e == KeyEvent.VK_6) {
			return "6";
		}
		else if(e == KeyEvent.VK_7) {
			return "7";
		}
		else if(e == KeyEvent.VK_8) {
			return "8";
		}
		else if(e == KeyEvent.VK_9) {
			return "9";
		}
		else if(e == KeyEvent.VK_0) {
			return "0";
		}
		else if(e == KeyEvent.VK_A) {
			return "a";
		}
		else if(e == KeyEvent.VK_S) {
			return "s";
		}
		else if(e == KeyEvent.VK_D) {
			return "d";
		}
		else if(e == KeyEvent.VK_F) {
			return "f";
		}
		else if(e == KeyEvent.VK_G) {
			return "g";
		}
		else if(e == KeyEvent.VK_H) {
			return "h";
		}
		else if(e == KeyEvent.VK_J) {
			return "j";
		}
		else if(e == KeyEvent.VK_K) {
			return "k";
		}
		else if(e == KeyEvent.VK_L) {
			return "l";
		}
		else if(e == KeyEvent.VK_SEMICOLON) {
			return ";";
		}
		else if(e == KeyEvent.VK_QUOTE) {
			return "'";
		}
		else if(e == KeyEvent.VK_Z) {
			return "z";
		}
		else if(e == KeyEvent.VK_X) {
			return "x";
		}
		else if(e == KeyEvent.VK_C) {
			return "c";
		}
		else if(e == KeyEvent.VK_V) {
			return "v";
		}
		else if(e == KeyEvent.VK_B) {
			return "b";
		}
		else if(e == KeyEvent.VK_N) {
			return "n";
		}
		else if(e == KeyEvent.VK_M) {
			return "m";
		}
		else if(e == KeyEvent.VK_COMMA) {
			return ",";
		}
		else if(e == KeyEvent.VK_PERIOD) {
			return ".";
		}
		else if(e == KeyEvent.VK_SLASH) {
			return "/";
		}
		else if(e == KeyEvent.VK_SPACE) {
			return " ";
		}
		else {
			return "";
		}
	}
	//check if shift is being held and returns either capital letters or lowercase
	public static String whatKeyAllCapitalize(int e, boolean k) {
		if(k) {
			if(e == KeyEvent.VK_Q) {
				return "Q";
			}
			else if(e == KeyEvent.VK_W) {
				return "W";
			}
			else if(e == KeyEvent.VK_E) {
				return "E";
			}
			else if(e == KeyEvent.VK_R) {
				return "R";
			}
			else if(e == KeyEvent.VK_T) {
				return "T";
			}
			else if(e == KeyEvent.VK_Y) {
				return "Y";
			}
			else if(e == KeyEvent.VK_U) {
				return "U";
			}
			else if(e == KeyEvent.VK_I) {
				return "I";
			}
			else if(e == KeyEvent.VK_O) {
				return "O";
			}
			else if(e == KeyEvent.VK_P) {
				return "P";
			}
			else if(e == KeyEvent.VK_OPEN_BRACKET) {
				return "[";
			}
			else if(e == KeyEvent.VK_CLOSE_BRACKET) {
				return "]";
			}
			else if(e == KeyEvent.VK_BACK_SLASH) {
				return "\"";
			}
			else if(e == KeyEvent.VK_1) {
				return "1";
			}
			else if(e == KeyEvent.VK_2) {
				return "2";
			}
			else if(e == KeyEvent.VK_3) {
				return "3";
			}
			else if(e == KeyEvent.VK_4) {
				return "4";
			}
			else if(e == KeyEvent.VK_5) {
				return "5";
			}
			else if(e == KeyEvent.VK_6) {
				return "6";
			}
			else if(e == KeyEvent.VK_7) {
				return "7";
			}
			else if(e == KeyEvent.VK_8) {
				return "8";
			}
			else if(e == KeyEvent.VK_9) {
				return "9";
			}
			else if(e == KeyEvent.VK_0) {
				return "0";
			}
			else if(e == KeyEvent.VK_A) {
				return "A";
			}
			else if(e == KeyEvent.VK_S) {
				return "S";
			}
			else if(e == KeyEvent.VK_D) {
				return "D";
			}
			else if(e == KeyEvent.VK_F) {
				return "F";
			}
			else if(e == KeyEvent.VK_G) {
				return "G";
			}
			else if(e == KeyEvent.VK_H) {
				return "H";
			}
			else if(e == KeyEvent.VK_J) {
				return "J";
			}
			else if(e == KeyEvent.VK_K) {
				return "K";
			}
			else if(e == KeyEvent.VK_L) {
				return "L";
			}
			else if(e == KeyEvent.VK_SEMICOLON) {
				return ";";
			}
			else if(e == KeyEvent.VK_QUOTE) {
				return "'";
			}
			else if(e == KeyEvent.VK_Z) {
				return "Z";
			}
			else if(e == KeyEvent.VK_X) {
				return "X";
			}
			else if(e == KeyEvent.VK_C) {
				return "C";
			}
			else if(e == KeyEvent.VK_V) {
				return "V";
			}
			else if(e == KeyEvent.VK_B) {
				return "B";
			}
			else if(e == KeyEvent.VK_N) {
				return "N";
			}
			else if(e == KeyEvent.VK_M) {
				return "M";
			}
			else if(e == KeyEvent.VK_COMMA) {
				return ",";
			}
			else if(e == KeyEvent.VK_PERIOD) {
				return ".";
			}
			else if(e == KeyEvent.VK_SLASH) {
				return "/";
			}
			else if(e == KeyEvent.VK_SPACE) {
				return " ";
			}
			else if(e == KeyEvent.VK_EQUALS) {
				return "+";
			}
			else {
				return "";
			}
		}
		else {
			if(e == KeyEvent.VK_Q) {
				return "q";
			}
			else if(e == KeyEvent.VK_W) {
				return "w";
			}
			else if(e == KeyEvent.VK_E) {
				return "e";
			}
			else if(e == KeyEvent.VK_R) {
				return "r";
			}
			else if(e == KeyEvent.VK_T) {
				return "t";
			}
			else if(e == KeyEvent.VK_Y) {
				return "y";
			}
			else if(e == KeyEvent.VK_U) {
				return "u";
			}
			else if(e == KeyEvent.VK_I) {
				return "i";
			}
			else if(e == KeyEvent.VK_O) {
				return "o";
			}
			else if(e == KeyEvent.VK_P) {
				return "p";
			}
			else if(e == KeyEvent.VK_OPEN_BRACKET) {
				return "[";
			}
			else if(e == KeyEvent.VK_CLOSE_BRACKET) {
				return "]";
			}
			else if(e == KeyEvent.VK_BACK_SLASH) {
				return "\"";
			}
			else if(e == KeyEvent.VK_1) {
				return "1";
			}
			else if(e == KeyEvent.VK_2) {
				return "2";
			}
			else if(e == KeyEvent.VK_3) {
				return "3";
			}
			else if(e == KeyEvent.VK_4) {
				return "4";
			}
			else if(e == KeyEvent.VK_5) {
				return "5";
			}
			else if(e == KeyEvent.VK_6) {
				return "6";
			}
			else if(e == KeyEvent.VK_7) {
				return "7";
			}
			else if(e == KeyEvent.VK_8) {
				return "8";
			}
			else if(e == KeyEvent.VK_9) {
				return "9";
			}
			else if(e == KeyEvent.VK_0) {
				return "0";
			}
			else if(e == KeyEvent.VK_A) {
				return "a";
			}
			else if(e == KeyEvent.VK_S) {
				return "s";
			}
			else if(e == KeyEvent.VK_D) {
				return "d";
			}
			else if(e == KeyEvent.VK_F) {
				return "f";
			}
			else if(e == KeyEvent.VK_G) {
				return "g";
			}
			else if(e == KeyEvent.VK_H) {
				return "h";
			}
			else if(e == KeyEvent.VK_J) {
				return "j";
			}
			else if(e == KeyEvent.VK_K) {
				return "k";
			}
			else if(e == KeyEvent.VK_L) {
				return "l";
			}
			else if(e == KeyEvent.VK_SEMICOLON) {
				return ";";
			}
			else if(e == KeyEvent.VK_QUOTE) {
				return "'";
			}
			else if(e == KeyEvent.VK_Z) {
				return "z";
			}
			else if(e == KeyEvent.VK_X) {
				return "x";
			}
			else if(e == KeyEvent.VK_C) {
				return "c";
			}
			else if(e == KeyEvent.VK_V) {
				return "v";
			}
			else if(e == KeyEvent.VK_B) {
				return "b";
			}
			else if(e == KeyEvent.VK_N) {
				return "n";
			}
			else if(e == KeyEvent.VK_M) {
				return "m";
			}
			else if(e == KeyEvent.VK_COMMA) {
				return ",";
			}
			else if(e == KeyEvent.VK_PERIOD) {
				return ".";
			}
			else if(e == KeyEvent.VK_SLASH) {
				return "/";
			}
			else if(e == KeyEvent.VK_SPACE) {
				return " ";
			}
			else if(e == KeyEvent.VK_EQUALS) {
				return "=";
			}
			else {
				return "";
			}
		}
	}
	//only returns numbers
	public static String whatKeyNum(int e) {
		if(e == KeyEvent.VK_1) {
			return "1";
		}
		else if(e == KeyEvent.VK_2) {
			return "2";
		}
		else if(e == KeyEvent.VK_3) {
			return "3";
		}
		else if(e == KeyEvent.VK_4) {
			return "4";
		}
		else if(e == KeyEvent.VK_5) {
			return "5";
		}
		else if(e == KeyEvent.VK_6) {
			return "6";
		}
		else if(e == KeyEvent.VK_7) {
			return "7";
		}
		else if(e == KeyEvent.VK_8) {
			return "8";
		}
		else if(e == KeyEvent.VK_9) {
			return "9";
		}
		else if(e == KeyEvent.VK_0) {
			return "0";
		}
		else {
			return "";
		}
	}
}
