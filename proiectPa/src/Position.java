import java.util.ArrayList;

public class Position {
	int row;
	int colum;
	Position()
	{
		row=0;
		colum=0;
	}
	Position(int r, int c)
	{
		row=r;
		colum=c;
	}
	public String toString()
	{
		return "[" + row + " " + colum + "]";
	}
	
	static void printPosition(ArrayList<Position> m)
	{
		int[][] matr = new int[8][8];
		for(Position p : m)
		{
			matr[p.row][p.colum]++;
		}
		for(int i=7; i>=0; i--)
		{	System.out.print(i+ "  ");
			for(int j=0; j<8; j++)
			{
				if(matr[i][j] == 0)
				{
					System.out.print("_ ");
				}
				else
				{
					System.out.print(matr[i][j]+ " ");
				}
			}
			System.out.println();
		}
	}
}
