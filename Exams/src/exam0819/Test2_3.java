package exam0819;

/**
 * @author Dozen Lee<br/>
 * 2022/8/19 17:29
 */
public class Test2_3 {
    class Rect {
        public float x;        //左上角，x轴坐标
        public float y;        //左上角，y轴坐标
        public float width;    //矩形的宽
        public float height;   //矩形的高
    }

    static boolean isIntersect(Rect a, Rect b) {
        return !(a.y - a.height >= b.y ||
                a.y <= b.y - b.height ||
                a.x + a.width <= b.x ||
                a.x >= b.x + b.width);
    }
}
