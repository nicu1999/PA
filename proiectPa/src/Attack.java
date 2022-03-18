import java.util.ArrayList;

public class Attack {
	
	static boolean isBlack(char c)
	{
		if((int)c >= 97 && (int)c <= 122)
		{
			return true;
		}
		else return false;
	}
	static boolean isWhite(char c)
	{
		if((int)c >= 65 && (int)c <= 90)
		{
			return true;
		}
		else return false;
	}	
	
	static ArrayList<Position> WhitePawn(Position p)
	{
		ArrayList<Position> a = new ArrayList<>();
		if(p.row != 7)
		{
			if(p.colum!=0 && p.colum!=7)
			{
				if(isBlack(Internal.board[p.row + 1][p.colum - 1]))
				{
					a.add(new Position(p.row + 1 , p.colum - 1));
				}
				if(isBlack(Internal.board[p.row + 1][p.colum + 1]))
				{
					a.add(new Position(p.row + 1 , p.colum + 1));
				}
			}
			
			if(p.colum == 0)
			{
				if(isBlack(Internal.board[p.row + 1][p.colum + 1]))
				{
					a.add(new Position(p.row + 1 , p.colum + 1));
				}
			}
			if(p.colum == 7)
			{
				if(isBlack(Internal.board[p.row + 1][p.colum - 1]))
				{
					a.add(new Position(p.row + 1 , p.colum - 1));
				}
			}
		}
		return a;
	}
	
	static ArrayList<Position> BlackPawn(Position p)
	{
		ArrayList<Position> a = new ArrayList<>();
		if(p.row != 0)
		{
			if(p.colum!=0 && p.colum!=7)
			{
				if(isWhite(Internal.board[p.row - 1][p.colum - 1]))
				{
					a.add(new Position(p.row - 1 , p.colum - 1));
				}
				if(isWhite(Internal.board[p.row - 1][p.colum + 1]))
				{
					a.add(new Position(p.row - 1 , p.colum + 1));
				}
			}	
			if(p.colum == 0)
			{
				if(isWhite(Internal.board[p.row - 1][p.colum + 1]))
					{
					a.add(new Position(p.row - 1 , p.colum + 1));
					}
			}
			if(p.colum == 7)
			{
				if(isWhite(Internal.board[p.row - 1][p.colum - 1]))
				{
					a.add(new Position(p.row - 1 , p.colum - 1));
				}
			}
		}
		return a;
	}
	
