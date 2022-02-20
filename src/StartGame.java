import java.io.IOException;

public class StartGame implements Command {

    //начать игру=запустить первый шаг
    Step firstStep;

    @Override
    public void execute()  {
        System.out.println("Старт игры");
        firstStep = new Step("firstFox");
    }
}






