/*========================================================
  class Ships
  declares and instantiates the battleships for each player
  ========================================================*/

public class Ships extends Tiles {

    //Constructor
    public Ships() {
	Tile s1 = new Tile( "boat", 2, "-X-" );
	Tile s2 = new Tile( "boat", 2, "-X-" );
	Tile s3 = new Tile( "submarine", 3, "-X-" );
	Tile s4 = new Tile( "submarine", 3, "-X-" );
	Tile s5 = new Tile( "destroyer", 3, "-X-" );
	Tile s6 = new Tile( "destroyer", 3, "-X-" );
	Tile s7 = new Tile( "submarine", 4, "-X-" );
	Tile s8 = new Tile( "submarine", 4, "-X-" );
	Tile s9 = new Tile( "aircraft carrier", 5, "-X-" );
	Tile s10 = new Tile( "aircraft carrier", 5, "-X-" );
    }

}