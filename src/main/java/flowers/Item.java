package flowers;

import lombok.Setter;

@Setter
public abstract class Item {
    protected String description;

    public String getDescription() {
        return this.description;
    }

    abstract public double getPrice();

    public void setDescription(String addToDescr) {
        this.description = String.format("%s; %s", this.description, addToDescr);
    }
}
