public class Make {
	Position from;
	Position to;
	char type;
	
	Make(Position from, Position to, char type)
	{
		this.from = from;
		this.to = to;
		this.type = type;
	}
	
	public String toString ()
	{
		return "[" + from + " " + to + " " + type + "]";
	}
	
	static void makeMove (Make m)
	{
		if(m.type == 'm')
		{
			//System.out.println("push");
			Internal.movehistory.push(new StackElement(m, Internal.board[m.to.row][m.to.colum]));
			char piece;
			piece = Internal.board[m.from.row][m.from.colum];
			Internal.board[m.from.row][m.from.colum] = ' ';
			Internal.board[m.to.row][m.to.colum] = piece;
			Internal.notmoved[m.from.row][m.from.colum] = false;
		}
		if(m.type == 'a' && Internal.board[m.to.row][m.to.colum] != 'k' && Internal.board[m.to.row][m.to.colum] != 'K')
		{
			//System.out.println("push");
			Internal.movehistory.push(new StackElement(m, Internal.board[m.to.row][m.to.colum]));
			char piece;
			piece = Internal.board[m.from.row][m.from.colum];
			Internal.board[m.from.row][m.from.colum] = ' ';
			Internal.board[m.to.row][m.to.colum] = piece;
			Internal.notmoved[m.from.row][m.from.colum] = false;
		}
		if (m.type == 'c')
		{
			//System.out.println("push");
			if(m.to.row == 0)
			{
				if(m.to.colum == 2)
				{
					Internal.movehistory.push(new StackElement(m, Internal.board[m.to.row][m.to.colum]));
					Internal.board[m.from.row][m.from.colum] = ' ';
					Internal.board[m.to.row][m.to.colum] = 'K';
					Internal.notmoved[m.from.row][m.from.colum] = false;
					Internal.notmoved[0][0] = false;
					Internal.board[0][0] = ' ';
					Internal.board[0][3] = 'R';	
				}
				
				if(m.to.colum == 6)
				{
					Internal.movehistory.push(new StackElement(m, Internal.board[m.to.row][m.to.colum]));
					Internal.board[m.from.row][m.from.colum] = ' ';
					Internal.board[m.to.row][m.to.colum] = 'K';
					Internal.notmoved[m.from.row][m.from.colum] = false;
					Internal.notmoved[0][7] = false;
					Internal.board[0][7] = ' ';
					Internal.board[0][5] = 'R';
				}
			}
			if(m.to.row == 7)
			{
				if(m.to.colum == 2)
				{
					Internal.movehistory.push(new StackElement(m, Internal.board[m.to.row][m.to.colum]));
					Internal.board[7][4] = ' ';
					Internal.board[7][2] = 'k';
					Internal.board[7][0] = ' ';
					Internal.board[7][3] = 'r';
					Internal.notmoved[7][4] = false;
					Internal.notmoved[7][0] = false;
				}
				
				if(m.to.colum == 6)
				{
					Internal.movehistory.push(new StackElement(m, Internal.board[m.to.row][m.to.colum]));
					Internal.board[7][4] = ' ';
					Internal.board[7][6] = 'k';
					Internal.board[7][7] = ' ';
					Internal.board[7][5] = 'r';
					Internal.notmoved[7][4] = false;
					Internal.notmoved[7][7] = false;
				}
			}
		}
		if(m.type == 'p')
		{
			//System.out.println("push");
			Internal.movehistory.push(new StackElement(m, Internal.board[m.to.row][m.to.colum] , true));
			if(m.from.row == 6)
			{
				Internal.board[m.from.row][m.from.colum] = ' ';
				Internal.board[m.to.row][m.to.colum] = 'Q';
			}
			if(m.from.row == 1)
			{
				Internal.board[m.from.row][m.from.colum] = ' ';
				Internal.board[m.to.row][m.to.colum] = 'q';
			}
		}
		if(m.type == 'P')
		{
			//System.out.println("push");
			Internal.movehistory.push(new StackElement(m, Internal.board[m.to.row][m.to.colum] , true));
			if(m.from.row == 6)
			{
				Internal.board[m.from.row][m.from.colum] = ' ';
				Internal.board[m.to.row][m.to.colum] = 'Q';
			}
			if(m.from.row == 1)
			{
				Internal.board[m.from.row][m.from.colum] = ' ';
				Internal.board[m.to.row][m.to.colum] = 'q';
			}
		}
	}
	static void unMakeMove (Make m)
	{
		if(m.type == 'm')
		{
			//System.out.println("pop");
			char piece;
			piece = Internal.board[m.to.row][m.to.colum];
			Internal.board[m.to.row][m.to.colum] = ' ';
			Internal.board[m.from.row][m.from.colum] = piece;
			Internal.movehistory.pop();
		}
		if(m.type == 'a')
		{
			//System.out.println("pop");
			char piece;
			piece = Internal.board[m.to.row][m.to.colum];
			Internal.board[m.from.row][m.from.colum] = piece;
			System.out.println();
			StackElement elm = Internal.movehistory.pop();
			Internal.board[m.to.row][m.to.colum] = elm.captured;
			
		}
		if (m.type == 'c')
		{
			//System.out.println("pop");
			if(m.to.row == 0)
			{
				if(m.to.colum == 2)
				{
					Internal.board[0][0] = 'R';
					Internal.board[0][2] = ' ';
					Internal.board[0][3] = ' ';
					Internal.board[0][4] = 'K';
					Internal.notmoved[0][0] = true;
					Internal.notmoved[0][4] = true;
					StackElement elm = Internal.movehistory.pop();
				}
				
				if(m.to.colum == 6)
				{
					Internal.board[0][7] = 'R';
					Internal.board[0][6] = ' ';
					Internal.board[0][5] = ' ';
					Internal.board[0][4] = 'K';
					Internal.notmoved[0][7] = true;
					Internal.notmoved[0][4] = true;
					StackElement elm = Internal.movehistory.pop();
				}
			}
			if(m.to.row == 7)
			{
				if(m.to.colum == 2)
				{
					Internal.board[7][0] = 'r';
					Internal.board[7][2] = ' ';
					Internal.board[7][3] = ' ';
					Internal.board[7][4] = 'k';
					Internal.notmoved[7][0] = true;
					Internal.notmoved[7][4] = true;
					StackElement elm = Internal.movehistory.pop();
				}
				
				if(m.to.colum == 6)
				{
					
					Internal.board[7][7] = 'r';
					Internal.board[7][6] = ' ';
					Internal.board[7][5] = ' ';
					Internal.board[7][4] = 'k';
					Internal.notmoved[7][7] = true;
					Internal.notmoved[7][4] = true;
					StackElement elm = Internal.movehistory.pop();
				}
			}
		}
		if(m.type == 'p')
		{
			//System.out.println("pop");
			StackElement elm = Internal.movehistory.pop();
			if(m.from.row == 6)
			{
				Internal.board[m.from.row][m.from.colum] = 'P';
				Internal.board[m.to.row][m.to.colum] = ' ';
			}
			if(m.from.row == 1)
			{
				Internal.board[m.from.row][m.from.colum] = 'p';
				Internal.board[m.to.row][m.to.colum] = ' ';
			}
		}
		
		if(m.type == 'P')
		{
			//System.out.println("pop");
			StackElement elm = Internal.movehistory.pop();
			if(m.from.row == 6)
			{
				Internal.board[m.from.row][m.from.colum] = 'P';
				Internal.board[m.to.row][m.to.colum] = elm.captured;
			}
			if(m.from.row == 1)
			{
				Internal.board[m.from.row][m.from.colum] = 'p';
				Internal.board[m.to.row][m.to.colum] = elm.captured;
			}
		}
	}
}
