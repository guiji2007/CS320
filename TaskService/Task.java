
public class Task {
	private String ID;
    private String name;
    private String desc;


    public Task() {
    }

    public Task(String ID, String name, String desc) {
        if(ID == null || name == null || desc == null||
        ID.length()>10 || name.length()>20 || desc.length()>50){
            throw new IllegalArgumentException("INVALID INPUT");
        }
        this.ID = ID;
        this.name = name;
        this.desc = desc;
    }

    public String getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(name == null || name.length()>20){
            throw new IllegalArgumentException("INVALID INPUT");
        }
        this.name = name;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        if(desc == null || desc.length()>50){
            throw new IllegalArgumentException("INVALID INPUT");
        }
        this.desc = desc;
    }

}
