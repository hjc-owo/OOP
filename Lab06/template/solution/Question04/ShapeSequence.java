public class ShapeSequence {
    int number = 0;
    private Shape[] shapes;


    public ShapeSequence(int size) {
        if (size < 0) {
            size = 0;
        }
        shapes = new Shape[size];
    }

    public void add(Shape shape) {
        if (shapes.length == number) {
            return;
        }
        shapes[number++] = shape;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < number; i++) {
            str.append(shapes[i].toString()).append(",");
        }
        return str + "]";
    }

    interface Iterator{
        boolean isEnd();
        Shape current();
        void moveNext();
        boolean equals(Object o);
    }


    public SequenceIterator iterator() {return new SequenceIterator();}

    private class SequenceIterator implements Iterator{
        int index = 0;

        public boolean isEnd() {
            return index == number;
        }

        public Shape current() {
            if (isEnd()) {
                return null;
            }
            return shapes[index];
        }

        public void moveNext() {
            if (isEnd()) {
                return;
            }
            index++;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SequenceIterator that = (SequenceIterator) o;
            return index == that.index;
        }

    }
}
