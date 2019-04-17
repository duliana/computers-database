package pojo;

import org.apache.commons.lang3.RandomStringUtils;

public class Computer {
    private String name;
    private String introducedDate;
    private String discontinuedDate;
    //private String company;

    public Computer(){

        setName("Test Computer" + RandomStringUtils.randomNumeric(5));
        setIDate("1990-12-28");
        setDDate("2000-12-28");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIDate(String introducedDate) {
        this.introducedDate = introducedDate;
    }

    public void setDDate(String discontinuedDate) {
        this.discontinuedDate = discontinuedDate;
    }

    public String getName() {
        return name;
    }

    public String getIntroduced() {
        return introducedDate;
    }

    public String getDisocntinued() {
        return discontinuedDate;
    }

}
