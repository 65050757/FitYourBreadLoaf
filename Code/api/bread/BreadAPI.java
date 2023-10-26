package api.bread;
public class BreadAPI {
    private String id;
    private String title;


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageType() {
        return null;
    }
    
    public String toString(){
        return "id: " + id + " menuName: " + title;
    };
}
