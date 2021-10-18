import flowers.FlowerType;

/*
TODO: Submit a project to GitHub
TODO: Setup GitHub Actions for this project that would run these tests. Hint.
TODO: Send link to your Github here
 */
public class Main {
    static Store s = new Store();

    public static void main(String[] args) {
        System.out.println(s.search(FlowerType.ROSE));
    }
}
