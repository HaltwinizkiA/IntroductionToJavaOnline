package tasks.task4;

import java.util.Arrays;
import java.util.List;

public class Ship {
    private String state="loaded";
  private   Container[] containers;

    @Override
    public String toString() {
        return "Ship{ state: " + state + "} Container:"+ Arrays.toString(containers);
    }
    public Container[] getContainers() {
        return containers;
    }



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Ship() {
        containers=new Container[5];
        for (int i=0;i<containers.length;i++){
            containers[i]=new Container();
        }

    }

    public void empty(){
        setState("empty");
        for (int i=0;i<containers.length;i++){
            containers[i]=null;
        }
    }

    public List<Container> addContainer(List<Container> containers){
        for (int i=0;i<this.containers.length;i++){
            if (containers.get(0)==null){
                System.out.println("container store in Port is empty");
                break;
            }
            this.containers[i]=containers.get(0);
            containers.remove(0);

        }
        System.out.println("Ship loaded");

return containers;
    }
}
