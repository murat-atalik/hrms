package findajob.hrms.core.helpers;

import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessResult;

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
