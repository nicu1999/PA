import java.util.Stack;

public class Internal {
	Internal()
	{
		
	}
	static char[][] board={ {'R','N','B','Q','K','B','N','R'},
						  {'P','P','P','P','P','P','P','P'},
						  {' ',' ',' ',' ',' ',' ',' ',' '},
						  {' ',' ',' ',' ',' ',' ',' ',' '},
						  {' ',' ',' ',' ',' ',' ',' ',' '},
						  {' ',' ',' ',' ',' ',' ',' ',' '},
						  {'p','p','p','p','p','p','p','p'},
						  {'r','n','b','q','k','b','n','r'}};
					 /* { {' ',' ',' ',' ',' ',' ',' ',' '},
						{'P','P','P','P','P','P','P','P'},
						{' ',' ','p',' ','p',' ',' ',' '},
						{' ',' ',' ',' ',' ',' ',' ',' '},
						{' ',' ',' ',' ',' ',' ',' ',' '},
						{' ',' ','P',' ','P',' ',' ',' '},
						{'p','p','p','p','p','p','p','p'},
						{' ',' ',' ',' ',' ',' ',' ',' '}};*/
					  /* {{' ',' ',' ',' ',' ',' ',' ',' '},
						{' ',' ',' ',' ',' ',' ',' ',' '},
						{' ',' ',' ',' ',' ',' ',' ',' '},
						{' ',' ',' ',' ',' ',' ',' ',' '},
						{' ',' ',' ',' ',' ',' ',' ',' '},
						{' ',' ',' ',' ',' ',' ',' ',' '},
						{' ',' ',' ',' ',' ',' ',' ',' '},
						{' ',' ',' ',' ',' ',' ',' ',' '}};*/
	static Stack<StackElement> movehistory = new Stack<StackElement>();
	
	static boolean[][] notmoved = { 
								{true,false,false,false,true,false,false,true},
								{true, true, true, true, true, true, true, true},
								{false,false,false,false,false,false,false,false},
								{false,false,false,false,false,false,false,false},
								{false,false,false,false,false,false,false,false},
								{false,false,false,false,false,false,false,false},
								{true, true, true, true, true, true, true, true},
								{true,false,false,false,true,false,false,true},
								};
	static void printBoard()
	{
		for(int i=7; i>=0; i--)
		{	System.out.print(i+ "  ");
			for(int j=0; j<8; j++)
			{
				if(board[i][j] == ' ')
				{
					System.out.print("_ ");
				}
				else
				{
					System.out.print(board[i][j]+ " ");
				}
			}
			System.out.println();
		}
		System.out.print("   ");
		for(int i=0; i<8; i++)
		{
			System.out.print(i+ " ");
		}
		System.out.println();
	}
	static char[][] cloneBoard( char[][] from )
	{
		char[][] copy = new char[8][8];
		for(int i=0;i<8 ;i++)
		{
			for(int j = 0; j < 8 ; j++)
			{
				copy[i][j] = from[i][j];
			}
		}
		return copy;
	}
}
