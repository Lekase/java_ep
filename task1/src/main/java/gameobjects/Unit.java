package gameobjects;

import baseobjects.HorseStep;
import baseobjects.SimpleStep;
import enums.Orientation;
import baseobjects.Position;
import interfaces.Action;
import orientation.*;

import java.util.HashMap;
import java.util.Map;

public abstract class Unit implements Action {
    protected Position position;
    protected Orientation orientation;
    protected SimpleStep simpleStep;
    protected HorseStep horseStep;
    private Map<Orientation, BaseOrientation> orientationMap;
    public Unit(){
        position = new Position();
        orientation = Orientation.NORTH;
        simpleStep = new SimpleStep();
        horseStep = new HorseStep();
        fillMap();
    }

    private void fillMap(){
        orientationMap = new HashMap<>(4);
        orientationMap.put(Orientation.NORTH,new NorthOrientation());
        orientationMap.put(Orientation.EAST,new EastOrientation());
        orientationMap.put(Orientation.SOUTH,new SouthOrientation());
        orientationMap.put(Orientation.WEST,new WestOrientation());
    }

    public void turnClockwise() {
        orientationMap.get(orientation).changeOrientation(this);
    }

    public void move(){
        orientationMap.get(orientation).move(this);
    }

    public Orientation getOrientation(){
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return position.getX() + " " + position.getY();
    }
}

