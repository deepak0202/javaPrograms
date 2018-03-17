/******************************************************************************
*  Purpose: pojo class to get and set user details
*  @author  Deepak Singh
*  @version 1.0
*  @since   15-03-2018
*
******************************************************************************/
package com.bridgeit.objectOrientedPrograms;

public class UserDetails 
{
		private String firstName;
		private String lastName;
		private String mobileNo;
		private String date;

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public UserDetails(){
		}	
}
