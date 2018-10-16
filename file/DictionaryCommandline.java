package tu_dien;


public class DictionaryCommandline {
	DictionaryManagement management=new DictionaryManagement();
	// hàm hiện thị toàn bộ mảng word
	public void showAllWords() {
		for(int i=0;i<management.dictionary.word.size();i++) {
			System.out.println(management.dictionary.word.get(i).word_target + " : "+management.dictionary.word.get(i).word_explain);
		}
	}
	
	//hàm gọi cải tiến lần 1
	public void dictionaryAdvanced() {
		DictionaryCommandline d=new DictionaryCommandline();
		d.management.insertFromFile();
		d.showAllWords();
		d.management.dictionaryLookup();
	}
}
