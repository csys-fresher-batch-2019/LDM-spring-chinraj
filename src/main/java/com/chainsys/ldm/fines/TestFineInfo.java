package com.chainsys.ldm.fines;

import java.util.Scanner;

import com.chainsys.chinlibapp.dao.imp.FineInfoDAOImpl;
import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.FinesInfo;

public class TestFineInfo {
	
	public static void main(String[] args) throws DbException {
		
	
		Scanner s = new Scanner(System.in);
		System.out.println("\n 1.AddFineInf\n 2.booksReturned\n 3.Fine per Student\n 4.LostPenality\n 5.Book Renewal");
		FineInfoDAOImpl d = new FineInfoDAOImpl();
		FinesInfo f = new FinesInfo();
		int n = s.nextInt();
		switch (n) {
		
		case 1: {
			System.out.println("Enter studentId :");
			f.setStudentId(s.nextInt());
			System.out.println("Enter ISBN :");
			f.setISBN(s.nextLong());
			System.out.println("Enter fines per day :");
			f.setFinePerDay(s.nextInt());
			d.addFineInfo(f);
			d.updateFineInfo(f);
			d.totalFine(f);
		}
			break;
		case 2: {

			System.out.println("Enter studentId :");
			f.setStudentId(s.nextInt());
			System.out.println("Enter ISBN :");
			f.setISBN(s.nextLong());
			d.bookReturn(f.getStudentId(), f.getISBN());

		}
			break;
		case 3: {
			System.out.println("Enter studentId :");
			f.setStudentId(s.nextInt());
			System.out.println("Enter ISBN :");
			f.setISBN(s.nextLong());
			d.updateFineInfo(f);
			d.totalFine(f);
			d.finePerStudent(f.getStudentId(), f.getISBN());
		}
			break;
		case 4: {
			System.out.println("Enter studentId :");
			f.setStudentId(s.nextInt());
			System.out.println("Enter ISBN :");
			f.setISBN(s.nextLong());
			d.penalityForBookLost(f.getStudentId(), f.getISBN());

		}
			break;
		case 5: {
			System.out.println("Enter studentId :");
			f.setStudentId(s.nextInt());
			System.out.println("Enter ISBN :");
			f.setISBN(s.nextLong());
			d.renewal(f.getStudentId(), f.getISBN());
		}
		}
		s.close();
	}
}
