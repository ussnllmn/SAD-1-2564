public abstract class IShape {
	
	    private int width;
	    private int height;

	    IShape() {
	    }

	    public void setWidth(int width) {
	        this.width = width;
	    }

	    public void setHeight(int height) {
	        this.height = height;
	    }

	    public int getArea() {
	        return width * height;
	    }
	}