package marvel.service;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import marvel.entity.Marvel;


public class MarvelService {
	
	private static List<Marvel> marvels;
	 static {
		 marvels = new ArrayList<Marvel>();
	 }
	 
	 private int count ;
	 public boolean addCharacter() {
		 boolean res = false;
		 
		 Marvel m = new Marvel();
		 m.setId(count);
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter Character Name : ");
		 m.setSuperheroName(sc.nextLine());
		 System.out.println("Enter Character Power Name : ");
		 m.setSuperPower(sc.nextLine());
		 System.out.println("Enter Character RealName : ");
		 m.setRealname(sc.nextLine());
		 
		 marvels.add(m);
		 saveCharacter();
		 
		 count++;
		 
		 res=true;
		 return res;
	 }
	
	 
	 private void saveCharacter() {
		 try {
			FileOutputStream fileout = new FileOutputStream("Marvels.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileout);
			out.writeObject(marvels);
		        out.close();
		        fileout.close();
			System.out.println("Serialized data is saved in Marvels.ser");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	 
	
	public List<Marvel> getAllCharacter() {
		try {
            FileInputStream fileIn = new FileInputStream("Marvels.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            marvels = (ArrayList<Marvel>) in.readObject();
            in.close();
            fileIn.close();
            
            
            System.out.println("Character Names:");
            for (Marvel marvel :marvels) {
                System.out.println(marvel.getSuperheroName());
            }
            return marvels;
		} catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}

}
