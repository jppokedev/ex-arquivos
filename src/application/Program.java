package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		List<Product> list = new ArrayList<>();		
		
		System.out.print("Enter file path: ");
		String sourceFileStr = sc.nextLine();
		
		File sourceFile = new File(sourceFileStr);
		String sourceFolderStr = sourceFile.getParent();
		/* Essa metodo "getParent" serva pra pegar o endereço 
		   e despreza o nome do arquivo que foi escrito ex: 
		   C:\temp\ex_arquivo\input.csv, no caso esse "input.csv e desprezado"
		*/
		boolean success = new File(sourceFolderStr + "\\out").mkdir();
		
		String targetFileStr = sourceFolderStr + "\\out\\summary.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))){
			
			String itemCsv = br.readLine(); // Esse readLine serve para ler as linhas
			while (itemCsv != null) {
				
				String[] fields = itemCsv.split(","); //Esse split quebra a string no divisor que eu informar dentro das aspas
				list.add(new Product(fields[0], fields[1], fields[2]));
				
				itemCsv = br.readLine(); // como ele ta dentro de um while e pula pra proxima e le a proxima		
			}
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))){
				
				for(Product item : list) {
					bw.write(item.getName() + "," + String.format("%.2f", item.sum()));
					bw.newLine();
				}
				
			}catch(IOException e) {
				System.out.println("Error! " + e.getMessage());
			}
			
		}catch(IOException e ){
			System.out.println("Error! " + e.getMessage());
		}
		
		sc.close();
		
	}

}
