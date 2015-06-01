package Modal;

public class Country {
    private String code, name, continent, region, governmentForm;
    private double surfaceArea, lifeExpectancy;
    private int population;

    public Country(String code, String name, String continent, String region, double surfaceArea, int population, double lifeExpectancy, String governmentForm) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.governmentForm = governmentForm;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public String getRegion() {
        return region;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public int getPopulation() {
        return population;
    }
}
