package com.example.files.files.components;
import com.example.files.files.models.File;
import com.example.files.files.models.Folder;
import com.example.files.files.models.Person;
import com.example.files.files.repositories.FileRepository;
import com.example.files.files.repositories.FolderRepository;
import com.example.files.files.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

    @Component
    public class DataLoader implements ApplicationRunner {

        @Autowired
        PersonRepository personRepository;

        @Autowired
        FolderRepository folderRepository;

        @Autowired
        FileRepository fileRepository;

        @Override
        public void run(ApplicationArguments args) throws Exception {

            Person john = new Person("John");
            personRepository.save(john);

            Person eric = new Person("Eric");
            personRepository.save(eric);

            Person meera = new Person("Meera");
            personRepository.save(meera);

            Folder folder1 = new Folder("John's Documents", john);
            folderRepository.save(folder1);

            Folder folder2 = new Folder("Eric's Spreadsheets", eric);
            folderRepository.save(folder2);

            Folder folder3 = new Folder("Meera's Pictures", meera);
            folderRepository.save(folder3);

            Folder folder4 = new Folder("Memes", meera);
            folderRepository.save(folder4);

            File file1 = new File("To-Do List", ".txt", 100, folder1);
            fileRepository.save(file1);

            File file2 = new File("Class Notes", ".docx", 12345, folder1);
            fileRepository.save(file2);

            File file3 = new File("Expenses", ".xls", 5, folder2);
            fileRepository.save(file3);

            File file4 = new File("Attendance Record", ".csv", 98724, folder2);
            fileRepository.save(file4);

            File file5 = new File("Portrait", ".png", 100000000, folder3);
            fileRepository.save(file5);

            File file6 = new File("Landscape", ".jpeg", 127486, folder3);
            fileRepository.save(file6);

            File file7 = new File("Cat Falling Over", ".gif", 99999999, folder4);
            fileRepository.save(file7);

        }
    }
