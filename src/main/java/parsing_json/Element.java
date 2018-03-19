package parsing_json;

import java.util.ArrayList;

public class Element {

    public String name;
    public String appearance;
    public Double atomic_mass;
    public Double boil;
    public String category;
    public String color;
    public Double density;
    public String discovered_by;
    public Double melt;
    public Double molar_heat;
    public String named_by;
    public long number;
    public long period;
    public String phase;
    public String source;
    public String spectral_img;
    public String summary;
    public String symbol;
    public long xpos;
    public long ypos;
    public ArrayList<Integer> shells;

    public String getName() {
        return name;
    }

    public String getAppearance() {
        return appearance;
    }

    public Double getAtomic_mass() {
        return atomic_mass;
    }

    public Double getBoil() {
        return boil;
    }

    public String getCategory() {
        return category;
    }

    public String getColor() {
        return color;
    }

    public Double getDensity() {
        return density;
    }

    public String getDiscovered_by() {
        return discovered_by;
    }

    public Double getMelt() {
        return melt;
    }

    public Double getMolar_heat() {
        return molar_heat;
    }

    public String getNamed_by() {
        return named_by;
    }

    public long getNumber() {
        return number;
    }

    public long getPeriod() {
        return period;
    }

    public String getPhase() {
        return phase;
    }

    public String getSource() {
        return source;
    }

    public String getSpectral_img() {
        return spectral_img;
    }

    public String getSummary() {
        return summary;
    }

    public String getSymbol() {
        return symbol;
    }

    public long getXpos() {
        return xpos;
    }

    public long getYpos() {
        return ypos;
    }

    public ArrayList<Integer> getShells() {
        return shells;
    }

    public Element(String name,
            String appearance,
            Double atomic_mass,
            Double boil,
            String category,
            String color,
            Double density,
            String discovered_by,
            Double melt,
            Double molar_heat,
            String named_by,
            long number,
            long period,
            String phase,
            String source,
            String spectral_img,
            String summary,
            String symbol,
            long xPos,
            long yPos,
            ArrayList<Integer> shells) {

        this.name = name;
        this.appearance = appearance;
        this.atomic_mass = atomic_mass;
        this.boil = boil;
        this.category = category;
        this.color = color;
        this.density = density;
        this.discovered_by = discovered_by;
        this.melt = melt;
        this.molar_heat = molar_heat;
        this.named_by = named_by;
        this.number = number;
        this.period = period;
        this.phase = phase;
        this.source = source;
        this.spectral_img = spectral_img;
        this.summary = summary;
        this.symbol = symbol;
        this.xpos = xPos;
        this.ypos = yPos;
        this.shells = shells;


    }

}