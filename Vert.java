public class Vert {
    private String name;
    private boolean state;

    public Vert(String name){
        this.name = name;
        state = false;
    }

    public String getName(){
        return name;
    }

    public boolean getState(){
        return state;
    }

    public void setState(){
        state = !state;
    }
    
}
