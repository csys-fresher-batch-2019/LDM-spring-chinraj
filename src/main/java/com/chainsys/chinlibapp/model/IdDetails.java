package com.chainsys.chinlibapp.model;

public class IdDetails {

	private int studentId;
	private int depositAmtInId;
	private int libraryWallet;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getDepositAmtInId() {
		return depositAmtInId;
	}

	public void setDepositAmtInId(int depositAmtInId) {
		this.depositAmtInId = depositAmtInId;
	}

	public int getLibraryWallet() {
		return libraryWallet;
	}

	public void setLibraryWallet(int libraryWallet) {
		this.libraryWallet = libraryWallet;
	}

	@Override
	public String toString() {
		return "IdDetails [studentId=" + studentId + ", depositAmtInId=" + depositAmtInId + ", libraryWallet="
				+ libraryWallet + "]";
	}
}
