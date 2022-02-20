import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;
import java.util.Scanner;

//загрузить игру из предложенных файлов
public class DownloadGame implements Command{

    private static File directory;

    @Override
    public void execute() {
        System.out.println("Загрузка игры");
        try{
            directory = new File("src/saved/");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        int i=0;
        for (String f: Objects.requireNonNull(directory.list())) {
            i++;
            System.out.println(i+". "+f);
        }
        if (i!=0) //если файлы есть в директории
        {
            System.out.println("Введите номер сохраненной игры:");

            int num=0;
            do{
                Scanner scanner = new Scanner(System.in);
                try{
                    num = scanner.nextInt();
                    if(num<1 || num>i)
                    {
                        System.out.println("Такой игры не существует! Повторите!");
                        continue;
                    }
                } catch (Exception e) {
                    System.out.println("Неверный ввод! Повторите!");
                    continue;
                }
            }while(num<1 || num>i);


            try (ObjectInputStream inputFile = new ObjectInputStream(new FileInputStream(directory.listFiles()[num-1]))){
                Step curStep = (Step)inputFile.readObject();
                curStep.printStep();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else System.out.println("Нет файлов. Начните игру сначала.");

    }

}
