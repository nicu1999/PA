public class Eye {
	static float Evaluation()
	{
		float score=0;
		int bbnumber = 0, wbnumber = 0;
		
		for(int i=0; i < 8 ; i++)
		{
			for(int j=0; j < 8; j++)
			{
				if(Internal.board[i][j] == 'P')
				{
					score +=1;
					for (Position p : Moves.WhitePawn(new Position(i, j)))
					{
						score += 0.1;
					}
				}
				if(Internal.board[i][j] == 'p')
				{
					score -=1;
					for (Position p : Moves.BlackPawn(new Position(i, j)))
					{
						score -= 0.1;
					}
				}
				if(Internal.board[i][j] == 'N')
				{
					score +=3;
					for (Position p : Moves.Knight(new Position(i, j)))
					{
						score += 0.1;
					}
				}
				if(Internal.board[i][j] == 'n')
				{
					score -=3;
					for (Position p : Moves.Knight(new Position(i, j)))
					{
						score -= 0.1;
					}
				}
				if(Internal.board[i][j] == 'B')
				{
					score +=3;
					wbnumber++;
					for (Position p : Moves.Bishop(new Position(i, j)))
					{
						score += 0.1;
					}
				}
				if(Internal.board[i][j] == 'b')
				{
					score -=3;
					bbnumber++;
					for (Position p : Moves.Bishop(new Position(i, j)))
					{
						score -= 0.1;
					}
				}
				if(Internal.board[i][j] == 'R')
				{
					score +=5;
					for (Position p : Moves.Rook(new Position(i, j)))
					{
						score += 0.1;
					}
				}
				if(Internal.board[i][j] == 'r')
				{
					score -=5;
					for (Position p : Moves.Rook(new Position(i, j)))
					{
						score -= 0.1;
					}
				}
				if(Internal.board[i][j] == 'Q')
				{
					score +=9;
					for (Position p : Moves.Queen(new Position(i, j)))
					{
						score += 0.1;
					}
				}
				if(Internal.board[i][j] == 'q')
				{
					score -=9;
					for (Position p : Moves.Queen(new Position(i, j)))
					{
						score -= 0.1;
					}
				}
				
			}
		}
		if(wbnumber == 2)
		{
			score += 0.5;
		}
		if(wbnumber == 2)
		{
			score -= 0.5;
		}
		
		return score;
	}
}
