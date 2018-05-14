import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.geom.*;

public class ArrowTrans extends JApplet {

    private int vertexCount = 8;
    private int[] xPoints = new int[vertexCount];
    private int[] yPoints = new int[vertexCount];
    private Polygon = null;

    //정적 메소드 : y 좌표 교정용
    private static int rY(int y) {
        return -y;
    }

    public void init() {
        setSize(610, 410);
    }

    public void paint(Graphics g) {

        //
        //이 자리에 기본 도형 객체를 생성합니다.
        //

        //기준좌표를 화면 중앙으로 이동하고
        //좌표 시스템을 그립니다.

        g.translate(300,200);
        drawCartesian(g);

        //이 자리에 기본 도형 객체를 생성하고,
        //변환한 다음 결과 도형객체를 다시 출력합니다.
        //
    }

    //////////좌표 그리기에 관련된 메소드//////////////


    private void drawCartesian(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(Color.white);
        g.fillRect(0, 0, 610, 410);
        g.setColor(oldColor);

        drawGrid(g);
        drawAxis(g);
    }

    //---------------------------------------
    //그리드 출력하기
    //---------------------------------------

    public void drawGrid(Graphics g){
        g.setColor(Color.lightGray);

        for(int t=0; t<300; t+=10){
            g.drawLine(t, rY(200), t, rY(-200));
            g.drawLine(-t, rY(200), -t, rY(-200));
        }

        for (int t=0;)
    }
}
