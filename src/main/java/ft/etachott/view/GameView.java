package ft.etachott.view;

public abstract class GameView {
    public GameView() {}

    abstract public void initialView();
    abstract public void createHeroView();
    abstract public void chooseHeroView();
    abstract public void exitView();
}
