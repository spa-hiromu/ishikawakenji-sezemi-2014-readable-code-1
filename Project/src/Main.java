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
        loadedRecipeString = loadFileEachOfLine(recipeFilePath);


        if (args.length < 1) {
            printEachLineOfArrayList(loadedRecipeString);
        } else {
            // 引数が与えられていれば指定したレシピを出力
            // 注意:現状与えられる引数は１つだけです。
            printEachLineOfArrayList(loadedRecipeString, Integer.valueOf(args[0]));
        }
    }

    /** 引数文字列(_recipeFilePath)で指定されたテキストファイルを一行ずつ読み込んでArrayListに格納 */
    public static ArrayList<String> loadFileEachOfLine(String _recipeFilePath)
    {
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

    /** レシピを一行ずつ出力する */
    public static void printEachLineOfArrayList(ArrayList<String> recipeList)
    {
        printUserName(recipeList);
        // 引数配列(_arrayList) の中身を一行ずつ出力する
        int recipeID = 1;
        for (String recipeName : recipeList) {
            System.out.println(recipeID + ":" + recipeName);
            recipeID++;
        }
    }

    public static void printEachLineOfArrayList(ArrayList<String> recipeList, int selectedID) {
        printUserName(recipeList);
        int recipeID = 1;
        for (String recipeName : recipeList) {
            if (recipeID == selectedID) {
                System.out.println(recipeID + ":" + recipeName);
            }
            recipeID++;
        }
    }

    /** ユーザ名を出力 */
    public static void printUserName(ArrayList<String> recipeList) {
        /** リソースの先頭をユーザ名としているので先頭だけ読んでその後は削除してレシピだけの状態にする */
        System.out.println("ユーザ名:" + recipeList.get(0));
        recipeList.remove(0);
    }

}
