package myPet;

import java.util.Scanner;

public class InputMismatch {
	
	static Scanner scan = new Scanner(System.in);
	public static int inputMismatchOToSix(int aniNum){
		
		String aniNumStr = scan.next();
		
		while(true){
			try{
				aniNum=Integer.parseInt(aniNumStr);
				if (aniNum != 0 && aniNum != 1 && aniNum != 2 && aniNum != 3 && aniNum != 4 && aniNum != 5
						&& aniNum != 6) {
					System.out.println("Pls choose number from 0 to 6, try again");
					aniNumStr =scan.next();
					continue;
				}
				break;
			}catch(Exception e){
				System.out.println("Pls choose number from 0 to 6, try again");
				aniNumStr =scan.next();
			}
		}
		
		return aniNum;
	}
	
	public static int inputMismatchOneToSix(int aniNum){
		
	
		String aniNumStr = scan.next();
		
		while(true){
			try{
				aniNum=Integer.parseInt(aniNumStr);
				if (aniNum != 1 && aniNum != 2 && aniNum != 3 && aniNum != 4 && aniNum != 5 && aniNum != 6) {
					System.out.println("Pls choose number from 1 to 6, try again");
					aniNumStr =scan.next();
					continue;
				}
				break;
			}catch(Exception e){
				System.out.println("Pls choose number from 1 to 6, try again");
				aniNumStr =scan.next();
			}
		}
		
		return aniNum;
	}

    	public static int inputMismatchOneToTwenty(int aniNum){
		
		String aniNumStr = scan.next();
		
		while(true){
			try{
				aniNum=Integer.parseInt(aniNumStr);
				if (aniNum < 1 || aniNum >20) {
					System.out.println("Pls use integer number from 1 to 20, try again");
					aniNumStr =scan.next();
					continue;
				}
				break;
			}catch(Exception e){
				System.out.println("Pls use integer number from 1 to 20, try again");
				aniNumStr =scan.next();
			}
		}
		
		return aniNum;
	}
	
	
}
