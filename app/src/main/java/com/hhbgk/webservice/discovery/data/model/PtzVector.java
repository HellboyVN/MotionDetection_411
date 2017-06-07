package com.hhbgk.webservice.discovery.data.model;

/**
 * Created by EternaLEnVy on 03/22/2017.
 */

public class PtzVector {
    private float x;
    private float y;
    private PtzSpaceInfo space;

    public PtzVector() {
    }

    public PtzVector(float x, float y, PtzSpaceInfo space) {
        this.x = x;
        this.y = y;
        this.space = space;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public PtzSpaceInfo getSpace() {
        return space;
    }

    public void setSpace(PtzSpaceInfo space) {
        this.space = space;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
}
