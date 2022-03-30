package demo;

import java.util.Scanner;

public class mainClass {
	   public static void drawField(byte[][] map) {
		   for(int i = 0; i < 3; i++){
	  	          for(int j = 0; j < 3; j++){
	  	            switch(map[i][j]){
	  	              case 0:
	  	                System.out.print(" 0 ");
	  	                break;
	  	              case 1:
	  	                System.out.print(" X ");
	  	                break;
	  	              case 2:
	  	                System.out.print("   ");
	  	                break; 
	  	            }
	  	            if(j!=2)
	  	              System.out.print("|");
	  	          }
	  	           System.out.println("");
	  	           if(i!=2)
	  	        	   System.out.println("-----------");
	  	       
	  	        }
	   }
	   public static void main(String[] args) {
		   Scanner in = new Scanner(System.in);
	        byte map[][] = new byte[3][3];
	        for(int i = 0; i < 3; i++){
	          for(int j = 0; j < 3; j++)
	            map[i][j] = 2;
	        }
	        boolean end = false;
	        System.out.println("What do you want to play? \nEnter 0 or X");
	        char playerSymb = in.next().charAt(0);
	        byte playerChose;
	        if(playerSymb == '0') {
	        	map[(int) ((Math.random()*100)%3)][(int) ((Math.random()*100)%3)] = 1;
	        	playerChose = 0;
	        }else
	        	playerChose = 1;
	        	
	        while(!end) {
	        	//Drawing field
	        	drawField(map);
	        	//Player turn
	        	boolean chose = false;
	        	while(!chose) {
	        		System.out.println("Your turn. Enter index of cell index from 0 to 2 (first row, then col): ");
		        	byte row = in.nextByte();
		        	byte col = in.nextByte();
		        	if(map[row][col]==2) {
		        		map[row][col] = playerChose;
		        		chose = true;
		        	}
		        	else
		        		System.out.println("It is already picked, choose another one: ");
	        	}
	        	
	        	//Checking for end of game
	        	for(int i = 0; i <3; i++) {
	        		if(map[i][0]==map[i][1] && map[i][1]==map[i][2] && map[i][0]!=2) {
	        			end = true;
	        			if(map[i][0]==playerChose){
	        				System.out.println("You win!");
	        				drawField(map);
	        			}else {
	        				System.out.println("You lose!");
	        				drawField(map);
	        			}
	        				
	        			i=3;
	        		} else if(map[0][i]==map[1][i] && map[1][i]==map[2][i] && map[0][i]!=2) {
	        			end = true;
	        			if(map[0][i]==playerChose) {
	        				System.out.println("You win!");
	        				drawField(map);
	        			}else {
	        				System.out.println("You lose!");
	        				drawField(map);
	        			}
	        				
	        			i=3;
	        		}
	        	}
	        	if(((map[0][0]==map[1][1]&&map[1][1]==map[2][2]) || (map[0][2]==map[1][1]&& map[2][0]==map[1][1]))&&map[1][1]!=2) {
	        		end = true;
        			if(map[1][1]==playerChose) {
        				System.out.println("You win!");
        				drawField(map);
        			}else {
        				System.out.println("You lose!");
        				drawField(map);
        			}	
	        	}
	        	if(!end) {
	        		end = true;
		        	for(int i=0;i<3 && end;i++) {
		        		for(int j = 0; j < 3 && end; j++) {
		        			if(map[i][j]==2)
		        				end = false;
		        		}
		        	}
		        	if(!end) {
		        		//Computer turn
			        	chose = false;
			        	while(!chose) {
			        		byte row = (byte) ((Math.random()*100)%3);
			        		byte col = (byte) ((Math.random()*100)%3);
			        		if(map[row][col] == 2) {
			        			chose = true;
			        			if(playerSymb == '0')
						        	map[row][col] = 1;
						        else
						        	map[row][col] = 0;
			        		}
			        	}
			        	
			        	
			        	//Checking for end of game
			        	for(int i = 0; i <3; i++) {
			        		if(map[i][0]==map[i][1] && map[i][1]==map[i][2] && map[i][0]!=2) {
			        			end = true;
			        			if(map[i][0]==playerChose) {
			        				System.out.println("You win!");
			        				drawField(map);
			        			}else {
			        				System.out.println("You lose!");
			        				drawField(map);
			        			}	
			        			i=3;
			        		} else if(map[0][i]==map[1][i] && map[1][i]==map[2][i] && map[0][i]!=2) {
			        			end = true;
			        			if(map[0][i]==playerChose) {
			        				System.out.println("You win!");
			        				drawField(map);
			        			}else {
			        				System.out.println("You lose!");
			        				drawField(map);
			        			}
			        			i=3;
			        		}
			        	}
			        	if(((map[0][0]==map[1][1]&&map[1][1]==map[2][2]) || (map[0][2]==map[2][2]&& map[2][0]==map[2][2]))&&map[2][2]!=2) {
			        		end = true;
		        			if(map[2][2]==playerChose) {
		        				System.out.println("You win!");
		        				drawField(map);
		        			}else {
		        				System.out.println("You lose!");
		        				drawField(map);
		        			}
			        	}
			        	if(!end) {
			        		end = true;
				        	for(int i=0;i<3 && end;i++) {
				        		for(int j = 0; j < 3 && end; j++) {
				        			if(map[i][j]==2)
				        				end = false;
				        				
				        		}
				        	}
				        	if(end) {
				        		System.out.println("Draw!");
				        		drawField(map);
				        	}
			        	}
			        	
		        	}else {
		        		System.out.println("Draw!");
		        		drawField(map);
		        	}
	        	
	        	
	        }
	       
	    }
	     in.close(); 
}
}
