import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

//Основное меню
public class Menu {
    private static HashMap<Integer, Command> commandMap = new HashMap<>();

    public Menu() {
        commandMap.put(1, new StartGame());
        commandMap.put(2, new DownloadGame());
        commandMap.put(3, new EndGame());
        commandMap.put(4, new SaveGame());
    }

    //начало игры
    public void start()  {
        System.out.println(" Добро пожаловать в игру! Выберите пункт:\n" +
                " 1.  Начать игру\n 2.  Загрузить игру\n 3.  Завершить игру");
        int item=0;
        Scanner scanner = new Scanner(System.in);
        do {
            if (scanner.hasNextInt()) {
                item = scanner.nextInt();
                if (item<1 || item>3)
                {
                    System.out.println("Введите от 1 до 3!");
                    continue;
                }
            }
            else {
                System.out.println("Неверный ввод! Повторите!");
                continue;
            }
            /*try{
                item = scanner.nextInt();
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("Неверный ввод! Повторите!");
                continue;
            }*/
        } while (item < 1 || item > 3);

        runCommand(item);
    }

    //запускаем нужный пункт меню
    static public void runCommand(int item) {
        commandMap.get(item).execute();
    }

    static public Object objectCommand(int item)
    {
        return commandMap.get(item);
    }
}
