package Builder;

public class Robot implements IRobot{
    private String head;
    private String arms;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getArms() {
        return arms;
    }

    public void setArms(String arms) {
        this.arms = arms;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "head='" + head + '\'' +
                ", arms='" + arms + '\'' +
                '}';
    }
}
