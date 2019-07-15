package pl.javastart.produkty;

public enum Category {
    GROCERIES("spozywcze"), HOUSEHOLD("domowe"), OTHER("inne");

    private String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Category convert(String category) {
        for (Category c : Category.values()) {
            if (c.getDescription().equals(category)) {
                return c;
            }
        }
        return null;
    }
}