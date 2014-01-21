public class Computer extends Player {
    
    //private _guess; possibly get all coords & guess by chance?
    

    public Computer() {
	super();
	_name = "Computer";
    }

    public int guessR () {
	return 10 + (int) Math.random();
    }
    public int guessC () {
	return 10 + (int) Math.random();
    }
}
