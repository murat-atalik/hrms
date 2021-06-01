package findajob.hrms;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import findajob.hrms.core.utilities.imageUploaders.CloudinaryManager;
import findajob.hrms.core.utilities.imageUploaders.ImageService;

import org.springframework.context.annotation.Bean;
@org.springframework.context.annotation.Configuration
public class Configuration {
	@Bean
	public ImageService imageService() {
		return new CloudinaryManager(cloudinary());
	}

	@Bean
	public Cloudinary cloudinary() {
		return new Cloudinary(ObjectUtils.asMap("cloud_name", "eacth", "api_key", "474248168587323", "api_secret",
				"9n7rxnyalWm6kVHAgjPKkg_aJ20"));
	}

}
