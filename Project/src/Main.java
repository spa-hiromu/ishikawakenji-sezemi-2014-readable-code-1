import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method 
		
		//読み込むテキストファイルのパス
		String recipeFilePath = "resource/recipe-txt.txt";
		
		//ファイルを一行ずつArrayListに格納する
		ArrayList<String> loadedRecipeString = new ArrayList<String>();
		loadedRecipeString = loadRecipeFile(recipeFilePath);
		
		//引数の配列を一行ずつ出力
		printEachLineOfArrayList(loadedRecipeString);
	}
	
	public static ArrayList<String> loadRecipeFile(String _recipeFilePath)
	{ 
		//引数文字列(_recipeFilePath)で指定されたテキストファイルを一行ずつ読み込んでArrayListに格納
		String line;
		ArrayList<String>  _loadedLineArray = new ArrayList<String>();
		BufferedReader br = null;
		
		try { 
			br = new BufferedReader(new FileReader(_recipeFilePath));
			//最後の行まで、一行ずつ読み込む
			while((line = br.readLine()) != null){
				_loadedLineArray.add(line);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
			//読み込みが終わったら閉じる
			try{
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		return _loadedLineArray;
	}
	
	public static void printEachLineOfArrayList(ArrayList<String> _arrayList)
	{ 
		//引数配列(_arrayList) の中身を一行ずつ出力する
		int i;
		int length = _arrayList.size();
		for(i = 0; i<length; i++){
			System.out.println(_arrayList.get(i));
		}
	}

}
