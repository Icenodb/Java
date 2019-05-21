package com.DesignMode.CloudHan;

public class Main {
    public static void main(String[] args) {
        new WhitePen(new CircleRuler()).draw();
        new WhitePen(new SquareRuler()).draw();
        new WhitePen(new TriangleRuler()).draw();
        System.out.println();
        new BlackPen(new CircleRuler()).draw();
        new BlackPen(new SquareRuler()).draw();
        new BlackPen(new TriangleRuler()).draw();
    }
    public interface Ruler {
        void regularize();
    }

    public static abstract class Pen {
        protected Ruler ruler;

        public Pen(Ruler ruler) {
            this.ruler = ruler;
        }

        public abstract void draw();
    }

    public static class SquareRuler implements Ruler {
        @Override
        public void regularize() {
            System.out.print("▢");
        }
    }

    public static class TriangleRuler implements Ruler {
        @Override
        public void regularize() {
            System.out.print("▷");
        }
    }

    public static class CircleRuler implements Ruler {
        @Override
        public void regularize() {
            System.out.print("○");
        }
    }

    public static class BlackPen extends Pen {
        public BlackPen(Ruler ruler) {
            super(ruler);
        }

        @Override
        public void draw() {
            System.out.print("黑");
            ruler.regularize();
        }
    }

    public static class WhitePen extends Pen {
        public WhitePen(Ruler ruler) {
            super(ruler);
        }

        @Override
        public void draw() {
            System.out.print("白");
            ruler.regularize();
        }
    }

}

