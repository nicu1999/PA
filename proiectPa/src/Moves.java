import java.util.ArrayList;

public class Moves {
	
	static ArrayList<Position> WhitePawn(Position p)
	{
		ArrayList m = new ArrayList<Position>();
		
		if(p.row == 6)
		{
			if( Internal.board[p.row + 1][p.colum] == ' ' )
			{
				m.add( new Position (p.row + 1, p.colum) );
			}
		}
		
		if(p.row != 7 && p.row != 6)
		{
			if( Internal.board[p.row + 1][p.colum] == ' ' )
			{
				m.add( new Position (p.row + 1, p.colum) );
			}
			if( (Internal.board[p.row + 2][p.colum] == ' ') &&
				(Internal.board[p.row + 1][p.colum] == ' ') &&
				(Internal.notmoved[p.row][p.colum] == true))
			{
				m.add(new Position (p.row + 2, p.colum));
			}
		}	
		return m;
	}
	
	static ArrayList<Position> BlackPawn(Position p)
	{
		ArrayList m = new ArrayList<Position>();
		
		if(p.row == 1)
		{
			if( Internal.board[p.row - 1][p.colum] == ' ' )
			{
				m.add( new Position (p.row - 1, p.colum) );
			}
		}
		
		if(p.row != 0 && p.row != 1)
		{
			if( Internal.board[p.row - 1][p.colum] == ' ' )
			{
				m.add( new Position (p.row - 1, p.colum) );
			}
			if( (Internal.board[p.row - 2][p.colum] == ' ') &&
				(Internal.board[p.row - 1][p.colum] == ' ') &&
				(Internal.notmoved[p.row][p.colum] == true))
			{
				m.add(new Position (p.row - 2, p.colum));
			}
		}	
		return m;
	}
	
	static ArrayList<Position> Rook(Position p)
	{
		ArrayList m = new ArrayList<Position>();
		boolean move = true; //daca sa mearga 
		int right = p.colum;
		int left = p.colum;
		int up = p.row;
		int down = p.row;
		if(right != 7)
		{
			right++;
			while(Internal.board[p.row][right] == ' ')
			{
				m.add(new Position(p.row, right));
				right++;
				if(right == 8)
				{
					break;
				}
			}
		}
		if(left != 0)
		{
			left --;
			while(Internal.board[p.row][left] == ' ')
			{
				m.add(new Position(p.row, left));
				left--;
				if(left == -1)
				{
					break;
				}
			}
		}
		if(up != 7)
		{
			up++;
			while(Internal.board[up][p.colum] == ' ')
			{
				m.add(new Position(up, p.colum));
				up++;
				if(up == 8)
				{
					break;
				}
			}
		}
		if(down != 0)
		{
			down--;
			while(Internal.board[down][p.colum] == ' ')
			{
				m.add(new Position(down, p.colum));
				down--;
				if(down == -1)
				{
					break;
				}
			}
		}
		
		return m;
	}
	
	static ArrayList<Position> Bishop(Position p)
	{
		ArrayList<Position> m = new ArrayList<Position>();
		Position upleft = new Position(p.row, p.colum);
		Position upright = new Position(p.row, p.colum);
		Position downleft = new Position(p.row, p.colum);
		Position downright = new Position(p.row, p.colum);

		if(upleft.row != 7 && upleft.colum != 0)
		{
			upleft.colum--;
			upleft.row++;
			while(Internal.board[upleft.row][upleft.colum] == ' ')
			{
				m.add(new Position(upleft.row , upleft.colum));
				upleft.colum--;
				upleft.row++;
				if(upleft.row == 8 || upleft.colum == -1 )
				{
					break;
				}
			}
		}
		
		if(upright.row != 7 && upright.colum != 7)
		{
			upright.colum++;
			upright.row++;
			while(Internal.board[upright.row][upright.colum] == ' ')
			{
				m.add(new Position(upright.row , upright.colum));
				upright.colum++;
				upright.row++;
				if(upright.row == 8 || upright.colum == 8 )
				{
					break;
				}
			}
		}
		
		if(downleft.row != 0 && downleft.colum != 0)
		{
			downleft.colum--;
			downleft.row--;
			while(Internal.board[downleft.row][downleft.colum] == ' ')
			{
				m.add(new Position(downleft.row , downleft.colum));
				downleft.colum--;
				downleft.row--;
				if(downleft.row == -1 || downleft.colum == -1 )
				{
					break;
				}
			}
		}
		
		if(downright.row != 0 && downright.colum != 7)
		{
			downright.colum++;
			downright.row--;
			while(Internal.board[downright.row][downright.colum] == ' ')
			{
				m.add(new Position(downright.row , downright.colum));
				downright.colum++;
				downright.row--;
				if(downright.row == -1 || downright.colum == 8 )
				{
					break;
				}
			}
		}
		return m;
	}
	static ArrayList<Position> Queen(Position p)
	{
		ArrayList<Position> m = new ArrayList<Position>();
		m = Rook(p);
		m.addAll(Bishop(p));
		return m;
	}
	
