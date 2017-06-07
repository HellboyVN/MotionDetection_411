package com.hhbgk.webservice.discovery.data.model;

import java.util.List;

/**
 * Created by EternaLEnVy on 03/22/2017.
 */

public class PtzPreset {
    private String name;
    private String token;
    private List<PtzVector> ptzPosition;

    public PtzPreset() {
    }

    public PtzPreset(String name, String token, List<PtzVector> ptzPosition) {
        this.name = name;
        this.token = token;
        this.ptzPosition = ptzPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<PtzVector> getPtzPosition() {
        return ptzPosition;
    }

    public void setPtzPosition(List<PtzVector> ptzPosition) {
        this.ptzPosition = ptzPosition;
    }
}
