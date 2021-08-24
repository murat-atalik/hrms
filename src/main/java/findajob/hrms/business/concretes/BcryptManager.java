package findajob.hrms.business.concretes;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.BcryptService;

@Service
public class BcryptManager implements BcryptService {

	@Override
	public boolean checkEncrypt(String value, String encryptedValue) {
		

		return BCrypt.checkpw(value, encryptedValue);
	}

	@Override
	public String encryptValue(String value) {
	
		return BCrypt.hashpw(value, BCrypt.gensalt(10));
	}

}
