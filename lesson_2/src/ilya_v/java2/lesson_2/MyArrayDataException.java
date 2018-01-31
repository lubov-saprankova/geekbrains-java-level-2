package ilya_v.java2.lesson_2;

public class MyArrayDataException extends MyException {

    public MyArrayDataException(int x, int y){
        super("Нецелочисленный формат в ячейке " + (x + 1) + "x" + (y + 1));
    }
}
