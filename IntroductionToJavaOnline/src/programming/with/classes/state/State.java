package programming.with.classes.state;

public class State {
    Region[] region;



    public State createState(){
        State state=new State();
        state.region=new Region[3];
        state.region[0]=new Region("Hrodnenskaya");
        state.region[0].area=new Area[2];
        state.region[0].s=25127;
        state.region[0].capital=new Town("Hrodna");
        state.region[0].area[0]=new Area("Lidskiy");
        state.region[0].area[1]=new Area("Skidelskiy");
        state.region[0].area[0].town=new Town[2];
        state.region[0].area[0].town[0]=new Town("Skidel");
        state.region[0].area[0].town[1]=new Town("Lida");

        state.region[1]=new Region("Minskaya");
        state.region[1].area=new Area[2];
        state.region[1].s=39912;
        state.region[1].capital=new Town("Minsk");
        state.region[1].area[0]=new Area("Borisovkii");
        state.region[1].area[1]=new Area("Beresinskiy");
        state.region[1].area[0].town=new Town[2];
        state.region[1].area[0].town[0]=new Town("Birisov");
        state.region[1].area[0].town[1]=new Town("Beresa");

        state.region[2]=new Region("Brestskaya");
        state.region[2].area=new Area[2];
        state.region[2].s=32787;
        state.region[2].capital=new Town("Brest");
        state.region[2].area[0]=new Area("Baranovichiskiy");
        state.region[2].area[1]=new Area("Ivacevichskiy");
        state.region[2].area[0].town=new Town[2];
        state.region[2].area[0].town[0]=new Town("Baranovichi");
        state.region[2].area[0].town[1]=new Town("Ivacevichi");

        outPutCountOfRegion(state);
        outPutRegionalCenters(state);
        outPutCapital(state.region[0]);
        outPutCapital(state.region[1]);
        outPutCapital(state.region[2]);
        outPutRegionSquare(state.region[0]);
        outPutRegionSquare(state.region[1]);
        outPutRegionSquare(state.region[2]);





        return state ;
    }
    public void outPutCapital(Region region){
        System.out.println("Region name : "+region.name+" capital: "+region.capital.name);

    }
    public void outPutCountOfRegion(State state){
        System.out.println("count of region: "+state.region.length);
    }
    public void outPutRegionalCenters(State state){
        System.out.println("Regional centers:");
        for (int i=0;i<state.region.length;i++)
        System.out.println(state.region[i].capital.name);
    }
    public void outPutRegionSquare(Region region){
        System.out.println("Region :"+region.name+" square: "+region.s);
    }







}
