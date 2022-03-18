import java.util.ArrayList;

public class Horus {
	boolean horuscolor = true; //true == white, false == black 
	String movehistory;
	static float pinf = 100005;
	static float minf = -100005;
	
	static ArrayList<Make> WhiteMoveGenerator()
	{
		ArrayList<Make> m = new ArrayList<Make>();
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				if(Internal.board[i][j] == 'P')
				{
					if(i <= 5)
					{
						for(Position pos : Moves.WhitePawn(new Position(i, j)))
						{
							m.add(new Make(new Position(i, j) , pos, 'm'));
						}
						for(Position pos : Attack.WhitePawn(new Position(i, j)))
						{
							m.add(new Make(new Position(i, j) , pos, 'a'));
						}
					}
					if (i == 6)
					{
						for(Position pos : Moves.WhitePawn(new Position(i, j)))
						{
							m.add(new Make(new Position(i, j) , pos, 'p')); // move promote
						}
						for(Position pos : Attack.WhitePawn(new Position(i, j)))
						{
							m.add(new Make(new Position(i, j) , pos, 'P')); // attack promote
						}
					}
				}
				if(Internal.board[i][j] == 'R')
				{
					for(Position pos : Moves.Rook(new Position(i, j)))
					{
						m.add(new Make(new Position(i, j) , pos, 'm'));
					}
					for(Position pos : Attack.Rook(new Position(i, j)))
					{
						m.add(new Make(new Position(i, j) , pos, 'a'));
					}
				}
				if(Internal.board[i][j] == 'N')
				{
					for(Position pos : Moves.Knight(new Position(i, j)))
					{
						m.add(new Make(new Position(i, j) , pos, 'm'));
					}
					for(Position pos : Attack.Knight(new Position(i, j)))
					{
						m.add(new Make(new Position(i, j) , pos, 'a'));
					}
				}
				if(Internal.board[i][j] == 'B')
				{
					for(Position pos : Moves.Bishop(new Position(i, j)))
					{
						m.add(new Make(new Position(i, j) , pos, 'm'));
					}
					for(Position pos : Attack.Bishop(new Position(i, j)))
					{
						m.add(new Make(new Position(i, j) , pos, 'a'));
					}
				}
				if(Internal.board[i][j] == 'Q')
				{
					for(Position pos : Moves.Queen(new Position(i, j)))
					{
						m.add(new Make(new Position(i, j) , pos, 'm'));
					}
					for(Position pos : Attack.Queen(new Position(i, j)))
					{
						m.add(new Make(new Position(i, j) , pos, 'a'));
					}
				}
				if(Internal.board[i][j] == 'K')
				{
					for(Position pos : Moves.King(new Position(i, j)))
					{
						m.add(new Make(new Position(i, j) , pos, 'm'));
					}
					for(Position pos : Attack.King(new Position(i, j)))
					{
						m.add(new Make(new Position(i, j) , pos, 'a'));
					}
					for(Position pos : Moves.Castling(new Position(i, j)))
					{
						m.add(new Make(new Position(i, j) , pos, 'c'));
					}
				}
			}
		}
		return m;

	}
	static ArrayList<Make> BlackMoveGenerator()
	{
		ArrayList<Make> m = new ArrayList<Make>();
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				if(Internal.board[i][j] == 'p')
				{
					if(i >= 2)
					{
						for(Position pos : Moves.BlackPawn(new Position(i, j)))
						{
							m.add(new Make(new Position(i, j) , pos, 'm'));
						}
						for(Position pos : Attack.BlackPawn(new Position(i, j)))
						{
							m.add(new Make(new Position(i, j) , pos, 'a'));
						}
					}
					if(i == 1)
					{
						for(Position pos : Moves.BlackPawn(new Position(i, j)))
						{
							m.add(new Make(new Position(i, j) , pos, 'p'));
						}
						for(Position pos : Attack.BlackPawn(new Position(i, j)))
						{
							m.add(new Make(new Position(i, j) , pos, 'P'));
						}
					}
				}
				if(Internal.board[i][j] == 'r')
				{
					for(Position pos : Moves.Rook(new Position(i, j)))
					{
						m.add(new Make(new Position(i, j) , pos, 'm'));
					}
					for(Position pos : Attack.Rook(new Position(i, j)))
					{
						m.add(new Make(new Position(i, j) , pos, 'a'));
					}
				}
				if(Internal.board[i][j] == 'n')
				{
					for(Position pos : Moves.Knight(new Position(i, j)))
					{
						m.add(new Make(new Position(i, j) , pos, 'm'));
					}
					for(Position pos : Attack.Knight(new Position(i, j)))
					{
						m.add(new Make(new Position(i, j) , pos, 'a'));
					}
				}
				if(Internal.board[i][j] == 'b')
				{
					for(Position pos : Moves.Bishop(new Position(i, j)))
					{
						m.add(new Make(new Position(i, j) , pos, 'm'));
					}
					for(Position pos : Attack.Bishop(new Position(i, j)))
					{
						m.add(new Make(new Position(i, j) , pos, 'a'));
					}
				}
				if(Internal.board[i][j] == 'q')
				{
					for(Position pos : Moves.Queen(new Position(i, j)))
					{
						m.add(new Make(new Position(i, j) , pos, 'm'));
					}
					for(Position pos : Attack.Queen(new Position(i, j)))
					{
						m.add(new Make(new Position(i, j) , pos, 'a'));
					}
				}
				/*if(Internal.board[i][j] == 'k')
				{
					for(Position pos : Moves.King(new Position(i, j)))
					{
						m.add(new Make(new Position(i, j) , pos, 'm'));
					}
					for(Position pos : Attack.King(new Position(i, j)))
					{
						m.add(new Make(new Position(i, j) , pos, 'a'));
					}
					for(Position pos : Moves.Castling(new Position(i, j)))
					{
						m.add(new Make(new Position(i, j) , pos, 'c'));
					}
				}*/
			}
		}

		return m;
	}
	
	
	static float alphaBetaMax( float alpha, float beta, int depthleft ) {
		   if ( depthleft == 0 ) return Eye.Evaluation();		   
		   float score;
		   for(Make h : Horus.WhiteMoveGenerator())
		   {
				Make.makeMove(h);
			    score = alphaBetaMin( alpha, beta, depthleft - 1 );
			    Make.unMakeMove(h);
			    if( score >= beta )
			    	return beta;   
			    if( score > alpha )
			    	alpha = score;
			}
		   return alpha;
		}

	static float alphaBetaMin( float alpha, float beta, int depthleft ) {
		   if ( depthleft == 0 ) return -Eye.Evaluation();
		   float score;
		   for(Make h : Horus.BlackMoveGenerator())
		   {
			  Make.makeMove(h);
		      score = -alphaBetaMax( alpha, beta, depthleft - 1 );
		      Make.unMakeMove(h);
		      if( score <= alpha )
		         return alpha;
		      if( score < beta )
		         beta = score; 
		   }
		   return beta;
		}
}
