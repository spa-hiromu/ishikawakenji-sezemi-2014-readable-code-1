import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 読み込むテキストファイルのパス
        String recipeFilePath = "resource/recipe-txt.txt";

        // ファイルを一行ずつArrayListに格納する
        ArrayList<String> loadedRecipeString = new ArrayList<String>();
        loadedRecipeString = loadRecipeFile(recipeFilePath);

        // 引数の配列を一行ずつ出力
        if (args.length < 1) {
            printEachLineOfArrayList(loadedRecipeString);
        } else {
            // 引数が与えられていれば指定したレシピを出力
            // 注意:現状与えられる引数は１つだけです。
            printEachLineOfArrayList(loadedRecipeString, Integer.valueOf(args[0]));
        }
    }

    public static ArrayList<String> loadRecipeFile(String _recipeFilePath)
    {
        // 引数文字列(_recipeFilePath)で指定されたテキストファイルを一行ずつ読み込んでArrayListに格納
        String line;
        ArrayList<String> _loadedLineArray = new ArrayList<String>();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(_recipeFilePath));
            // 最後の行まで、一行ずつ読み込む
            while ((line = br.readLine()) != null) {
                _loadedLineArray.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 読み込みが終わったら閉じる
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return _loadedLineArray;
    }

    public static void printEachLineOfArrayList(ArrayList<String> _arrayList)
    {
        // 引数配列(_arrayList) の中身を一行ずつ出力する
        int recipeID = 1;
        for (String recipeName : _arrayList) {
            System.out.println(recipeID + ":" + recipeName);
            recipeID++;
        }
    }

    public static void printEachLineOfArrayList(ArrayList<String> _arrayList, int selectedID) {
        int recipeID = 1;
        for (String recipeName : _arrayList) {
            if (recipeID == selectedID) {
                System.out.println(recipeID + ":" + recipeName);
            }
            recipeID++;
        }
    }

}
