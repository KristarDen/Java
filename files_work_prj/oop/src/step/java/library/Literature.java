package step.java.library;

public abstract class Literature {  // base - superclass
    private String title ;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract String toString () ;

    public abstract String toJsonString() ;
}
