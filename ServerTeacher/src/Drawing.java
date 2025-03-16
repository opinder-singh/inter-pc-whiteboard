import java.awt.*;

public class Drawing {
    String shapeType;
    int startingX;
    int startingY;
    int endingX;
    int endingY;
    int stroke;
    Color selectedColor;
    boolean isSolid;
    String text;

    public Drawing(String shapeType, int startingX, int startingY, int endingX, int endingY, int stroke, Color selectedColor, boolean isSolid, String text) {
        this.shapeType = shapeType;
        this.startingX = startingX;
        this.startingY = startingY;
        this.endingX = endingX;
        this.endingY = endingY;
        this.stroke = stroke;
        this.selectedColor = selectedColor;
        this.isSolid = isSolid;
        this.text = text;
    }
}