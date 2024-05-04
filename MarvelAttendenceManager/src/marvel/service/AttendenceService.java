package marvel.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import marvel.entity.Attendence;
import marvel.entity.Marvel;



public class AttendenceService {
	private static List<Attendence> allAttendence;
	static {
		allAttendence = new ArrayList<Attendence>();
	}
	
	public void startAttendence() {
		MarvelService ms = new MarvelService();
		List<Marvel> marvels = ms.getAllCharacter();
		
		for(Marvel m : marvels) {
			Attendence a = new Attendence();
			System.out.println(m.getId()+"||"+m.getSuperheroName()+":");
			a.setId(m.getId());
			a.setSuperheroName(m.getSuperheroName());
			Date d = new Date();
			System.out.println(d);
			a.setDate(d);
			
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.println("Enter p if present, a if absent");
				String isPresent = sc.nextLine();
				if("p".equals(isPresent)) {
					a.setPresent(true);
					break;
				}else if("a".equals(isPresent)){
					a.setPresent(false);
					break;
				}else {
					System.out.println("Please enter a valid input");
				}
				
				System.out.println("Enter Description");
				a.setDiscription(sc.nextLine());
				allAttendence.add(a);
				System.out.println("----------------------------------------------------");
			}
		}
		
		savedata();
	}

	private void savedata() {
		try {
			FileOutputStream fileOut = new FileOutputStream("attendance.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(allAttendence);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in attendence.ser");
		} catch (IOException e) {
	        e.printStackTrace();
	        System.err.println("Failed to save data.");
		}
		
	}
	
	public List<Attendence> getAllAttendence(){
		try {
            FileInputStream fileIn = new FileInputStream("attendance.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            allAttendence = (ArrayList<Attendence>)in.readObject();
            in.close();
            fileIn.close();
            return allAttendence;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("IO Exception occurred while reading/writing data.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Class not found exception occurred.");
        }
            return null;
        
	}
	
	public void showAttendence() {
		for(Attendence a:getAllAttendence()) {
			System.out.println(a.getId()+" || "+a.getSuperheroName()+" || "+a.getDiscription()+" || "+a.getDate()+" || "+a.isPresent());
			System.out.println("-------------------------------------------------------------");
		}
	}
	

}
