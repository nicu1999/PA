import java.util.ArrayList;

public class Check {
	static boolean isInCheck(boolean color, ArrayList<Make> m)
	{
		Position p = new Position(); // ma bazez ca multime de maturi este de culare opusa fata de color
		if(color == true)
		{
			for(int i=0; i<8; i++)
			{
				for(int j=0; j<8; j++)
				{
					if(Internal.board[i][j] == 'K' )
					p.row = i;
					p.colum = j;
				}
			}
		}
		else
		{
			for(int i=0; i<8; i++)
			{
				for(int j=0; j<8; j++)
				{
					if(Internal.board[i][j] == 'k' )
						p = new Position(i, j);	
				}
			}
		}
		
		if(color == true)
		{
			for(Make h : m)
			{
				if(h.to.colum == p.colum && h.to.colum == p.colum)
				{
					return true;
				}
			}
		}
		return false;
	}
}
