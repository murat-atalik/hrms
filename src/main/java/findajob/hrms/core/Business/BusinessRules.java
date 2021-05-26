package findajob.hrms.core.Business;

import findajob.hrms.core.utilities.Result;
import findajob.hrms.core.utilities.SuccessResult;

public class BusinessRules {
	public static Result Run(Result... logics) {
		for (Result result : logics) {
			if(!result.isSuccess()) {
				return result;
			}
		}
		return new SuccessResult();
	}
}