	static ArrayList<Position> Knight (Position p)
	{
		ArrayList<Position> m = new ArrayList<Position>();
		//
		if(p.row <=5 && p.colum >= 1 && (Internal.board[p.row + 2][p.colum - 1] == ' '))
		{
			m.add(new Position(p.row + 2 ,p.colum - 1));
		}
		if(p.row <=5 && p.colum <= 6 && (Internal.board[p.row + 2][p.colum + 1] == ' '))
		{
			m.add(new Position(p.row + 2 ,p.colum + 1));
		}
		//
		if(p.row <=6 && p.colum >= 2 && (Internal.board[p.row + 1][p.colum - 2] == ' '))
		{
			m.add(new Position(p.row + 1 ,p.colum - 2));
		}
		if(p.row >=1 && p.colum >= 2 && (Internal.board[p.row - 1][p.colum - 2] == ' '))
		{
			m.add(new Position(p.row - 1 ,p.colum - 2));
		}
		//
		if(p.row <=6 && p.colum <= 5 && (Internal.board[p.row + 1][p.colum + 2] == ' '))
		{
			m.add(new Position(p.row + 1 ,p.colum + 2));
		}
		if(p.row >=1 && p.colum <= 5 && (Internal.board[p.row - 1][p.colum + 2] == ' '))
		{
			m.add(new Position(p.row - 1 ,p.colum + 2));
		}
		//
		if(p.row >=2 && p.colum >= 1 && (Internal.board[p.row - 2][p.colum - 1] == ' '))
		{
			m.add(new Position(p.row - 2 ,p.colum - 1));
		}
		if(p.row >=2 && p.colum <= 6 && (Internal.board[p.row - 2][p.colum + 1] == ' '))
		{
			m.add(new Position(p.row - 2 ,p.colum + 1));
		}
		return m;
		
	}
	static ArrayList<Position> King(Position p)
	{
		ArrayList m = new ArrayList<Position>();
		
		if(p.row != 7)
		{
			if (Internal.board[p.row + 1][p.colum] == ' ')
			{
				m.add( new Position (p.row + 1, p.colum) );
			}
		}
		
		if(p.row != 0)
		{
			if( Internal.board[p.row - 1][p.colum] == ' ' )
			{
				m.add( new Position (p.row - 1, p.colum) );
			}
		}

		if(p.colum != 0)
		{
			if( Internal.board[p.row][p.colum - 1] == ' ')
			{
				m.add( new Position (p.row, p.colum - 1) );
			}
		}
		
		if(p.colum != 7)
		{
			if(Internal.board[p.row][p.colum + 1] == ' ')
			{
				m.add( new Position (p.row, p.colum + 1) );
			}
		}
		
		if(p.colum != 0 && p.row != 7)
		{
			if( Internal.board[p.row + 1][p.colum -1] == ' ')
			{
				m.add( new Position (p.row + 1, p.colum - 1) );
			}
		}
		
		if(p.colum != 7 && p.row != 7)
		{
			if( Internal.board[p.row + 1][p.colum + 1] == ' ' )
			{
				m.add( new Position (p.row + 1, p.colum + 1) );
			}	
		}
		if(p.colum != 0 && p.row != 0)
		{
			if( Internal.board[p.row - 1][p.colum - 1] == ' ' )
			{
				m.add( new Position (p.row - 1, p.colum - 1 ) );
			}
		}
		if(p.colum != 7 && p.row != 0)
		{
			if(Internal.board[p.row - 1][p.colum + 1] == ' ')
			{
				m.add( new Position (p.row - 1, p.colum + 1 ) );
			}
		}
		
		return m;
	}
	
	static ArrayList<Position> Castling(Position p)
	{
		ArrayList<Position> m = new ArrayList<Position>();
		boolean color;
		if(Attack.isWhite(Internal.board[p.row][p.colum]))
		{
			color = true; //white == true, black == false;
		}
		else
		{
			color = false;
		}
		
		if(color == true)
		{
			if(p.row == 0 && p.colum == 4 &&
			Internal.board[p.row][p.colum] == 'K' &&
			Internal.notmoved[p.row][p.colum] == true)
			{
				if (Internal.board[0][5] == ' ' &&
					Internal.board[0][6] == ' ' &&
					Internal.board[0][7] == 'R'  &&
					Internal.notmoved[0][7] == true)
					{
						m.add( new Position(0, 6));
					}
				if(Internal.board[0][3] == ' ' &&
					Internal.board[0][2] == ' ' &&
					Internal.board[0][1] == ' ' &&
					Internal.board[0][0] == 'R'  &&
					Internal.notmoved[0][0] == true)
					{
						m.add( new Position(0, 2));
					}
				}
			}
		else
		{
			if(p.row == 7 && p.colum == 4 &&
				Internal.board[p.row][p.colum] == 'k' &&
				Internal.notmoved[p.row][p.colum] == true)
				{
				if(	Internal.board[7][3] == ' ' &&
					Internal.board[7][2] == ' ' &&
					Internal.board[7][1] == ' ' &&
					Internal.board[7][0] == 'r' &&
					Internal.notmoved[7][0] == true)
					{
						m.add( new Position(7, 2));
					}
					if(	Internal.board[7][5] == ' ' &&
					Internal.board[7][6] == ' ' &&
					Internal.board[7][7] == 'r'  &&
					Internal.notmoved[7][7] == true)
					{
						m.add( new Position(7, 6));
					}
			}
		}	
		return m;
	}
}
