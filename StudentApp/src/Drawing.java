import java.awt.*;

class Drawing {

        String shapeType;
        int startingX;
        int startingY;
        int endingX;
        int endingY;
        Color selectedColor;
        int stroke;
        boolean isSolid;
        String text;

        public Drawing(String shapeType, int startingX, int startingY, int endingX, int endingY, Color selectedColor, int stroke, boolean isSolid, String text) {
            this.shapeType = shapeType;
            this.startingX = startingX;
            this.startingY = startingY;
            this.endingX = endingX;
            this.endingY = endingY;
            this.selectedColor = selectedColor;
            this.stroke = stroke;
            this.isSolid = isSolid;
            this.text = text;
        }
    }
    