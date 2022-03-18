public class Turn {

	static boolean isEngineTurnToPlay(boolean turn, boolean playingas)
	{
		return !(turn ^ playingas); //returneaza 1 doar cand turn si playingas sunt adevart sau fals
	}			
	
}
