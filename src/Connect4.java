import java.util.Random;
import java.util.Scanner;

public class Connect4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int Rows = 6;
		int Columns = 7;
		char[][] c = new char[Rows][Columns];
		for (int i = 0; i < Rows; i++) {
			for (int j = 0; j < Columns; j++) {
				c[i][j] = ' ';
			}
		}

		System.out.println("Welcome to connect4");
		System.out.println("Select game type");
		System.out.println("Enter 1 for \"Player vs. Computer\"");
		System.out.println("Enter 2 for \"Player vs. Player\"");
		System.out.println("Starting game");
		System.out.println("");
		int choos_player = 0;
		while (true) {
			choos_player = input.nextInt();
			if (choos_player == 1 || choos_player == 2) {
				break;
			} else {
				System.out.println("plz enter 1 or 2");
			}

		}

		// System.out.println("Starting game");
		// if (choos_player == 1) {
		// ///>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>PLAYER1
		// TOOOO COMPUTER
		while (true) {
			int prs = 0;
			// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>PLAYER1
			
			while (true) {
				System.out.print("Player 1: ");
				prs = input.nextInt();
				if (prs > 0 && prs < 8) {
					prs = prs - 1;
					break;
				} else {
					System.out.println("Invalid place, play again");
				}
			}
			if (c[0][prs] != ' ') {
				System.out.println("Invalid place, play again");
				continue;
			}

			for (int i = Rows - 1; i >= 0; i--) {
				if (c[i][prs] == ' ') {
					c[i][prs] = 'X';
					break;
				}

			}
			// >>>>>>>>>>>>PRINT TABEL
			for (int i = 1; i < 8; i++) {
				System.out.print(" " + i + " |");
			}
			System.out.println("");
			for (int i = 0; i < Rows; i++) {
				for (int j = 0; j < Columns; j++) {
					System.out.print(" " + c[i][j] + " |");
				}
				System.out.println("");
			}
			// >>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
			// Testing Winner
			//
			// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.Horizontal
			int tstew1 = 0;
			for (int i = Rows - 1; i >= 0; i--) {
				tstew1 = 0;
				for (int j = 0; j < Columns; j++) {
					if (c[i][j] == 'X') {
						tstew1++;
					} else if (tstew1 >= 4) {
						break;
					} else {
						tstew1 = 0;
					}
				}
				if (tstew1 >= 4) {

					break;
				}
				
			}
			if (tstew1 >= 4) {
				System.out.println("\n" + "Player 1 is the Winner!");
				break;
			}
			tstew1 = 0;
			// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.Vertical
			for (int i = Columns - 1; i >= 0; i--) {
				tstew1 = 0;
				for (int j = 0; j < Rows; j++) {
					if (c[j][i] == 'X') {
						tstew1++;
					} else if (tstew1 >= 4) {
						break;
					} else {
						tstew1 = 0;
					}
				}
				if (tstew1 >= 4) {

					break;
				}
				
			}
			if (tstew1 >= 4) {
				System.out.println("\n" + "Player 1 is the Winner!");
				break;
			}
			// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>diagona
			// >>>>>>>>>>>>>>>>>>>>>>>>>about rows
			// .....
			int tstew_1d1 = 0;
			int tstew_1d2 = 0;
			int tstew_d1 = 0;
			int tstew_d2 = 0;
			for (int i = 0; i < Rows; i++) {
				int z = i;
				if (i < Rows / 2) {
					
					
					for (int j = 0; j < Rows - i; j++, z++) { // or condition is
																// z < rows
						if (c[z][j] == 'X') {
							tstew_1d1++;
						} else if (tstew_d1 >= 4) {
							break;
						} else {
							tstew_1d1 = 0;
						}
					}
				} else if (i >= Rows / 2) {
					
					for (int j = 0; z >= 0; j++, z--) {
						if (c[z][j] == 'X') {
							tstew_1d2++;
						} else if (tstew_d2 >= 4) {
							break;
						} else {
							tstew_1d2 = 0;
						}
					}
				}
				
			}
			if (tstew_1d2 >= 4 || tstew_1d1 >= 4) {
				System.out.println("\n" + "Player 1 is the Winner!");
				break;
			}
			// >>>>>>>>>>>>>>>>>>>>>about Columns
			tstew_d1 = 0;
			tstew_d2 = 0;
			for (int i = 1; i <= 3; i++) { // or i < rows/2
				int z = i;
				
				for (int j = 0; z < Columns; j++, z++) {
					if (c[j][z] == 'X') {
						tstew_d1++;
					} else if (tstew_d1 >= 4) {
						break;
					} else {
						tstew_d1 = 0;
					}
				}
				
			}
			// >>>>> next step
			tstew_d2 = 0;
			for (int i = 0; i < Rows / 2; i++) {
				int test =0 ;
				int z = i;
				
				for (int j = Rows; z < Rows; j--, z++) {

					if (c[z][j] == 'X') {
						test++;
					} else if (test >= 4) {
						tstew_d2 = test;
						break;
					} else {
						test = 0;
					}
				}
				
			}

			if (tstew_d2 >= 4 || tstew_d1 >= 4) {
				System.out.println("\n" + "Player 1 is the Winner!");
				break;
			}
			System.out.println("");
			// .....
			if (choos_player == 1) {
				// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>COMPUTER
				// PLAYER
				System.out.println("Computer: ");
				// >>>>>>>>>>>>>>codeing to computer thenk
				// int cumthenk = 0;
				// int toprs =0 ;
				// for (int i = Rows - 1; i >= 0; i--) {
				// for (int j = 0; j < Columns; j++) {
				// if (c[i][j] == 'X') {
				// cumthenk++;
				// } else if (cumthenk == 3 && c[i][j] == ' ') {
				// toprs = j+1 ;
				//
				// break;
				// } else {
				// cumthenk = 0;
				// }
				// }
				// if (cumthenk == 3) {
				//
				// break;
				// }
				//
				// }
				// if(toprs>0) {
				// prs= toprs
				//
				//
				// }else
				// Random code in her
				// }

				// >>>>>>>>>>>>>>>>>>>>>>
				Random rn = new Random();

				while (true) {

					int n = 7 - 1 + 1;
					int i = rn.nextInt();
					if (i < 0) {
						i = i * -1;
					}
					i = i % n;
					prs = i;

					if (prs >= 0 && prs < 7) {
						if (c[0][prs] == ' ') {
							break;
						}
					} else {
						System.out.println("Invalid place, play again");
					}
				}

				for (int i = Rows - 1; i >= 0; i--) {
					if (c[i][prs] == ' ') {
						c[i][prs] = 'O';
						break;
					}

				}
				// >>>>>>>>>>>>>>>>>>>> PRINT TABEL
				for (int i = 1; i < 8; i++) {
					System.out.print(" " + i + " |");
				}
				System.out.println("");
				for (int i = 0; i < Rows; i++) {
					for (int j = 0; j < Columns; j++) {
						System.out.print(" " + c[i][j] + " |");
					}
					System.out.println("");
				}
				// >>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>><>>>>>>>>>><<<<<<Testing
				// Winner
				//
				// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.Horizontal
				tstew1 = 0;
				for (int i = Rows - 1; i >= 0; i--) {
					tstew1 = 0;
					for (int j = 0; j < Columns; j++) {
						if (c[i][j] == 'O') {
							tstew1++;
						} else if (tstew1 >= 4) {
							break;
						} else {
							tstew1 = 0;
						}
					}
					if (tstew1 >= 4) {

						break;
					}
					
				}
				if (tstew1 >= 4) {
					System.out.println("\n" + "Computer is winner !");
					break;
				}
				tstew1 = 0;
				// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.>>>>>>>>>>>>>>>>>>>>>>>>>>>.Vertical
				int tstevp1 =0 ;
				for (int i = Columns - 1; i >= 0; i--) {
					tstevp1 = 0;
					for (int j = 0; j < Rows; j++) {
						if (c[j][i] == 'O') {
							tstevp1++;
						} else if (tstevp1 >= 4) {
							break;
						} else {
							tstevp1 = 0;
						}
					}
					if (tstevp1 >= 4) {

						break;
					}
					
				}
				if (tstevp1 >= 4) {
					System.out.println("\n" + "Computer is winner!");
					break;
				}
				// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>diagona
				// >>>>>>>>>>>>>>>>>>>>>>>>>about rows
				// .....
				tstew_d1 = 0;
				tstew_d2 = 0;
				for (int i = 0; i < Rows; i++) {
					int z = i;
					if (i < Rows / 2) {
						
						for (int j = 0; j < Rows - i; j++, z++) { // or
																	// condition
																	// is
																	// z < rows
							if (c[z][j] == 'O') {
								tstew_d1++;
							} else if (tstew_d1 >= 4) {
								break;
							} else {
								tstew_d1 = 0;
							}
						}
					} else if (i >= Rows / 2) {
						
						for (int j = 0; z >= 0; j++, z--) {
							if (c[z][j] == 'O') {
								tstew_d2++;
							} else if (tstew_d2 >= 4) {
								break;
							} else {
								tstew_d2 = 0;
							}
						}
					}
					
				}
				if (tstew_d2 >= 4 || tstew_d1 >= 4) {
					System.out.println("\n" + "Computer is winner");
					break;
				}
				// >>>>>>>>>>>>>>>>>>>>>about Columns
				tstew_d1 = 0;
				tstew_d2 = 0;
				for (int i = 1; i <= 3; i++) { // or i < rows/2
					int z = i;
					
					for (int j = 0; z < Columns; j++, z++) {
						if (c[j][z] == 'O') {
							tstew_d1++;
						} else if (tstew_d1 >= 4) {
							break;
						} else {
							tstew_d1 = 0;
						}
					}
					
				}
				// >>>>> next step

				for (int i = 0; i < Rows / 2; i++) {
					int z = i;
					
					for (int j = Rows; z < Rows; j--, z++) {

						if (c[z][j] == 'O') {
							tstew_d2++;
						} else if (tstew_d2 >= 4) {
							break;
						} else {
							tstew_d2 = 0;
						}
					}
					
				}

				if (tstew_d2 >= 4 || tstew_d1 >= 4) {
					System.out.println("\n" + "Computer is winner!");
					break;
				}

				System.out.println("");

				// //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>PLAYER1
				// TOOO PLAYER2

				// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>PLAYER2
			} else if (choos_player == 2) {
				System.out.print("Player 2: ");
				while (true) {
					prs = input.nextInt();
					prs = prs - 1;
					if (prs >= 0 && prs < 7) {
						if (c[0][prs] == ' ') {
							break;
						}else {
							System.out.println("Invalid place, play again");
							System.out.print("Player 2: ");
						}
					} else {
						System.out.println("Invalid place, play again");
						System.out.print("Player 2: ");
					}
				}

				for (int i = Rows - 1; i >= 0; i--) {
					if (c[i][prs] == ' ') {
						c[i][prs] = 'O';
						break;
					}

				}
				// >>>>>>>>>>>>>>>>>>>> PRINT TABEL
				for (int i = 1; i < 8; i++) {
					System.out.print(" " + i + " |");
				}
				System.out.println("");
				for (int i = 0; i < Rows; i++) {
					for (int j = 0; j < Columns; j++) {
						System.out.print(" " + c[i][j] + " |");
					}
					System.out.println("");
				}
				// >>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>><>>>>>>>>>><<<<<<Testing
				// Winner
				//
				// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.Horizontal
				tstew1 = 0;
				for (int i = Rows - 1; i >= 0; i--) {
					tstew1 = 0;
					for (int j = 0; j < Columns; j++) {
						if (c[i][j] == 'O') {
							tstew1++;
						} else if (tstew1 >= 4) {
							break;
						} else {
							tstew1 = 0;
						}
					}
					if (tstew1 >= 4) {

						break;
					}
					
				}
				if (tstew1 >= 4) {
					System.out.println("\n" + "Player 2 is the Winner!");
					break;
				}
				tstew1 = 0;
				// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.>>>>>>>>>>>>>>>>>>>>>>>>>>>.Vertical
				int tstev =0 ;
				for (int i = Columns - 1; i >= 0; i--) {
					 tstev =0 ;
					for (int j = 0; j < Rows; j++) {
						if (c[j][i] == 'O') {
							tstev++;
						} else if (tstev >= 4) {
							break;
						} else {
							tstev = 0;
						}
					}
					if (tstev >= 4) {

						break;
					}
					
				}
				if (tstev >= 4) {
					System.out.println("\n" + "Player 2 is the Winner!");
					break;
				}
				tstev= 0 ;
				// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>diagona
				// >>>>>>>>>>>>>>>>>>>>>>>>>about rows
				// .....
				tstew_d1 = 0;
				tstew_d2 = 0;
				tstew_1d1 = 0;
				tstew_1d2 = 0;
				for (int i = 0; i < Rows; i++) {
					int z = i;
					if (i < Rows / 2) {
						
						for (int j = 0; z < Rows; j++, z++) { // or
																// condition
																// is
																// z < rows
							if (c[z][j] == 'O') {
								tstew_1d1++;
							} else if (tstew_d1 >= 4) {
								break;
							} else {
								tstew_1d1 = 0;
							}
						}
					} else if (i >= Rows / 2) {
						
						for (int j = 0; z >= 0; j++, z--) {
							if (c[z][j] == 'O') {
								tstew_1d2++;
							} else if (tstew_1d2 >= 4) {
								break;
							} else {
								tstew_1d2 = 0;
							}
						}
					}
					
				}
				if (tstew_1d2 >= 4 || tstew_1d1 >= 4) {
					System.out.println("\n" + "Player 2 is the Winner!");
					break;
				}
				// >>>>>>>>>>>>>>>>>>>>>about Columns
				tstew_d1 = 0;
				tstew_d2 = 0;
				for (int i = 1; i <= 3; i++) { // or i < rows/2
					int z = i;
					
					for (int j = 0; z < Columns; j++, z++) {
						if (c[j][z] == 'O') {
							tstew_d1++;
						} else if (tstew_d1 >= 4) {
							break;
						} else {
							tstew_d1 = 0;
						}
					}
					
				}
				// >>>>> next step

				for (int i = 0; i < Rows / 2; i++) {
					int z = i;
					
					for (int j = Rows; z < Rows; j--, z++) {

						if (c[z][j] == 'O') {
							tstew_d2++;
						} else if (tstew_d2 >= 4) {
							break;
						} else {
							tstew_d2 = 0;
						}
					}
					
				}

				if (tstew_d2 >= 4 || tstew_d1 >= 4) {
					System.out.println("\n" + "Player 2 is the Winner!");
					break;
				}
				System.out.println("");
			}
			 int equivalent =0 ;
			 for (int i = 0; i < Columns ; i++) {
				if (c[0][i] == ' ') {
					equivalent++ ;
				}
				
			}
			 if (equivalent==0) {
				System.out.println("Draw!");
				break;
			}
		}
	}
}