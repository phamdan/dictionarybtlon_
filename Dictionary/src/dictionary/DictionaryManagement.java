/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import dictionary.Word;
import dictionary.Dictionary;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Dan_Pham
 */
public class DictionaryManagement {
    Dictionary dictionary=new Dictionary();
	private int n;
	
	//Nhập dữ liệu từ bàn phímm
	public void insertFromCommandline() {
		Scanner sc=new Scanner(System.in);
		this.n=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++) {
			String a=sc.nextLine();
			String b=sc.nextLine();
			dictionary.word.add(new Word(a,b));
		}
	}
	
	//nhập dữ liệu từ file
	public void insertFromFile() {
		 try {
	            String input = "C:\\Users\\Dan_Pham\\Documents\\NetBeansProjects\\Dictionary\\src\\dictionary\\text.txt";
	            FileInputStream fis = new FileInputStream(new File(input));
	            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	            String line;
	            while((line=br.readLine())!=null){
	            	String[] b=line.split(":");
	            	b[0]=b[0].trim();
	            	b[1]=b[1].trim();
	            	dictionary.word.add(new Word(b[0],b[1]));
	            }
	            br.close();
	        } catch (IOException e) {
	            System.out.println("file rong");
	        }
	    }
	
	//tra cứu từ điển bằng dòng lệnh
	public void dictionaryLookup() {
		System.out.println("nhập từ bạn muốn tra cứu:");
		Scanner sc=new Scanner(System.in);
		String a=sc.nextLine();
		for(int i=0;i<dictionary.word.size();i++) {
			if(dictionary.word.get(i).word_target.equalsIgnoreCase(a)) {
				System.out.println(dictionary.word.get(i).word_explain);
				break;
			}
		}
	}
	
	//hàm thêm dữ liệu từ điển
	public void insertWord() {
		System.out.println("nhap dữ liệu mà bạn muốn thêm:");
		System.out.println("nhap từ tiếng anh muốn thêm:");
		Scanner sc=new Scanner(System.in);
		String a=sc.nextLine();
		System.out.println("nhập nghĩa từ bạn vừa thêm:");
		String b=sc.nextLine();
		// ghi dữ liệu này ra file
		
		String nameFile = "C:\\Users\\Dan_Pham\\Documents\\NetBeansProjects\\Dictionary\\src\\dictionary\\text.txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(nameFile, true))) {
			String content = a+"	: "+b+"\n";
			bw.write(content);
			// không cần đóng BufferedWriter (nó đã tự động đóng)
			// bw.close();
		} catch (IOException e) {
			System.out.println("file rỗng");
		}
		dictionary.word.add(new Word(a,b));
		
	}
	
	// hàm xóa dữ liệu từ điển
	public void removeWord(){
		System.out.println("nhập từ bạn muốn xóa: ");
		Scanner sc=new Scanner(System.in);
		String a=sc.nextLine();
		for(int i=0;i<dictionary.word.size();i++) {
			if(dictionary.word.get(i).word_target.equalsIgnoreCase(a)) {
				dictionary.word.remove(i);
				break;
			}
		}
		// xóa dữ liệu từ mình cần xóa trong file
		// ý tưởng: xóa cả file rồi tạo lại file mới để ghi đè lên
		// xóa file
		try{
			 
    		File file = new File("C:\\Users\\Dan_Pham\\Documents\\NetBeansProjects\\Dictionary\\src\\dictionary\\text.txt");
    		file.delete();
 
    	}catch(Exception e){
    		System.out.println(" file chưa được xóa");
    	}
		
		//tạo lại file rồi ghi lại dữ liệu từ mảng
		try{
	         File file = new File("C:\\Users\\Dan_Pham\\Documents\\NetBeansProjects\\Dictionary\\src\\dictionary\\text.txt");
	         file.createNewFile();
	     }
	     catch(IOException ioe) {
	        System.out.println("file chưa tạo được");
	     }
		// ghi dữ liệu từ điển vào file
		String FileName="C:\\Users\\Dan_Pham\\Documents\\NetBeansProjects\\Dictionary\\src\\dictionary\\text.txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FileName))) {
			for(int i=0;i<dictionary.word.size();i++) {
			String content =dictionary.word.get(i).word_target+"	: "+dictionary.word.get(i).word_explain+"\n" ;
			bw.write(content);
			}
			// không cần đóng BufferedWriter (nó đã tự động đóng)
			// bw.close();
		} catch (IOException e) {
			System.out.println("khong ghi duoc");
			}
	}
	
	//HÀm tìm những từ liên quan 
	public void dictionarySearcher() {
		Scanner sc=new Scanner (System.in);
		System.out.println("nhập từ gợi ý bạn muốn tìm: ");
		String a=sc.nextLine();
		for(int i=0;i<dictionary.word.size();i++) {
			if(dictionary.word.get(i).word_target.startsWith(a)) {
				System.out.println(dictionary.word.get(i).word_target+"	: "+dictionary.word.get(i).word_explain);
			}
		}
	}
	
	//HÀM HIỆN TỪ ĐIỂN HIỆN TẠI TRONG MẢNG RA FILE
	public void dictionaryExportToFile() {
		
		// Tạo file
		try{
	         File file = new File("C:\\Users\\Dan_Pham\\Documents\\NetBeansProjects\\Dictionary\\src\\dictionary\\newFile.txt");
	         file.createNewFile();
	     }
	     catch(IOException ioe) {
	        System.out.println("file chưa tạo được");
	     }
		//ghi dữ liệu vào file
		String FileName="C:\\Users\\Dan_Pham\\Documents\\NetBeansProjects\\Dictionary\\src\\dictionary\\newFile.txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FileName))) {
			for(int i=0;i<dictionary.word.size();i++) {
			String content =dictionary.word.get(i).word_target+"	: "+dictionary.word.get(i).word_explain+"\n" ;
			bw.write(content);
			}
			// không cần đóng BufferedWriter (nó đã tự động đóng)
			// bw.close();
		} catch (IOException e) {
			System.out.println("File khong ghi duoc");
			}
	}
}
