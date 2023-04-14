package homework;

import java.awt.*;

public class LineColor {

    int vertexStart;
    int vertexEnd;
    Color colorLine;

    public LineColor(int vertexStart, int vertexEnd) {
        this.vertexStart = vertexStart;
        this.vertexEnd = vertexEnd;
    }

    public int getVertexStart() {
        return this.vertexStart;
    }

    public int getVertexEnd() {
        return vertexEnd;
    }

    public Color getColorLine() {
        return colorLine;
    }

    public void setColorLine(Color colorLine) {
        this.colorLine = colorLine;
    }

    public void setVertexEnd(int vertexEnd) {
        this.vertexEnd = vertexEnd;
    }

    public void setVertexStart(int vertexStart) {
        this.vertexStart = vertexStart;
    }

    public int getStart() {
        return vertexStart;
    }

    public int getEnd() {
        return vertexEnd;
    }
}
