import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//System.out.println(Horus.alphaBetaMax(Horus.minf, Horus.pinf, 3));
		Scanner sc = new Scanner(System.in);
		String s;
		boolean turn = true; // true joaca alb, false joaca negru
		boolean playingas = true;
		//boolean isforced = false;
		int i = 0;
		char[][] backup_board = Internal.cloneBoard(Internal.board);
		System.out.println("feature sigint=0");
		System.out.flush();
		System.out.println("feature sigterm=0 san=0");
		System.out.flush();
		s="";
		while(true)
		{ 
			if(s.equals("new"))
			{
				Internal.cloneBoard(backup_board);
				turn = false;
				playingas = true;
				//isforced = false;
			}
			if(s.equals("xboard"))
			{
				
			}
			if (s.equals("black") || s.equals("white")) {
				i++;
			}
			if (i == 2) {
				playingas = !playingas;
				i = 0;
			}
			if (s.equals("quit")) {
				break;
			}
			if (s.equals("force")) {
				//isforced = true;
			}
			if (s.equals("go")) {
				//isforced = false;
			}
			if (ConvertMoves.isCastlingMove(s)) {
				if(s.equals("e1g1"))
				{
					Internal.board[0][4] = ' ';
					Internal.board[0][6] = 'K';
					Internal.board[0][7] = ' ';
					Internal.board[0][5] = 'R';	
				}
				if(s.equals("e1c1"))
				{
					Internal.board[0][4] = ' ';
					Internal.board[0][2] = 'K';
					Internal.board[0][0] = ' ';
					Internal.board[0][3] = 'R';	
				}
				if(s.equals("e8g8"))
				{
					Internal.board[7][4] = ' ';
					Internal.board[7][6] = 'K';
					Internal.board[7][7] = ' ';
					Internal.board[7][5] = 'R';	
				}
				if(s.equals("e8c8"))
				{
					Internal.board[7][4] = ' ';
					Internal.board[7][2] = 'K';
					Internal.board[7][0] = ' ';
					Internal.board[7][3] = 'R';	
				}
				turn = !turn;
			}
			else if (ConvertMoves.isNormalMove(s)) {
				ArrayList<Position> m = ConvertMoves.convert(s);
				char piece;
				piece = Internal.board[m.get(0).row][m.get(0).colum];
				Internal.board[m.get(0).row][m.get(0).colum] = ' ';
				Internal.board[m.get(1).row][m.get(1).colum] = piece;
				turn = !turn;
			}
			if (ConvertMoves.isPromotionMove(s)) {
				ArrayList<Position> m = ConvertMoves.convert(s);
				char piece;
				Internal.board[m.get(0).row][m.get(0).colum] = ' ';
				if(playingas == true)
				{
					Internal.board[m.get(1).row][m.get(1).colum] = s.charAt(4);
				}
				else
				{
					Internal.board[m.get(1).row][m.get(1).colum] = s.toUpperCase().charAt(4);
				}
				turn = !turn;
			}
			
			if(turn == playingas)
			{
				if(playingas == true)
				{
					System.out.println(Horus.alphaBetaMax(Horus.minf, Horus.pinf, 10));
				}
				else
				{
					System.out.println(Horus.alphaBetaMax(Horus.minf, Horus.pinf, 10));
				}
				turn = !turn;
			}
			s = sc.nextLine();
		}
	}

}
