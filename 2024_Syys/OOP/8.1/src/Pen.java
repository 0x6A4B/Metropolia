package src;

public class Pen {
    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;
        Color(String color) { this.color = color; };
        @Override
        public String toString() { return color; }
    }


    // your code here
    
    private boolean cap = true;
    private Color color = Color.RED;

    public Pen(){}
    public Pen(Color color){ this.color = color; }

    public void capOff(){ cap = false; }
    public void capOn(){ cap = true; }

    public String draw(){ if (!cap) return "Drawing " + color; return ""; }

    public void changeColor(Color color){ if (cap) this.color = color; }

}
