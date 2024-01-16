package com.example.Social.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	
	public String save(MultipartFile file,String appendPath) throws IOException { 
		String uploadDirectory = "uploads/static";
		String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		
		File directory= new File(uploadDirectory);
		if(!directory.exists()) {
			directory.mkdirs();
		}
		Path filePath=Paths.get(uploadDirectory,fileName);
		Files.copy(file.getInputStream(),filePath,StandardCopyOption.REPLACE_EXISTING);
		return "static/"+appendPath+"/"+fileName;   
		
	}

}
