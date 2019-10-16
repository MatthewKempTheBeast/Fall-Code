package Rubiks;

import java.awt.Color;
import java.util.ArrayList;
import GUI2.*;
public class Cube {
	private static int[][] faces;
	//private int face;
	public Cube(int[] face1, int[] face2,int[] face3,int[] face4
			,int[] face5,int[] face6) {
		int[][] faces = new int[6][9];
		faces[0] = face1;
		faces[1] = face2;
		faces[2] = face3;
		faces[3] = face4;
		faces[4] = face5;
		faces[5] = face6;
		this.faces = faces;
		//this.face = 1;
	}
	public Cube() {
		int[][] faces = new int[6][9];
		//faces 0 = face 1 is red and 1 represent red
		faces[0] = new int[] {1,1,1,1,1,1,1,1,1};
		//faces 1 = face 2 is green and 2 represents green
		faces[1] = new int[] {2,2,2,2,2,2,2,2,2};
		//faces 2 = face 3 is wihte and 3 represents white
		faces[2] = new int[] {3,3,3,3,3,3,3,3,3};
		//faces 3 = face 4 is blue and 4 represents blue
		faces[3] = new int[] {4,4,4,4,4,4,4,4,4};
		//faces 4 = face 5 is yellow and 5 represents yellow
		faces[4] = new int[] {5,5,5,5,5,5,5,5,5};
		//faces 5 = face 6 is orange and 6 represents orange
		faces[5] = new int[] {6,6,6,6,6,6,6,6,6};
		this.faces = faces;
		//this.face = 1;
	}
	public int[] getF1(){
		return faces[0];
	}
	public int[] getF2(){
		return faces[1];
	}
	public int[] getF3(){
		return faces[2];
	}
	public int[] getF4(){
		return faces[3];
	}
	public int[] getF5(){
		return faces[4];
	}
	public int[] getF6(){
		return faces[5];
	}
	public int[] getFace(int face) {
		if(face == 1) {
			return faces[0];
		}
		else if(face == 2) {
			return faces[1];
		}
		else if(face == 3) {
			return faces[2];
		}
		else if(face == 4) {
			return faces[3];
		}
		else if(face == 5) {
			return faces[4];
		}
		else {
			return faces[5];
		}
	}
	public int[][] getFaces(){
		return faces;
	}
	public int getSpot(int face, int spot) {
		if(face < 6 && face >= 0 && spot >= 0 && spot < 9) {
			return faces[face][spot];
		}
		else {
			return 0;
		}
	}
	public int rotateRight(int face) {
		if(face == 0) {
			return 3;
		}
		else if(face == 1) {
			return 0;
		}
		else if(face == 2) {
			return 3;
		}
		else if(face == 3) {
			return 5;
		}
		else if(face == 4) {
			return 3;
		}
		else {
			return 3;
		}
	}
	public int rotateLeft(int face) {
		if(face == 0) {
			return 1;
		}
		else if(face == 1) {
			return 5;
		}
		else if(face == 2) {
			return 1;
		}
		else if(face == 3) {
			return 0;
		}
		else if(face == 4) {
			return 1;
		}
		else {
			return 1;
		}
	}
	public int rotateUp(int face) {
		if(face == 0) {
			return 2;
		}
		else if(face == 1) {
			return 2;
		}
		else if(face == 2) {
			return 5;
		}
		else if(face == 3) {
			return 2;
		}
		else if(face == 4) {
			return 0;
		}
		else {
			return 4;
		}
	}
	public int rotateDown(int face) {
		if(face == 0) {
			return 4;
		}
		else if(face == 1) {
			return 4;
		}
		else if(face == 2) {
			return 0;
		}
		else if(face == 3) {
			return 4;
		}
		else if(face == 4) {
			return 5;
		}
		else {
			return 2;
		}
	}
	public int[] getRightCol(int face) {
		if(face == 1) {
			int[] n = {faces[0][2],faces[0][5],faces[0][8]};
			return (n);
		}
		else if(face == 2) {
			int[] n = {faces[1][2],faces[1][5],faces[1][8]};
			return (n);
		}
		else if(face == 3) {
			int[] n = {faces[2][2],faces[2][5],faces[2][8]};
			return (n);
		}
		else if(face == 4) {
			int[] n = {faces[3][2],faces[3][5],faces[3][8]};
			return (n);
		}
		else if(face == 5) {
			int[] n = {faces[4][2],faces[4][5],faces[4][8]};
			return (n);
		}
		else {
			int[] n = {faces[5][2],faces[5][5],faces[5][8]};
			return (n);
		}
	}
	//returns the reversed verison of the col
	public int[] getRRightCol(int face) {
		if(face == 1) {
			int[] n = {faces[0][8],faces[0][5],faces[0][2]};
			return (n);
		}
		else if(face == 2) {
			int[] n = {faces[1][8],faces[1][5],faces[1][2]};
			return (n);
		}
		else if(face == 3) {
			int[] n = {faces[2][8],faces[2][5],faces[2][2]};
			return (n);
		}
		else if(face == 4) {
			int[] n = {faces[3][8],faces[3][5],faces[3][2]};
			return (n);
		}
		else if(face == 5) {
			int[] n = {faces[4][8],faces[4][5],faces[4][2]};
			return (n);
		}
		else {
			int[] n = {faces[5][8],faces[5][5],faces[5][2]};
			return (n);
		}
	}
	public int[] getLeftCol(int face) {
		if(face == 1) {
			int[] n = {faces[0][0],faces[0][3],faces[0][6]};
			return (n);
		}
		else if(face == 2) {
			int[] n = {faces[1][0],faces[1][3],faces[1][6]};
			return (n);
		}
		else if(face == 3) {
			int[] n = {faces[2][0],faces[2][3],faces[2][6]};
			return (n);
		}
		else if(face == 4) {
			int[] n = {faces[3][0],faces[3][3],faces[3][6]};
			return (n);
		}
		else if(face == 5) {
			int[] n = {faces[4][0],faces[4][3],faces[4][6]};
			return (n);
		}
		else {
			int[] n = {faces[5][0],faces[5][3],faces[5][6]};
			return (n);
		}
	}
	public int[] getRLeftCol(int face) {
		if(face == 1) {
			int[] n = {faces[0][6],faces[0][3],faces[0][0]};
			return (n);
		}
		else if(face == 2) {
			int[] n = {faces[1][6],faces[1][3],faces[1][0]};
			return (n);
		}
		else if(face == 3) {
			int[] n = {faces[2][6],faces[2][3],faces[2][0]};
			return (n);
		}
		else if(face == 4) {
			int[] n = {faces[3][6],faces[3][3],faces[3][0]};
			return (n);
		}
		else if(face == 5) {
			int[] n = {faces[4][6],faces[4][3],faces[4][0]};
			return (n);
		}
		else {
			int[] n = {faces[5][6],faces[5][3],faces[5][0]};
			return (n);
		}
	}
	public int[] getTopRow(int face) {
		if(face == 1) {
			int[] n = {faces[0][0],faces[0][1],faces[0][2]};
			return n;
		}
		else if(face == 2) {
			int[] n = {faces[1][0],faces[1][1],faces[1][2]};
			return n;
		}
		else if(face == 3) {
			int[] n = {faces[2][0],faces[2][1],faces[2][2]};
			return n;
		}
		else if(face == 4) {
			int[] n = {faces[3][0],faces[3][1],faces[3][2]};
			return n;
		}
		else if(face == 5) {
			int[] n = {faces[4][0],faces[4][1],faces[4][2]};
			return n;
		}
		else {
			int[] n = {faces[5][0],faces[5][1],faces[5][2]};
			return n;
		}
	}
	public int[] getRTopRow(int face) {
		if(face == 1) {
			int[] n = {faces[0][2],faces[0][1],faces[0][0]};
			return n;
		}
		else if(face == 2) {
			int[] n = {faces[1][2],faces[1][1],faces[1][0]};
			return n;
		}
		else if(face == 3) {
			int[] n = {faces[2][2],faces[2][1],faces[2][0]};
			return n;
		}
		else if(face == 4) {
			int[] n = {faces[3][2],faces[3][1],faces[3][0]};
			return n;
		}
		else if(face == 5) {
			int[] n = {faces[4][2],faces[4][1],faces[4][0]};
			return n;
		}
		else {
			int[] n = {faces[5][2],faces[5][1],faces[5][0]};
			return n;
		}
	}
	public int[] getBottomRow(int face) {
		if(face == 1) {
			int[] n = {faces[0][6],faces[0][7],faces[0][8]};
			return n;
		}
		else if(face == 2) {
			int[] n = {faces[1][6],faces[1][7],faces[1][8]};
			return n;
		}
		else if(face == 3) {
			int[] n = {faces[2][6],faces[2][7],faces[2][8]};
			return n;
		}
		else if(face == 4) {
			int[] n = {faces[3][6],faces[3][7],faces[3][8]};
			return n;
		}
		else if(face == 5) {
			int[] n = {faces[4][6],faces[4][7],faces[4][8]};
			return n;
		}
		else {
			int[] n = {faces[5][6],faces[5][7],faces[5][8]};
			return n;
		}
	}
	public int[] getRBottomRow(int face) {
		if(face == 1) {
			int[] n = {faces[0][8],faces[0][7],faces[0][6]};
			return n;
		}
		else if(face == 2) {
			int[] n = {faces[1][8],faces[1][7],faces[1][6]};
			return n;
		}
		else if(face == 3) {
			int[] n = {faces[2][8],faces[2][7],faces[2][6]};
			return n;
		}
		else if(face == 4) {
			int[] n = {faces[3][8],faces[3][7],faces[3][6]};
			return n;
		}
		else if(face == 5) {
			int[] n = {faces[4][8],faces[4][7],faces[4][6]};
			return n;
		}
		else {
			int[] n = {faces[5][8],faces[5][7],faces[5][6]};
			return n;
		}
	}
	public void setRightCol(int face,int[] replace) {
		faces[face-1][2] = replace[0];
		faces[face-1][5] = replace[1];
		faces[face-1][8] = replace[2];
	}
	public void setLeftCol(int face,int[] replace) {
		faces[face-1][0] = replace[0];
		faces[face-1][3] = replace[1];
		faces[face-1][6] = replace[2];
	}
	public void setTopRow(int face,int[] replace) {
		faces[face-1][0] = replace[0];
		faces[face-1][1] = replace[1];
		faces[face-1][2] = replace[2];
	}
	public void setBottomRow(int face,int[] replace) {
		faces[face-1][6] = replace[0];
		faces[face-1][7] = replace[1];
		faces[face-1][8] = replace[2];
	}
	//each face of the cube can only be oriented in one y direction
	public void rightUp(int face) {
		if(face == 1) {
			int[] f1 = getRightCol(1);
			int[] f3 = getRightCol(3);
			int[] f6 = getRightCol(6);
			int[] f5 = getRightCol(5);
			setRightCol(1,f5);
			setRightCol(3,f1);
			setRightCol(6,f3);
			setRightCol(5,f6);
			rotate90(4);
		}
		//2 and 4 need special functions becuase they are situation differenlt then the rest of the cube axis
		else if(face == 2) {
			int[] f2 = getRRightCol(2);
			int[] f3 = getBottomRow(3);
			int[] f4 = getRLeftCol(4);
			int[] f5 = getTopRow(5);
			setRightCol(2,f5);
			setBottomRow(3,f2);
			setLeftCol(4,f3);
			setTopRow(5,f4);
			rotate90(1);
		}
		else if(face == 3) {
			int[] f1 = getRightCol(1);
			int[] f3 = getRightCol(3);
			int[] f6 = getRightCol(6);
			int[] f5 = getRightCol(5);
			setRightCol(1,f5);
			setRightCol(3,f1);
			setRightCol(6,f3);
			setRightCol(5,f6);
			rotate90(4);
		}
		else if(face == 4) {
			int[] f4 = getRightCol(4);
			int[] f5 = getRBottomRow(5);
			int[] f2 = getLeftCol(2);
			int[] f3 = getRTopRow(3);
			setRightCol(4,f5);
			setBottomRow(5,f2);
			setLeftCol(2,f3);
			setTopRow(3,f4);
			rotate90(6);
		}
		else if(face == 5) {
			int[] f1 = getRightCol(1);
			int[] f3 = getRightCol(3);
			int[] f6 = getRightCol(6);
			int[] f5 = getRightCol(5);
			setRightCol(1,f5);
			setRightCol(3,f1);
			setRightCol(6,f3);
			setRightCol(5,f6);
			rotate90(4);
		}
		else {
			int[] f1 = getRightCol(1);
			int[] f3 = getRightCol(3);
			int[] f6 = getRightCol(6);
			int[] f5 = getRightCol(5);
			setRightCol(1,f5);
			setRightCol(3,f1);
			setRightCol(6,f3);
			setRightCol(5,f6);
			rotate90(4);
		}
	}
	public void leftUp(int face) {
		if(face == 1) {
			int[] f1 = getLeftCol(1);
			int[] f3 = getLeftCol(3);
			int[] f6 = getLeftCol(6);
			int[] f5 = getLeftCol(5);
			setLeftCol(1,f5);
			setLeftCol(3,f1);
			setLeftCol(6,f3);
			setLeftCol(5,f6);
			rotateNeg90(2);
		}
		else if(face == 2) {
			int[] f2 = getRLeftCol(2);
			int[] f3 = getTopRow(3);
			int[] f4 = getRRightCol(4);
			int[] f5 = getBottomRow(5);
			setLeftCol(2,f5);
			setTopRow(3,f2);
			setRightCol(4,f3);
			setBottomRow(5,f4);
			rotateNeg90(6);
		}
		else if(face == 3) {
			int[] f1 = getLeftCol(1);
			int[] f3 = getLeftCol(3);
			int[] f6 = getLeftCol(6);
			int[] f5 = getLeftCol(5);
			setLeftCol(1,f5);
			setLeftCol(3,f1);
			setLeftCol(6,f3);
			setLeftCol(5,f6);
			rotateNeg90(2);
		}
		else if(face == 4) {
			int[] f4 = getLeftCol(4);
			int[] f3 = getRBottomRow(3);
			int[] f2 = getRightCol(2);
			int[] f5 = getRTopRow(5);
			setLeftCol(4,f5);
			setBottomRow(3,f4);
			setRightCol(2,f3);
			setTopRow(5,f2);
			rotateNeg90(1);
		}
		else if(face == 5) {
			int[] f1 = getLeftCol(1);
			int[] f3 = getLeftCol(3);
			int[] f6 = getLeftCol(6);
			int[] f5 = getLeftCol(5);
			setLeftCol(1,f5);
			setLeftCol(3,f1);
			setLeftCol(6,f3);
			setLeftCol(5,f6);
			rotateNeg90(2);
		}
		else {
			int[] f1 = getLeftCol(1);
			int[] f3 = getLeftCol(3);
			int[] f6 = getLeftCol(6);
			int[] f5 = getLeftCol(5);
			setLeftCol(1,f5);
			setLeftCol(3,f1);
			setLeftCol(6,f3);
			setLeftCol(5,f6);
			rotateNeg90(2);
		}
	}
	public void rightDown(int face) {
		if(face == 1) {
			int[] f1 = getRightCol(1);
			int[] f3 = getRightCol(3);
			int[] f6 = getRightCol(6);
			int[] f5 = getRightCol(5);
			setRightCol(1,f3);
			setRightCol(3,f6);
			setRightCol(6,f5);
			setRightCol(5,f1);
			rotateNeg90(4);
		}
		//2 and 4 need special functions becuase they are situation differenlt then the rest of the cube axis
		else if(face == 2) {
			int[] f2 = getRightCol(2);
			int[] f3 = getRBottomRow(3);
			int[] f4 = getLeftCol(4);
			int[] f5 = getRTopRow(5);
			setRightCol(2,f3);
			setBottomRow(3,f4);
			setLeftCol(4,f5);
			setTopRow(5,f2);
			rotateNeg90(1);
		}
		else if(face == 3) {
			int[] f1 = getRightCol(1);
			int[] f3 = getRightCol(3);
			int[] f6 = getRightCol(6);
			int[] f5 = getRightCol(5);
			setRightCol(1,f3);
			setRightCol(3,f6);
			setRightCol(6,f5);
			setRightCol(5,f1);
			rotateNeg90(4);
		}
		else if(face == 4) {
			int[] f4 = getRRightCol(4);
			int[] f5 = getBottomRow(5);
			int[] f2 = getRLeftCol(2);
			int[] f3 = getTopRow(3);
			setRightCol(4,f3);
			setBottomRow(5,f4);
			setLeftCol(2,f5);
			setTopRow(3,f2);
			rotateNeg90(6);
		}
		else if(face == 5) {
			int[] f1 = getRightCol(1);
			int[] f3 = getRightCol(3);
			int[] f6 = getRightCol(6);
			int[] f5 = getRightCol(5);
			setRightCol(1,f3);
			setRightCol(3,f6);
			setRightCol(6,f5);
			setRightCol(5,f1);
			rotateNeg90(4);
		}
		else {
			int[] f1 = getRightCol(1);
			int[] f3 = getRightCol(3);
			int[] f6 = getRightCol(6);
			int[] f5 = getRightCol(5);
			setRightCol(1,f3);
			setRightCol(3,f6);
			setRightCol(6,f5);
			setRightCol(5,f1);
			rotateNeg90(4);
		}
	}
	public void leftDown(int face) {
		if(face == 1) {
			int[] f1 = getLeftCol(1);
			int[] f3 = getLeftCol(3);
			int[] f6 = getLeftCol(6);
			int[] f5 = getLeftCol(5);
			setLeftCol(1,f3);
			setLeftCol(3,f6);
			setLeftCol(6,f5);
			setLeftCol(5,f1);
			rotate90(2);
		}
		else if(face == 2) {
			int[] f2 = getLeftCol(2);
			int[] f3 = getRTopRow(3);
			int[] f4 = getRightCol(4);
			int[] f5 = getRBottomRow(5);
			setLeftCol(2,f3);
			setTopRow(3,f4);
			setRightCol(4,f5);
			setBottomRow(5,f2);
			rotate90(6);
		}
		else if(face == 3) {
			int[] f1 = getLeftCol(1);
			int[] f3 = getLeftCol(3);
			int[] f6 = getLeftCol(6);
			int[] f5 = getLeftCol(5);
			setLeftCol(1,f3);
			setLeftCol(3,f6);
			setLeftCol(6,f5);
			setLeftCol(5,f1);
			rotate90(2);
		}
		else if(face == 4) {
			int[] f2 = getRRightCol(2);
			int[] f3 = getBottomRow(3);
			int[] f4 = getRLeftCol(4);
			int[] f5 = getTopRow(5);
			setRightCol(2,f5);
			setBottomRow(3,f2);
			setLeftCol(4,f3);
			setTopRow(5,f4);
			rotate90(1);
		}
		else if(face == 5) {
			int[] f1 = getLeftCol(1);
			int[] f3 = getLeftCol(3);
			int[] f6 = getLeftCol(6);
			int[] f5 = getLeftCol(5);
			setLeftCol(1,f3);
			setLeftCol(3,f6);
			setLeftCol(6,f5);
			setLeftCol(5,f1);
			rotate90(2);
		}
		else {
			int[] f1 = getLeftCol(1);
			int[] f3 = getLeftCol(3);
			int[] f6 = getLeftCol(6);
			int[] f5 = getLeftCol(5);
			setLeftCol(1,f3);
			setLeftCol(3,f6);
			setLeftCol(6,f5);
			setLeftCol(5,f1);
			rotate90(2);
		}
	}
	public void topRight(int face) {
		if(face == 1) {
			int[] f1 = getTopRow(1);
			int[] f4 = getRTopRow(4);
			int[] f6 = getRBottomRow(6);
			int[] f2 = getTopRow(2);
			setTopRow(1,f2);
			setTopRow(4,f1);
			setBottomRow(6,f4);
			setTopRow(2,f6);
			rotateNeg90(3);
		}
		else if(face == 2) {
			int[] f1 = getTopRow(1);
			int[] f4 = getRTopRow(4);
			int[] f6 = getRBottomRow(6);
			int[] f2 = getTopRow(2);
			setTopRow(1,f2);
			setTopRow(4,f1);
			setBottomRow(6,f4);
			setTopRow(2,f6);
			rotateNeg90(3);
		}
		else if(face == 3) {
			rightDown(4);
			rotateNeg90(6);
		}
		else if(face == 4) {
			int[] f1 = getTopRow(1);
			int[] f4 = getRTopRow(4);
			int[] f6 = getRBottomRow(6);
			int[] f2 = getTopRow(2);
			setTopRow(1,f2);
			setTopRow(4,f1);
			setBottomRow(6,f4);
			setTopRow(2,f6);
			rotateNeg90(3);
		}
		else if(face == 5) {
			rightDown(2);
			rotateNeg90(1);
		}
		else {
			/*
			int[] f1 = getTopRow(1);
			int[] f4 = getTopRow(4);
			int[] f6 = getTopRow(6);
			int[] f2 = getTopRow(2);
			setTopRow(1,f2);
			setTopRow(4,f1);
			setTopRow(6,f4);
			setTopRow(2,f6);*/
			bottomLeft(4);
			rotateNeg90(5);
		}
	}
	public void bottomRight(int face) {
		if(face == 1) {
			int[] f1 = getBottomRow(1);
			int[] f4 = getRBottomRow(4);
			int[] f6 = getRTopRow(6);
			int[] f2 = getBottomRow(2);
			setBottomRow(1,f2);
			setBottomRow(4,f1);
			setTopRow(6,f4);
			setBottomRow(2,f6);
			rotate90(5);
		}
		else if(face == 2) {
			int[] f1 = getBottomRow(1);
			int[] f4 = getRBottomRow(4);
			int[] f6 = getRTopRow(6);
			int[] f2 = getBottomRow(2);
			setBottomRow(1,f2);
			setBottomRow(4,f1);
			setTopRow(6,f4);
			setBottomRow(2,f6);
			rotate90(5);
		}
		else if(face == 3) {
			leftDown(4);
			rotate90(1);
		}
		else if(face == 4) {
			int[] f1 = getBottomRow(1);
			int[] f4 = getRBottomRow(4);
			int[] f6 = getRTopRow(6);
			int[] f2 = getBottomRow(2);
			setBottomRow(1,f2);
			setBottomRow(4,f1);
			setTopRow(6,f4);
			setBottomRow(2,f6);
			rotate90(5);
		}
		else if(face == 5) {
			leftDown(2);
			rotateNeg90(6);
		}
		else {
			topLeft(4);
			rotate90(3);
		}
	}
	public void topLeft(int face) {
		if(face == 1) {
			int[] f1 = getTopRow(1);
			int[] f2 = getRTopRow(2);
			int[] f6 = getRBottomRow(6);
			int[] f4 = getTopRow(4);
			setTopRow(1,f4);
			setTopRow(2,f1);
			setBottomRow(6,f2);
			setTopRow(4,f6);
			rotate90(3);
		}
		else if(face == 2) {
			int[] f1 = getTopRow(1);
			int[] f2 = getRTopRow(2);
			int[] f6 = getRBottomRow(6);
			int[] f4 = getTopRow(4);
			setTopRow(1,f4);
			setTopRow(2,f1);
			setBottomRow(6,f2);
			setTopRow(4,f6);
			rotate90(3);
		}
		else if(face == 3) {
			leftDown(2);
			//i think
			rotate90(6);
		}
		else if(face == 4) {
			int[] f1 = getTopRow(1);
			int[] f2 = getRTopRow(2);
			int[] f6 = getRBottomRow(6);
			int[] f4 = getTopRow(4);
			setTopRow(1,f4);
			setTopRow(2,f1);
			setBottomRow(6,f2);
			setTopRow(4,f6);
			rotate90(3);
		}
		else if(face == 5) {
			rightUp(2);
			rotate90(1);
		}
		else {
			bottomRight(2);
			//i think
			rotate90(5);
		}
	}
	public void bottomLeft(int face) {
		if(face == 1) {
			int[] f1 = getBottomRow(1);
			int[] f2 = getRBottomRow(2);
			int[] f6 = getRTopRow(6);
			int[] f4 = getBottomRow(4);
			setBottomRow(1,f4);
			setBottomRow(2,f1);
			setTopRow(6,f2);
			setBottomRow(4,f6);
			rotateNeg90(5);
		}
		else if(face == 2) {
			int[] f1 = getBottomRow(1);
			int[] f2 = getRBottomRow(2);
			int[] f6 = getRTopRow(6);
			int[] f4 = getBottomRow(4);
			setBottomRow(1,f4);
			setBottomRow(2,f1);
			setTopRow(6,f2);
			setBottomRow(4,f6);
			rotateNeg90(5);
		}
		else if(face == 3) {
			rightDown(2);
			rotateNeg90(1);
		}
		else if(face == 4) {
			int[] f1 = getBottomRow(1);
			int[] f2 = getRBottomRow(2);
			int[] f6 = getRTopRow(6);
			int[] f4 = getBottomRow(4);
			setBottomRow(1,f4);
			setBottomRow(2,f1);
			setTopRow(6,f2);
			setBottomRow(4,f6);
			rotateNeg90(5);
		}
		else if(face == 5) {
			leftUp(2);
			//i think
			rotateNeg90(6);
		}
		else {
			/*int[] f1 = getBottomRow(1);
			int[] f2 = getBottomRow(2);
			int[] f6 = getBottomRow(6);
			int[] f4 = getBottomRow(4);
			setBottomRow(1,f4);
			setBottomRow(2,f1);
			setBottomRow(6,f2);
			setBottomRow(4,f6);
			*/
			topRight(4);
			rotateNeg90(3);
		}
	}
	public void rotate90(int face) {
		//rotates the face 90 degrees based on the way the face is oriented, 90 would be turning red right once
		int[] f = faces[face-1];
		int[] fnew = new int[9];
		fnew[0] = f[6];
		fnew[1] = f[3];
		fnew[2] = f[0];
		fnew[3] = f[7];
		fnew[4] = f[4];
		fnew[5] = f[1];
		fnew[6] = f[8];
		fnew[7] = f[5];
		fnew[8] = f[2];
		faces[face-1] = fnew;
	}
	public void rotateNeg90(int face) {
		//rotates the face -90 degrees based on the way the face is oriented, -90 would be turning red left once
		int[] f = faces[face-1];
		int[] fnew = new int[9];
		fnew[0] = f[2];
		fnew[1] = f[5];
		fnew[2] = f[8];
		fnew[3] = f[1];
		fnew[4] = f[4];
		fnew[5] = f[7];
		fnew[6] = f[0];
		fnew[7] = f[3];
		fnew[8] = f[6];
		faces[face-1] = fnew;
	}
	public void F(int face) {
		if(face == 1) {
			leftDown(4);
		}
		else if(face == 2) {
			leftDown(1);
		}
		else if(face == 3) {
			topLeft(1);
		}
		else if(face == 4) {
			rightUp(1);
		}
		else if(face == 5) {
			bottomRight(1);
		}
		else {
			rightUp(4);
		}
	}
	public void FPrime(int face) {
		if(face == 1) {
			leftUp(4);
		}
		else if(face==2) {
			leftUp(1);
		}
		else if(face==3) {
			topRight(1);
		}
		else if(face==4) {
			rightDown(1);
		}
		else if(face==5) {
			bottomLeft(1);
		}
		else {
			rightDown(4);
		}
	}
	public void B(int face) {
		if(face==1) {
			rightUp(4);
		}
		else if(face==2) {
			rightUp(1);
		}
		else if(face==3) {
			bottomRight(1);
		}
		else if(face==4) {
			leftDown(2);
		}
		else if(face==5) {
			topLeft(1);
		}
		else {
			leftDown(4);
		}
	}
	public void BPrime(int face) {
		if(face==1) {
			rightDown(2);
		}
		else if(face==2) {
			rightDown(1);
		}
		else if(face==3) {
			bottomLeft(1);
		}
		else if(face==4) {
			leftUp(2);
		}
		else if(face==5) {
			topRight(1);
		}
		else {
			leftUp(4);
		}
	}
	public void randomize() {
		int move = (int)(Math.random()*8);
		int face = (int)(Math.random()*6);
		if(move == 0) {
			//System.out.println("rightUp, face: "+face);
			rightUp(face);
		}
		else if(move == 1) {
			//System.out.println("leftUp, face: "+face);
			leftUp(face);
		}
		else if(move == 2) {
			//System.out.println("rightDown, face: "+face);
			rightDown(face);
		}
		else if(move == 3) {
			//System.out.println("leftDown, face: "+face);
			leftDown(face);
		}
		else if(move == 4) {
			//System.out.println("topRight, face: "+face);
			topRight(face);
		}
		else if(move == 5){
			//System.out.println("bottomRight, face: "+face);
			bottomRight(face);
		}
		else if(move == 6) {
			//System.out.println("topLeft, face: "+face);
			topLeft(face);
		}
		else if(move ==7) {
			//System.out.println("bottomLeft, face: "+face);
			bottomLeft(face);
		}
	}
	public void randomize(int amount){
		for(int i=0;i<amount;i++) {
			//Thread.sleep(100);
			randomize();
		}
	}
	public void printCube() {
		//System.out.println(faces.length);
		for(int i = 0; i < faces.length;i++) {
			for(int j = 0; j < faces[i].length;j++) {
				System.out.print(faces[i][j]+ " ");
				if((j+1)%3==0) {
					System.out.println();
				}
			}
			System.out.println();
		}
	}
	public Color getSpotColor(int spot) {
		if(spot == 1) {
			return Color.RED;
		}
		else if(spot == 2) {
			return Color.GREEN;
		}
		else if(spot == 3) {
			return Color.WHITE;
		}
		else if(spot == 4) {
			return Color.BLUE;
		}
		else if(spot == 5) {
			return Color.YELLOW;
		}
		else {
			return Color.ORANGE;
		}
	}
	public void printTotals() {
		int red = 0;
		int green = 0;
		int white =0;
		int blue = 0;
		int yellow = 0;
		int orange = 0;
		for(int i = 0;i < faces.length;i++) {
			for(int j = 0; j < faces[0].length;j++) {
				if(faces[i][j]==1) {
					red++;
				}
				else if(faces[i][j]==2) {
					green++;
				}
				else if(faces[i][j]==3) {
					white++;
				}
				else if(faces[i][j]==4) {
					blue++;
				}
				else if(faces[i][j]==5) {
					yellow++;
				}
				else {
					orange++;
				}
			}
		}
		System.out.println("===============");
		System.out.println("red: " + red);
		System.out.println("green: " + green);
		System.out.println("white: " + white);
		System.out.println("blue: " + blue);
		System.out.println("yellow: " + yellow);
		System.out.println("orange: " + orange);
		System.out.println("===============");
	}
	//checks to make sure that pieces maintain their states ex: (corner piece remains a corner piece)
	//should be 4 corner, 4 edges, 1 center for each color
	public void checkForContinuity() {
		int redCorner = 0;
		int greenCorner = 0;
		int whiteCorner = 0;
		int blueCorner = 0;
		int yellowCorner = 0;
		int orangeCorner = 0;
		
		int redEdge = 0;
		int greenEdge = 0;
		int whiteEdge = 0;
		int blueEdge = 0;
		int yellowEdge = 0;
		int orangeEdge = 0;
		
		int redCenter = 0;
		int greenCenter = 0;
		int whiteCenter = 0;
		int blueCenter = 0;
		int yellowCenter = 0;
		int orangeCenter = 0;
		for(int i = 0; i < faces.length;i++) {
			for(int j = 0; j<faces[0].length;j++) {
				if(j==0) {
					if(faces[i][0]==1) {
						redCorner++;
					}
					else if(faces[i][0]==2) {
						greenCorner++;
					}
					else if(faces[i][0]==3) {
						whiteCorner++;
					}
					else if(faces[i][0]==4) {
						blueCorner++;
					}
					else if(faces[i][0]==5) {
						yellowCorner++;
					}
					else {
						orangeCorner++;
					}
				}
				else if(j==1) {
					if(faces[i][1]==1) {
						redEdge++;
					}
					else if(faces[i][1]==2) {
						greenEdge++;
					}
					else if(faces[i][1]==3) {
						whiteEdge++;
					}
					else if(faces[i][1]==4) {
						blueEdge++;
					}
					else if(faces[i][1]==5) {
						yellowEdge++;
					}
					else {
						orangeEdge++;
					}
				}
				else if(j==2) {
					if(faces[i][2]==1) {
						redCorner++;
					}
					else if(faces[i][2]==2) {
						greenCorner++;
					}
					else if(faces[i][2]==3) {
						whiteCorner++;
					}
					else if(faces[i][2]==4) {
						blueCorner++;
					}
					else if(faces[i][2]==5) {
						yellowCorner++;
					}
					else {
						orangeCorner++;
					}
				}
				else if(j==3) {
					if(faces[i][3]==1) {
						redEdge++;
					}
					else if(faces[i][3]==2) {
						greenEdge++;
					}
					else if(faces[i][3]==3) {
						whiteEdge++;
					}
					else if(faces[i][3]==4) {
						blueEdge++;
					}
					else if(faces[i][3]==5) {
						yellowEdge++;
					}
					else {
						orangeEdge++;
					}
				}
				else if(j==4) {
					if(faces[i][4]==1) {
						redCenter++;
					}
					else if(faces[i][4]==2) {
						greenCenter++;
					}
					else if(faces[i][4]==3) {
						whiteCenter++;
					}
					else if(faces[i][4]==4) {
						blueCenter++;
					}
					else if(faces[i][4]==5) {
						yellowCenter++;
					}
					else {
						orangeCenter++;
					}
				}
				else if(j==5) {
					if(faces[i][5]==1) {
						redEdge++;
					}
					else if(faces[i][5]==2) {
						greenEdge++;
					}
					else if(faces[i][5]==3) {
						whiteEdge++;
					}
					else if(faces[i][5]==4) {
						blueEdge++;
					}
					else if(faces[i][5]==5) {
						yellowEdge++;
					}
					else {
						orangeEdge++;
					}
				}
				else if(j==6) {
					if(faces[i][6]==1) {
						redCorner++;
					}
					else if(faces[i][6]==2) {
						greenCorner++;
					}
					else if(faces[i][6]==3) {
						whiteCorner++;
					}
					else if(faces[i][6]==4) {
						blueCorner++;
					}
					else if(faces[i][6]==5) {
						yellowCorner++;
					}
					else {
						orangeCorner++;
					}
				}
				else if(j==7) {
					if(faces[i][7]==1) {
						redEdge++;
					}
					else if(faces[i][7]==2) {
						greenEdge++;
					}
					else if(faces[i][7]==3) {
						whiteEdge++;
					}
					else if(faces[i][7]==4) {
						blueEdge++;
					}
					else if(faces[i][7]==5) {
						yellowEdge++;
					}
					else {
						orangeEdge++;
					}
				}
				else if(j==8) {
					if(faces[i][8]==1) {
						redCorner++;
					}
					else if(faces[i][8]==2) {
						greenCorner++;
					}
					else if(faces[i][8]==3) {
						whiteCorner++;
					}
					else if(faces[i][8]==4) {
						blueCorner++;
					}
					else if(faces[i][8]==5) {
						yellowCorner++;
					}
					else {
						orangeCorner++;
					}
				}
			}
		}
		System.out.println("===========");
		System.out.println("redCorner: " + redCorner + "redEdge: "+redEdge+"redCenter: "+redCenter);
		System.out.println("greenCorner: " + greenCorner + "greenEdge: "+greenEdge+"greenCenter: "+greenCenter);
		System.out.println("whiteCorner: " + whiteCorner + "whiteEdge: "+whiteEdge+"whiteCenter: "+whiteCenter);
		System.out.println("blueCorner: " + blueCorner + "blueEdge: "+blueEdge+"blueCenter: "+blueCenter);
		System.out.println("yellowCorner: " + yellowCorner + "yellowEdge: "+yellowEdge+"yellowCenter: "+yellowCenter);
		System.out.println("orangeCorner: " + orangeCorner + "orangeEdge: "+orangeEdge+"orangeCenter: "+orangeCenter);
	}
	public ArrayList<Drawable> getFaceArray(int face) {
		ArrayList<Drawable> temp = new ArrayList<Drawable>();
		for(int i = 0; i < 9;i++) {
			if(i < 3) {
				temp.add(new TextBox(150+i*100,125,100,100,"",getSpotColor(faces[face][i]),i+1));
			}
			else if(i > 2 && i < 6) {
				temp.add(new TextBox(150+((i-3)*100),225,100,100,"",getSpotColor(faces[face][i]),i+1));
			}
			else {
				temp.add(new TextBox(150+((i-6)*100),325,100,100,"",getSpotColor(faces[face][i]),i+1));
			}
		}
		return temp;
	}
	public boolean checkSolved() {
		boolean k = true;
		for(int i = 0;i < faces.length;i++) {
			for(int j = 0; j < faces[0].length;j++) {
				if(faces[i][j] != i+1) {
					k = false;
				}
			}
		}
		return k;
	}
	public void randSolve() {
		int count = 0;
		while(!checkSolved()) {
			randomize();
			count++;
			if(count%10000000 == 0) {
				System.out.println(count);
			}
		}
		System.out.println("moves to solve: " + count);
	}
	public boolean checkWhiteCross() {
		boolean k = true;
		if(faces[2][1] != 3 || faces[2][3] != 3 || faces[2][5] != 3 ||faces[2][7] != 3|| faces[2][0] != 3|| faces[2][2] != 3|| faces[2][6] != 3|| faces[2][8] != 3) {
			k = false;
		}
		if(faces[0][1] != 1 || faces[1][1] != 2 || faces[3][1] != 4 || faces[5][7] != 6) {
			k = false;
		}
		return k;
	}
	public void randWhiteCrossSolve() {
		int count = 0;
		while(!checkWhiteCross()) {
			randomize();
			count++;
			if(count%10000000 == 0) {
				System.out.println(count);
			}
		}
		System.out.println("moves to solve: " + count);
	}
	public boolean checkWhiteCorners() {
		boolean k = true;
		if(faces[2][0] != 3|| faces[2][2] != 3|| faces[2][6] != 3|| faces[2][8] != 3) {
			k = false;
		}
		/*if(faces[0][0] != 1 || faces[0][2] != 1 || faces[1][0] != 2|| faces[1][2] != 2 || faces[3][0] != 4|| faces[3][2] != 4 || faces[5][6] != 6|| faces[5][8] != 6) {
			k = false;
		}*/
		return k;
	}
	public void randWhiteCornersSolve() {
		int count = 0;
		randWhiteCrossSolve();
		/*while(!checkWhiteCorners()) {
			randomize();
			count++;
			if(count%10000000 == 0) {
				System.out.println(count);
			}
		}*/
		System.out.println("moves to solve: " + count);
	}
	public void reset() {
		int[][] faces = new int[6][9];
		//faces 0 = face 1 is red and 1 represent red
		faces[0] = new int[] {1,1,1,1,1,1,1,1,1};
		//faces 1 = face 2 is green and 2 represents green
		faces[1] = new int[] {2,2,2,2,2,2,2,2,2};
		//faces 2 = face 3 is wihte and 3 represents white
		faces[2] = new int[] {3,3,3,3,3,3,3,3,3};
		//faces 3 = face 4 is blue and 4 represents blue
		faces[3] = new int[] {4,4,4,4,4,4,4,4,4};
		//faces 4 = face 5 is yellow and 5 represents yellow
		faces[4] = new int[] {5,5,5,5,5,5,5,5,5};
		//faces 5 = face 6 is orange and 6 represents orange
		faces[5] = new int[] {6,6,6,6,6,6,6,6,6};
		this.faces = faces;
	}
}
