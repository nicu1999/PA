import java.util.ArrayList;

public class ConvertMoves {

	static public ArrayList<Position> convert(String move) {
		ArrayList<Position> res = new ArrayList<>(2);
		char first = move.charAt(0);
		char second = move.charAt(1);
		char third = move.charAt(2);
		char fourth = move.charAt(3);
		first -= 97;
		second -= 48;
		third -= 97;
		fourth -= 48;
		res.add(new Position(second - 1, first));
		res.add(new Position(fourth - 1, third));
		return res;
	}

	static boolean isNormalMove(String move) {
		try {
			char first = move.charAt(0);
			char second = move.charAt(1);
			char third = move.charAt(2);
			char fourth = move.charAt(3);
			if ((first >= 97 && first <= 104) && (third >= 97 && third <= 104) && (second >= 48 && second <= 56) && (fourth >= 48 && fourth <= 56))
			{
				return true;
			}
			return false;
		} 
		catch (Exception e)
		{
			return false;
		}
	}
	
	static boolean isPromotionMove(String move) {
		if( isNormalMove(move) )
		{
			try {
				if(move.charAt(4) == 'q' || move.charAt(4) == 'Q')
				{
					return true;
				}		
			} catch(Exception e)
			{
				
			}
		}
		return false;
	
	}
	
	static boolean isCastlingMove(String move) {
		if(move.equals("e1g1") || move.equals("e1c1") || move.equals("e8g8") || move.equals("e8c8"))
			return true;
		else 
			return false;
	}
	
	
	static String output(Make m) {
		int first;
		int second;
		int third;
		int fourth;
		first = m.from.colum + 97;
		second = m.from.row + 1;
		fourth = m.to.row + 1;
		third = m.to.colum + 97;
		return "move " +  (char)first + second+ " " + (char)third + fourth;
	}
	
	
}
