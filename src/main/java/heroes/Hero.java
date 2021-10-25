package heroes;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private int id;
    private String name;
    private String humanName;
    private String imageUrl;
    private List<String> powers = new ArrayList<>();

    public Hero() {
    }

    public Hero(int id, String name, String humanName, String imageUrl, List<String> powers) {
        this.id = id;
        this.name = name;
        this.humanName = humanName;
        this.imageUrl = imageUrl;
        this.powers = powers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHumanName() {
        return humanName;
    }

    public void setHumanName(String humanName) {
        this.humanName = humanName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getPowers() {
        return new ArrayList<>(powers);
    }

    public void setPowers(List<String> powers) {
        this.powers = powers;
    }

    public static List<Hero> makeHeroes() {
        return new ArrayList<>(
                List.of(
                        new Hero(1, "Scarlet Witch", "Wanda Maximoff",
                                "http://comicvine.gamespot.com/a/uploads/scale_small/11112/111123579/5091566-7852300467-latest",
                                List.of(Power.RED_MAGIC, Power.TELEKINESIS)),
                        new Hero(2, "Vision", null,
                                "http://comicvine.gamespot.com/a/uploads/scale_small/3/31666/4479803-vision.jpg",
                                List.of(Power.FLIGHT, Power.PHASING)),
                        new Hero(3, "Bumblebee", "Karen Beecher",
                                "http://comicvine.gamespot.com/a/uploads/scale_small/11125/111252513/5519379-titans-3.jpg",
                                List.of(Power.FLIGHT, Power.BLAST)),
                        new Hero(4, "Iron Man", "Elon Musk",
                                "http://comicvine.gamespot.com/a/uploads/scale_small/11118/111187046/7560188-0157851318-EeSKH3CWkAAiO2j.jpg",
                                List.of()),
                        new Hero(5, "Swamp Thing", "Alec Holland",
                                "http://comicvine.gamespot.com/a/uploads/scale_small/10/101435/2225341-2133495_swamp_thing.jpg",
                                List.of(Power.PLANT_CONTROL))
                ));
    }
}
