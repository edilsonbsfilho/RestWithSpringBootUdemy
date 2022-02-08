package br.com.erudio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.erudio.service.FileStorageService;
import br.com.erudio.vo.UploadFileResponseVO;
import io.swagger.annotations.Api;

/**
 * 
 * @author Edilson
 *
 */
@Api(value = "File Services", description = "EndPoints for File manipulation", tags = {"File Services"})
@RestController
@RequestMapping("/api/v1/file")
public class FileController {

	@Autowired
	private FileStorageService fileStorageService;
	
	/**
	 * 
	 * @param file
	 * @return
	 */
	@PostMapping("/uploadFile")
	public UploadFileResponseVO uploadFile(@RequestParam("file") MultipartFile file) {
		String fileName = fileStorageService.storeFile(file);
		
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/api/v1/file/downloadFile/")
				.path(fileName)
				.toUriString();
		
		return new UploadFileResponseVO(fileName, fileDownloadUri, file.getContentType(), file.getSize());
	}
}
