package com.avotrack.avotrack.models;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public class Flight {
    private JsonNode barometric_alt;
    private  JsonNode geometric_alt;
    private Double ground_speed;
    private Double track;
    private  Integer barometric_rate;
    private  Integer squawk;
    private String emergency;
    private Double nav_qnh;
    private JsonNode nav_altitude_mcp;
    private Double heading;
    private List<String> modes;
    private Integer nic;
    private Integer rc;
    private Integer version;
    private Integer nic_baro;
    private Integer nac_p;
    private Integer nac_v;
    private Integer sil;
    private String sil_type;
    private Integer gva;
    private Integer sda;
    private Integer alert;
    private JsonNode mlat;
    private JsonNode tisb;
    private Double rssi;


}
