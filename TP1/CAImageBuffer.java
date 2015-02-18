

public class CAImageBuffer extends ImageBuffer {

	public CAImageBuffer(int width, int height) {
		super(width, height);
		this.cls(0xFF,0xFF,0xFF);
	}

	/**
	 * update image according to value in array[][] (2D)
	 * @param cells
	 */
	public void update (boolean[][] cells)
	{
		if ( cells.length != this.getWidth() || cells[0].length != this.getHeight() )
		{
			System.err.println("array size does not match with image size.");
			System.exit(-1);
		}
		
		for ( int x = 0 ; x != cells.length ; x++ )
			for ( int y = 0 ; y != cells[0].length ; y++ )
				if ( cells[x][y] == true )
					this.setPixel(x, y, 0x00, 0x00, 0x00 );
				else
					this.setPixel(x, y, 0xFF, 0xFF, 0xFF );

	}
	
	/**
	 * update first line of image to value in array[] (1D). All image is moved one line downwards prior to update.
	 * @param cells
	 */
	public void update (boolean[] cells)
	{
		if ( cells.length != this.getWidth() )
		{
			System.err.println("array length does not match with image length.");
			System.exit(-1);
		}

		for ( int x = 0 ; x != this.getWidth() ; x++ )
			for ( int y = 0 ; y != this.getHeight()-1 ; y++ )
				this.setPixel(x, y, this.getPixel(x, y+1) );

		
		for ( int x = 0 ; x != cells.length ; x++ )
			if ( cells[x] == true )
				this.setPixel(x, this.getHeight()-1, 0x00, 0x00, 0x00 );
			else
				this.setPixel(x, this.getHeight()-1, 0xFF, 0xFF, 0xFF );		
	}
}