	static ArrayList<Position> Rook(Position p)
	{
		ArrayList<Position> a = new ArrayList<>();
		boolean color;
		if(isWhite(Internal.board[p.row][p.colum]))
		{
			color = true; //white == true, black == false;
		}
		else
		{
			color = false;
		}
		for(int i = p.colum + 1 ; i < 8 ; i++)
		{
			if( (Internal.board[p.row][i]) != ' ')
			{
				if(color == true)
				{
					if((int)Internal.board[p.row][i] >= 97 && 
					(int)Internal.board[p.row][i] <= 122)
					{
						a.add(new Position(p.row, i));
					}
					break;
				}
				else
				{
					if((int)Internal.board[p.row][p.colum] >=65 && 
						(int)Internal.board[p.row][p.colum] <=90)
					{
						a.add(new Position(p.row, i));
					}
					break;
				}
			}
		}
		
		for(int i = p.colum - 1 ; i >= 0 ; i--)
		{
			if( (Internal.board[p.row][i]) != ' ')
			{
				if(color == true)
				{
					if((int)Internal.board[p.row][i] >= 97 && 
					(int)Internal.board[p.row][i] <= 122)
					{
						a.add(new Position(p.row, i));
					}
					break;
				}
				else
				{
					if((int)Internal.board[p.row][p.colum] >=65 && 
						(int)Internal.board[p.row][p.colum] <=90)
					{
						a.add(new Position(p.row, i));
					}
					break;
				}
			}
		}
		
		for(int i = p.row + 1 ; i < 8 ; i++)
		{
			if( (Internal.board[i][p.colum]) != ' ')
			{
				if(color == true)
				{
					if((int)Internal.board[i][p.colum] >= 97 && 
					(int)Internal.board[i][p.colum] <= 122)
					{
						a.add(new Position(i, p.colum));
					}
					break;
				}
				else
				{
					if((int)Internal.board[i][p.colum] >=65 && 
						(int)Internal.board[i][p.colum] <=90)
					{
						a.add(new Position(i, p.colum));
					}
					break;
				}
			}
		}
		
		for(int i = p.row - 1 ; i >= 0 ; i--)
		{
			if( (Internal.board[i][p.colum]) != ' ')
			{
				if(color == true)
				{
					if((int)Internal.board[i][p.colum] >= 97 && 
					(int)Internal.board[i][p.colum] <= 122)
					{
						a.add(new Position(i, p.colum));
					}
					break;
				}
				else
				{
					if((int)Internal.board[i][p.colum] >=65 && 
						(int)Internal.board[i][p.colum] <=90)
					{
						a.add(new Position(i, p.colum));
					}
					break;
				}
			}
		}
		
		return a;
	}
	static ArrayList<Position> Knight (Position p)
	{
		ArrayList<Position> m = new ArrayList<Position>();
		boolean color;
		if(isWhite(Internal.board[p.row][p.colum]))
		{
			color = true; //white == true, black == false;
		}
		else
		{
			color = false;
		}
		
		if(color == true)
		{
			if(p.row <=5 && p.colum >= 1 && isBlack(Internal.board[p.row + 2][p.colum - 1]))
			{
				m.add(new Position(p.row + 2 ,p.colum - 1));
			}
			if(p.row <=5 && p.colum <= 6 && isBlack(Internal.board[p.row + 2][p.colum + 1]))
			{
				m.add(new Position(p.row + 2 ,p.colum + 1));
			}
			//
			if(p.row <=6 && p.colum >= 2 && isBlack(Internal.board[p.row + 1][p.colum - 2]))
			{
				m.add(new Position(p.row + 1 ,p.colum - 2));
			}
			if(p.row >=1 && p.colum >= 2 && isBlack(Internal.board[p.row - 1][p.colum - 2]))
			{
				m.add(new Position(p.row - 1 ,p.colum - 2));
			}
			//
			if(p.row <=6 && p.colum <= 5 && isBlack(Internal.board[p.row + 1][p.colum + 2]))
			{
				m.add(new Position(p.row + 1 ,p.colum + 2));
			}
			if(p.row >=1 && p.colum <= 5 && isBlack(Internal.board[p.row - 1][p.colum + 2]))
			{
				m.add(new Position(p.row - 1 ,p.colum + 2));
			}
			//
			if(p.row >=2 && p.colum >= 1 && isBlack(Internal.board[p.row - 2][p.colum - 1]))
			{
				m.add(new Position(p.row - 2 ,p.colum - 1));
			}
			if(p.row >=2 && p.colum <= 6 && isBlack(Internal.board[p.row - 2][p.colum + 1]))
			{
				m.add(new Position(p.row - 2 ,p.colum + 1));
			}
		}
		else
		{
			if(p.row <=5 && p.colum >= 1 && isWhite(Internal.board[p.row + 2][p.colum - 1]))
			{
				m.add(new Position(p.row + 2 ,p.colum - 1));
			}
			if(p.row <=5 && p.colum <= 6 && isWhite(Internal.board[p.row + 2][p.colum + 1]))
			{
				m.add(new Position(p.row + 2 ,p.colum + 1));
			}
			//
			if(p.row <=6 && p.colum >= 2 && isWhite(Internal.board[p.row + 1][p.colum - 2]))
			{
				m.add(new Position(p.row + 1 ,p.colum - 2));
			}
			if(p.row >=1 && p.colum >= 2 && isWhite(Internal.board[p.row - 1][p.colum - 2]))
			{
				m.add(new Position(p.row - 1 ,p.colum - 2));
			}
			//
			if(p.row <=6 && p.colum <= 5 && isWhite(Internal.board[p.row + 1][p.colum + 2]))
			{
				m.add(new Position(p.row + 1 ,p.colum + 2));
			}
			if(p.row >=1 && p.colum <= 5 && isWhite(Internal.board[p.row - 1][p.colum + 2]))
			{
				m.add(new Position(p.row - 1 ,p.colum + 2));
			}
			//
			if(p.row >=2 && p.colum >= 1 && isWhite(Internal.board[p.row - 2][p.colum - 1]))
			{
				m.add(new Position(p.row - 2 ,p.colum - 1));
			}
			if(p.row >=2 && p.colum <= 6 && isWhite(Internal.board[p.row - 2][p.colum + 1]))
			{
				m.add(new Position(p.row - 2 ,p.colum + 1));
			}
		}
		return m;
	}
	
