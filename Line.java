import java.lang.*;

public class Line {
    char _c;
    int _length;
    public Line(char c, int length ){
        this._c = c;
        this._length = length;
    }
    public String toString(){
        StringBuilder s = new StringBuilder("");
        int i;
        for (i = 0; i < _length; ++i) {
            s.append(_c);
        }
        return s.toString();
    }
}

