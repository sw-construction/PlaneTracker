package com.avotrack.avotrack.models;

import java.util.List;

public class Flight {

    private String barometric_alt;
    private  String geometric_alt;
    private Double ground_speed;
    private Double track;
    private  Integer barometric_rate;
    private  Integer squawk;
    private String emergency;
    private Double nav_qnh;
    private String nav_altitude_mcp;
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
    private String mlat;
    private String tisb;
    private Double rssi;

    public Flight () {

    }

    public String getBarometric_alt() {
        return barometric_alt;
    }

    public void setBarometric_alt(String barometric_alt) {
        this.barometric_alt = barometric_alt;
    }

    public String getGeometric_alt() {
        return geometric_alt;
    }

    public void setGeometric_alt(String geometric_alt) {
        this.geometric_alt = geometric_alt;
    }

    public Double getGround_speed() {
        return ground_speed;
    }

    public void setGround_speed(Double ground_speed) {
        this.ground_speed = ground_speed;
    }

    public Double getTrack() {
        return track;
    }

    public void setTrack(Double track) {
        this.track = track;
    }

    public Integer getBarometric_rate() {
        return barometric_rate;
    }

    public void setBarometric_rate(Integer barometric_rate) {
        this.barometric_rate = barometric_rate;
    }

    public Integer getSquawk() {
        return squawk;
    }

    public void setSquawk(Integer squawk) {
        this.squawk = squawk;
    }

    public String getEmergency() {
        return emergency;
    }

    public void setEmergency(String emergency) {
        this.emergency = emergency;
    }

    public Double getNav_qnh() {
        return nav_qnh;
    }

    public void setNav_qnh(Double nav_qnh) {
        this.nav_qnh = nav_qnh;
    }

    public String getNav_altitude_mcp() {
        return nav_altitude_mcp;
    }

    public void setNav_altitude_mcp(String nav_altitude_mcp) {
        this.nav_altitude_mcp = nav_altitude_mcp;
    }

    public Double getHeading() {
        return heading;
    }

    public void setHeading(Double heading) {
        this.heading = heading;
    }

    public List<String> getModes() {
        return modes;
    }

    public void setModes(List<String> modes) {
        this.modes = modes;
    }

    public Integer getNic() {
        return nic;
    }

    public void setNic(Integer nic) {
        this.nic = nic;
    }

    public Integer getRc() {
        return rc;
    }

    public void setRc(Integer rc) {
        this.rc = rc;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getNic_baro() {
        return nic_baro;
    }

    public void setNic_baro(Integer nic_baro) {
        this.nic_baro = nic_baro;
    }

    public Integer getNac_p() {
        return nac_p;
    }

    public void setNac_p(Integer nac_p) {
        this.nac_p = nac_p;
    }

    public Integer getNac_v() {
        return nac_v;
    }

    public void setNac_v(Integer nac_v) {
        this.nac_v = nac_v;
    }

    public Integer getSil() {
        return sil;
    }

    public void setSil(Integer sil) {
        this.sil = sil;
    }

    public String getSil_type() {
        return sil_type;
    }

    public void setSil_type(String sil_type) {
        this.sil_type = sil_type;
    }

    public Integer getGva() {
        return gva;
    }

    public void setGva(Integer gva) {
        this.gva = gva;
    }

    public Integer getSda() {
        return sda;
    }

    public void setSda(Integer sda) {
        this.sda = sda;
    }

    public Integer getAlert() {
        return alert;
    }

    public void setAlert(Integer alert) {
        this.alert = alert;
    }

    public String getMlat() {
        return mlat;
    }

    public void setMlat(String mlat) {
        this.mlat = mlat;
    }

    public String getTisb() {
        return tisb;
    }

    public void setTisb(String tisb) {
        this.tisb = tisb;
    }

    public Double getRssi() {
        return rssi;
    }

    public void setRssi(Double rssi) {
        this.rssi = rssi;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "barometric_alt='" + barometric_alt + '\'' +
                ", geometric_alt='" + geometric_alt + '\'' +
                ", ground_speed=" + ground_speed +
                ", track=" + track +
                ", barometric_rate=" + barometric_rate +
                ", squawk=" + squawk +
                ", emergency='" + emergency + '\'' +
                ", nav_qnh=" + nav_qnh +
                ", nav_altitude_mcp='" + nav_altitude_mcp + '\'' +
                ", heading=" + heading +
                ", modes=" + modes +
                ", nic=" + nic +
                ", rc=" + rc +
                ", version=" + version +
                ", nic_baro=" + nic_baro +
                ", nac_p=" + nac_p +
                ", nac_v=" + nac_v +
                ", sil=" + sil +
                ", sil_type='" + sil_type + '\'' +
                ", gva=" + gva +
                ", sda=" + sda +
                ", alert=" + alert +
                ", mlat='" + mlat + '\'' +
                ", tisb='" + tisb + '\'' +
                ", rssi=" + rssi +
                '}';
    }
}