	static ArrayList<Position> Bishop(Position p)
	{
		ArrayList<Position> m = new ArrayList<Position>();
		boolean color;
		Position upleft = new Position(p.row, p.colum);
		Position upright = new Position(p.row, p.colum);
		Position downleft = new Position(p.row, p.colum);
		Position downright = new Position(p.row, p.colum);
		
		if(isWhite(Internal.board[p.row][p.colum]))
		{
			color = true; //white == true, black == false;
		}
		else
		{
			color = false;
		}

		if(upleft.row != 7 && upleft.colum != 0)
		{
			upleft.row++;
			upleft.colum--;
			while(Internal.board[upleft.row][upleft.colum] == ' ' && upleft.row != 7 && upleft.colum != 0)
			{
				upleft.row++;
				upleft.colum--;	
			}
			if(color == true)
			{
				if(isBlack(Internal.board[upleft.row][upleft.colum]))
				{
					m.add(new Position(upleft.row, upleft.colum) );
				}
			}
			else
			{
				if(isWhite(Internal.board[upleft.row][upleft.colum]))
				{
					m.add(new Position(upleft.row, upleft.colum) );
				}
			}
		}
		//
		if(downleft.row != 0 && downleft.colum != 0)
		{
			downleft.row--;
			downleft.colum--;
			while(Internal.board[downleft.row][downleft.colum] == ' ' && downleft.row != 0 && downleft.colum != 0)
			{
				downleft.row--;
				downleft.colum--;	
			}
			if(color == true)
			{
				if(isBlack(Internal.board[downleft.row][downleft.colum]))
				{
					m.add(new Position(downleft.row, downleft.colum) );
				}
			}
			else
			{
				if(isWhite(Internal.board[downleft.row][downleft.colum]))
				{
					m.add(new Position(downleft.row, downleft.colum) );
				}
			}
		}
		//
		if(downright.row != 0 && downright.colum != 7)
		{
			downright.row--;
			downright.colum++;
			while(Internal.board[downright.row][downright.colum] == ' ' && downright.row != 0 && downright.colum != 7)
			{
				downright.row--;
				downright.colum++;	
			}
			if(color == true)
			{
				if(isBlack(Internal.board[downright.row][downright.colum]))
				{
					m.add(new Position(downright.row, downright.colum) );
				}
			}
			else
			{
				if(isWhite(Internal.board[downright.row][downright.colum]))
				{
					m.add(new Position(downright.row, downright.colum) );
				}
			}
		}
		
		if(upright.row != 7 && upright.colum != 7)
		{
			upright.row++;
			upright.colum++;
			while(Internal.board[upright.row][upright.colum] == ' ' && upright.row != 7 && upright.colum != 7)
			{
				upright.row++;
				upright.colum++;	
			}
			if(color == true)
			{
				if(isBlack(Internal.board[upright.row][upright.colum]))
				{
					m.add(new Position(upright.row, upright.colum) );
				}
			}
			else
			{
				if(isWhite(Internal.board[upright.row][upright.colum]))
				{
					m.add(new Position(upright.row, upright.colum) );
				}
			}
		}
		return m;
	}
	
	
	static ArrayList<Position> King(Position p)
	{
		ArrayList<Position> m = new ArrayList<Position>();
		boolean color;
		if(isWhite(Internal.board[p.row][p.colum]))
		{
			color = true; //white == true, black == false;
		}
		else
		{
			color = false;
		}
		
		if(color == true)
		{
			if(p.row != 7)
			{
				if ( isBlack(Internal.board[p.row + 1][p.colum]))
				{
					m.add( new Position (p.row + 1, p.colum) );
				}
			}
			
			if(p.row != 0)
			{
				if( isBlack(Internal.board[p.row - 1][p.colum]))
				{
					m.add( new Position (p.row - 1, p.colum) );
				}
			}

			if(p.colum != 0)
			{
				if( isBlack(Internal.board[p.row][p.colum - 1] ))
				{
					m.add( new Position (p.row, p.colum - 1) );
				}
			}
			
			if(p.colum != 7)
			{
				if(isBlack(Internal.board[p.row][p.colum + 1] ))
				{
					m.add( new Position (p.row, p.colum + 1) );
				}
			}
			
			if(p.colum != 0 && p.row != 7)
			{
				if( isBlack(Internal.board[p.row + 1][p.colum -1] ))
				{
					m.add( new Position (p.row + 1, p.colum - 1) );
				}
			}
			
			if(p.colum != 7 && p.row != 7)
			{
				if( isBlack(Internal.board[p.row + 1][p.colum + 1] ))
				{
					m.add( new Position (p.row + 1, p.colum + 1) );
				}	
			}
			if(p.colum != 0 && p.row != 0)
			{
				if( isBlack(Internal.board[p.row - 1][p.colum - 1]))
				{
					m.add( new Position (p.row - 1, p.colum - 1 ) );
				}
			}
			if(p.colum != 7 && p.row != 0)
			{
				if(isBlack(Internal.board[p.row - 1][p.colum + 1]))
				{
					m.add( new Position (p.row - 1, p.colum + 1 ) );
				}
			}
		}
		else
		{
			if(p.row != 7)
			{
				if ( isWhite(Internal.board[p.row + 1][p.colum]))
				{
					m.add( new Position (p.row + 1, p.colum) );
				}
			}
			
			if(p.row != 0)
			{
				if( isWhite(Internal.board[p.row - 1][p.colum]))
				{
					m.add( new Position (p.row - 1, p.colum) );
				}
			}

			if(p.colum != 0)
			{
				if( isWhite(Internal.board[p.row][p.colum - 1] ))
				{
					m.add( new Position (p.row, p.colum - 1) );
				}
			}
			
			if(p.colum != 7)
			{
				if(isWhite(Internal.board[p.row][p.colum + 1] ))
				{
					m.add( new Position (p.row, p.colum + 1) );
				}
			}
			
			if(p.colum != 0 && p.row != 7)
			{
				if( isWhite(Internal.board[p.row + 1][p.colum -1] ))
				{
					m.add( new Position (p.row + 1, p.colum - 1) );
				}
			}
			
			if(p.colum != 7 && p.row != 7)
			{
				if( isWhite(Internal.board[p.row + 1][p.colum + 1] ))
				{
					m.add( new Position (p.row + 1, p.colum + 1) );
				}	
			}
			if(p.colum != 0 && p.row != 0)
			{
				if( isWhite(Internal.board[p.row - 1][p.colum - 1]))
				{
					m.add( new Position (p.row - 1, p.colum - 1 ) );
				}
			}
			if(p.colum != 7 && p.row != 0)
			{
				if(isWhite(Internal.board[p.row - 1][p.colum + 1]))
				{
					m.add( new Position (p.row - 1, p.colum + 1 ) );
				}
			}
		}	
		return m;
	}
	
	static ArrayList<Position> Queen(Position p)
	{
		ArrayList<Position> m = new ArrayList<Position>();
		m=Rook(p);
		m.addAll(Bishop(p));
		return m;
	}
}
