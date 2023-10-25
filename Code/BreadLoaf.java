public class BreadLoaf {
    private String menuName;
    private List<Ingredient> ingredients;
    private double panSize;
    private String process;

    public BreadLoaf() {}

    public BreadLoaf(String menuName, List<Ingredient> ingredients, double panSize, String process) {
        this.menuName = menuName;
        this.ingredients = ingredients;
        this.panSize = panSize;
        this.process = process;
    }

    public String getMenuName() {
        return menuName;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public double getPanSize() {
        return panSize;
    }

    public String getProcess() {
        return process;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setPanSize(double panSize) {
        this.panSize = panSize;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void writeProcess() {
        System.out.println("Process:");
        System.out.println(process);
    }

    @Override
    public String toString() {
        return "BreadLoaf{" +
                "menuName='" + menuName + '\'' +
                ", ingredients=" + ingredients +
                ", panSize=" + panSize +
                ", process='" + process + '\'' +
                '}';
    }
}