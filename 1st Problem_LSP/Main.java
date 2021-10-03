public class Main {

    private static final int width = 4;
    private static final int height = 5;

    public static void main(String[] args) {	
    	IShape reg1 = new Rectangle(width, height);
        System.out.println("==== Rectangle ====");
        System.out.println("Width = " + width);
        System.out.println("Height = " + height);
        System.out.println("Area = " + reg1.getArea());

        IShape reg2 = new Square(6);
        System.out.println("====   Square  ====");
        System.out.println("Width = " + width);
        System.out.println("Height = " + height);
        System.out.println("Area = " + reg2.getArea());
    }
}
