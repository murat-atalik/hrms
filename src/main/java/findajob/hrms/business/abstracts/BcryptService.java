package findajob.hrms.business.abstracts;


public interface BcryptService {
		boolean checkEncrypt(String value,String encryptedValue);
		String encryptValue(String value);
}
