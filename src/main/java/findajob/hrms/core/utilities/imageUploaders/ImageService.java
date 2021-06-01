package findajob.hrms.core.utilities.imageUploaders;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import findajob.hrms.core.utilities.results.DataResult;

public interface ImageService {
	DataResult<Map> save(MultipartFile file);
}
