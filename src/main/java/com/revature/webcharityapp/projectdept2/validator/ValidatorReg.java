package com.revature.webcharityapp.projectdept2.validator;

import com.revature.webcharityapp.projectdept2.exception.ValidatorException;
import com.revature.webcharityapp.projectdept2.model.RegUserDetails;

public class ValidatorReg {

	public static void validateBeforeRegistration(RegUserDetails user) throws ValidatorException {

		String name = user.getName();
		if (name == null || "".equals(name.trim()) ) {
			throw new ValidatorException("Invalid Name");
		}
		//long phone_no = user.getPhoneno();
		//if (phone_no == 0 ) {
			//throw new ValidatorException("Invalid phone_no");
	//	}
	
		
		

	}
}