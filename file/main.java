package tu_dien;

import java.io.IOException;
import java.util.Scanner;

public class main {

	public static void main(String[] args){
		DictionaryCommandline commandline=new DictionaryCommandline();
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.println("1. hien thi ket qua danh sach tu dien");
		System.out.println("2. tra cuu tu dien");
		System.out.println("3. them du lieu tu dien");
		System.out.println("4. xóa du lieu tu dien");
		System.out.println("5. tim kiem cac tu");
		System.out.println("6. xuat du lieu ra file");
		System.out.println("so ban muon nhap: ");
		n=sc.nextInt();
		switch(n) 
			{
				case 1:
				{
					commandline.management.insertFromFile();
					commandline.showAllWords();
					break;
				}
				case 2:
				{
					commandline.management.insertFromFile();
					commandline.management.dictionaryLookup();
					break;
				}
				case 3:
				{
					commandline.management.insertFromFile();
					commandline.management.insertWord();
					break;
				}
				case 4:
				{
					commandline.management.insertFromFile();
					commandline.management.removeWord();
					break;
				}
				case 5:
				{
					commandline.management.insertFromFile();
					commandline.management.dictionarySearcher();
					break;
				}
				case 6:
				{
					commandline.management.insertFromFile();
					commandline.management.dictionaryExportToFile();
					break;
				}
			}
	}

}
