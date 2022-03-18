public class StackElement {
	Make m;
	char captured;
	boolean enpass; 
	StackElement(Make m, char captured)
	{
		this.m = m;
		this.captured = captured;
		enpass = false;
	}
	StackElement(Make m, char captured, boolean enpass)
	{
		this.m = m;
		this.captured = captured;
		this.enpass = enpass;
	}
}
