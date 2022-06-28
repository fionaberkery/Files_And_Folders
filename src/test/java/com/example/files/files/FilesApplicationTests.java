package com.example.files.files;

import com.example.files.files.models.File;
import com.example.files.files.models.Folder;
import com.example.files.files.models.Person;
import com.example.files.files.repositories.FileRepository;
import com.example.files.files.repositories.FolderRepository;
import com.example.files.files.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FilesApplicationTests {

	@Autowired
	private FileRepository fileRepository;

	@Autowired
	private FolderRepository folderRepository;

	@Autowired
	private PersonRepository personRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreateAPersonAndAFolderAndAFile(){
		Person person = new Person("Fi");
		personRepository.save(person);

		Folder folder = new Folder("Package", person);
		folderRepository.save(folder);

		File file = new File("Level", "123", 55, folder);
		fileRepository.save(file);
	}

	@Test
	public void addFilesToFolder(){
		Person person = new Person("Fi");
		personRepository.save(person);
		Folder folder = new Folder("Package", person);
		folderRepository.save(folder);
		Folder otherFolder = new Folder("Blocks", person);
		folderRepository.save(otherFolder);
		File file1 = new File("Level1", "123", 55, folder);
		fileRepository.save(file1);
		File file2 = new File("Level2", "456", 65, folder);
		fileRepository.save(file2);
		File file3 = new File("Level3", "789", 75, otherFolder);
		fileRepository.save(file3);
		File file4 = new File("Level4", "654", 83, otherFolder);
		fileRepository.save(file4);

		folder.addFile(file1);
		folder.addFile(file2);

		otherFolder.addFile(file3);
		otherFolder.addFile(file4);

		folderRepository.save(otherFolder);
		folderRepository.save(folder);
	}

}
